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
	//The lawn mowers string array
	private String[] lawnMowers;
	
	/**
	 * Construct a new printState with the given level and player
	 * @param level
	 * @param player
	 */
	public PrintState(Level level, Player player) {
		this.level = level;
		this.player = player;
		
		//Create a new 9x5 board
		board = new String[level.X_MAX + 1][level.Y_MAX + 1];
		lawnMowers = new String[level.Y_MAX + 1];
		
		//Initialize the board array
		clearBoard();
		
		//Print the game title
		printTitle();
		
		//Give the user his available commands
		player.printHelp();
	}
	
	//Creates an empty board
	public void clearBoard() { 
		for (int y = 0; y < level.Y_MAX + 1; y ++) {
			lawnMowers[y] = "[  LM  ]";
			for (int x = 0; x < level.X_MAX + 1; x ++) {
				board[x][y] = "";
			}
		}
	}

	/**
	 * Update the printState with the current state of the level
	 * @param lawns the level's lawns
	 */
	public void updateState(Lawn[] lawns) {
		clearBoard();
		for (int y = 0; y < lawns.length; y ++) {
			if (lawns[y].isLawnMowerActivated())
				lawnMowers[y] = "[  X   ]";
			
			for (Plant plant: lawns[y].getPlants()) {
				board[plant.getxPos()][plant.getyPos()] += 
						" " + plant.toString();
				
			}
			for (Zombie zombie: lawns[y].getZombies()) {
				
				board[(int) Math.round(zombie.getCurrentX())][zombie.getyPos()] += 
						" " + zombie.toString();
			}
		}
	}
	
	/**
	 * Prints the current state of the level
	 */
	public void print() {
		
		//Print the Wave number and number of zombies remaining;
		System.out.println("WAVE: " + level.currentWave() + "    Zombies Remaining: " + level.zombieCount());
		
		//Print each tile of the board
		for (int y = 0; y < 5; y ++) {
			System.out.println("___________________________________________________________________________________________________________________________________________________________________");
			System.out.print(lawnMowers[y]);
			for (int x = 0; x < 9; x ++) {
				//Pad the string to 13 characters with whitespace for a uniform look
				board[x][y] = String.format("%-14s", board[x][y]).replace(" ", " ");
				System.out.print(" | " + board[x][y]);
			}
			System.out.println();
		}
		
		//Print the suntotal
		System.out.println("\nSuntotal: " + player.getSunTotal());
	}
	
	/**
	 * Prints the game title
	 */
	public void printTitle() {
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
				"__________.__                 __    ____   ____          __________            ___.   .__               \r\n" + 
				"\\______   \\  | _____    _____/  |_  \\   \\ /   /_____     \\____    /____   _____\\_ |__ |__| ____   ______\r\n" + 
				" |     ___/  | \\__  \\  /    \\   __\\  \\   Y   /  ___/       /     //  _ \\ /     \\| __ \\|  |/ __ \\ /  ___/\r\n" + 
				" |    |   |  |__/ __ \\|   |  \\  |     \\     /\\___ \\       /     /(  <_> )  Y Y  \\ \\_\\ \\  \\  ___/ \\___ \\ \r\n" + 
				" |____|   |____(____  /___|  /__|      \\___//____  > /\\  /_______ \\____/|__|_|  /___  /__|\\___  >____  >\r\n" + 
				"                    \\/     \\/                    \\/  \\/          \\/           \\/    \\/        \\/     \\/"+ "\n" +
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" + 
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------\n"
				);
	}
}
