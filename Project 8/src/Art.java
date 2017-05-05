import java.io.BufferedWriter;
import java.io.IOException;

/* Zachary Betters
 * CIS 211
 * Project 8
 * 4/12/17 
 */

public class Art implements Comparable<Art> {

	private int artID; 
	private String artTitle;  
	private int artistID;
	private int appraisedValue;
	
	//constructor  
	public Art(int id, String title, int artistID, int value) {
		artID = id;
		artTitle = title;
		this.artistID = artistID;
		appraisedValue = value;
	} 
	
	public int getArtID() {
		return artID;
	}

	public void setArtID(int id) {
		artID = id;
	}

	public String getArtTitle() {
		return artTitle;
	}

	public void setArtTitle(String title) {
		artTitle = title;
	}

	public int getArtistID() {
		return artistID;
	}

	public void setArtistID(int id) {
		artistID = id;
	}

	public int getAppraisedValue() {
		return appraisedValue;
	}

	public void setAppraisedValue(int value) {
		appraisedValue = value;
	}
	
	public String toString() { 
		System.out.printf("%10d %28s %12d\n", artID, artTitle, appraisedValue);	
		return "";
	}
	
	//method to write to given file
	public void writeFile(BufferedWriter file) throws IOException {	
		file.write(String.format("%10d %28s %12d\r\n", 
				artID, artTitle, appraisedValue));	
	}

	//method for sorting (sort by artistID first, then by artID)
	public int compareTo(Art other) {
		
		if (artistID == other.artistID) {
			if (artID > other.artID)
				return 1;
			
			else if (artID < other.artID)
				return -1;
      	else
      		return 0;
        }
		else if (artistID < other.artistID)
			return -1;
		else
			return 1;
	} 
} 