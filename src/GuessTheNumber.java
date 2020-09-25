import java.util.Scanner;
import java.util.Random;
public class GuessTheNumber extends RockPaperScissor{
	private Scanner scan = new Scanner(System.in);
	private String winCondition;
	
	public GuessTheNumber(String player) {
		super(player);
		// TODO Auto-generated constructor stub
	}

	
	public String getWinCondition() {
		return winCondition;
	}
	
	public void game() {
		System.out.println("You win after guessing the right number");
		int guessNumber;	
		Random randNumber = new Random();
		int randomGuess = randNumber.nextInt(5) + 1;
		System.out.print("Input number : ");
		guessNumber = scan.nextInt();
		if(guessNumber == randomGuess) {
			winCondition = "Win";
			System.out.println("==============\nYou win\n===============");
			System.out.print("Press enter to continue.....");
			Tools.enterToContinue();
		}
		else {
			winCondition = "Lose";
			System.out.println("Number to be guessed : " + randomGuess);
			System.out.print("Press enter to continue.....");
			Tools.enterToContinue();
		}
	}
}
