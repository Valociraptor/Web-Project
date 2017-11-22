import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.HashMap;

public class Map{

    public String lyricGet(String title){
        HashMap<String, String> trackList = new HashMap<String, String >();

        trackList.put ("Walrus", "I AM THE WALRUS, GOO GOO GA JOOB");
        trackList.put ("Tiger", "TIGER STYLE! TIGER STYLE! TIGER STYLE! TIGER STYLE! ");
        trackList.put ("Crane", "Blah blah blah blah blah blah blah blah blah ");
        trackList.put ("Bees", "ZZZZZZZZZZZZZZZZZZZZzzzzzzzzzzz");

        String lyrics = trackList.get(title);

        return lyrics;



    }
}
