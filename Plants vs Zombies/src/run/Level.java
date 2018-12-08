/**
 * @author Jolar Tabungar 101030060
 * 
 * Implementation of the Level class
 * 
 */
package run;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import plant.*;
import zombie.*;

public class Level implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Turn History Array
	public ArrayList<Level> turnHistory;

	// Constants for the coordinate bounds
	public static final int X_MIN = 0;
	public static final int X_MAX = 8;
	public static final int Y_MIN = 0;
	public static final int Y_MAX = 4;

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

	private GameData gameData;
	
	private boolean gameWin;
	private boolean gameLose;
	/*
	 * //The player playing the level private Player player; //Level's printState
	 * class private PrintState printState;
	 */

	// Constructs a new Level
	public Level(ArrayList<Integer> waveSizes, GameGUI game) {
		this.gameData = game.getGameData();

		lawns = new Lawn[5];
		this.waveSizes = waveSizes;
		turnCountdown = MINIMUM_TURN_COUNTDOWN_LENGTH;
		spawnCount = 0;
		waveCount = 1;
		remainingCount = waveSizes.get(0);
		gameWin = false;
		gameLose = false;

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
			int spawnCount, int remainingCount, int wavecount, GameData game) {
		this.sunTotal = sunTotal;
		this.generateSunCountdown = generateSunCountdown;
		this.lawns = lawns;
		this.waveSizes = waveSizes;
		this.turnCountdown = turnCountdown;
		this.spawnCount = spawnCount;
		this.remainingCount = remainingCount;
		this.waveCount = wavecount;
		this.gameData = game;
	}

	public Level copyLevel() {
		Lawn[] lawnsCopy = new Lawn[5];

		for (int i = 0; i < 5; i++) {
			lawnsCopy[i] = lawns[i].copy();
		}

		Level copyLevel = new Level(sunTotal, generateSunCountdown, lawnsCopy, (ArrayList<Integer>) waveSizes.clone(),
				turnCountdown, spawnCount, remainingCount, waveCount, gameData);

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
		if (varietyCount % 10 == 0) {
			zombie = new Gargantuar(yPos);
		}

		lawns[yPos].getZombies().add(zombie);
	}

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

		if (gameData.sunflowerSelected()) {
			plant = new Sunflower(x, y);
		} else if (gameData.peashooterSelected()) {
			plant = new Peashooter(x, y);
		} else if (gameData.snowpeashooterSelected()) {
			plant = new SnowPeashooter(x, y);
		} else if (gameData.potatomineSelected()) {
			plant = new PotatoMine(x, y);
		} else if (gameData.hypnoshroomSelected()) {
			plant = new HypnoShroom(x, y);
		} else if (gameData.wallnutSelected()) {
			plant = new Wallnut(x, y);
		}

		for (Plant aPlant : lawns[y].getPlants()) {
			if (aPlant.getxPos() == x && aPlant.getyPos() == y)
				return false;
		}

		if (getSunTotal() >= plant.getBuyThreshold()) {
			lawns[y].getPlants().add(plant);
			setSunTotal(getSunTotal() - plant.getBuyThreshold());
			return true;
		}
		return false;
	}

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
			if (plant.getxPos() == x && plant.getyPos() == y) {
				lawns[y].getPlants().remove(plant);
				return true;
			}
		}
		return false;
	}

	/**
	 * Remove the zombie from the game and update the relevant fields
	 * 
	 * @param zombie
	 */
	public void removeZombie(Zombie zombie) {
		lawns[zombie.getyPos()].getZombies().remove(zombie);
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
	 * @return the closest zombie
	 */
	public Zombie closestZombie(Object entity, int yPos, int xPos) {
		Zombie closest = null;

		if (!lawns[yPos].getZombies().isEmpty()) {

			// Find a potential closest zombie
			int i = 0;
			closest = lawns[yPos].getZombies().get(i);
			while (lawns[yPos].getZombies().size() > 1
					&& i < lawns[yPos].getZombies().size() && closest == entity) {
				closest = lawns[yPos].getZombies().get(i);
				i++;
			}

			// For each loop to visit all zombies
			for (Zombie zombie : lawns[yPos].getZombies()) {
				// If current zombie is closer than our current closest, update closest
				
				//If reference entity is a plant
				if (entity instanceof Plant) {
					if (zombie.getCurrentX() < closest.getCurrentX() && zombie.getCurrentX() >= xPos)
						closest = zombie;
				}
				
				//If reference entity is a zombie
				else if (entity instanceof Zombie) {
					Zombie reference = (Zombie) entity;
					//If zombie is hypnotized
					if (reference.isHypnotized()) {
						if (zombie.getCurrentX() < closest.getCurrentX() && zombie.getCurrentX() >= xPos) {
							//Doesn't count if it's the zombie of reference
							if (reference != zombie)
								closest = zombie;
						}
					}
					
					//If zombie is not hypnotized
					else {
						if (zombie.getCurrentX() > closest.getCurrentX() && zombie.getCurrentX() <= xPos)
							closest = zombie;
					}
							
				}
			

			}
		}

		return closest;
	}

	/**
	 * Determines the closest plant in the lawn of the zombie
	 * @param yPos the lawn of reference
	 * @param zombie the zombie of reference
	 * @return
	 */
	public Plant closestPlant(int yPos, Zombie zombie) {
		Plant closest = null;
		if (!lawns[yPos].getPlants().isEmpty()) {

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
				if (plant.getxPos() > closest.getxPos()
						&& plant.getxPos() <= closestZombie(plant, yPos, plant.getxPos()).getCurrentX())
					closest = plant;
			}

		}
		return closest;
	}

	/**
	 * All plants do their respective actions
	 */
	public void plantAction() {
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
					Zombie targetZombie = closestZombie(peashooter, peashooter.getyPos(), peashooter.getxPos());
					if (targetZombie != null) {
						// Deal damage to zombie
						targetZombie.hit(peashooter.getHitValue());
						// If zombie is dead, remove it
						if (targetZombie.isDead()) {
							removeZombie(targetZombie);
						}
					}
				}

				else if (plant instanceof SnowPeashooter) {
					// Cast plant as Snowpeashooter
					SnowPeashooter snowpeashooter = (SnowPeashooter) plant;

					// Find closest zombie in the row of the peashooter
					Zombie targetZombie = closestZombie(snowpeashooter, snowpeashooter.getyPos(), snowpeashooter.getxPos());
					if (targetZombie != null) {
						targetZombie.setSlowed(true);
						// Deal damage to zombie
						targetZombie.hit(snowpeashooter.getHitValue());
						// If zombie is dead, remove it
						if (targetZombie.isDead()) {
							removeZombie(targetZombie);
						}
					}
				}

				else if (plant instanceof PotatoMine) {
					// Cast plant as PotatoMine
					PotatoMine potatomine = (PotatoMine) plant;

					potatomine.decrementExplosionCountdown();

					// List for all zombies that die from the explosion
					ArrayList<Zombie> explodedZombies = new ArrayList<Zombie>();

					// Damage each zombie on the same tile as the potatomine
					for (Zombie zombie : lawns[i].getZombies()) {
						if ((int) Math.round(zombie.getCurrentX()) == potatomine.getxPos()) {
							if (potatomine.isPrimed()) {
								potatomine.explode();
								zombie.hit(potatomine.getExplosionDamage());
							}
							// Remove it later if it is dead
							if (zombie.isDead())
								explodedZombies.add(zombie);
						}
					}

					// Remove all dead zombies
					for (Zombie zombie : explodedZombies)
						removeZombie(zombie);

					// Remove potatomine after it explodes
					if (potatomine.hasExploded()) {
						removedPlants.add(potatomine);
					}

				}

				else if (plant instanceof HypnoShroom) {

				}

			}

			for (Plant plant : removedPlants)
				lawns[i].getPlants().remove(plant);
		}
	}

	public void zombieAction() {

		// Visit all zombies
		for (int i = 0; i < lawns.length; i++) {

			// Flag if this lawn's lawn mower gets activated
			boolean lawnMowerActivate = false;

			ArrayList<Zombie> removedZombies = new ArrayList<Zombie>();
			
			for (Zombie zombie : lawns[i].getZombies()) {

				zombie.setMoving(true);
				
				int xPos = (int) (Math.round(zombie.getCurrentX()));
				// Determine whether zombie needs to stop due to plant/zombie collision
				if (!lawns[i].getPlants().isEmpty()) {
					if (xPos == closestPlant(i, zombie).getxPos())
						zombie.setMoving(false);
				}
				
				if (lawns[i].getZombies().size() > 1) {
					if (xPos == (int) Math.round(closestZombie(zombie, i, xPos).getCurrentX())) {
						if (closestZombie(zombie, i, xPos).isHypnotized() || zombie.isHypnotized())
							zombie.setMoving(false);
					}
				}

				if (zombie.isMoving()) {
					// If the zombies reaches the last tile and lawn mower is
					// already activated, then it is game over.
					if (zombie.getCurrentX() < 0 && lawns[i].isLawnMowerActivated()) {
						gameLose = true;
					}

					// If the zombies reach the last tile activate lawn mower
					if (zombie.getCurrentX() < 0) {
						lawnMowerActivate = true;
					}

					//If zombie is hypnotized, move opposite direction
					if (zombie.isHypnotized()) {
						zombie.setCurrentX(zombie.getCurrentX() + zombie.getMovementSpeed());
						//If it reaches the end of the board, remove it
						if (zombie.getCurrentX() > Level.X_MAX) {
							removedZombies.add(zombie);
						}
					}

					else {
						zombie.setCurrentX(zombie.getCurrentX() - zombie.getMovementSpeed());
					}

				} else {
					//If zombie is hypnotized, will attack other zombies
					if (zombie.isHypnotized() && lawns[i].getZombies().size() > 1) {
						Zombie targetZombie = closestZombie(zombie, i, (int) zombie.getCurrentX());
						if (targetZombie != null) {
							targetZombie.setHitThreshold(targetZombie.getHitThreshold() - zombie.attack());
							if (targetZombie.isDead()) {
								removedZombies.add(targetZombie);
							}
						}
					} else {
						// Attack until plant is dead
						Plant targetPlant = closestPlant(i, zombie);
						if (targetPlant != null) {
							targetPlant.setHitThreshold(targetPlant.getHitThreshold() - zombie.attack());
							if (targetPlant.isPlantDead()) {
								// If plant was a hypnoshroom, hypnotize the zombie
								if (targetPlant instanceof HypnoShroom) {
									zombie.setHypnotized(true);
								}
								lawns[i].getPlants().remove(targetPlant);
								zombie.setMoving(true);
							}

						}
					}

				}
			}

			// Activate the lawnmower once all the zombies have done their actions
			if (lawnMowerActivate) {
				activateLawnMower(i);
			}
			
			//Remove all hypnotized zombies that have left
			for (Zombie zombie: removedZombies) {
				removeZombie(zombie);
			}
		}
	}

	public Lawn getLawn(int y) {
		return lawns[y];
	}

	/**
	 * Activates the lawn mower in the given lawn
	 * 
	 * @param yPos
	 */
	public void activateLawnMower(int yPos) {
		lawns[yPos].setLawnMower(true);
		remainingCount -= lawns[yPos].getZombies().size();
		lawns[yPos].getZombies().clear();
	}

	/**
	 * Gets the next move from the player and continues the level simulation.
	 */
	public void NextTurn() {
		// Generate sun for the player
		gameGenerateSun();

		// Continue to spawn waves until there are no more waves left
		if (!waveSizes.isEmpty()) {
			if (spawnCount < waveSizes.get(0)) {
				zombieWave();
			}
		}

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
		}

		checkWinCondition();
	}

	/**
	 * Returns the total number of zombies remaining currently in the wave;
	 * 
	 * @return the total number of zombies remaining currently in the wave
	 */
	public int zombieCount() {
		return remainingCount;
	}

	/**
	 * Returns the current wave number
	 * 
	 * @return the current wave number
	 */
	public int currentWave() {
		return waveCount;
	}

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
					gameWin = true;
				}
				// If there are zombies in the row then win condition is not met
			}
		}
	}

	/**
	 * @return the current suntotal of player
	 */
	public int getSunTotal() {
		return sunTotal;
	}

	/**
	 * Generate sun for the player when countdown is up
	 */
	public void gameGenerateSun() {
		// Decrement countdown
		countDownToGenerateSun();

		// If countdown is over, generate sun
		if (generateSunCountdown == 0) {
			generateSunCountdown = SUN_GENERATION_COUNTDOWN_LENGTH;
			setSunTotal(getSunTotal() + PLAYER_GENERATED_SUN_AMOUNT);
		}
	}

	/**
	 * Decrement the sun generation countdown
	 */
	private void countDownToGenerateSun() {
		generateSunCountdown--;
	}

	/**
	 * Sets the suntotal of the player
	 * 
	 * @param newtotal
	 *            the new suntotal of the player
	 */
	public void setSunTotal(int newtotal) {
		sunTotal = newtotal;
	}

	/**
	 * 
	 * @param y
	 * @return returns a list of lawns on the y coordinate
	 */

	public Lawn getLawns(int y) {
		return lawns[y];
	}
	
	/**
	 * Returns true when the game is won.
	 * @return true when the game is won.
	 */
	public boolean gameWin() {
		return gameWin;
	}
	/**
	 * Returns true when the game is lost.
	 * @return true whe the game is lost.
	 */
	public boolean gameLose() {
		return gameLose;
	}
}
