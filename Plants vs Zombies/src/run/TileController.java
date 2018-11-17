package run;

import java.awt.event.*;

public class TileController implements MouseListener  {
	private int x;
	private int y;
	private GameGUI game;
	private Level level;
	
	public TileController(GameGUI game, Level level, int x, int y) {
		this.game = game;
		this.level = level;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if (game.peashooterSelected() || game.sunflowerSelected()) {
			if (level.addPlant(x, y)) {
				System.out.println(level.getSunTotal());
				level.NextTurn();
				game.clearBoard();
				game.populateBoard();
				game.updateStats();
			}
		}
		
		else {
			if (level.removePlant(x, y)) {
				game.clearBoard();
				game.populateBoard();
			}
		}
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
