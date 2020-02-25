package hranicky_problem1;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI5 {
	private static Scanner inputs = new Scanner(System.in);
	private int randInt1;
	private int randInt2;
	private int randResponse;
	private double response;
	private int conformation;
	private int difficulty;
	private final int numQs = 10;
	private int numCorrect;
	private double percentRight;
	private int type;
	private int randomType;
	private final double tolerance = .001;
	
	public void quiz() {
		numCorrect = 0;
		readDifficulty();
		readProblemType();
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
		randInt1 = generateQuestionArgument(difficulty);
		randInt2 = generateQuestionArgument(difficulty);
		
		switch(type) {
		case 1:
			System.out.printf("What is %d plus %d?\n",randInt1, randInt2);
			break;
		case 2:
			System.out.printf("What is %d times %d?\n",randInt1, randInt2);
			break;
		case 3:
			System.out.printf("What is %d minus %d?\n",randInt1, randInt2);
			break;
		case 4:
			randInt2 = rand.nextInt((int)Math.pow(10, difficulty)-1) + 1;
			System.out.printf("What is %d divided by %d?\n",randInt1, randInt2);
			break;
		case 5:
			askRandomQuestion();
			break;
		}
	}
	
	private void askRandomQuestion() {
		SecureRandom rand = new SecureRandom();
		
		randomType = rand.nextInt(4) + 1;
		switch(randomType) {
		case 1:
			System.out.printf("What is %d plus %d?\n",randInt1, randInt2);
			break;
		case 2:
			System.out.printf("What is %d times %d?\n",randInt1, randInt2);
			break;
		case 3:
			System.out.printf("What is %d minus %d?\n",randInt1, randInt2);
			break;
		case 4:
			randInt2 = rand.nextInt((int)Math.pow(10, difficulty)-1) + 1;
			System.out.printf("What is %d divided by %d?\n",randInt1, randInt2);
			break;
		}
	}
	
	private void readResponse() {
		response = inputs.nextDouble();
	}
	
	private boolean isAnswerCorrect(double response) {
		switch(type) {
		case 1:
			return (randInt1 + randInt2 == response);
		case 2:
			return (randInt1 * randInt2 == response);
		case 3:
			return (randInt1 - randInt2 == response);
		case 4:
			return (Math.abs(((double)randInt1/randInt2)-response) < tolerance);
		case 5:
			return isRandomAnswerCorrect();
		}
		return false;
	}
	
	private boolean isRandomAnswerCorrect() {
		switch(randomType) {
		case 1:
			return (randInt1 + randInt2 == response);
		case 2:
			return (randInt1 * randInt2 == response);
		case 3:
			return (randInt1 - randInt2 == response);
		case 4:
			return (Math.abs(((double)randInt1/randInt2)-response) < tolerance);
		}
		return false;
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
	
	public void readDifficulty() {
		System.out.println("Please enter a difficulty level of 1, 2, 3, or 4, with 1 being the easiest and 4 being the hardest.");
		while(true) {
			difficulty = inputs.nextInt();
			if(difficulty != 1 && difficulty != 2 && difficulty != 3 && difficulty != 4) {
				System.out.println("Please enter a valid difficulty");
			}
			else
				break;
		}
	}
	
	public int generateQuestionArgument(int diff) {
		SecureRandom rand = new SecureRandom();
		return rand.nextInt((int)Math.pow(10, diff));
	}
	
	public void readProblemType() {
		System.out.println("Please enter a problem type (1 being addition, 2 being multiplication, "
				+ "3 being subtraction,\n4 being division, and 5 being a random group of all 4.)");
		while(true) {
			type = inputs.nextInt();
			if(!(type == 1 || type == 2 || type == 3 || type == 4 || type == 5)) {
				System.out.println("Please enter a valid type");
			}
			else
				break;
		}
	}
	
	public static void main(String args[]) {
		CAI5 quiz = new CAI5();
		quiz.quiz();
	}
}