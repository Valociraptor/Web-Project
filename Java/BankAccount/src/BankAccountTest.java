
public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount();
		
		account1.deposit("checking",  500);
		account1.deposit("savings",  500);
		account2.deposit("checking",  500);
		account2.deposit("savings",  500);
		
		account1.withdraw("checking",  10);
		account1.withdraw("savings",  20);
		account2.withdraw("checking",  5000);
		account2.withdraw("savings",  500);
		
		
		account1.getSaveBal();
		account1.getCheckBal();
		account2.getSaveBal();
		account2.getCheckBal();
		
		account1.getTotals();
	}

}
