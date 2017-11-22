public class StringManipulatorTesting{
    public static void main(String[] args){
        StringManipulator x = new StringManipulator();

        String y = x.trimAndConcat("Die in a ", "Fire");
        // System.out.println(y);


        // char letter = 'o';
        // Integer a = x.getIndexOrNull("Coding", letter);
        // Integer b = x.getIndexOrNull("Hello World", letter);
        // Integer c = x.getIndexOrNull("Hi", letter);
        // System.out.println(a); // 1
        // System.out.println(b); // 4
        // System.out.println(c); // null


        String word = "barnyard";
        String subString = "yard";
        String notSubString = "sdfgfd";
        Integer d = x.getIndexOrNull(word, subString);
        Integer e = x.getIndexOrNull(word, notSubString);
        System.out.println(d); // 2
        System.out.println(e); // null

        // String word = x.concatSubstring("Hello", 1, 2, "world");
        // System.out.println(word); // eworld


            }
}