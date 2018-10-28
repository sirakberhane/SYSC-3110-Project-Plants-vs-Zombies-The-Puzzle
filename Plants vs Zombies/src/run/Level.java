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
	
	//Level's array of lawns
	private Lawn[] lawns;
	//The player playing the level
	private Player player;
	//Level's printState class
	private PrintState printState;
	
	//Constructs a new Level
	public Level() {
		lawns = new Lawn[5];
		
		//Initialize the 5 lawns
		for (int i = 0; i < 5; i ++) {
			lawns[i] = new Lawn();
		}
		
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
		
		lawns[y].getZombies().add(zombie);
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
		
		for (Plant aPlant: lawns[y].getPlants()) {
			if (aPlant.getxPos() == x && aPlant.getyPos() == y)
				return false;
		}
		
		if (player.getSunTotal() >= plant.getBuyThreshold()) {
			lawns[y].getPlants().add(plant);
			//plants.add(plant);
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
		for (Plant plant: lawns[y].getPlants()) {
			if (plant.getxPos() == x && plant.getyPos() == y) {
				lawns[y].getPlants().remove(plant);
				//plants.remove(plant);
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
		Zombie closest = lawns[yPos].getZombies().get(0);
		
		//For each loop to visit all zombies
		for (Zombie zombie: lawns[yPos].getZombies()) {
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
		for (int i = 0; i < lawns.length; i ++) {
			
			for (Plant plant: lawns[i].getPlants()) {
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
					if (targetZombie.isDead()) {
						lawns[i].getZombies().remove(targetZombie);
					}
					
				}
			}
		}
	}

	public void zombieAction() {
		//Visit all zombies
		for (int i = 0; i < lawns.length; i ++) {
			for (Zombie zombie: lawns[i].getZombies()) {
				//Zombie moves
				if (zombie.isMoving()) {
					zombie.setCurrentX(zombie.getCurrentX() - zombie.getMovementSpeed());
					if (!lawns[i].getPlants().isEmpty() && (lawns[i].getPlants().get(i).getyPos() == (int)zombie.getyPos())) {
						// If zombie encounters a plant, then zombie movement should stop
						zombie.setMoving(false);

						// Attack until plant is dead
						lawns[i].getPlants().get(i).setHitThreshold(lawns[i].getPlants().get(i).getHitThreshold()-zombie.attack());


						// Remove any dead plants 
						if (lawns[i].getPlants().get(i).isPlantDead()) {
							lawns[i].getPlants().remove(i);
							zombie.setMoving(true);
						} 

						// If the Zombies reach the last tile activate lawn mower 
						if (lawns[i].getPlants().isEmpty() && (zombie.getCurrentX() == 0)) {
							lawns[i].setLawnMower(true);
							while (lawns[i].getZombies().isEmpty()) {
								lawns[i].getZombies().remove(i);
							}
						}

						// If the Zombies reaches the last tile and there is no plants and lawn mower is 
						// already activated, then it is game over.
						if (lawns[i].getPlants().isEmpty() && (zombie.getCurrentX() <= 0) && lawns[i].isLawnMowerActivated()) {
							System.out.println("Zombies Ate Your Brains!");
							System.out.println("GAME OVER!");
							System.exit(0);

						}
					}
				}
			}
		}
	}
	
	public void activateLawnMower(int yPos) {
		lawns[yPos].setLawnMower(true);
		
		for (Zombie zombie: lawns[yPos].getZombies()) {
			if (zombie.getyPos() == yPos) {
				lawns[yPos].getZombies().remove(zombie);
			}
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
		printState.updateState(lawns);
		//Print the Current State
		printState.print();
	}
}
