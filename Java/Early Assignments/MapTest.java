import java.util.ArrayList;

public class MapTest{
    public static void main(String[] args){
        
        String title = "Walrus";

        Map x = new Map();

        System.out.println(x.lyricGet(title));
        System.out.println(x.lyricGet("Tiger"));
        System.out.println(x.lyricGet("Crane"));
        System.out.println(x.lyricGet("Bees"));

    }

}