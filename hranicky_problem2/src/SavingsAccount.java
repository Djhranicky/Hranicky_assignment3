package hranicky_problem2;

public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance;
	private double monthlyInterest;
	
	public SavingsAccount() {
		savingsBalance = 0.00;
	}
	
	public SavingsAccount(double initialBalance) {
		savingsBalance = initialBalance;
	}
	
	public void calculateMonthlyInterest() {
		monthlyInterest = savingsBalance * annualInterestRate/12;
		savingsBalance += monthlyInterest;
	}
	
	public double getBalance() {
		return savingsBalance;
	}
	
	public double getMonthlyInterest() {
		return monthlyInterest;
	}
	
	public static void modifyInterestRate(double rate) {
		annualInterestRate = rate;
	}
}
