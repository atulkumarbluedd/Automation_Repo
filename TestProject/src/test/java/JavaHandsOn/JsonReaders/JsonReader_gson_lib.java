package JavaHandsOn.JsonReaders;

import RestAssuredHandsOn.PoJO.Comments;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

public class JsonReader_gson_lib {
    @Test
    public void ReadJsonFile_using_Gson() throws FileNotFoundException {
        FileReader file = new FileReader("./Resources/newFile.json");
        Gson gson = new Gson();
        Person person = gson.fromJson(file, Person.class);


        /* file reading started */

        System.out.println(person.getCollege());
        System.out.println(person.getSection());
    }

    @Test(description = "This test is about writing json data into new json file")
    public void fileWriting_gson() throws IOException {
        FileWriter writer = new FileWriter("./Resources/test.json");
        /* data to be set*/
        Person person = new Person();
        person.setBranch("ECE");
        person.setName("Atul kumar Arya");
        person.setCollege("IIT Kanpur");

        /* gson object creation*/
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); // for pretty print
//        Gson gson = new Gson();
        String jsonString = gson.toJson(person);
        System.out.println(jsonString);
        writer.write(jsonString);
        writer.close();

    }

    @Test(description = "Print json in console using from jsonFile !! And then read from jsonString and get a specific result")
    public void readDatafromFile() throws Exception {
        String output = new Gson().toJson(JsonParser.parseReader(new FileReader("./Resources/newFile.json")));
        System.out.println(output);
        /** json string to jsonObject*/
        JsonElement jsonElement = JsonParser.parseString(output);
        JsonObject object = jsonElement.getAsJsonObject();
        System.out.println(object.get("Branch"));
        System.out.println(object.get("College"));

        /** another test case for json array */
        String jsonString = new Gson().toJson(JsonParser.parseReader(new FileReader("./Resources/sample.json")));
        JsonElement jsonElement1 = JsonParser.parseString(jsonString);
        JsonArray jsonArray = jsonElement1.getAsJsonArray();
        jsonArray.get(0);
        System.out.println(jsonArray.get(0).getAsJsonObject().get("squadName"));
    }

    @Test(description = "deserialization and seralization using gson")
    public void deserialization_serialization() throws IOException {
        Gson gson = new Gson();
        Person person = new Person();
        person.setName("Atul kumar Arya");
        person.setCollege("IIT Kanpur");
        person.setBranch("CSE");

        /* serialization */
        String jsonString = gson.toJson(person);
        System.out.println(jsonString);

        /* deserialization */
        Person person1 = gson.fromJson(jsonString, Person.class);
        System.out.println(person1.getName());
        System.out.println(person1.getCollege());
        System.out.println(person1.getBranch());
        assert Objects.equals(person1.getName(), "Atul kumar Arya");
    }
    @Test(description = "Gson props")
    public void readJsonFromApi() {
        Gson gson = new GsonBuilder()
                .serializeNulls()                  // include nulls in JSON
                .disableHtmlEscaping()            // avoid escaping HTML characters
                .setPrettyPrinting()
                .create();


        // prop 2 :

        /**
         * When you don’t have a POJO or structure is unknown
         */
        String responseBody ="""
                [
                    {
                        "postId": 1,
                        "id": 1,
                        "name": "id labore ex et quam laborum",
                        "email": "Eliseo@gardner.biz",
                        "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium"
                    },
                    {
                        "postId": 1,
                        "id": 2,
                        "name": "quo vero reiciendis velit similique earum",
                        "email": "Jayne_Kuhic@sydney.com",
                        "body": "est natus enim nihil est dolore omnis voluptatem numquam\\net omnis occaecati quod ullam at\\nvoluptatem error expedita pariatur\\nnihil sint nostrum voluptatem reiciendis et"
                    }
                ]
                
                """;
        JsonArray jsonarr = JsonParser.parseString(responseBody).getAsJsonArray();
        JsonObject jsonObject = jsonarr.get(1).getAsJsonObject();
        System.out.println("+++++++++++++++++");
        System.out.println(jsonObject.get("name").getAsString());


        // prop 3 :


        String jsonArray = """
                [
                    {
                        "postId": 1,
                        "id": 1,
                        "name": "id labore ex et quam laborum",
                        "email": "Eliseo@gardner.biz",
                        "body": "laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium"
                    },
                    {
                        "postId": 1,
                        "id": 2,
                        "name": "quo vero reiciendis velit similique earum",
                        "email": "Jayne_Kuhic@sydney.com",
                        "body": "est natus enim nihil est dolore omnis voluptatem numquam\\net omnis occaecati quod ullam at\\nvoluptatem error expedita pariatur\\nnihil sint nostrum voluptatem reiciendis et"
                    }
                ]
                
                """;

        Type type = new TypeToken<List<Comments>>() {}.getType();
        List<Comments> comments = new Gson().fromJson(jsonArray, type);

        System.out.println(comments.get(0).getName());

    }

    /**
     * | Library     | Type Needed                       | Notes                        |
     * | ----------- | --------------------------------- | ---------------------------- |
     * | RestAssured | `response.as(new TypeRef<>() {})` | Uses Jackson internally      |
     * | Gson        | `new TypeToken<List<Comments>>()` | Good for stand-alone parsing |
     */

}