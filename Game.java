import java.util.Random;
import java.util.Scanner;

public class Game {

	//two variables beyond the scope of any methods to 
	//keep track of the player and computer scores
	private static int computerScore = 0;
	private static int playerScore = 0;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		run(input);
	}
	
	
	public static void run(Scanner input) {
		printIntro();
		boolean gameInProgress = true;
		
		while(gameInProgress) {

			//reading in and storing the computer's choice
			String computerChoice = play();
			
			//reading in and storing the player's choice
			String playerChoice = validInput(input);
			
			//if the player chooses to exit this will break 
			//out of the loop and output the total score
			if (playerChoice.equalsIgnoreCase("Q")) {
				scoreBoard();
				if(computerScore == playerScore) {
					System.out.println("You tied with the computer");
				} else if (computerScore > playerScore) {
					System.out.println("You lost! :(");
				} else {
					System.out.println("You won! :)");
				}
				System.out.println("Thanks for playing!");
				break;
			}
			System.out.printf("Player chose: %s \nComputer chose: %s\n", playerChoice, computerChoice);
			
			if(playerChoice.equalsIgnoreCase(computerChoice)) {
				System.out.println("It's a tie!");
			} else if ((playerChoice.equalsIgnoreCase("Rock") && computerChoice.equalsIgnoreCase("Scissors") || (playerChoice.equalsIgnoreCase("Paper") && computerChoice.equalsIgnoreCase("Rock")) || (playerChoice.equalsIgnoreCase("Scissors") && playerChoice.equalsIgnoreCase("Paper")))) {
				System.out.println("You win this round!");
				playerScore++;
			} else {
				System.out.println("The computer wins this round");
				computerScore++;
			}
			
			System.out.printf("Current Score \nPlayer: %s\nComputer: %s\n",playerScore,computerScore);
		}
	}
	
	public static void printIntro() {
		System.out.println("Welcome to Greg's Rock, Paper, Scissors game");
		System.out.println("Please enter 'Rock' 'Paper' or 'Scissors' to proceed");
		System.out.println("Or enter 'Q' to quit");
	}
	
	/**
	*Method that will randomly generate a number from
	*1-3 and return Rock/Paper/Scissors depending on the number
	*/
	public static String play() {
		Random r = new Random();
		int computerChoice = r.nextInt(3)+1;
		if(computerChoice == 1) {
			return "Rock";
		} else if (computerChoice == 2) {
			return "Paper";
		} else {
			return "Scissors";
		}
	}
	
	/**
	*Method that takes in a Scanner and keeps the 
	*user in a loop until they enter valid input.
	*Returns the valid input
	*/
	public static String validInput(Scanner input) {
		boolean invalid = true;
		String userInput = "";
		while(invalid) {
			userInput = input.nextLine();
			if(userInput.equalsIgnoreCase("Rock") || userInput.equalsIgnoreCase("Paper") || userInput.equalsIgnoreCase("Scissors") || userInput.equalsIgnoreCase("Q")) {
				invalid = !invalid;
			}
		}
		return userInput;
	}
	
	/**
	*Method that prints both the player and the computer's scores
	*/
	public static void scoreBoard() {
		System.out.println("Player points: " + playerScore);
		System.out.println("Computer points: " + computerScore);
	}
}
