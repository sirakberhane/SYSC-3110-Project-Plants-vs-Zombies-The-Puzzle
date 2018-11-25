package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SnowPeashooterSelectController implements MouseListener {
	//Reference to the GameGUI
	private GameGUI game;

	//Create a new PeashooterSelectController with the reference to the GameGUI
	public SnowPeashooterSelectController(GameGUI game) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Select the Peashooter Option, update the hud
		//game.selectSnow();
		game.updateHUD();
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
