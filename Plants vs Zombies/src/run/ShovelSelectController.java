package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ShovelSelectController implements MouseListener {
	private GameGUI game;
	private Level level;

	public ShovelSelectController(GameGUI game, Level level) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		game.selectShovel();
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