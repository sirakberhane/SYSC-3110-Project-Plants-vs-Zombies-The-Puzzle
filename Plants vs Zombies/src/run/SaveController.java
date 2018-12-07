package run;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveController implements ActionListener {

	GameGUI game;
	public SaveController(GameGUI game) {
		this.game = game;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		game.exportSave();
	}

}
