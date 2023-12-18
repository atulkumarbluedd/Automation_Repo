package JavaHandsOn.JsonReaders;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class JsonReader_jackson {
    @Test(description = "Read json file !!")
    public void jsonReader() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("./Resources/newFile.json");
        // Read json data from a file and map into Person.class file
        Person person = mapper.readValue(file, Person.class);

        /* file reading */
        System.out.println(person.getName());
        System.out.println(person.getSection());
        System.out.println(person.getCollege());
    }
    @Test(description = "write json file !!")
    public void writeJsonFile() throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person();
        person.setCollege("IIM shilong");
        person.setName("ATUL kr. arya");
        person.setBranch("CSE");

        /* file writing */
        File file = new File("./Resources/test.json");
        mapper.writeValue(file,person);
    }
}
