package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 
 * @author Jolar Tabungar
 * 
 * Listener to Select the HypnoShroom Option When It is Clicked
 *
 */
public class HypnoshroomSelectController implements MouseListener {
	// Reference to the GameGUI
	private GameGUI game;

	// Create a new HypnoShroomSelectController with the reference to the GameGUI
	public HypnoshroomSelectController(GameGUI game) {
			this.game = game;
		}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Select the Hypnoshroom Option, update the hud
		game.selectHypnoshroom();
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
