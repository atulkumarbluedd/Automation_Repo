package RestAssuredHandsOn.ApiUtils;

import io.restassured.response.Response;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.containing;
import static com.github.tomakehurst.wiremock.client.WireMock.equalTo;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo;
import static io.restassured.RestAssured.given;

public class WiremockUtils {
   public static String BASE_URL = "http://localhost:8089";
    public static String accessToken;
    public static String refreshToken;
    public static void setupMocks() {
        stubFor(post(urlEqualTo("/auth/login"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"accessToken\": \"valid-access-token\", \"refreshToken\": \"valid-refresh-token\" }")));

        stubFor(get(urlEqualTo("/protected"))
                .withHeader("Authorization", equalTo("Bearer valid-access-token"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"message\": \"Protected data\", \"user\": {\"name\": \"admin\"} }")));

        stubFor(get(urlEqualTo("/protected"))
                .withHeader("Authorization", equalTo("Bearer expired-access-token"))
                .willReturn(aResponse()
                        .withStatus(401)
                        .withBody("{ \"error\": \"Token expired\" }")));

        stubFor(post(urlEqualTo("/auth/refresh"))
                .withRequestBody(containing("valid-refresh-token"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"accessToken\": \"new-valid-access-token\" }")));

        stubFor(get(urlEqualTo("/protected"))
                .withHeader("Authorization", equalTo("Bearer new-valid-access-token"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody("{ \"message\": \"Protected data after refresh\", \"user\": {\"name\": \"admin\"} }")));
    }

    public static void loginAndGetTokens() {
        Response response = given()
                .contentType("application/json")
                .body("{\"username\": \"admin\", \"password\": \"password\"}")
                .when()
                .post(BASE_URL + "/auth/login")
                .then()
                .statusCode(200)
                .extract().response();

        accessToken = response.jsonPath().getString("accessToken");
        refreshToken = response.jsonPath().getString("refreshToken");

        System.out.println("Access Token: " + accessToken);
        System.out.println("Refresh Token: " + refreshToken);
    }
    public static void useAccessToken() {
        Response response = given()
                .header("Authorization", "Bearer " + accessToken)
                .when()
                .get(BASE_URL + "/protected")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println("Protected API response: " + response.asPrettyString());
    }

    public static void refreshAccessToken() {
        Response response = given()
                .contentType("application/json")
                .body("{\"refreshToken\": \"" + refreshToken + "\"}")
                .when()
                .post(BASE_URL + "/auth/refresh")
                .then()
                .statusCode(200)
                .extract().response();

        accessToken = response.jsonPath().getString("accessToken");
        System.out.println("New Access Token: " + accessToken);
    }
}
