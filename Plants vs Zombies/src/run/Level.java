/**
 * @author Jolar Tabungar 101030060
 * 
 * Implementation of the Level class
 * 
 */		
package run;
import java.util.ArrayList;
import java.util.Random;
import plant.*;
import zombie.*;
import player.*;

public class Level {
	
	//Constants for the coordinate bounds
	public static final int X_MIN = 0;
	public static final int X_MAX = 8;
	public static final int Y_MIN = 0;
	public static final int Y_MAX = 4;
	
	//All plants on the board
	private ArrayList<Plant> plants;
	//All zombies on the board
	private ArrayList<Zombie> zombies;
	//The player playing the level
	private Player player;
	//Level's printState class
	private PrintState printState;
	
	//Constructs a new Level
	public Level() {
		plants = new ArrayList<Plant>();
		zombies = new ArrayList<Zombie>();
		player = new Player(this);
		printState = new PrintState(this, player);
	}
	
	/**]
	 * Adds a new zombie to the level
	 * @param zombieType the type of zombie to be spawned
	 * @param y the row the zombie will be spawned in
	 */
	public void addZombie(String zombieType, int y) {
		Zombie zombie = null;
		
		if (zombieType.equalsIgnoreCase("zombie")) {
			zombie = new BasicZombie(y);
		}
		
		zombies.add(zombie);
	}
	
	/**
	 * Adds a new plant to the level
	 * @param plantType the type of plant to be spawned
	 * @param x the column of placement
	 * @param y the row of placement
	 * @return true if the plant can be placed (due to sun cost and if space is empty)
	 */
	public boolean addPlant(String plantType, int x, int y) {
		Plant plant = null;
		
		if (plantType.equalsIgnoreCase("sunflower")) {
			plant = new Sunflower(x, y);
		}
		else if (plantType.equalsIgnoreCase("peashooter")) {
			plant = new Peashooter(x, y);
		}
		
		for (Plant aPlant: plants) {
			if (aPlant.getxPos() == x && aPlant.getyPos() == y)
				return false;
		}
		
		if (player.getSunTotal() >= plant.getBuyThreshold()) {
			plants.add(plant);
			player.setSunTotal(player.getSunTotal() - plant.getBuyThreshold());
			return true;
		}
		return false;
	}
	
	/**
	 * Removes and deletes a plant at (x, y) position
	 * @param x the row in question
	 * @param y the column in question
	 * @return true if plant exists at (x, y) position and therefore can be removed, false otherwise
	 */
	public boolean removePlant(int x, int y) {
		for (Plant plant: plants) {
			if (plant.getxPos() == x && plant.getyPos() == y) {
				plants.remove(plant);
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * Spawns n = zombieCount zombies (simulates a wave of zombies being added)
	 * @param zombieCount
	 */
	public void zombieWave(int zombieCount) {
		int currentCount = 0;
		while (currentCount < zombieCount) {
			Random randomY = new Random();
			addZombie("zombie", randomY.nextInt(5));
			currentCount ++;
		}
		
	}
	
	/**
	 * Returns the closest zombie in the given row
	 * @param yPos the given row
	 * @return the closest zombie
	 */
	public Zombie closestZombie(int yPos) {
		Zombie closest = zombies.get(0);
		
		//For each loop to visit all zombies
		for (Zombie zombie: zombies) {
			//Only interested in zombies in the given row
			if (zombie.getyPos() == yPos) {
				//If current zombie is closer than our current closest, update closest
				if (zombie.getCurrentX() < closest.getCurrentX())
					closest = zombie;
			}
		}

		return closest;
	}
	
	/**
	 * All plants do their respective actions
	 */
	public void plantAction() {
		//Visit all plants
		for (Plant plant: plants) {
			//Sunflower action
			if (plant instanceof Sunflower) {
				//Cast plant as sunflower
				Sunflower sunflower = (Sunflower) plant;
				//Give the player more sun
				player.setSunTotal(player.getSunTotal() + sunflower.generateSun());
			}
			//Peashooter action
			else if (plant instanceof Peashooter) {
				//Cast plant as peashooter
				Peashooter peashooter = (Peashooter) plant;
				
				//Find closest zombie in the row of the peashooter
				Zombie targetZombie = closestZombie(peashooter.getyPos());
				//Deal damage to zombie
				targetZombie.hit(peashooter.getHitValue());
			}
		}
	}
	
	public void zombieAction() {
		//Visit all zombies
		for (Zombie zombie: zombies) {
			//Zombie moves
			zombie.setCurrentX(zombie.getCurrentX() - zombie.getMovementSpeed());
		}
	}
	
	/**
	 * Gets the next move from the player and continues the level simulation.
	 */
	public void NextTurn() {
		//Get player's action
		player.getPlayerAction();
		
		//Spawn zombies
		zombieWave(1);
		
		//Zombies do actions
		zombieAction();
		
		//Plants do actions
		plantAction();
		
		//Update the printState
		printState.updateState(plants, zombies);
		//Print the Current State
		printState.print();
	}
}
