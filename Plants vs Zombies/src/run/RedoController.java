package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RedoController implements MouseListener {
	//References to the GameGUI and level;
	private GameGUI game;
	
	
	//Create a new RedoController, with the reference to the GameGUI
	public RedoController(GameGUI game, Level level) {
		this.game = game;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//Tell game to go to next level state
		game.getNextLevelState();
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