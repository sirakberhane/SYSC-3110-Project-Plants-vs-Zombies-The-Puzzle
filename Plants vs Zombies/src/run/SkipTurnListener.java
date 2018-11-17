package run;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * @author Jolar Tabungar
 * 
 * The ActionListener for the Skip Turn Button
 * 
 */

public class SkipTurnListener implements ActionListener {
	//References to the GameGUI and level;
	private GameGUI game;
	private Level level;
	
	//Create a new SkipTurnListener, with the references to the GameGUI and level
	public SkipTurnListener(GameGUI game, Level level) {
		this.game = game;
		this.level = level;
	}
	
	public void actionPerformed(ActionEvent e) {
		//Tell level to go to the next turn
		level.NextTurn();
		//Update the GUI 
		game.clearBoard();
		game.populateBoard();
		game.updateStats();
	}

}
