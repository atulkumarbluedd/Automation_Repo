package RestAssuredHandsOn;

import RestAssuredHandsOn.PoJO.Data;
import RestAssuredHandsOn.PoJO.Response;
import RestAssuredHandsOn.PoJO.Response1;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.json.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;

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
                .when().get("/api/users/{page}").as(Response1.class);
        System.out.println(responseObject.getSupport().getText());
    }

    @Test(description = "this test is to deserialize data into multiple simmilar type of objects !!")
    public void deserialization_similar_objects_And_query_parameters() throws JsonProcessingException {

        RestAssured.baseURI = "https://reqres.in/";
        Response response = RestAssured.given().queryParam("page", "2")
                .when().get("/api/users/").as(Response.class);
        System.out.println(response.getData()[3].getEmail());
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

}
