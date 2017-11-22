import java.util.ArrayList;
public class BasicJava{
    public void printAll(){
        for(int i = 1 ; i <256; i++){
            System.out.println(i);
        }

    }

    public void printOdd(){
        for(int i = 1 ; i <256; i += 2){
            System.out.println(i);
        }
    }

    public void printSum(){
        int sum = 0;
        for(int i = 1 ; i <256; i++){
            sum += i;
            System.out.println("New number: "+i+" Sum: "+ sum);
        }
    }

    public void itArr(int[] arr){
        for(int val : arr){
            System.out.println(val);
        }
    }

    public int findMax(int[] arr){
        int max = 0;
        for(int val : arr){
            if (val > max){
                max = val;
            }
        }
        return max;
    }

    public void getAverage(int[] arr){
        int length = arr.length;
        double avg = 0;
        for (int i = 0; i < length; i++){
            avg += (int) arr[i];
        }
        avg = avg/length;
        System.out.println(avg);
    }

    public ArrayList<Integer> oddArr(){
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i = 1; i <256 ; i +=2){
            y.add(i);
        }
        return y;
    }

    public int overY(int[]arr, int val){
        int counter = 0;
        for (int idx : arr){
            if (idx > val){
                counter++;
            }
        }
        return counter;
    }

    public int[] squareIt(int[] arr){

        for (int i = 0; i <arr.length; i++){
            arr[i] = arr[i]*arr[i];
            System.out.println(arr[i]);
        }
        
        return arr;
    }

    public void minusArr(int[] array){
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        int length = array.length;

        for(int i = 0; i < length; i++) {
            if(array[i] < 0) {
                myArray.add(0);
            } else {
                myArray.add(array[i]);
            }
        }

        System.out.println(myArray);  
    }


    public ArrayList<Integer> minMaxAvg(int[] arr){
        int min = 0;
        int max = 0;
        int avg = 0;

        int length = arr.length;
        for (int i = 0; i < length; i++){
            avg += (int) arr[i];
        }
        avg = avg/length;

        for(int val : arr){
            if (val > max){
                max = val;
            }
        }

        for(int val : arr){
            if (val < min){
                min = val;
            }
        }  

        ArrayList<Integer> myArray = new ArrayList<Integer>();
        myArray.add(max);
        myArray.add(min);
        myArray.add(avg);

        return myArray;
    }

    public void arrayShift(int[] givenArray){
        int length = givenArray.length - 1;

        for(int i = 0; i < length; i++){
            givenArray[i] = givenArray[i + 1];
        }

        givenArray[length] = 0;

        System.out.println(givenArray);
    }   

}
