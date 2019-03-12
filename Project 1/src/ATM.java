
public class ATM {
	
	static String cardNum="0000";  //only user's card number
	int bal=0; //Balance
	
	public int currentBalance() {
		return bal;
	}
	
	public void withdraw(String amount) {
		int amInt=Integer.parseInt(amount);
		bal=bal-amInt;
		
	}
	
	public void deposit(String amount) {
		int amInt=Integer.parseInt(amount);
		bal=bal+amInt;
	}
}