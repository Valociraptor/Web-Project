import java.util.Random;

public class BankAccount {
	protected double checkingBal;
	protected double savingBal;
	protected Integer accNum;
	private static Integer numberOfAcc = 0;
	private static double totalMoney = 0.00;
	
	public BankAccount() {
		checkingBal = 0.00;
		savingBal = 0.00;
		accNum = getAccNum();
		numberOfAcc++;
		System.out.println("Your new Account Number is: "+ accNum);
	}
	
	private static Integer getAccNum() {
		Random random = new Random();
		Integer num = random.nextInt(1000000000)+900000000 ;
		return num;
	}
	
	public double getCheckBal() {
		System.out.println("Your Checking Account balance is: "+ checkingBal);
		return checkingBal;
		
	}
	
	
	public double getSaveBal() {
		System.out.println("Your Savings Account balance is: "+ savingBal);
		return savingBal;
		
	}
	
	public void deposit(String type, double amt) {
		if (type == "checking" || type == "Checking") {
			checkingBal += amt;
			totalMoney += amt;
			System.out.println("Your Checking Account's new balance is: "+ checkingBal);
		}
		else {
			savingBal+= amt;
			totalMoney += amt;
			System.out.println("Your Savings Account's new balance is: "+ savingBal);
		}
	}
	
	public void withdraw(String type, double amt) {
		if (type == "checking" || type == "Checking") {
			if(amt > checkingBal) {
				System.out.println("I'm sorry, you don't have enought money in your account for this withdrawl!  Your current balance is: "+ checkingBal);
			}
			else {
				checkingBal -= amt;
				totalMoney -= amt;
				System.out.println("Your Checking Account's new balance is: "+ checkingBal);
			}
		}
		else {
			if(amt > savingBal) {
				System.out.println("I'm sorry, you don't have enought money in your account for this withdrawl!  Your current balance is: "+ savingBal);
			}
			else {
				savingBal-= amt;
				totalMoney -= amt;
				System.out.println("Your Savings Account's new balance is: "+ savingBal);
			}
		}
	}
	
	public void getTotals() {
		System.out.println("The total money in this banks is: "+totalMoney+" The total number of bank accounts is: "+ numberOfAcc);
	}
}
