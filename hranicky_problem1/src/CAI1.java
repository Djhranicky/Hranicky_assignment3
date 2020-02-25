package hranicky_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI1 {
	private static Scanner inputs = new Scanner(System.in);
	private int randInt1;
	private int randInt2;
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
		System.out.println("Very good!");
	}
	
	private void displayIncorrectResponse() {
		System.out.println("No, please try again.");
	}
	
	public static void main(String args[]) {
		CAI1 quiz = new CAI1();
		quiz.quiz();
	}
}
