package RestAssuredHandsOn.Mocking;

import RestAssuredHandsOn.ApiUtils.WiremockUtils;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static RestAssuredHandsOn.AutherizationHandsOn.*;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;


//todo: ************** REFRESH TOKEN FLOW **************************
/**
 * Refresh token is used to get a new access token without requiring the user to re-authenticate.
 * This is particularly useful for long-lived sessions where you want to maintain user authentication
 * without asking them to log in again.
 *
 * The refresh token is typically issued alongside the access token and has a longer expiration time.

 Goal: Automate this flow using Rest Assured
 1. Call /auth/login to get: >> it returns accessToken and refreshToken
 2. Store the accessToken and refreshToken
 3. Use the accessToken to call a protected API
 4.Call a protected API using the accessToken
 5.Simulate token expiry (or mock it)
 6.Use refreshToken to get a new accessToken
 7.Call protected API again using the new token

 */

public class MockJwtTestUsingWireMock extends WiremockUtils {
    static WireMockServer wireMockServer = new WireMockServer(8089); // same port as your base URL


    //todo: *******MOCKING JWT FLOW USING WIREMOCK **********
    @Test(description = "refreshTokenFlow_with_Mock_Apis")
    public void refreshTokenFlow_with_Mock_Apis() {
        wireMockServer.start();              // Start mock server
        configureFor("localhost", 8089);     // Configure WireMock on port 8089
        setupMocks();                        // Define mock endpoints

        loginAndGetTokens();                 // Simulate login → get tokens

        accessToken = "expired-access-token"; // Force token to be invalid
        useAccessToken();                    // This will fail (401)

        System.out.println("Refreshing token...");
        refreshAccessToken();                // Get new access token

        useAccessToken();                    // This will now succeed

        wireMockServer.stop();
    }

    //todo: when we have actual Apis.
    @Test(description = "refreshTokenFlow_withActual_Apis")
    public void refreshTokenFlow_withActual_Apis() {

        // Step 1: Login to get accessToken and refreshToken
        loginAndGetTokens();
        useAccessToken();
        // Simulate token expiry (you can mock or use an expired token here)
        System.out.println("Access token expired... using refresh token");

        refreshAccessToken();
        useAccessToken(); // try again with new access token
    }


}
