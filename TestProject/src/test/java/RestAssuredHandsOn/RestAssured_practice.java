package RestAssuredHandsOn;

import RestAssuredHandsOn.PoJO.Comments;
import RestAssuredHandsOn.PoJO.Data;
import RestAssuredHandsOn.PoJO.Response1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RestAssured_practice {

    @Test(description = "this test is to demonstrate path parameters")
    public void TestFor_PathParameter() {
        RestAssured.baseURI = "https://reqres.in/";
        String str = RestAssured.given().pathParams("page", "2")
                .when().get("/api/users/{page}").asPrettyString();
        System.out.println(str);
    }

    @Test(description = "Test is to demonstrate deserialization !!")
    public void deserialization() {
        RestAssured.baseURI = "https://reqres.in/";
        Response1 responseObject = RestAssured.given().pathParams("page", "2")
                .when().get("/api/users/{page}").getBody().
                // here we can use get body or without get body both will work
                as(Response1.class);
        System.out.println(responseObject.getSupport().getText());
        String expected="To keep ReqRes free, contributions towards server costs are appreciated!";
        Assert.assertEquals(responseObject.getSupport().getText().trim()/*Actual*/,expected /*expected*/);
    }

    @Test(description = "this test is to deserialize data into multiple simmilar type of objects !!")
    public void deserialization_similar_objects_And_query_parameters() throws JsonProcessingException {

        RestAssured.baseURI = "https://reqres.in/";
        Response response = RestAssured.given().queryParam("page", "2")
                .when().get("/api/users/").as(Response.class);
        System.out.println(new RestAssuredHandsOn.PoJO.Response().getData()[3].getEmail());
    }

    @Test(description = "this test is about how can we store a part of the response into the pojo" +
            "in this test we have only stored the 3rd data object instead of storing all the Array of data json objects")
    public void deserialize_some_part_of_response() throws JsonProcessingException {

        RestAssured.baseURI = "https://reqres.in/";
        HashMap<String, Object> map = RestAssured.given().queryParam("page", "2")
                .when().get("/api/users/").jsonPath().get("data[2]");
        Data data_Object = new ObjectMapper().readValue(new JSONObject(map).toString(), Data.class);
        System.out.println(data_Object.getFirstName());
    }

    @Test(description = "Deserialize only data array's repeated part from the json response into data class pojo !! ")
    public void deserialize_data_array_only() throws JsonProcessingException {
        RestAssured.baseURI = "https://reqres.in/";
        ArrayList data_array = RestAssured.given().queryParam("page", "2")
                .when().get("/api/users/").jsonPath().get("data");
        /** below is a very important step where we are storing the similar duplicate array of data into class array **/
        Data[] data_Object = new ObjectMapper().readValue(new JSONArray(data_array).toString(), Data[].class);
        System.out.println(data_Object[1].getFirstName());
    }


    /* like this kind of json means repeated objects. where starting is done via Json Arrays.
    [
        {
            "postId": 1,
            "id": 1,
            "name": "id labore ex et quam laborum",
            "email": "Eliseo@gardner.biz",
            "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\ntempora quo necessitatibus\ndolor quam autem quasi\nreiciendis et nam sapiente accusantium"
        },
        {
            "postId": 1,
            "id": 2,
            "name": "quo vero reiciendis velit similique earum",
            "email": "Jayne_Kuhic@sydney.com",
            "body": "est natus enim nihil est dolore omnis voluptatem numquam\net omnis occaecati quod ullam at\nvoluptatem error expedita pariatur\nnihil sint nostrum voluptatem reiciendis et"
        },
     */
    @Test(description = "this test is to demonstrate Handle nested json !!")
    public void nestedJsonHandling() {
            // This is a sample test method
            System.out.println("This is a sample test method in the sample class.");
            RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
            io.restassured.response.Response response = RestAssured.given()
                    .when()
                    .get("/comments")
                    .then()
                    .extract().response();
            // You can add assertions here to validate the response
            // For example, you can check the status code

            Assert.assertEquals(response.statusCode(), 200, "Expected status code is 200");
            // You can also check the response body or other properties
            Assert.assertFalse(response.jsonPath().getList("$").isEmpty(), "Response should contain comments");
            // Print the response body for debugging
//        System.out.println("Response Body: " + response.asString());
            // Additional assertions can be added as needed
            // This is just a sample test, you can modify it as per your requirements
            System.out.println("Sample test executed successfully.");

            // like this you can convert the response to a List of Comments objects
            List<Comments> commentsList = response.as(new TypeRef<>() {
            });
            // You can also convert the response to a custom class if needed
            // For example, if you have a Comments class defined, you can do:

            // Now you can work with the commentsList as needed
            for (Comments comment : commentsList) {
                System.out.println("Post ID: " + comment.getPostId());
                System.out.println("Comment ID: " + comment.getId());
                System.out.println("Name: " + comment.getName());
                System.out.println("Email: " + comment.getEmail());
                System.out.println("Body: " + comment.getBody());
                System.out.println("-----------------------------");
            }


            // one more way to convert the response into List of Comments objects
        List<Comments> commentsList1 = response.jsonPath().getList("$", Comments.class);
        for (Comments comment : commentsList1) {
            System.out.println("Post ID: " + comment.getPostId());
            System.out.println("Comment ID: " + comment.getId());
            System.out.println("Name: " + comment.getName());
            System.out.println("Email: " + comment.getEmail());
            System.out.println("Body: " + comment.getBody());
            System.out.println("-----------------------------");
        }

            // if you want to access a specific comment, you can do so like this:
            // Assuming you want to access the first comment in the list [0] for first comment and [1] for second comment etc.
            System.out.println("------+++++");
            Comments firstComment = response.jsonPath().getObject("[0]", Comments.class);

            System.out.println("First Comment Post ID: " + firstComment.getPostId());
            System.out.println("First Comment ID: " + firstComment.getId());
            System.out.println("First Comment Name: " + firstComment.getName());
            System.out.println("First Comment Email: " + firstComment.getEmail());
            System.out.println("First Comment Body: " + firstComment.getBody());
            System.out.println("-----------------------------");

        }

    @Test(description = "This test is to filter comments by postId using Groovy-based JsonPath")
    // Note: Ensure you have the necessary dependencies for RestAssured and Gson in your project
    public void testFilterCommentsByPostId() {
        // Make the API call
        Response responseBody = RestAssured
                .get("https://jsonplaceholder.typicode.com/comments")
                .then()
                .statusCode(200)
                .extract().response();

        // Filter using Groovy-based JsonPath: postId == 1
        // ==~: Groovy regex match operator
        List<Comments> filteredComments = responseBody.jsonPath()
                .getList("findAll { it.postId == 1 && it.email ==~ /.*\\.biz$/ }", Comments.class);
        /**
         * | Part    | Meaning                                                                            |
         * | ------- | ---------------------------------------------------------------------------------- |
         * | `/.../` | Delimiters for a regular expression in Groovy                                      |
         * | `.*`    | Match **any number of any characters** (except newline)                            |
         * | `\\.`   | A **literal dot `.`**, because in regex `.` means "any character", so we escape it |
         * | `biz`   | Just the string `"biz"`                                                            |
         * | `$`     | End of the string (ensures it ends with `.biz`)                                    |
         *
         *   \. → escapes dot in regex
         * But \. in Java must be written as "\\." in a string
         * In Groovy regex /.../, only one backslash is needed But inside Java string literals, you must double it, so:
         *
         * | Context        | Regex Pattern  |
         * | -------------- | -------------- |
         * | Java string    | `"^.*\\.biz$"` |
         * | Groovy pattern | `/.*\.biz$/`   |
         */

        // Assert the list is not empty
        Assert.assertFalse(filteredComments.isEmpty(), "Filtered list should not be empty");

        // Assert all postIds in filtered list are 1
        for (Comments comment : filteredComments) {
            Assert.assertEquals(comment.getPostId(), 1, "postId mismatch in comment: " + comment.getId());
        }

        // Print for reference
        filteredComments.forEach(c -> System.out.println("ID: " + c.getId() + " Email: " + c.getEmail()));
    }


@Test(description = "one more way to deserialize the response using Gson")
    public void deserializeResponseUsingGson() {
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
     Response responseBody =  RestAssured.given()
            .when()
            .get("/comments")
            .then()
            .extract().response();

     Comments comments=new Gson().fromJson(responseBody.getBody().asString(), Comments.class);


    Gson gson = new GsonBuilder().setPrettyPrinting().create();


}

}




/** 2nd way to convert response into List of Comments objects using Gson
 * Gson gson = new Gson();
 * Type type = new TypeToken<List<Comments>>(){}.getType();
 * List<Comments> commentsList = gson.fromJson(response.asString(), type);
 */


/* using object mapper
ObjectMapper mapper = new ObjectMapper();
List<Comments> commentsList = mapper.readValue(response.asString(), new TypeReference<List<Comments>>() {});

 */


/**
 * | Library     | Type Needed                       | Notes                        |
 * | ----------- | --------------------------------- | ---------------------------- |
 * | RestAssured | `response.as(new TypeRef<>() {})` | Uses Jackson internally      |
 * | Gson        | `new TypeToken<List<Comments>>()` | Good for stand-alone parsing |
 */

