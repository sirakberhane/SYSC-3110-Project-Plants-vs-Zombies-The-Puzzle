package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 
 * @author Jolar Tabungar
 * 
 * Listener to Select the Potatomine Option When It is Clicked
 *
 */
public class PotatomineSelectController implements MouseListener {
	//Reference to the GameGUI
		private GameGUI game;

		//Create a new PotatomineSelectController with the reference to the GameGUI
		public PotatomineSelectController(GameGUI game) {
			this.game = game;
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			//Select the Potatomine Option, update the hud
			game.selectPotatomine();
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
