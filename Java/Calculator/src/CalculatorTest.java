
public class CalculatorTest {

	public static void main(String[] args) {
		Calculator calc1 = new Calculator();
		Calculator calc2 = new Calculator(1, 1, '+');
		
		calc2.performOperation();
		System.out.println(calc2.getResults());
		
		calc1.setOperandOne(5);
		calc1.setOperandTwo(10);
		calc1.setOperation('*');
		calc1.performOperation();
		System.out.println(calc1.getResults());

	}

}
