import java.util.*;

public class Jukebox5{
	public static void main(String[] args) {
		new Jukebox5().go();
	}

	public void go(){
		List<SongV3> songList = MockSongs.getSongsV3();
		System.out.println(songList);

		songList.sort((one, two) -> one.getTitle().compareTo(two.getTitle()));
		System.out.println(songList);

		Set<SongV3> songSet = new TreeSet<>(songList);
		System.out.println(songSet);

		Set<SongV3> songSet = new TreeSet<>((o1, o2) -> o1.getBpm() - o2.getBpm());
		songSet.addAll(songList);
		System.out.println(songSet);

		//Set<SongV3> songSet = new HashSet<>(songList); //HashSet has a constructor to  take made list and work with items in it.
		//System.out.println(songSet);

		//songList.sort((one, two) -> one.getArtist().compareTo(two.getArtist()));
	//	System.out.println(songList);

		//songList.sort((one, two) -> one.getBpm() - two.getBpm());
		//System.out.println(songList);	// different syntax, why? 

		//songList.sort((one, two) -> two.getTitle().compareTo(one.getTitle()));
		//System.out.println(songList);	// decending order two - one
	}
}


class SongV3 implements Comparable<SongV3>{
	private String title;
	private String artist;
	private int bpm;
	
	public boolean equals(Object aSong) { //overridden hashCode() and equas() woow :o!!! MUST to remove dublicates
		SongV3 other = (SongV3) aSong;
		return title.equals(other.getTitle());
	}

	public int hashCode() { //overridden hashCode() and equas() woow :o!!! MUST to remove dublicates
		return title.hashCode();
	}

	public int compareTo(SongV3 s){
		return title.compareTo(s.getTitle());
	}

	SongV3(String title, String artist, int bpm) {
		this.title = title;
		this.artist = artist;
		this.bpm = bpm;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int getBpm() {
		return bpm;
	}
	
	public String toString() {
		return title;
	}
}

class MockSongs {
	public static List<String> getSongStrings() {
		List<String> songs = new ArrayList<>();
		songs.add("somersault");
		songs.add("casidity");
		songs.add("$10");
		songs.add("havana");
		songs.add("casidity");
		songs.add("50 Ways");
		return songs;
	}
	public static List<SongV3> getSongsV3() {
		List<SongV3> songs = new ArrayList<>();
		songs.add(new SongV3("somersault", "zero 7", 147));
		songs.add(new SongV3("casidity", "grateful dead", 158));
		songs.add(new SongV3("$10", "hitchhiker", 140));

		songs.add(new SongV3("havana", "cabello", 105));
		songs.add(new SongV3("casidity", "grateful dead", 158));
		songs.add(new SongV3("50 ways", "simon", 102));
		return songs;
	}

}

// JAVA 7 <> diamond operator was introduced. ArrayList IS-A List. 
// e.g. List<Dog> d = new List<>();
// GENERICS feature added in java 5 (this type brackets < >). 
