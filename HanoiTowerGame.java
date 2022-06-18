//Student 1 full name:
//Student 2 full name:
//==================================================



/**
 * Your documentation for this class ....
 *
 *
 */

import java.lang.Math;

public class HanoiTowerGame {

	//This will point to the array of three towers (type of towers LinkedStack)
	LinkedStack[] towerValues = new LinkedStack[3]; 
	int level;				//current level of game/no of moves
	int maxLevels;			//maximum moves allowed
	GameState gamestate;	//state of game (playing, loser, winner)
	int disks;				//maximum disks for game
	
	public HanoiTowerGame(int disks) {			//constructor that accepts no. of disks
		level = 0;
		maxLevels = 2*((int)Math.pow(2,disks) -1);			//setting max moves according to given conditions
		gamestate = GameState.PLAYING;
		this.disks = disks;
		for(int i=0;i<3;i++) {					//for each tower initializing the stack as empty 
			towerValues[i] = new LinkedStack();
		}
		
		for(int i=disks,j=0;i>0;i--) {				//moving all the disks to tower 1 to start the game
			towerValues[j].push(i);
		}
		
	}
	
	public void play(int s, int d) {				//function called by HumanPlayer to play the game (make a move) by getting source and destination for move
		if(towerValues[s].size()>0) {				//checking if source tower is not empty
			if(towerValues[d].size()!=0) {			//checking if destination tower is not empty
				//if destination tower is not empty then checking if disk to be moved is smaller than already present disk or not
				if(towerValues[s].peek() < towerValues[d].peek()) {		
					towerValues[d].push(towerValues[s].pop());
					level++;
				}
				else {			//if its smaller then marking move as invalid
					System.out.println("Invalid Move, Move again!");
				}
			}
			else {
				//if destination tower is empty then any move is valid
				towerValues[d].push(towerValues[s].pop());
				level++;
			}
		}
		
		//checking whether a player won or lost and changing game state
		if(checkWinner()==1) {
			gamestate= GameState.WINNER;
		}
		else if(checkWinner()==0) {
			gamestate = GameState.LOSER;
		}
	}
	
	public int checkWinner() {			//function for checking whether a player won or lost 
		if(towerValues[0].size==0 && towerValues[2].size==disks) {			//if all disks are moved from tower 1 to 3 then returning true
			return 1;
		}
		if(towerValues[2].size!=disks && level>=maxLevels) {				//if disks are not moved and maxlevels has reached, returning false
			return 0;
		}
		return 2;
	}
	
	public int getDisks() {			//function for getting disks
		return this.disks;
	}
	
	public int getLevel() {			//function for getting current level
		return this.level;
	}
	
	public int maxLevels() {			//function for getting maxlevel
		return this.maxLevels;
	}
	
	public GameState getGameState() {			//function for getting current game state
		return this.gamestate;
	}
	
	public int getDisksAtTower (int i) {			//function for getting disks at a tower
		return towerValues[i].size;
	}
	
	public void toStr() {			//function for getting displaying board on screen
		for(int i=0,j=1;i<3;i++) {
			System.out.println("Tower "+j);
			towerValues[i].display();
			j++;
		}
		
	}

}
