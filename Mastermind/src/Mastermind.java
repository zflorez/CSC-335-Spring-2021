import java.util.Scanner;

import controller.MastermindController;
import model.MastermindModel;

/**
 * 
 * @author Zachary Florez
 * @course CSC 252
 * @class Mastermind
 *
 */
public class Mastermind {

	public static void main(String[] args) {
		// This class represents the view, it should be how uses play the game
		System.out.println("Welcome to Mastermind!");
		Scanner in = new Scanner(System.in);
		
		System.out.print("Would you like to play? ");
		String answer = in.next();
		
		// Invalid input from the player
		if (answer.toLowerCase().startsWith("y") == false && answer.toLowerCase().startsWith("n") == false) {
			System.out.println(answer + " is not a valid input, please input yes or no to continue");
			System.out.println("If \"yes\" or \"no\" isn't inputted, game will automatically end");
			answer = in.next();
		}
		
		// while the user wants to play:
		while (answer.startsWith("y") || answer.startsWith("Y")) {
			System.out.println("\nEnter \"exit\" anytime to exit your current game.");
			
			
			// Construct the model
			MastermindModel model = new MastermindModel();
			
			// Construct the controller based off model
			MastermindController controller = new MastermindController(model);
		
			// Loop to read up to ten user guesses. 
			for (int i = 1; i <= 10; i ++) {
				System.out.printf("Enter guess number %d: ", i, "\n");
				String guess = in.next();
				
				//first check if user doesn't want to play anymore
				if (guess.contains("exit")) {
					System.out.println("\nSorry to see you give up");
					break;
				}
				
				// if statement to check if guess was correct length.
				if (guess.length() != 4) {
					System.out.println("Guess 4 colors please. You can retry the same attempt until you guess 4 colors only.");
					i = i - 1; 
					System.out.println();
					continue;
				}
				
				boolean won = controller.isCorrect(guess);
				
				// if statements to see if the user won the game, or of they exceeded
				// their max guesses (10). 
				if (won == true) {
					System.out.println("Congrats! You beat Mastermind!!");
					i = 11;
				} else if (i == 10) {
					System.out.println("Sorry, you didn't beat Mastermind.");
				}
			}
			System.out.print("Do you want to play again? ");
			answer = in.next();
		}
		
		in.close();
		// End of game. 
		System.out.println("Thanks, see you again soon.");
	}
}
