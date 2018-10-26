package run;
import java.util.ArrayList;

import plant.*;
import player.Player;

public class PrintState {
	
	private Level level;
	private Player player;
	private String[][] board;
	
	public PrintState(Level level, Player player) {
		this.level = level;
		this.player = player;
		board = new String[9][5];
		clearBoard();
	}
	
	public void clearBoard() {
		for (int y = 0; y < 5; y ++) {
			for (int x = 0; x < 9; x ++) {
				board[x][y] = "[      ]";
			}
		}
	}
	public void updateState(ArrayList<Plant> plants) {
		clearBoard();
		for (Plant plant: plants) {
			board[plant.getxPos()][plant.getyPos()] = 
					"[" + plant.toString() + "]";
		}
	}
	
	public void print() {
		for (int y = 0; y < 5; y ++) {
			for (int x = 0; x < 9; x ++) {
				System.out.print(board[x][y]);
			}
			System.out.println("\n");
		}
		System.out.println("Suntotal: " + player.getSunTotal());
		level.NextTurn();
	}
	

}
