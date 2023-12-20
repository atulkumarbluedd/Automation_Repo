package SeleniumHandsOn.Factories;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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

    public static void textFileWriter(String path) {
        try (FileWriter writer = new FileWriter(path)) {
            writer.write("new text added");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void appendTextFile(String path) {
        try (FileWriter writer = new FileWriter(path,true)) {
            writer.write("appended text");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Test(description = "this test is to show how this utility works !!")
    public void fileReader() throws IOException {
        textFileReaderUtil("testing.txt");
        appendTextFile("sample.txt");
        textFileWriter("sample.txt");
        textFileReaderUtil("sample.txt");
    }
}
