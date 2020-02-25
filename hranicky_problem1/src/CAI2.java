package hranicky_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI2 {
	private static Scanner inputs = new Scanner(System.in);
	private int randInt1;
	private int randInt2;
	private int randResponse;
	private int response;
	
	
	public void quiz() {
		askQuestion();
		readResponse();
		while(!isAnswerCorrect(response)) {
			displayIncorrectResponse();
			readResponse();
		}
		displayCorrectResponse();
	}
	
	private void askQuestion() {
		SecureRandom rand = new SecureRandom();
		
		randInt1 = rand.nextInt(10);
		randInt2 = rand.nextInt(10);
		
		System.out.println("What is " + randInt1 + " times " + randInt2 + "?");
	}
	
	private void readResponse() {
		response = inputs.nextInt();
	}
	
	private boolean isAnswerCorrect(int response) {
		return (randInt1 * randInt2 == response);
	}
	
	private void displayCorrectResponse() {
		SecureRandom rand = new SecureRandom();
		
		randResponse = rand.nextInt(4);
		
		switch(randResponse) {
			case 0:
				System.out.println("Very good!");
				break;
			case 1:
				System.out.println("Excellent!");
				break;
			case 2:
				System.out.println("Nice work!");
				break;
			case 3:
				System.out.println("Keep up the good work!");
				break;
		}
	}
	
	private void displayIncorrectResponse() {
		SecureRandom rand = new SecureRandom();
		
		randResponse = rand.nextInt(4);
		
		switch(randResponse) {
			case 0:
				System.out.println("No. Please try again.");
				break;
			case 1:
				System.out.println("Wrong. Try once more.");
				break;
			case 2:
				System.out.println("Don't give up!");
				break;
			case 3:
				System.out.println("No. Keep Trying.");
				break;
		}
	}
	
	public static void main(String args[]) {
		CAI2 quiz = new CAI2();
		quiz.quiz();
	}
}