package JavaHandsOn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class logestStringInFile   {


    @Test(description = "Longest word in the input file.")
    public void test() throws Exception {

        String longestWord = "";
        try {
            try (BufferedReader r = new BufferedReader(new FileReader("testing.txt"))) {
                String line;
                while ((line = r.readLine()) != null) {
                    String words[] = line.split(" ");
                    for (String word : words) {

                        if (longestWord.length() < word.length())
                            longestWord = word;
                    }
                }
            } finally {
                System.out.println(longestWord);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
