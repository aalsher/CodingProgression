import java.util.HashMap;
public class Hashmatique{
  public void trackList(){
    //create HashMap
    HashMap<String,String> tracklist = new HashMap<>();
    //add four songs into HashMap
    String firstsong = tracklist.put("Closer","We ain't ever getting older");
    String secondsong =tracklist.put("Despacito","Lyrics here");
    String thirdsong =tracklist.put("The Greatest", "Don't give up, no no no");
    String fourthsong =tracklist.put("Thrills","It's Saturday night and the radio is on");

    //retrieve the values
    String retrieve = tracklist.get("Closer");
    System.out.println(retrieve);
    System.out.println(tracklist);
  }
}
