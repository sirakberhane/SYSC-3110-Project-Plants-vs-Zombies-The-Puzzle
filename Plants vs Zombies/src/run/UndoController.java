package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class UndoController implements MouseListener {
	//References to the GameGUI and level;
	private GameGUI game;
	
	//Create a new UndoController, with the references to the GameGUI
	public UndoController(GameGUI game, Level level) {
		this.game = game;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//Tell Game to go to the previous state
		game.getPreviousLevelState();
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
