package run;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SkipTurnListener implements ActionListener {
	private GameGUI game;
	private Level level;
	
	public SkipTurnListener(GameGUI game, Level level) {
		this.game = game;
		this.level = level;
	}
	
	public void actionPerformed(ActionEvent e) {
		level.NextTurn();
		game.clearBoard();
		game.populateBoard();
		game.updateStats();
	}

}
