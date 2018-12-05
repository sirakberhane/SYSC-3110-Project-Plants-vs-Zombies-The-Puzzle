/**
 * @author Jolar Tabungar 101030060
 * 
 * Implementation of the Level class
 * 
<<<<<<< HEAD
 */		
package run;
=======
 */
package run;

import java.io.*;
>>>>>>> parent of 7fba955... Merge
import java.util.ArrayList;
import java.util.Random;
import plant.*;
import zombie.*;

<<<<<<< HEAD
public class Level {
	
	//Constants for the coordinate bounds
=======
public class Level implements Serializable {

	// Turn History Array
	public ArrayList<Level> turnHistory;

	// Constants for the coordinate bounds
>>>>>>> parent of 7fba955... Merge
	public static final int X_MIN = 0;
	public static final int X_MAX = 8;
	public static final int Y_MIN = 0;
	public static final int Y_MAX = 4;
<<<<<<< HEAD
	
	//Constant for minimum turnCountdown till next wave
	public static final int MINIMUM_TURN_COUNTDOWN_LENGTH = 7;
	//Sun generation amount
	public static final int PLAYER_GENERATED_SUN_AMOUNT = 25;
	//Sun generation countdown length
	public static final int SUN_GENERATION_COUNTDOWN_LENGTH = 4;
	
	//The player's suntotal
    private int sunTotal;
    //Countdown till player generates sun
  	private int generateSunCountdown;
	
	//Level's array of lawns
	private Lawn[] lawns;
	//Level's sizes for waves
	private ArrayList<Integer> waveSizes;
	//Level's turn countdown for next wave
	private int turnCountdown;
	//The amount of zombies currently spawned in the wave
	private int spawnCount;
	//The amount of zombies remaining in the wave
	private int remainingCount;
	//The wave count
	private int waveCount;
	
	private GameGUI game;
	/*
	//The player playing the level
	private Player player;
	//Level's printState class
	private PrintState printState;
	*/
	
	//Constructs a new Level
	public Level(ArrayList<Integer> waveSizes, GameGUI game) {
		this.game = game;
		
=======

	// Constant for minimum turnCountdown till next wave
	public static final int MINIMUM_TURN_COUNTDOWN_LENGTH = 7;
	// Sun generation amount
	public static final int PLAYER_GENERATED_SUN_AMOUNT = 25;
	// Sun generation countdown length
	public static final int SUN_GENERATION_COUNTDOWN_LENGTH = 4;

	// The player's suntotal
	private int sunTotal;
	// Countdown till player generates sun
	private int generateSunCountdown;

	// Level's array of lawns
	private Lawn[] lawns;
	// Level's sizes for waves
	private ArrayList<Integer> waveSizes;
	// Level's turn countdown for next wave
	private int turnCountdown;
	// The amount of zombies currently spawned in the wave
	private int spawnCount;
	// The amount of zombies remaining in the wave
	private int remainingCount;
	// The wave count
	private int waveCount;

	private GameGUI game;
	/*
	 * //The player playing the level private Player player; //Level's printState
	 * class private PrintState printState;
	 */

	// Constructs a new Level
	public Level(ArrayList<Integer> waveSizes, GameGUI game) {
		this.game = game;

>>>>>>> parent of 7fba955... Merge
		lawns = new Lawn[5];
		this.waveSizes = waveSizes;
		turnCountdown = MINIMUM_TURN_COUNTDOWN_LENGTH;
		spawnCount = 0;
		waveCount = 1;
		remainingCount = waveSizes.get(0);
<<<<<<< HEAD
		
		//Starting suntotal
		sunTotal = 100; 
				
		//Start countdown to sun generation
	    generateSunCountdown = SUN_GENERATION_COUNTDOWN_LENGTH;
		
		//Initialize the 5 lawns
		for (int i = 0; i < 5; i ++) {
			lawns[i] = new Lawn();
		}
		
	}
	
	//Create a new level given all the values of the fields
	public Level(
			int sunTotal,
			int generateSunCountdown,
			Lawn[] lawns,
			ArrayList<Integer> waveSizes,
			int turnCountdown,
			int spawnCount,
			int remainingCount,
			int wavecount,
			GameGUI game) 
	{
=======

		// Starting suntotal
		sunTotal = 100;

		// Start countdown to sun generation
		generateSunCountdown = SUN_GENERATION_COUNTDOWN_LENGTH;

		// Initialize the 5 lawns
		for (int i = 0; i < 5; i++) {
			lawns[i] = new Lawn();
		}

	}

	// Create a new level given all the values of the fields
	public Level(int sunTotal, int generateSunCountdown, Lawn[] lawns, ArrayList<Integer> waveSizes, int turnCountdown,
			int spawnCount, int remainingCount, int wavecount, GameGUI game) {
>>>>>>> parent of 7fba955... Merge
		this.sunTotal = sunTotal;
		this.generateSunCountdown = generateSunCountdown;
		this.lawns = lawns;
		this.waveSizes = waveSizes;
		this.turnCountdown = turnCountdown;
		this.spawnCount = spawnCount;
		this.remainingCount = remainingCount;
		this.waveCount = wavecount;
		this.game = game;
	}
<<<<<<< HEAD
	
	public Level copyLevel() {
		Lawn[] lawnsCopy = new Lawn[5];
		
		for (int i = 0 ; i < 5; i ++) {
			lawnsCopy[i] = lawns[i].copy();
		}
		
		Level copyLevel = new Level(
				sunTotal,
				generateSunCountdown,
				lawnsCopy,
				(ArrayList<Integer>) waveSizes.clone(),
				turnCountdown,
				spawnCount,
				remainingCount,
				waveCount,
				game);
		
		return copyLevel;
	}
	
	
	
	
	/**]
	 * Adds a new zombie to the level
	 * @param varietyCount determines the type of zombie to be added
	 * @param y the row the zombie will be spawned in
	 */
	public void addZombie(int varietyCount, int yPos) {
		Zombie zombie = null;
		
		
		if (varietyCount % 1 == 0) {
			zombie = new BasicZombie(yPos);
		}
		//Every third zombie is a Bucketzombie
		if (varietyCount % 3 == 0) {
			zombie = new BucketZombie(yPos);
		}
		//Every 5th zombie is a newspaperzombie
		if (varietyCount % 4 == 0) {
			zombie = new NewspaperZombie(yPos);
		}
		//Every 7th zombie is a football zombie
		if (varietyCount % 5 == 0) {
			zombie = new FootballZombie(yPos);
		}
		//Every 15th zombie is a gargantuar
=======

	public Level copyLevel() {
		Lawn[] lawnsCopy = new Lawn[5];

		for (int i = 0; i < 5; i++) {
			lawnsCopy[i] = lawns[i].copy();
		}

		Level copyLevel = new Level(sunTotal, generateSunCountdown, lawnsCopy, (ArrayList<Integer>) waveSizes.clone(),
				turnCountdown, spawnCount, remainingCount, waveCount, game);

		return copyLevel;
	}

	public ArrayList<Level> getHistory() {
		return turnHistory;
	}

	/**
	 * ] Adds a new zombie to the level
	 * 
	 * @param varietyCount
	 *            determines the type of zombie to be added
	 * @param y
	 *            the row the zombie will be spawned in
	 */
	public void addZombie(int varietyCount, int yPos) {
		Zombie zombie = null;

		if (varietyCount % 1 == 0) {
			zombie = new BasicZombie(yPos);
		}
		// Every third zombie is a Bucketzombie
		if (varietyCount % 3 == 0) {
			zombie = new BucketZombie(yPos);
		}
		// Every 5th zombie is a newspaperzombie
		if (varietyCount % 4 == 0) {
			zombie = new NewspaperZombie(yPos);
		}
		// Every 7th zombie is a football zombie
		if (varietyCount % 5 == 0) {
			zombie = new FootballZombie(yPos);
		}
		// Every 15th zombie is a gargantuar
>>>>>>> parent of 7fba955... Merge
		if (varietyCount % 10 == 0) {
			zombie = new Gargantuar(yPos);
		}

		lawns[yPos].getZombies().add(zombie);
	}
<<<<<<< HEAD
	
	/**
	 * Adds a new plant to the level
	 * @param plantType the type of plant to be spawned
	 * @param x the column of placement
	 * @param y the row of placement
	 * @return true if the plant can be placed (due to sun cost and if space is empty)
	 */
	public boolean addPlant(int x, int y) {
		Plant plant = null;
		
		if (game.sunflowerSelected()) {
			plant = new Sunflower(x, y);
		}
		else if (game.peashooterSelected()) {
			plant = new Peashooter(x, y);
		}
		else if (game.snowpeashooterSelected()) {
			plant = new SnowPeashooter(x, y);
		}
		else if (game.potatomineSelected()) {
			plant = new PotatoMine(x, y);
		}
		else if (game.hypnoshroomSelected()) {
			plant = new HypnoShroom(x, y);
		}
		else if (game.wallnutSelected()) {
			plant = new Wallnut(x, y);
		}
		
		
		
		for (Plant aPlant: lawns[y].getPlants()) {
			if (aPlant.getxPos() == x && aPlant.getyPos() == y)
				return false;
		}
		
=======

	/**
	 * Adds a new plant to the level
	 * 
	 * @param plantType
	 *            the type of plant to be spawned
	 * @param x
	 *            the column of placement
	 * @param y
	 *            the row of placement
	 * @return true if the plant can be placed (due to sun cost and if space is
	 *         empty)
	 */
	public boolean addPlant(int x, int y) {
		Plant plant = null;

		if (game.sunflowerSelected()) {
			plant = new Sunflower(x, y);
		} else if (game.peashooterSelected()) {
			plant = new Peashooter(x, y);
		} else if (game.snowpeashooterSelected()) {
			plant = new SnowPeashooter(x, y);
		} else if (game.potatomineSelected()) {
			plant = new PotatoMine(x, y);
		} else if (game.hypnoshroomSelected()) {
			plant = new HypnoShroom(x, y);
		} else if (game.wallnutSelected()) {
			plant = new Wallnut(x, y);
		}

		for (Plant aPlant : lawns[y].getPlants()) {
			if (aPlant.getxPos() == x && aPlant.getyPos() == y)
				return false;
		}

>>>>>>> parent of 7fba955... Merge
		if (getSunTotal() >= plant.getBuyThreshold()) {
			lawns[y].getPlants().add(plant);
			setSunTotal(getSunTotal() - plant.getBuyThreshold());
			return true;
		}
		return false;
	}
<<<<<<< HEAD
	
	/**
	 * Removes and deletes a plant at (x, y) position
	 * @param x the row in question
	 * @param y the column in question
	 * @return true if plant exists at (x, y) position and therefore can be removed, false otherwise
	 */
	public boolean removePlant(int x, int y) {
		for (Plant plant: lawns[y].getPlants()) {
=======

	/**
	 * Removes and deletes a plant at (x, y) position
	 * 
	 * @param x
	 *            the row in question
	 * @param y
	 *            the column in question
	 * @return true if plant exists at (x, y) position and therefore can be removed,
	 *         false otherwise
	 */
	public boolean removePlant(int x, int y) {
		for (Plant plant : lawns[y].getPlants()) {
>>>>>>> parent of 7fba955... Merge
			if (plant.getxPos() == x && plant.getyPos() == y) {
				lawns[y].getPlants().remove(plant);
				return true;
			}
		}
		return false;
	}
<<<<<<< HEAD
	
	/**
	 * Remove the zombie from the game and update the relevant fields
=======

	/**
	 * Remove the zombie from the game and update the relevant fields
	 * 
>>>>>>> parent of 7fba955... Merge
	 * @param zombie
	 */
	public void removeZombie(Zombie zombie) {
		lawns[zombie.getyPos()].getZombies().remove(zombie);
<<<<<<< HEAD
		remainingCount --;
	}
	
	/**
	 * Spawns n = zombieCount zombies (simulates a wave of zombies being added)
	 * @param zombieCount
	 */
	public void zombieWave() {
		//The number of zombies spawned in this call
		int currentCount = 0;
		Random randomY = new Random();
		//Spawn about a fifth of the wave size every call
		int yPos = randomY.nextInt(Y_MAX + 1);
		int varietyCount = 1;
		while (currentCount < waveSizes.get(0) / 5 && spawnCount < waveSizes.get(0)) {
			//Hold Variable to make sure yPos is unique every time
			int tempYPos = randomY.nextInt(Y_MAX + 1);
			
			while (tempYPos == yPos) {
				tempYPos = randomY.nextInt(Y_MAX + 1);
			}
			
			yPos = tempYPos;
			
            addZombie(varietyCount, yPos);
            
			currentCount ++;
			spawnCount ++;
			varietyCount ++;
		}
		
	}
	
	/**
	 * Returns the closest zombie in the given row
	 * @param yPos the given row
	 * @param plant the plant of reference
=======
		remainingCount--;
	}

	/**
	 * Spawns n = zombieCount zombies (simulates a wave of zombies being added)
	 * 
	 * @param zombieCount
	 */
	public void zombieWave() {
		// The number of zombies spawned in this call
		int currentCount = 0;
		Random randomY = new Random();
		// Spawn about a fifth of the wave size every call
		int yPos = randomY.nextInt(Y_MAX + 1);
		int varietyCount = 1;
		while (currentCount < waveSizes.get(0) / 5 && spawnCount < waveSizes.get(0)) {
			// Hold Variable to make sure yPos is unique every time
			int tempYPos = randomY.nextInt(Y_MAX + 1);

			while (tempYPos == yPos) {
				tempYPos = randomY.nextInt(Y_MAX + 1);
			}

			yPos = tempYPos;

			addZombie(varietyCount, yPos);

			currentCount++;
			spawnCount++;
			varietyCount++;
		}

	}

	/**
	 * Returns the closest zombie in the given row
	 * 
	 * @param yPos
	 *            the given row
	 * @param plant
	 *            the plant of reference
>>>>>>> parent of 7fba955... Merge
	 * @return the closest zombie
	 */
	public Zombie closestZombie(int yPos, Plant plant) {
		Zombie closest = null;
<<<<<<< HEAD
		
		if (!lawns[yPos].getZombies().isEmpty()) {
			
			//Find a potential closest zombie
			int i = 0;
			closest = lawns[yPos].getZombies().get(i);
			while (closest.getCurrentX() < plant.getxPos() && lawns[yPos].getZombies().size() > 1 && i < lawns[yPos].getZombies().size()) {
				closest = lawns[yPos].getZombies().get(i);
				i ++;
			}
	
			//For each loop to visit all zombies
			for (Zombie zombie: lawns[yPos].getZombies()) {
				//If current zombie is closer than our current closest, update closest
				if (zombie.getCurrentX() < closest.getCurrentX() && zombie.getCurrentX() >= plant.getxPos())
					closest = zombie;
		
=======

		if (!lawns[yPos].getZombies().isEmpty()) {

			// Find a potential closest zombie
			int i = 0;
			closest = lawns[yPos].getZombies().get(i);
			while (closest.getCurrentX() < plant.getxPos() && lawns[yPos].getZombies().size() > 1
					&& i < lawns[yPos].getZombies().size()) {
				closest = lawns[yPos].getZombies().get(i);
				i++;
			}

			// For each loop to visit all zombies
			for (Zombie zombie : lawns[yPos].getZombies()) {
				// If current zombie is closer than our current closest, update closest
				if (zombie.getCurrentX() < closest.getCurrentX() && zombie.getCurrentX() >= plant.getxPos())
					closest = zombie;

>>>>>>> parent of 7fba955... Merge
			}
		}

		return closest;
	}

<<<<<<< HEAD
	
=======
>>>>>>> parent of 7fba955... Merge
	/**
	 * 
	 */
	public Plant closestPlant(int yPos, Zombie zombie) {
		Plant closest = null;
		if (!lawns[yPos].getPlants().isEmpty()) {
<<<<<<< HEAD
			
			//Find a potential closest plant
			int i = 0;
			closest = lawns[yPos].getPlants().get(i);
			while (closest.getxPos() > zombie.getCurrentX() && lawns[yPos].getPlants().size() > 1 && i < lawns[yPos].getPlants().size()) {
				closest = lawns[yPos].getPlants().get(i);
				i ++;
			}
		
			//For each loop to visit all plants in the row
			for (Plant plant: lawns[yPos].getPlants()) {
				//If current plant is closer than our current closest, update closest
=======

			// Find a potential closest plant
			int i = 0;
			closest = lawns[yPos].getPlants().get(i);
			while (closest.getxPos() > zombie.getCurrentX() && lawns[yPos].getPlants().size() > 1
					&& i < lawns[yPos].getPlants().size()) {
				closest = lawns[yPos].getPlants().get(i);
				i++;
			}

			// For each loop to visit all plants in the row
			for (Plant plant : lawns[yPos].getPlants()) {
				// If current plant is closer than our current closest, update closest
>>>>>>> parent of 7fba955... Merge
				if (plant.getxPos() > closest.getxPos() && plant.getxPos() <= closestZombie(yPos, plant).getCurrentX())
					closest = plant;
			}

		}
		return closest;
	}
<<<<<<< HEAD
	
=======

>>>>>>> parent of 7fba955... Merge
	/**
	 * All plants do their respective actions
	 */
	public void plantAction() {
<<<<<<< HEAD
		//Visit all plants
		for (int i = 0; i < lawns.length; i ++) {
			
			ArrayList<Plant> removedPlants = new ArrayList<Plant>();
			
			for (Plant plant: lawns[i].getPlants()) {
				//Sunflower action
				if (plant instanceof Sunflower) {
					//Cast plant as sunflower
					Sunflower sunflower = (Sunflower) plant;
					//Give the player more sun
					setSunTotal(getSunTotal() + sunflower.generateSun());
				}
				//Peashooter action
				else if (plant instanceof Peashooter) {
					//Cast plant as peashooter
					Peashooter peashooter = (Peashooter) plant;
				
					//Find closest zombie in the row of the peashooter
					Zombie targetZombie = closestZombie(peashooter.getyPos(), peashooter);
					if (targetZombie != null) {
						//Deal damage to zombie
						targetZombie.hit(peashooter.getHitValue());
						//If zombie is dead, remove it
=======
		// Visit all plants
		for (int i = 0; i < lawns.length; i++) {

			ArrayList<Plant> removedPlants = new ArrayList<Plant>();

			for (Plant plant : lawns[i].getPlants()) {
				// Sunflower action
				if (plant instanceof Sunflower) {
					// Cast plant as sunflower
					Sunflower sunflower = (Sunflower) plant;
					// Give the player more sun
					setSunTotal(getSunTotal() + sunflower.generateSun());
				}
				// Peashooter action
				else if (plant instanceof Peashooter) {
					// Cast plant as peashooter
					Peashooter peashooter = (Peashooter) plant;

					// Find closest zombie in the row of the peashooter
					Zombie targetZombie = closestZombie(peashooter.getyPos(), peashooter);
					if (targetZombie != null) {
						// Deal damage to zombie
						targetZombie.hit(peashooter.getHitValue());
						// If zombie is dead, remove it
>>>>>>> parent of 7fba955... Merge
						if (targetZombie.isDead()) {
							removeZombie(targetZombie);
						}
					}
				}
<<<<<<< HEAD
				
				else if (plant instanceof SnowPeashooter) {
					//Cast plant as Snowpeashooter
					SnowPeashooter snowpeashooter = (SnowPeashooter) plant;
					
					//Find closest zombie in the row of the peashooter
					Zombie targetZombie = closestZombie(snowpeashooter.getyPos(), snowpeashooter);
					if (targetZombie != null) {
						//Deal damage to zombie
						targetZombie.hit(snowpeashooter.getHitValue());
						//If zombie is dead, remove it
=======

				else if (plant instanceof SnowPeashooter) {
					// Cast plant as Snowpeashooter
					SnowPeashooter snowpeashooter = (SnowPeashooter) plant;

					// Find closest zombie in the row of the peashooter
					Zombie targetZombie = closestZombie(snowpeashooter.getyPos(), snowpeashooter);
					if (targetZombie != null) {
						// Deal damage to zombie
						targetZombie.hit(snowpeashooter.getHitValue());
						// If zombie is dead, remove it
>>>>>>> parent of 7fba955... Merge
						if (targetZombie.isDead()) {
							removeZombie(targetZombie);
						}
					}
				}
<<<<<<< HEAD
				
				else if (plant instanceof PotatoMine) {
					//Cast plant as PotatoMine
					PotatoMine potatomine = (PotatoMine) plant;
					
					potatomine.decrementExplosionCountdown();
					
					//List for all zombies that die from the explosion
					ArrayList<Zombie> explodedZombies = new ArrayList<Zombie>();
					
					//Damage each zombie on the same tile as the potatomine
					for (Zombie zombie: lawns[i].getZombies()) {
=======

				else if (plant instanceof PotatoMine) {
					// Cast plant as PotatoMine
					PotatoMine potatomine = (PotatoMine) plant;

					potatomine.decrementExplosionCountdown();

					// List for all zombies that die from the explosion
					ArrayList<Zombie> explodedZombies = new ArrayList<Zombie>();

					// Damage each zombie on the same tile as the potatomine
					for (Zombie zombie : lawns[i].getZombies()) {
>>>>>>> parent of 7fba955... Merge
						if ((int) Math.round(zombie.getCurrentX()) == potatomine.getxPos()) {
							if (potatomine.isPrimed()) {
								potatomine.explode();
								zombie.hit(potatomine.getExplosionDamage());
							}
<<<<<<< HEAD
							//Remove it later if it is dead
=======
							// Remove it later if it is dead
>>>>>>> parent of 7fba955... Merge
							if (zombie.isDead())
								explodedZombies.add(zombie);
						}
					}
<<<<<<< HEAD
					
					//Remove all dead zombies
					for (Zombie zombie: explodedZombies)
						removeZombie(zombie);
					
					//Remove potatomine after it explodes
					if (potatomine.hasExploded()) {
						removedPlants.add(potatomine);
					}
							
				}
				
				else if (plant instanceof HypnoShroom) {
					//Cast plant as HypnoShroom
					HypnoShroom hypnoshroom = (HypnoShroom) plant;
					
					//Find closest zombie in the row of the hypnoshroom
					Zombie targetZombie = closestZombie(hypnoshroom.getyPos(), hypnoshroom);
					
					//If zombie is on the same tile
					if (targetZombie.getCurrentX() == hypnoshroom.getxPos()) {
						
					}
					
				}
				
				
			}
			
			for (Plant plant: removedPlants)
=======

					// Remove all dead zombies
					for (Zombie zombie : explodedZombies)
						removeZombie(zombie);

					// Remove potatomine after it explodes
					if (potatomine.hasExploded()) {
						removedPlants.add(potatomine);
					}

				}

				else if (plant instanceof HypnoShroom) {
					// Cast plant as HypnoShroom
					HypnoShroom hypnoshroom = (HypnoShroom) plant;

					// Find closest zombie in the row of the hypnoshroom
					Zombie targetZombie = closestZombie(hypnoshroom.getyPos(), hypnoshroom);

					// If zombie is on the same tile
					if (targetZombie.getCurrentX() == hypnoshroom.getxPos()) {

					}

				}

			}

			for (Plant plant : removedPlants)
>>>>>>> parent of 7fba955... Merge
				lawns[i].getPlants().remove(plant);
		}
	}

	public void zombieAction() {
<<<<<<< HEAD
		
		//Visit all zombies
		for (int i = 0; i < lawns.length; i ++) {
			
			//Flag if this lawn's lawn mower gets activated
			boolean lawnMowerActivate = false;
			
			for (Zombie zombie: lawns[i].getZombies()) {
				
				zombie.setMoving(true);
				
				//Determine whether zombie needs to stop due to plant collision
=======

		// Visit all zombies
		for (int i = 0; i < lawns.length; i++) {

			// Flag if this lawn's lawn mower gets activated
			boolean lawnMowerActivate = false;

			for (Zombie zombie : lawns[i].getZombies()) {

				zombie.setMoving(true);

				// Determine whether zombie needs to stop due to plant collision
>>>>>>> parent of 7fba955... Merge
				if (!lawns[i].getPlants().isEmpty()) {
					if (zombie.getCurrentX() == closestPlant(i, zombie).getxPos())
						zombie.setMoving(false);
					else
						zombie.setMoving(true);
				}
<<<<<<< HEAD
				
				if (zombie.isMoving()) {
					// If the zombies reaches the last tile and lawn mower is 
=======

				if (zombie.isMoving()) {
					// If the zombies reaches the last tile and lawn mower is
>>>>>>> parent of 7fba955... Merge
					// already activated, then it is game over.
					if (zombie.getCurrentX() < 0 && lawns[i].isLawnMowerActivated()) {
						game.loseScreen();
					}
<<<<<<< HEAD
					
					// If the zombies reach the last tile activate lawn mower 
					if (zombie.getCurrentX() < 0) {
						lawnMowerActivate = true;
					}
					
=======

					// If the zombies reach the last tile activate lawn mower
					if (zombie.getCurrentX() < 0) {
						lawnMowerActivate = true;
					}

>>>>>>> parent of 7fba955... Merge
					//
					if (zombie.isMoving()) {
						zombie.setCurrentX(zombie.getCurrentX() - zombie.getMovementSpeed());
					}
<<<<<<< HEAD
				}
				else {
=======
				} else {
>>>>>>> parent of 7fba955... Merge
					// Attack until plant is dead
					Plant targetPlant = closestPlant(i, zombie);
					if (targetPlant != null) {
						targetPlant.setHitThreshold(targetPlant.getHitThreshold() - zombie.attack());
						if (targetPlant.isPlantDead()) {
							lawns[i].getPlants().remove(targetPlant);
							zombie.setMoving(true);
<<<<<<< HEAD
						} 

					}
					
				}
			}
			
			//Activate the lawnmower once all the zombies have done their actions
=======
						}

					}

				}
			}

			// Activate the lawnmower once all the zombies have done their actions
>>>>>>> parent of 7fba955... Merge
			if (lawnMowerActivate) {
				activateLawnMower(i);
			}
		}
	}
<<<<<<< HEAD
	
	public Lawn getLawn(int y) {
		return lawns[y];
	}
	
	/**
	 * Activates the lawn mower in the given lawn
=======

	public Lawn getLawn(int y) {
		return lawns[y];
	}

	/**
	 * Activates the lawn mower in the given lawn
	 * 
>>>>>>> parent of 7fba955... Merge
	 * @param yPos
	 */
	public void activateLawnMower(int yPos) {
		lawns[yPos].setLawnMower(true);
		remainingCount -= lawns[yPos].getZombies().size();
		lawns[yPos].getZombies().clear();
	}
<<<<<<< HEAD
	
=======

>>>>>>> parent of 7fba955... Merge
	/**
	 * Gets the next move from the player and continues the level simulation.
	 */
	public void NextTurn() {
<<<<<<< HEAD
		//Generate sun for the player
		gameGenerateSun();
		
		//Continue to spawn waves until there are no more waves left
=======
		/*
		 * try { turnHistory.add((Level) clone()); } catch (CloneNotSupportedException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 */
		// Generate sun for the player
		gameGenerateSun();

		// Continue to spawn waves until there are no more waves left
>>>>>>> parent of 7fba955... Merge
		if (!waveSizes.isEmpty()) {
			if (spawnCount < waveSizes.get(0)) {
				zombieWave();
			}
		}
<<<<<<< HEAD
		
		//Zombies do actions
		zombieAction();
		
		//Plants do actions
		plantAction();
		
		//Decrement the turn countdown for the next wave
		turnCountdown --;
		
		//Reset for next wave
		if (turnCountdown <= 0 && !waveSizes.isEmpty() && waveSizes.size() != 1 && remainingCount == 0) {
			//Remove the size of completed wave from list
			waveSizes.remove(waveSizes.get(0));
			//Reset the turnCountdown
			turnCountdown = MINIMUM_TURN_COUNTDOWN_LENGTH;
			//Reset the remainingCount
			if (!waveSizes.isEmpty())
				remainingCount = waveSizes.get(0);
			//Reset the spawn count
			spawnCount = 0;
			//Increment the wave counter
			waveCount ++;
=======

		// Zombies do actions
		zombieAction();

		// Plants do actions
		plantAction();

		// Decrement the turn countdown for the next wave
		turnCountdown--;

		// Reset for next wave
		if (turnCountdown <= 0 && !waveSizes.isEmpty() && waveSizes.size() != 1 && remainingCount == 0) {
			// Remove the size of completed wave from list
			waveSizes.remove(waveSizes.get(0));
			// Reset the turnCountdown
			turnCountdown = MINIMUM_TURN_COUNTDOWN_LENGTH;
			// Reset the remainingCount
			if (!waveSizes.isEmpty())
				remainingCount = waveSizes.get(0);
			// Reset the spawn count
			spawnCount = 0;
			// Increment the wave counter
			waveCount++;
>>>>>>> parent of 7fba955... Merge
		}

		checkWinCondition();
	}
<<<<<<< HEAD
	
	/**
	 * Returns the total number of zombies remaining currently in the wave;
=======

	public void undoTurn() {
	}

	public void redoTurn() {

	}

	/**
	 * Returns the total number of zombies remaining currently in the wave;
	 * 
>>>>>>> parent of 7fba955... Merge
	 * @return the total number of zombies remaining currently in the wave
	 */
	public int zombieCount() {
		return remainingCount;
	}
<<<<<<< HEAD
	
	/**
	 * Returns the current wave number
=======

	/**
	 * Returns the current wave number
	 * 
>>>>>>> parent of 7fba955... Merge
	 * @return the current wave number
	 */
	public int currentWave() {
		return waveCount;
	}
<<<<<<< HEAD
	
	
	/**
	 * Return true if the win condition is met, false otherwise 
	 * @return true if the win condition is met, false otherwise
	 */
	public void checkWinCondition() {
		//Only check if there are no more zombies to be spawned
		if (waveSizes.size() == 1 && remainingCount == 0) {
			for (int i = 0; i < lawns.length; i ++) {
				//If no more zombies in this row, win condition is met so far
				if (lawns[i].getZombies().isEmpty()) {
					game.winScreen();
				}
				//If there are zombies in the row then win condition is not met
			}
		}
	}
	
=======

	/**
	 * Return true if the win condition is met, false otherwise
	 * 
	 * @return true if the win condition is met, false otherwise
	 */
	public void checkWinCondition() {
		// Only check if there are no more zombies to be spawned
		if (waveSizes.size() == 1 && remainingCount == 0) {
			for (int i = 0; i < lawns.length; i++) {
				// If no more zombies in this row, win condition is met so far
				if (lawns[i].getZombies().isEmpty()) {
					game.winScreen();
				}
				// If there are zombies in the row then win condition is not met
			}
		}
	}

>>>>>>> parent of 7fba955... Merge
	/**
	 * @return the current suntotal of player
	 */
	public int getSunTotal() {
		return sunTotal;
	}
<<<<<<< HEAD
	
=======

>>>>>>> parent of 7fba955... Merge
	/**
	 * Generate sun for the player when countdown is up
	 */
	public void gameGenerateSun() {
<<<<<<< HEAD
		//Decrement countdown
		countDownToGenerateSun();
		
		//If countdown is over, generate sun
		if (generateSunCountdown == 0) {
			generateSunCountdown = SUN_GENERATION_COUNTDOWN_LENGTH;
			setSunTotal(getSunTotal() + PLAYER_GENERATED_SUN_AMOUNT);
		} 
	}
	
=======
		// Decrement countdown
		countDownToGenerateSun();

		// If countdown is over, generate sun
		if (generateSunCountdown == 0) {
			generateSunCountdown = SUN_GENERATION_COUNTDOWN_LENGTH;
			setSunTotal(getSunTotal() + PLAYER_GENERATED_SUN_AMOUNT);
		}
	}

>>>>>>> parent of 7fba955... Merge
	/**
	 * Decrement the sun generation countdown
	 */
	private void countDownToGenerateSun() {
<<<<<<< HEAD
		generateSunCountdown --;
=======
		generateSunCountdown--;
>>>>>>> parent of 7fba955... Merge
	}

	/**
	 * Sets the suntotal of the player
<<<<<<< HEAD
	 * @param newtotal the new suntotal of the player
=======
	 * 
	 * @param newtotal
	 *            the new suntotal of the player
>>>>>>> parent of 7fba955... Merge
	 */
	public void setSunTotal(int newtotal) {
		sunTotal = newtotal;
	}
<<<<<<< HEAD
	
	/**
	 * 
	 * @param y
	 * @return returns  a list of lawns on the y coordinate
	 */
	
	public Lawn getLawns(int y){
=======

	/**
	 * 
	 * @param y
	 * @return returns a list of lawns on the y coordinate
	 */

	public Lawn getLawns(int y) {
>>>>>>> parent of 7fba955... Merge
		return lawns[y];
	}
}
