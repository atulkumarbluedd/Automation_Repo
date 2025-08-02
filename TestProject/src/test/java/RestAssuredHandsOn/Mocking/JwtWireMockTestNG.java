package RestAssuredHandsOn.Mocking;
import RestAssuredHandsOn.ApiUtils.WiremockUtils;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.testng.annotations.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


// todo: ********Real time scenario using WireMock for JWT authentication flow**********
// todo: class demonstrates how to use WireMock to mock JWT authentication flows in a TestNG environment



/** JSON Web Token. :: JWT
 * Here we have 3 parts
 * 1. Header
 * 2. Payload
 * 3. Signature
 *
 *
 *  eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9
 *  .eyJ1c2VyIjoiYWRtaW4iLCJpYXQiOjE3NTQxNDA5ODEsImV4cCI6MTc1NDE0NDU4MX0
 *  .zuSmSt_tJ48FudXaDwFanNmZXZbvLL15esMegan9LL0
 *
 * we can decode the JWT token using online tools like https://www.jwt.io/
 *
 *  The payload decoded (base64) is something like:
 * {
 *   "user": "admin",
 *   "iat": 1754140981,
 *   "exp": 1754144581
 * }
 *
 *
 */


public class JwtWireMockTestNG extends WiremockUtils {
    static WireMockServer wireMockServer;



    @BeforeClass
    public void startWireMock() {
        wireMockServer = new WireMockServer(8089);
        wireMockServer.start();
        configureFor("localhost", 8089);
        setupMocks();
    }

    @AfterClass
    public void stopWireMock() {
        if (wireMockServer != null && wireMockServer.isRunning()) {
            wireMockServer.stop();
        }
    }

    @Test(priority = 1)
    public void testLoginAndGetTokens() {
        loginAndGetTokens();
        assert accessToken != null && !accessToken.isEmpty() : "Access token should not be null";
        assert refreshToken != null && !refreshToken.isEmpty() : "Refresh token should not be null";
        System.out.println("Login tokens received successfully");
    }

    @Test(priority = 2, dependsOnMethods = "testLoginAndGetTokens")
    public void testAccessWithExpiredToken() {
        accessToken = "expired-access-token";
        useAccessToken();  // Will assert inside that 401 is returned
    }

    @Test(priority = 3, dependsOnMethods = "testAccessWithExpiredToken")
    public void testRefreshToken() {
        refreshAccessToken();
        assert accessToken.equals("new-valid-access-token") : "Access token should be refreshed";
        System.out.println("Token refreshed successfully");
    }

    @Test(priority = 4, dependsOnMethods = "testRefreshToken")
    public void testAccessWithNewToken() {
        useAccessToken();  // Will assert inside that 200 is returned
    }




}
