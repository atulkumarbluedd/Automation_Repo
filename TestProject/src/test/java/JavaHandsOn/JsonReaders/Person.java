package JavaHandsOn.JsonReaders;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {
    /**
     * here we have     @JsonProperty("Branch")
     * as capital letters were not working so to tell jackson this is specific property.
     *
     * @return
     */
    @JsonProperty("Branch")
    public String getBranch() {
        return Branch;
    }

    @JsonProperty("Branch")
    public void setBranch(String branch) {
        Branch = branch;
    }

    @JsonProperty("College")
    public String getCollege() {
        return College;
    }

    @JsonProperty("College")
    public void setCollege(String college) {
        College = college;
    }

    @JsonProperty("Section")
    public String getSection() {
        return Section;
    }

    @JsonProperty("Section")
    public void setSection(String section) {
        Section = section;
    }

    @JsonProperty("Name")
    public String getName() {
        return Name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        Name = name;
    }

    String Branch;
    String College;
    String Section;
    String Name;

}
