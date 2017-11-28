
public class Calculator {
	private double operandOne = 0;
	private double operandTwo = 0;
	private char operation;
	private double results;
	
	
	public void performOperation() {
		if (operation == '+') {
			results = add();
		}
		
		else if (operation == '-') {
			results = subtract();
		}
		
		else if (operation == '*') {
			results = multiply();
		}
		
		else if (operation == '/') {
			results = divide();
		}
		
		else{
			System.out.println("You have not submited a valid operation character!");
		}
	}
	
	private double add() {
		return operandOne + operandTwo;
	}
	private double subtract() {
		return operandOne - operandTwo;
	}
	
	private double multiply() {
		return operandOne * operandTwo;
	}
	
	private double divide() {
		return operandOne / operandTwo;
	}
	
	
	
	
	
	public double getResults() {
		
		return results;
	}

	public Calculator() {
		
	}
	
	public Calculator(double op1, double op2, char operation) {
		operandOne = op1;
		operandTwo = op2;
		this.operation = operation;
	}
	
	
	
	
	public double getOperandOne() {
		return operandOne;
	}
	public void setOperandOne(double operandOne) {
		this.operandOne = operandOne;
	}
	public double getOperandTwo() {
		return operandTwo;
	}
	public void setOperandTwo(double operandTwo) {
		this.operandTwo = operandTwo;
	}
	public char getOperation() {
		return operation;
	}
	public void setOperation(char operation) {
		this.operation = operation;
	}
	
	
	
	
}
