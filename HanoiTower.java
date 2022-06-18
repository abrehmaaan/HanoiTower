import java.util.Scanner;

//Don't change anything in this file
/**
 * The class <b>HanoiTower</b> is the class that implements the actual Hanoi Tower 
 * Game. The class controls how a two players will play. It also asks the players 
 * if they wants to continue playing once each player played one game.
 * This class will be used as test for the playing the game between two players.
 * This class will be invoked from the command prompt: java HanoiTower args1 args2 ...
 */

public class HanoiTower {

	//main class for playing the game which uses all other classes simultaneously 
    public static void main(String[] args) {
        StudentInfo.display();			//displaying student info
        HanoiTowerGame game;			//creating a game object
        int disks=3;					//setting default disks to 3					
        Scanner in = new Scanner(System.in);		
        char ch;						//variable for choice whether player wants to play again or not
        // check the arguments and use the correct value
        if (args.length > 0) {			//getting arguments from command line 
            disks=Math.max(Integer.valueOf(args[0]),1);			//setting disks equal to argument provided
            if (args.length > 1)			//if more than one arguments are provided then displaying message
                System.out.println("Too many arguments. Only the first one is used.");
        }
       
        Player[] players = { new HumanPlayer(), new HumanPlayer() };			//array of two players
        do {			//making user play the game once
            System.out.println("\nPlayer 1 turn");
            game = new HanoiTowerGame(disks);			//initializing object of game with provided disks number for player 1
            players[0].play(game); // calls play from HumanPlayer 1

            System.out.println("\nPlayer 2 turn");
            game = new HanoiTowerGame(disks);			//initializing object of game with provided disks number for player 2
            players[1].play(game); // calls play from HumanPlayer 2

            //displaying scores of both players at end of game
            System.out.println("Player 1 score "+players[0].getScore());
            System.out.println("Player 2 score "+players[1].getScore());
            disks++;			//increasing disk number for next game and asking for user choice
            System.out.println("Do you want to play again?! enter y or Y");
            System.out.println("Number of disks will be increased by 1!!");
            
            ch = in.next().charAt(0);
        } while (ch=='y' || ch=='Y' );
    }

}
