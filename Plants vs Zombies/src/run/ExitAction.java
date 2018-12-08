package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * 
 * @author Jolar Tabungar
 * 
 * Listener to exit the game when exit is clicked
 *
 */
public class ExitAction implements MouseListener {
	//Reference to the GameGUI
	private GameGUI game;

	//Create a new Exit Action with the reference to the GameGUI
	public ExitAction(GameGUI game) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.exit(0);
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