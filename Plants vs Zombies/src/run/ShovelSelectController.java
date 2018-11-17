package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/**
 * 
 * @author Jolar Tabungar
 * The MouseListener class for the Shovel Select Option
 *
 */

public class ShovelSelectController implements MouseListener {
	//Reference to the GameGUI
	private GameGUI game;

	//Create a new ShovelSelectController with the reference to the GameGUI
	public ShovelSelectController(GameGUI game) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Select the shovel select option, and update the HUD
		game.selectShovel();
		game.updateHUD();
	}
	
	//Unused

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