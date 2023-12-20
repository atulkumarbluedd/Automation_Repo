package JavaHandsOn;

import java.io.FileReader;
import java.io.IOException;

public class FileReading {
 
	public static void main(String[] args) {
		try {
            try (FileReader reader = new FileReader("testing.txt")) {
                int i;
                while ((i = reader.read()) != -1) {
                    System.out.print((char) i);
                }
            }
		}
		catch(IOException e) {
			System.out.println("Exception Handled..!");
		}
	}
}
