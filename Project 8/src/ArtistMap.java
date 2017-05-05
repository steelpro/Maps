import java.util.Vector;

/* Zachary Betters
 * CIS 211
 * Project 8
 * 4/12/17 
 */

@SuppressWarnings("hiding")
public class ArtistMap<Integer extends Comparable<? super Integer>, String> {
	
	private Vector<Artist> dictionary; 	

	public ArtistMap() {
		dictionary = new Vector<>(); 
	} 

	public ArtistMap(int initialCapacity) {
		dictionary = new Vector<>(initialCapacity);
	} 

    public String add(int artistID, String artistname) {
    	
	  String result = null;	
      int keyIndex = locateIndex(artistID);
      
      //create new artist based on data given
	  Artist newEntry = new Artist(artistID, artistname);
	  
	  //add to vector
	  dictionary.add(keyIndex, newEntry);
				
	  return result;
	} 

   public String getValue(int artistID) {
	   
      String result = null;  

      int keyIndex = locateIndex(artistID);
		
      if ( (keyIndex < dictionary.size()) && 
		      artistID == (dictionary.get(keyIndex)).getKey() ) {
         result = (dictionary.get(keyIndex)).getValue();
	  } 
		
	 return result;
   } 

	private int locateIndex(int artistID) {
      
		int numberOfEntries = dictionary.size();
		int index = 0;
		
		while ( (index < numberOfEntries) && 
		         (artistID < ( (dictionary.get(index)).getKey()) ) ) {
			index++;
		} 
		
		return index;
	} 

   public int getSize() {
      return dictionary.size();
   } 
	
	private class Artist {
		
		private int artistID;
		private String artistname;
		
		private Artist(int searchKey, String dataValue) {
			artistID = searchKey;
			artistname = dataValue;
		} 
		
		private int getKey() {
			return artistID;
		} 
		
		public String getValue() {
			return artistname;
		} 
	} 
} 