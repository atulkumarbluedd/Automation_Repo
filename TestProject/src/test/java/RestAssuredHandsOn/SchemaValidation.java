package RestAssuredHandsOn;

import RestAssuredHandsOn.PoJO.User;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

// - JSON Schema Validator dependency is required for this test
public class SchemaValidation {
    @Test(description = "Validate the schema of the response")
    public void validateSchema() {
            RestAssured.baseURI = "https://api.example.com";

            Response response = given()
                    .when()
                    .get("/users/1")
                    .then()
                    .assertThat()
                    .statusCode(200)
                    //todo: Need to add the schema File here
                    .body(matchesJsonSchema(new File("src/test/resources/schemas/user-schema.json")))
                    .extract().response();

            // Deserialize using Gson
            String responseBody = response.getBody().asString();
            User user = new Gson().fromJson(responseBody, User.class);

            // Basic assertions using POJO
            assert user.getId() == 1;
            assert user.getName().equals("Atul");
            System.out.println("All assertions passed ✅");
        }

}
