package JavaHandsOn.streamConcepts.StreamExamples;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class StudentStreamTest{
    @Test(description = "print students based on marks in increasing order !!")
    public void sampleTest(){
        Student s1 = new Student("X", 1, 50);
        Student s2 = new Student("Y", 2, 60);
        Student s3 = new Student("Z", 3, 40);

        Student[] sArr = { s1, s2, s3 };

        // Sorting using streams based on marks
        Arrays.stream(sArr)
                .sorted(Comparator.comparingInt(Student::getSmarks))
                .forEach(student -> System.out.println(student.getSmarks() + " - Marks: "+ student.getSname()));

        /**
         * print in reverse order
         */
        Arrays.stream(sArr).sorted(Comparator.comparing(Student::getSmarks).
                reversed()).forEach(s-> System.out.println(s.getSname()));
    }
}
