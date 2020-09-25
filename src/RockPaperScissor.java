import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
	private String winCondition;
	private String player;
	private String[] choose = {"Rock","Paper","Scissor"};
	private int score1;
	private int score2;
	private Scanner scan = new Scanner(System.in);
	
	public RockPaperScissor(String player) {
		this.player = player;
	}
	
	public String getWinCondition() {
		return winCondition;
	}
	
	public void game() {
		int countRound = 0;
		int playerChoose;
		
		System.out.println("You win if your score is 3");
		while(score1 != 3 && score2 != 3) {
			System.out.println("=======================");
			System.out.printf("%16s\n", "Round " + (countRound + 1));
			System.out.printf("%19s\n","Your score : " + score1);
			System.out.printf("%20s\n", "Enemy score : " + score2);
			System.out.println("=======================");
			
			
			System.out.println("You may choose : ");
			System.out.println("1.Rock\n2.Paper\n3.Scissor");
			System.out.println("(Input in number)");
			
			
			try {
				System.out.print("<?(1-3) ");
				playerChoose = scan.nextInt();
			}
			catch(Exception e) {
				playerChoose = -1;scan.nextLine();
				scan.nextLine();
			}
			
			String playerMove = this.choose[playerChoose - 1];

			//Player 2 use random to move
			Random ai = new Random();					
			int enemyChoose = ai.nextInt(2);
			String enemyMove = this.choose[enemyChoose];
			
			
			// show hand respectively
			System.out.println("Your hands : " + playerMove);
			System.out.println("Enemy hands : " + enemyMove);
			
			//Calculate according to the condition
			if(playerMove.equals("Paper") && enemyMove.equals("Rock")) {
				System.out.println("You win");
				score1++;
			}
			else if (playerMove.equals("Scissor") && enemyMove.equals("Paper")) {
				System.out.println("You win");
				score1++;
			}
			else if(playerMove.equals("Rock") && enemyMove.equals("Scissor")) {
				System.out.println("You win");
				score1++;
			}
			else if(playerMove.equals(enemyMove)) {
				System.out.println("DRAW");
			}
			else {
				System.out.println("You lose");
				score2++;
			}
			System.out.print("Press enter to continue.....");
			Tools.enterToContinue();
			Tools.cls();
			countRound++; //Next round;
		}
		
		System.out.println("=======================");
		System.out.printf("%19s\n","Your score : " + score1);
		System.out.printf("%20s\n", "Enemy score : " + score2);
		System.out.println("=======================");
		
		if(score1 == 3) {
			System.out.println(this.player + " Win");
			this.winCondition = "Win";
		}
		else {
			System.out.println("You are loser");
			this.winCondition = "Lose";
		}
	}
	
}
 