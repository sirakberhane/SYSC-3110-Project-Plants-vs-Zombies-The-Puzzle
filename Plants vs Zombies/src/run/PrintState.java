package run;
import java.util.ArrayList;

import plant.*;
import player.Player;
import zombie.*;

/**
 * 
 * @author Jolar Tabungar 
 * 
 * PrintState is responsible for printing the current state of the level as a textual
 * representation
 *
 */
public class PrintState {
	//PrintState's level
	private Level level;
	//The player class
	private Player player;
	//The board string array
	private String[][] board;
	/**
	 * Construct a new printState with the given level and player
	 * @param level
	 * @param player
	 */
	public PrintState(Level level, Player player) {
		this.level = level;
		this.player = player;
		//Create a new 9x5 board
		board = new String[9][5];
		//Initialize the board array
		clearBoard();
	}
	
	//Creates an empty board
	public void clearBoard() {
		for (int y = 0; y < 5; y ++) {
			for (int x = 0; x < 9; x ++) {
				board[x][y] = "[      ]";
			}
		}
	}

	//Update the board with the new states of all the added plants and zombies
	public void updateState(Lawn[] lawns) {
		clearBoard();
		for (int y = 0; y < lawns.length; y ++) {
			for (Plant plant: lawns[y].getPlants()) {
				board[plant.getxPos()][plant.getyPos()] = 
						"[" + plant.toString() + "]";
			}
			for (Zombie zombie: lawns[y].getZombies()) {
				board[(int) zombie.getCurrentX() + 1][zombie.getyPos()] = 
						"[" + zombie.toString() + "]";
			}
		}
	}
	
	//Print the current state of the board
	public void print() {
		//Print each tile of the board
		for (int y = 0; y < 5; y ++) {
			
			for (int x = 0; x < 9; x ++) {
				System.out.print(board[x][y]);
			}
			System.out.println("\n");
		}
		//Print the suntotal
		System.out.println("Suntotal: " + player.getSunTotal());
		//Proceed to the next turn
		level.NextTurn();
	}
}
