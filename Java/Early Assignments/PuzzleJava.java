import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class PuzzleJava{

    public ArrayList<Integer> printSum(int[] array){
        int sum = 0;
        ArrayList<Integer> greaterarray = new ArrayList<Integer>();
        for(int val : array){
            sum += val;
            if(val > 10){
                greaterarray.add(val);
            }
        }
        System.out.println(sum);
        return greaterarray;

    }

    public ArrayList<String> shuffle(ArrayList<String> array){
        Collections.shuffle(array);
        ArrayList<String> greaterarray = new ArrayList<String>();
        for (String val : array){
            System.out.println(val);
            if(val.length() >5){
                greaterarray.add(val);
            }
        }
        return greaterarray;
    }


    public void alphabet(ArrayList<Character> array){
        Collections.shuffle(array);

        Character first = array.get(0);
        Character last = 'z';
        for (Character cha : array){
            last = cha;
        }
        System.out.println("The first character in this array is: "+first);
        System.out.println("The last character in this array is: "+last);
        if (first == 'A' || first =='E' || first =='I' || first == 'O' || first == 'U'){
            System.out.println("IT'S VOWEL TIME SON!");
        }
    }

    public ArrayList<Integer> randomArr(){
        ArrayList<Integer> greaterarray = new ArrayList<Integer>();
        int num = 0;
        for (int i = 0; i < 11; i++){
            Random random = new Random();
            num = random.nextInt(46) + 55;
            greaterarray.add(num);

        }
        return greaterarray;
        
    }


    public void minMaxSort(ArrayList<Integer> array){
        Collections.sort(array);
        
        System.out.println(array);
        int min = array.get(0);
        int max = array.get(0);

        for (int val : array){
            if (val > max){
                max = val;
            }
            if (val < min){
                min = val;
            }
        }
        System.out.println("Max value is: "+max);
        System.out.println("Min value is: "+min);
    }

    public String randString(){
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        Random random = new Random();
        StringBuilder finalString = new StringBuilder("abcde");

        for (int i = 0; i <5 ; i++){
            finalString.setCharAt(i, charArray[random.nextInt(25)]);
        }

       return finalString.toString();

    }


    public ArrayList<String> randStrArr(){
        ArrayList<String> array = new ArrayList<String>();
        for (int i = 0; i < 10; i++){
            array.add(randString());
        }

        return array;
    }

}