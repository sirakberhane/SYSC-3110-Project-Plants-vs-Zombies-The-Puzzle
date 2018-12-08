package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoadController implements MouseListener {
	//References to the GameGUI
	private GameGUI game;
	
	//Create a new LoadController, with the references to the GameGUI
	public LoadController(GameGUI game) {
		this.game = game;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//Tell Game to load
		game.importSave();
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
