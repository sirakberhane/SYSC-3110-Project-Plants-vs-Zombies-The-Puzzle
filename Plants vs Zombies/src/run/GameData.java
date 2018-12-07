package run;

import java.io.Serializable;

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

	public void setSunflower(boolean b) {
		sunflowerSelected = b;
	}

	public void setPeashooter(boolean b) {
		peashooterSelected = b;
	}

	public void setSnowpeashooter(boolean b) {
		snowpeashooterSelected = b;
	}

	public void setPotatoMine(boolean b) {
		potatomineSelected = b;
	}
	public void setHypnoshroom(boolean b) {
		hypnoshroomSelected = b;
	}
	public void setWallnut(boolean b) {
		wallnutSelected = b;
	}
	public void setShovel(boolean b) {
		shovelSelected = b;
	}

}
