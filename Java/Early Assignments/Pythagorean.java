public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        legA *= legA;
        legB *= legB;
        
        double legC = Math.sqrt(legA + legB);
        return legC;
    }
}