package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 
 * @author Jolar Tabungar
 * 
 * Listener to Save When It is Clicked
 *
 */
public class SaveController implements MouseListener {
	//References to the GameGUI and level;
	private GameGUI game;
	
	//Create a new SaveController, with the references to the GameGUI
	public SaveController(GameGUI game) {
		this.game = game;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//Tell Game to save
		game.exportSave();
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
