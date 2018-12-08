package run;

import java.io.Serializable;

/**
 * This is the data the Level class uses to make changes within GameGUI.
 * @author Ryan Tordesillas 101041626
 *
 */
public class GameData implements Serializable{

	//Flags to determine which select option is set
	private boolean sunflowerSelected;
	private boolean peashooterSelected;
	private boolean shovelSelected;
	private boolean snowpeashooterSelected;
	private boolean potatomineSelected;
	private boolean hypnoshroomSelected;
	private boolean wallnutSelected;

	public GameData(boolean sun, boolean pea, boolean shovel, boolean snow, boolean potato, boolean hypno, boolean wall) {
		sunflowerSelected = sun;
		peashooterSelected = pea;
		shovelSelected = shovel;
		snowpeashooterSelected = snow;
		potatomineSelected = potato;
		hypnoshroomSelected = hypno;
		wallnutSelected = wall;
	}

	/**
	 * This method will update the data as the GUI updates.
	 * @param sun the sunflower boolean
	 * @param pea the peashooter boolean
	 * @param shovel the shovel boolean
	 * @param snow the snowpeashooter boolean
	 * @param potato the potatomine boolean
	 * @param hypno the hypnoshroom boolean
	 * @param wall the wallnut boolean
	 */
	public void update(boolean sun, boolean pea, boolean shovel, boolean snow, boolean potato, boolean hypno, boolean wall) {
		sunflowerSelected = sun;
		peashooterSelected = pea;
		shovelSelected = shovel;
		snowpeashooterSelected = snow;
		potatomineSelected = potato;
		hypnoshroomSelected = hypno;
		wallnutSelected = wall;
	}

	/**
	 * Return true if sunflower is selected for placing, false otherwise
	 * @return true if sunflower is selected for placing, false otherwise
	 */
	public boolean sunflowerSelected() {
		return sunflowerSelected;
	}

	/**
	 * Return true if peashooter is selected for placing, false otherwise
	 * @return true if peashooter is selected for placing, false otherwise
	 */
	public boolean peashooterSelected() {
		return peashooterSelected;
	}

	/**
	 * Return true if snowpeashooter is selected for placing, false otherwise
	 * @return true if snowpeashooter is selected for placing, false otherwise
	 */
	public boolean snowpeashooterSelected() {
		return snowpeashooterSelected;
	}

	/**
	 * Return true if Potatomine is selected for placing, false otherwise
	 * @return true if Potatomine is selected for placing, false otherwise
	 */
	public boolean potatomineSelected() {
		return potatomineSelected;
	}

	/**
	 * Return true if Hypnoshroom is selected for placing, false otherwise
	 * @return true if Hypnoshroom is selected for placing, false otherwise
	 */
	public boolean hypnoshroomSelected() {
		return hypnoshroomSelected;
	}

	/**
	 * Return true if Wallnut is selected for placing, false otherwise
	 * @return true if Wallnut is selected for placing, false otherwise
	 */
	public boolean wallnutSelected() {
		return wallnutSelected;
	}

	/**
	 * Returns true if shovel is selected, false otherwise
	 * @return true if shovel is selected, false otherwise
	 */
	public boolean shovelSelected() {
		return shovelSelected;
	}

	/**
	 * Deselect All Placement/Removal Options
	 */
	public void deselectAll() {
		sunflowerSelected = false;
		peashooterSelected = false;
		snowpeashooterSelected = false;
		potatomineSelected = false;
		hypnoshroomSelected = false;
		wallnutSelected = false;
		shovelSelected = false;
	}

	/**
	 * Sets the sunflower
	 * @param true if set false if not set
	 */
	public void setSunflower(boolean b) {
		sunflowerSelected = b;
	}

	/**
	 * Sets the peashooter
	 * @param true if set false if not set
	 */
	public void setPeashooter(boolean b) {
		peashooterSelected = b;
	}

	/**
	 * Sets the snowpeashooter
	 * @param true if set false if not set
	 */
	public void setSnowpeashooter(boolean b) {
		snowpeashooterSelected = b;
	}
	/**
	 * Sets the Potatomine
	 * @param true if set false if not set
	 */
	public void setPotatoMine(boolean b) {
		potatomineSelected = b;
	}
	/**
	 * Sets the hypnoshroom
	 * @param true if set false if not set
	 */
	public void setHypnoshroom(boolean b) {
		hypnoshroomSelected = b;
	}
	/**
	 * Sets the wallnut
	 * @param true if set false if not set
	 */
	public void setWallnut(boolean b) {
		wallnutSelected = b;
	}
	/**
	 * Sets the shovel
	 * @param true if set false if not set
	 */
	public void setShovel(boolean b) {
		shovelSelected = b;
	}

}
