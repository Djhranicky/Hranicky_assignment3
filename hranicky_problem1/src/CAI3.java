package hranicky_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI3 {
	private static Scanner inputs = new Scanner(System.in);
	private int randInt1;
	private int randInt2;
	private int randResponse;
	private int response;
	private int conformation;
	private final int numQs = 10;
	private int numCorrect;
	private double percentRight;
	
	
	public void quiz() {
		numCorrect = 0;
		for(int i = 0; i < numQs; i ++) {
			askQuestion();
			readResponse();
			if(isAnswerCorrect(response)) {
				displayCorrectResponse();
				numCorrect++;
			}
			else {
				displayIncorrectResponse();
			}
		}
		displayCompletionMessage();
		quizAgain();
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
	
	public void displayCompletionMessage() {
		
		percentRight = (100.0 * numCorrect / numQs);
		System.out.printf("Score: %.0f%%\n", percentRight);
		if(percentRight < 75) {
			System.out.println("Please ask your teacher for extra help.");
		}
		else {
			System.out.println("Congragulations, you are ready to go to the next level!");
		}
	}
	
	public void quizAgain() {
		
		System.out.println("Would you like to solve another problem set? (1 for yes or 2 for no)");
		while(true) {
			conformation = inputs.nextInt();
			if(conformation != 1 && conformation !=2) {
				System.out.println("Please enter a valid choice.");
			}
			else
				break;
		}
		if(conformation == 1) {
			quiz();
		}
	}
	
	public static void main(String args[]) {
		CAI3 quiz = new CAI3();
		quiz.quiz();
	}
}