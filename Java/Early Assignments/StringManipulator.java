public class StringManipulator{
    public String trimAndConcat(String str1, String str2){
        return str1 + str2;
    } 

    public Integer getIndexOrNull(String str1, char cha){
        int result = str1.indexOf(cha);
        if (result == -1){
            return null;
        }

        return result;
    }

    public Integer getIndexOrNull(String str1, String str2){

        int result = str1.indexOf(str2);
        if (result == -1){
            return null;
        }

        return result;

    }    


    public String concatSubstring(String str1, int num1, int num2, String str2){
        String newstring = str1.substring(num1, num2);


        return newstring + str2;
    }

}