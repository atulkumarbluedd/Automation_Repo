package JavaHandsOn.JsonReaders;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    public String getBranch() {
        return Branch;
    }


    public void setBranch(String branch) {
        Branch = branch;
    }


    public String getCollege() {
        return College;
    }


    public void setCollege(String college) {
        College = college;
    }


    public String getSection() {
        return Section;
    }


    public void setSection(String section) {
        Section = section;
    }


    public String getName() {
        return Name;
    }


    public void setName(String name) {
        Name = name;
    }

    /**
     *  here we have     @JsonProperty("Branch")
     *      * as capital letters were not working so to tell jackson this is specific property.
     */
    @JsonProperty("Branch")
    String Branch;
    @JsonProperty("College")
    String College;
    @JsonProperty("Section")
    String Section;
    @JsonProperty("Name")
    String Name;

}
