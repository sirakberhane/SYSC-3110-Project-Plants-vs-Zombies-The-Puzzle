package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayAction implements MouseListener {
	//Reference to the GameGUI
	private GameGUI game;

	//Create a new PeashooterSelectController with the reference to the GameGUI
	public PlayAction(GameGUI game) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		game.createGameScreen();
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