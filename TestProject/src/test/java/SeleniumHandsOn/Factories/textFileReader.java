package SeleniumHandsOn.Factories;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class textFileReader {
    public static void textFileReaderUtil(String path) throws IOException {
        FileReader fis = new FileReader(path);
        BufferedReader reader = new BufferedReader(fis);
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    @Test(description = "this test is to show how this utility works !!")
    public void fileReader() throws IOException {
        textFileReaderUtil("testing.txt");
    }
}
