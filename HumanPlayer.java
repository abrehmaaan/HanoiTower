import java.util.Scanner;

//Student 1 full name:
//Student 2 full name:
//==================================================

/**
 * The class <b>HumanPlayer</b> is the class that controls the human's plays.
 * This implements all the required functions of Player interface for providing play functionality
 * 
 */


public class HumanPlayer implements Player {
	int score = 0;

//	function that allows user to play the game for limited moves. this function accepts a parameter which game board and uses that to implement functionality
	@Override
	public void play(HanoiTowerGame game) {			
		game.toStr();					//function for printing game board
		System.out.println("Your goal is to move 2 disks from tower 1 to 3\nOnly one simple rule: no large disk on the top of a smaller one!");
		while(game.getGameState()==GameState.PLAYING) {			//while user has not won or lost the game loop will ask him to make a move
			System.out.println("Enter the source and the destination towers each on a single line:");
			Scanner input = new Scanner(System.in);
			int s = input.nextInt();				//getting source and destination as input
			int d = input.nextInt();
			game.play(s-1, d-1);				//function that makes a move for given source and destination at the game boared
			game.toStr();						//printing board after move
			System.out.println("Moves played "+ game.getLevel()+"\tMax "+game.maxLevels());			//printing details of moves after a move
		}
		if(game.getGameState()==GameState.LOSER) {
			//if user lost game then setting score to zero and displaying message
			score = 0;
			System.out.println("You finished the allowed number of moves!\nYour score is 0");
		}
		else if (game.getGameState()==GameState.WINNER) {
			//if user won game then setting score to One and displaying message
			System.out.println("You did it within the allowed number of moves!\nYour score is 1");
			score = 1;
		}
	}

	@Override
	public int getScore() {				//function for getting score of a player
		return score;
	}

}