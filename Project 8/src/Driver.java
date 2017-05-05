import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/* Zachary Betters
 * CIS 211
 * Project 8
 * 4/12/17 
 */

public class Driver {

	public static void main(String[] args) throws IOException {
		
		 ArtCollections artDirectory = new ArtCollections();
		 
	     String fileName = "p7arts.txt"; 	     
	     Scanner data = new Scanner(new File(fileName));
	     
	     artDirectory.readArts(data);
	     artDirectory.writeFile();
	     artDirectory.print();
	}
}