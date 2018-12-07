package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CreateAction implements MouseListener {
	// Reference to the GameGUI
	private GameGUI game;
	private ArrayList<Integer> waveSizes;
	private WriteFile writeFile;

	// Create a new PeashooterSelectController with the reference to the GameGUI
	public CreateAction(GameGUI game) {
		this.game = game;
		waveSizes = new ArrayList<Integer>();
		writeFile = new WriteFile();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String result = null;
		boolean isNum = false;
		boolean cancelCreation = false;
		while (!isNum) {
			try {
				result = null;
				result = JOptionPane.showInputDialog("Enter the number of waves");

				if (result != null) {
					// checking valid integer using parseInt() method
					Integer test = Integer.parseInt(result);
					if (test > 1)
						isNum = true;
				}

				else {
					cancelCreation = true;
					break;
				}
			} catch (NumberFormatException c) {
				isNum = false;
			}

			System.out.println(result);
		}

		Integer numWaves = null;
		if (result != null)
			numWaves = Integer.parseInt(result);

		if (numWaves != null) {
			int i = 0;
			while (i < numWaves) {

				isNum = false;
				String resultNumZombie = null;
				while (!isNum) {
					
					try {
						resultNumZombie = null;
						resultNumZombie = JOptionPane
								.showInputDialog("Enter the number of zombies for Wave " + (i + 1));

						if (resultNumZombie != null) {
							Integer test = Integer.parseInt(resultNumZombie);
							if (test > 1)
								isNum = true;
						}
						else {
							cancelCreation = true;
							break;
						}

					} catch (NumberFormatException c) {
						isNum = false;
					}

				}

				if (resultNumZombie != null) {
					Integer numZombies = Integer.parseInt(resultNumZombie);
					i++;
					if (numZombies != null)
						waveSizes.add(numZombies);

				}
				else {
					cancelCreation = true;
					break;
				}

			}

			if (!cancelCreation) {
				String levelName = JOptionPane.showInputDialog("Enter the name of the level: ");

				if (levelName != null)
					writeFile.writeXmlFile(waveSizes, levelName);
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