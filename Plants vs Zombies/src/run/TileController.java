package run;

import java.awt.event.*;
/**
 * 
 * @author Jolar Tabungar
 * The MouseListener for each tile for GameGUI board
 *
 */

public class TileController implements MouseListener  {
	//The x position of the tile
	private int x;
	//The y position of the tile
	private int y;
	//References to GameGUI and Level
	private GameGUI game;
	private Level level;
	
	//Construct the new TileController with the references and it's position on the board
	public TileController(GameGUI game, Level level, int x, int y) {
		this.game = game;
		this.level = level;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//If any plant is selected
		if (!game.shovelSelected()) {
			//Add that plantType if possible
			if (level.addPlant(x, y)) {
				//Tell Level to move on to next turn
				level.NextTurn();
				//Update the GameGUI
				game.clearBoard();
				game.populateBoard();
				game.updateStats();
			}
		}
		
		//If shovel is selected
		else {
			//If possible, remove the plant and update the GUI, level does not continue to next turn
			if (level.removePlant(x, y)) {
				game.clearBoard();
				game.populateBoard();
			}
		}
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
