package run;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadController implements ActionListener {
	GameGUI game;
	public LoadController(GameGUI game) {
		this.game = game;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		game.importSave();
	}

}
