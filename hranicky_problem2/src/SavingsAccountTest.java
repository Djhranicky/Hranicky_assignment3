package hranicky_problem2;

public class SavingsAccountTest {
	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000.00);
		SavingsAccount saver2 = new SavingsAccount(3000.00);
		
		SavingsAccount.modifyInterestRate(.04);
		
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		System.out.printf("The monthly interest for saver 1 is %.2f%n", saver1.getMonthlyInterest());
		System.out.printf("The balance for saver 1 is %.2f%n", saver1.getBalance());
		System.out.printf("The monthly interest for saver 2 is %.2f%n", saver2.getMonthlyInterest());
		System.out.printf("The balance for saver 2 is %.2f%n", saver2.getBalance());
		System.out.println();
		
		SavingsAccount.modifyInterestRate(.05);
		
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		System.out.printf("The monthly interest for saver 1 is %.2f%n", saver1.getMonthlyInterest());
		System.out.printf("The balance for saver 1 is %.2f%n", saver1.getBalance());
		System.out.printf("The monthly interest for saver 2 is %.2f%n", saver2.getMonthlyInterest());
		System.out.printf("The balance for saver 2 is %.2f%n", saver2.getBalance());
		
		
	}
}
