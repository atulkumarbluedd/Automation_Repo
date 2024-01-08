package JavaHandsOn.streamConcepts.StreamExamples;

import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Student {



    @Getter
    @Setter
    private String sname;
    @Getter
    @Setter
    private int smarks;
    private int sid;

    public Student(String sname, int sid, int smarks) {
        this.sname = sname;
        this.sid = sid;
        this.smarks = smarks;
    }


    public void compare(int marks) {
        if (this.smarks > marks) {
            System.out.println(this.sname + " has higher marks.");
        } else if (this.smarks < marks) {
            System.out.println(this.sname + " has lower marks.");
        } else {
            System.out.println(this.sname + " has the same marks.");
        }
    }


}
