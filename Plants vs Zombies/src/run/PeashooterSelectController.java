package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PeashooterSelectController implements MouseListener {
	private GameGUI game;
	private Level level;

	public PeashooterSelectController(GameGUI game, Level level) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		game.selectPeashooter();
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