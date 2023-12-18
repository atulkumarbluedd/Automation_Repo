package JavaHandsOn.JsonReaders;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class jsonHandling_using_JsonSimple_lib {
    private JSONObject empjsonObject;

    /**
     * Here we require only one jar of json.simple to perform below tasks
     */
    @Test(description = "This test is to create json object and push into new json file")
    public void createJson() throws IOException {

        FileWriter file = new FileWriter("./Resources/test.json");
        JSONObject jsonobject = new JSONObject();
        jsonobject.put("Name", "Kotte");
        jsonobject.put("College", "BVRIT");
        jsonobject.put("Branch", "Computer science engineering");
        jsonobject.put("Section", "CSE-C");
        System.out.println(jsonobject);
        file.write(jsonobject.toJSONString());
        file.close();
//        JSONObject object = new JSONObject(file);
    }

    @Test(description = "This test is about reading json file !!")
    public void readJson_from_jsonFile() throws IOException, ParseException {
        /* convert json file into java object*/
        JSONArray object = (JSONArray) new JSONParser().parse(new FileReader("./Resources/sample.json"));
        JSONObject Jsoninput = (JSONObject) object.getFirst();
        System.out.println(Jsoninput);
        String squadName = (String) Jsoninput.get("squadName");
        System.out.println(squadName);
    }
}
