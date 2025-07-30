package RestAssuredHandsOn.ApiUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.util.Properties;

public class HybridOAuthTokenManager {

    /**
     * ThreadLocal → so each thread reuses its own copy of the token
     * File caching → so you don't fetch a token from the server if a valid token is already stored on disk
     */
    private static final ThreadLocal<String> threadLocalToken = new ThreadLocal<>();
    private static final ThreadLocal<Instant> threadLocalExpiry = new ThreadLocal<>();
    private static final String TOKEN_FILE = "token-cache.properties";
    private static final Object fileLock = new Object();

    public static String getAccessToken() {
        String token = threadLocalToken.get();
        Instant expiry = threadLocalExpiry.get();

        if (token != null && expiry != null && Instant.now().isBefore(expiry)) {
            return token;
        }

        synchronized (fileLock) {
            // Try reading from file
            try {
                Properties props = new Properties();
                File file = new File(TOKEN_FILE);

                if (file.exists()) {
                    try (FileInputStream fis = new FileInputStream(file)) {
                        props.load(fis);
                        String fileToken = props.getProperty("access_token");
                        long expiryEpoch = Long.parseLong(props.getProperty("expiry_time"));

                        if (Instant.now().getEpochSecond() < expiryEpoch) {
                            // Cache it in ThreadLocal
                            threadLocalToken.set(fileToken);
                            threadLocalExpiry.set(Instant.ofEpochSecond(expiryEpoch));
                            return fileToken;
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to read token from file", e);
            }

            // Fetch new token from server
            return fetchAndCacheNewToken();
        }
    }
    // Fetch new token from OAuth server
    private static String fetchAndCacheNewToken() {
        RestAssured.baseURI = "https://example.com"; // Your OAuth domain

        Response response = RestAssured.given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("grant_type", "client_credentials")
                .formParam("client_id", "your-client-id")
                .formParam("client_secret", "your-client-secret")
                .when()
                .post("/oauth2/token")  // Your token endpoint
                .then()
                .statusCode(200)
                .extract().response();

        String newToken = response.jsonPath().getString("access_token");
        int expiresIn = response.jsonPath().getInt("expires_in");

        Instant expiryTime = Instant.now().plusSeconds(expiresIn - 60); // Renew 1 minute early

        threadLocalToken.set(newToken);
        threadLocalExpiry.set(expiryTime);

        // Save to file
        Properties props = new Properties();
        props.setProperty("access_token", newToken);
        props.setProperty("expiry_time", String.valueOf(expiryTime.getEpochSecond()));

        try (FileOutputStream fos = new FileOutputStream(TOKEN_FILE)) {
            props.store(fos, "Cached OAuth Token");
        } catch (IOException e) {
            throw new RuntimeException("Failed to cache token to file", e);
        }

        System.out.println("Fetched and cached new token (thread: " + Thread.currentThread().getName() + ")");
        return newToken;
    }
    }

