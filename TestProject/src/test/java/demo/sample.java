package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class sample extends base{
 
 
 @Test(description = "Longest word in the input file.")
 public void test() throws Exception{
//	 String dir=System.getProperty("C:\\Users\\91977\\OneDrive\\Desktop\\myfile.txt");
//	   FileReader fis= new FileReader(dir);
//	  BufferedReader reader = new  BufferedReader(fis);
//	  
//	  String line;
//	   while((line=reader.readLine())!=null) {
//		   System.out.println(line);
//	   }
//	   reader.close();
	 String  longestWord = "";
	 try {
		
		 System.out.println(System.getProperty("user.dir"));
		 BufferedReader r= new BufferedReader(new FileReader("testing.txt"));
		try {
			String line;
			while((line=r.readLine())!=null) {
				 String words[] =line.split(" ");
				  for(String word:words) {
					  
					  if(longestWord .length()<word.length())
						  longestWord =word;
				  }
			}
		}
		finally {
			r.close();
			System.out.println(longestWord  );
		}
	} catch (IOException e) {
		e.printStackTrace();
		 
	}
  }
}
