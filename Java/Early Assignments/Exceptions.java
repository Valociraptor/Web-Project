import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.HashMap;


public class Exceptions{
    public static void main(String[] args){

        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");

        for (Object item : myList){
            try{
                Integer castedValue = (Integer) item;
                System.out.println("It worked!");
            }

            catch (ClassCastException e){
                System.out.println("Yeah that failed...");
            }
        }

        

    }
}