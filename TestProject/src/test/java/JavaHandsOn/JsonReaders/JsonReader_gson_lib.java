package JavaHandsOn.JsonReaders;

import com.google.gson.*;
import org.testng.annotations.Test;

import java.io.*;

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
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
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
}
