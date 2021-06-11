import java.util.HashMap;
import java.util.Set;

public class Hashmatique {
	public static void main (String [] args){
		HashMap<String,String> trackList = new HashMap<String,String>();

		
		trackList.put("Track 1", "Good Bye My Lover");
		trackList.put("Track 2", "If Tomorrow Never Comes");
		trackList.put("Track 3", "The Twist");
		trackList.put("Track 4", "Soledad");
		
		System.out.println(trackList.get("song Title :" + "Track 2"));
		
		Set <String> tracks = trackList.keySet();
		for (String track : tracks){
        //System.out.print("Song Title : " + track + " : ");
        System.out.println("Song Lyrics : " + trackList.get(track));
		}
	}
}

