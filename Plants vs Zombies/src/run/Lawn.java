package run;
import plant.*;
import zombie.*;
import java.util.*;

public class Lawn {
	//Zombies on this lawn
	private ArrayList<Zombie> zombies;
	//Plants on this lawn
	private ArrayList<Plant> plants;
	//Lawnmower on this lawn, true if activated, false otherwise
	private boolean lawnMower;
	
	/**
	 * Construct a new lawn that will contain a lawn mower, plants and zombies
	 */
	public Lawn() {
		zombies = new ArrayList<Zombie>();
		plants = new ArrayList<Plant>();
		lawnMower = false;
	}
	
	/**
	 * Return this lawn's plants
	 * @return this lawn's plants arrayList
	 */
	public ArrayList<Plant> getPlants() {
		return plants;
	}
	
	/**
	 * Return this lawn's zombies 
	 * @return this lawn's zombies arrayList
	 */
	public ArrayList<Zombie> getZombies() {
		return zombies;
	}
	
	/**
	 * Return true if the lawn mower has been activated, false otherwise
	 * @return true if the lawn mower is activated, false otherwise
	 */
	public boolean isLawnMowerActivated() {
		return lawnMower;
	}
	
	/**
	 * Set the lawn mower to be activated or deactivated 
	 * @param activated true if activated false, otherwise
	 */
	public void setLawnMower(boolean activated) {
		lawnMower = activated;
	}
	
	
	
}
