import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/* Zachary Betters
 * CIS 211
 * Project 8
 * 4/12/17 
 */

public class ArtCollections {
	
   public ArtistMap <Integer, String> artist; //create map to store artists
   private ArrayList<ArtistMap <Integer, String>> artists; //create list to store maps
   private ArrayList<Art> artWorks; //create list to store art

   public ArtCollections() throws FileNotFoundException { 
      artists = new ArrayList<ArtistMap <Integer, String>>();
      artist = new ArtistMap<Integer, String>();
      artWorks = new ArrayList<Art>();  
      storeArtists();
   } 
   
   public ArrayList<ArtistMap <Integer, String>> storeArtists()
		   throws FileNotFoundException {

		Scanner fileArtists = null;
		
		try { fileArtists = new Scanner(new File("p7artists.txt")); } 
		catch (Exception e) { System.out.println("Cannot import data from p7artists.txt"); }
		
		fileArtists.useDelimiter("\t|\r\n");
		
		try {
			while (fileArtists.hasNext()) {
				
				int artistID = fileArtists.nextInt(); 
				String artistName = fileArtists.next();

				artist.add(artistID, artistName); //create artist, add to map
				artists.add(artist); //add created artist to list of maps
			}	
		}
		catch (Exception e) { System.out.println("Cannot store data from p7artists.txt!"); }

		fileArtists.close();
		return artists; 
	}
   
    //store file given
    public void readArts(Scanner data) throws FileNotFoundException {
	   
    	data.useDelimiter("\t|\r\n");
	  
    	while (data.hasNext()) {
    	  
    		int artID = data.nextInt();
    		String artTitle = data.next();
    		int artistID = data.nextInt();				
    		int apprVal = data.nextInt();
    		
    		Art newArt = new Art(artID, artTitle, artistID, apprVal);
    		artWorks.add(newArt); //create and store art based on data from file
    	} 
      
    	Collections.sort(artWorks); //sort by artist ID and artID
    	data.close();  
   } 
    
   //print data to file 
   public void writeFile() throws IOException {
	   
	   BufferedWriter fileOut = null; 
		
	   try { fileOut = new BufferedWriter(new FileWriter("p8out(Zach).txt", false)); }
	   catch (Exception e) { System.out.println("Cannot create file to export to!"); }
	   
	   try {
		   
		   //print headers 
		   fileOut.write(String.format("%s %12s %7s %18s %25s \r\n\r\n", 
				"Artist ID", "Artist Name", "Art ID", "Art Title", "Appraised Value"));   
	   
		   for (int i = 0; i < artWorks.size(); i++) {
			   
			   //receive data
			   int artistID = artWorks.get(i).getArtistID();
			   String artistName = (String) artists.get(artistID-1).getValue(artistID);
			   
			   //write data to file and call writeFile() method to write other data
			   fileOut.write(String.format("%3d %15s", artistID, artistName));
			   artWorks.get(i).writeFile(fileOut);	
		   }
	   }
	   catch (Exception e) { System.out.println("Cannot write data to p8out(Zach).txt"); }
	   fileOut.close();
   }
   
   public void print() throws IOException {
	      
	   System.out.printf("%s %12s %7s %18s %25s \n\n", 
				"Artist ID", "Artist Name", "Art ID", "Art Title", "Appraised Value");
	   
	   for (int i = 0; i < artWorks.size(); i++) {
		   
		   int artistID = artWorks.get(i).getArtistID();
		   String artistName = (String) artists.get(artistID-1).getValue(artistID);

		   System.out.printf("%3d %15s", artistID, artistName); 
		   artWorks.get(i).toString();
	   }
   }
} 