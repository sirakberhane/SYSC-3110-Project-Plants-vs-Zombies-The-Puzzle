package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 
 * @author Jolar Tabungar
 * The MouseListener for the Sunflower Select option
 *
 */

public class SunflowerSelectController implements MouseListener {
	//References to the GameGUI
	private GameGUI game;

	//Create the SunflowerSelectController
	public SunflowerSelectController(GameGUI game, Level level) {
		//Reference to the game
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Select the sunflower select option
		//Update the select options, apperance
		game.selectSunflower();
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