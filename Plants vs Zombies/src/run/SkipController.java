package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 
 * @author Jolar Tabungar
 * 
 *         The MouseListener for the Skip Turn Option
 * 
 */

public class SkipController implements MouseListener {
	// References to the GameGUI and level;
	private GameGUI game;
	private Level level;

	// Create a new SkipTurnListener, with the references to the GameGUI and level
	public SkipController(GameGUI game, Level level) {
		this.game = game;
		this.level = level;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		level = game.getCurrentLevelState();
		
		// Tell level to go to the next turn
		level.NextTurn();
		
		// Update the GUI
		game.updateGUI();
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
