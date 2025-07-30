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
        /* here we are deserialization of Person Object*/
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
    @Test(description = "print directly in console  json string and then deserialize it !!")
    public void deserialization_serialization_without_Json_File() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Person person = new Person();
        person.setCollege("IIM shilong");
        person.setName("ATUL kr. arya");
        person.setBranch("CSE");
        /* print in console as string*/
        // Serialize
        String ans = mapper.writeValueAsString(person);
        System.out.println(ans);

        // Deserialize

        Person person1 = mapper.readValue(ans, Person.class);
        System.out.println(person1.getName());
        System.out.println(person1.getCollege());
        System.out.println(person1.getBranch());
        System.out.println(person1.getSection());

    }
}
