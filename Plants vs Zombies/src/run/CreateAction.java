package run;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * 
 * @author Jolar Tabungar
 *
 * CreateAction implements the level building feature
 * Prompts Player for number of waves and the number of zombies per wave, then saves the template
 * in the levels directory (levels can be selected when you hit play)
 * 
 */

public class CreateAction implements MouseListener {
	// Reference to the GameGUI
	private GameGUI game;
	//WaveSizes to be created by the player
	private ArrayList<Integer> waveSizes;
	//Reference to writefile to save the level template
	private WriteFile writeFile;

	// Create a new CreateAction with the reference to the GameGUI
	public CreateAction(GameGUI game) {
		this.game = game;
		waveSizes = new ArrayList<Integer>();
		writeFile = new WriteFile();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Will contain the input value for number of waves
		String result = null;
		//flag to check if the value is a number
		boolean isNum = false;
		//flag to check if the process was cancelled
		boolean cancelCreation = false;
		//Continue prompting player until a number is entered
		while (!isNum) {
			try {
				//Reset result
				result = null;
				//Prompt player for numWaves
				result = JOptionPane.showInputDialog("Enter the number of waves");

				//If a value was entered
				if (result != null) {
					// checking valid integer using parseInt() method
					Integer test = Integer.parseInt(result);
					//If value is valid
					if (test > 1) {
						//Break the loop
						isNum = true;
					}
				}

				//Value was not entered
				else {
					//Cancel process
					cancelCreation = true;
					//Break Loop
					break;
				}
			} catch (NumberFormatException c) {
				//Value was not a number, so continue prompting
				isNum = false;
			}

			System.out.println(result);
		}

		//Convert result into Integer
		Integer numWaves = null;
		if (result != null)
			numWaves = Integer.parseInt(result);

		//Continue if numWaves was successful
		if (numWaves != null) {
			int i = 0;
			//Ask user for number of zombies for each wave
			while (i < numWaves) {

				//Ask player for number, repeat if value is invalid
				isNum = false;
				String resultNumZombie = null;
				while (!isNum) {
					
					try {
						resultNumZombie = null;
						resultNumZombie = JOptionPane
								.showInputDialog("Enter the number of zombies for Wave " + (i + 1));

						if (resultNumZombie != null) {
							//If value was entered, check if valid
							Integer test = Integer.parseInt(resultNumZombie);
							if (test > 1)
								isNum = true;
						}
						else {
							//Cancel process and break loop
							cancelCreation = true;
							break;
						}

					} catch (NumberFormatException c) {
						//If not a number, continue loop
						isNum = false;
					}

				}

				//Convert value into Integer
				if (resultNumZombie != null) {
					Integer numZombies = Integer.parseInt(resultNumZombie);
					//Move on to next wave
					i++;
					//Add the value to the waveSizes array
					if (numZombies != null)
						waveSizes.add(numZombies);

				}
				else {
					//Cancelled Process, break loop
					cancelCreation = true;
					break;
				}

			}

			//If process was not cancelled
			if (!cancelCreation) {
				//Prompt player for level name
				String levelName = JOptionPane.showInputDialog("Enter the name of the level: ");

				//If a value was entered, save the level template, otherwise nothing happens
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