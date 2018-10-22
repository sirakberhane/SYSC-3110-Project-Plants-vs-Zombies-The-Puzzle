package zombie;
/**
 * This class will create zombies that will be used in the main class.
 * @author Ryan Tordesillas(101041626)
 *
 */
public class Zombie {
	
	/** The left most point of the board*/
	private final int ENDOFBOARD = 8;
	
	/** The speed of the zombie */
	private int movementSpeed;
	/** The amount of damage the zombie can deal */
	private int hitValue;
	/** The amount of hits the zombie can take before dying */
	private int hitThreshold;
	/** The name/type of the zombie */
	private String name;
	/** The current X position of the zombie */
	private int currentX;
	/** The row where the zombie will move */
	private int yPos;
	
	/**
	 * This is the default constructor that will be used my majority of the sub-classes.
	 * @param movementSpeed the speed of the zombie
	 * @param hitValue the damage of the zombie
	 * @param hitThreshold the amount of hits the zombie can take
	 * @param name the name of the zombie
	 * @param yPos the row where the zombie will spawn
	 */
	public Zombie(int movementSpeed, int hitValue, int hitThreshold, String name, int yPos) {
		this.movementSpeed = movementSpeed;
		this.hitValue = hitValue;
		this.hitThreshold = hitThreshold;
		this.name = name;
		currentX = ENDOFBOARD;
		this.yPos = yPos;
	}

	/**
	 * Returns the movement of the zombie.
	 * @return movementSpeed the speed of the zombie.
	 */
	public int getMovementSpeed() {
		return movementSpeed;
	}

	/**
	 * This will return the hit value of the zombie when it attacks.
	 * @return hitValue the damage of the zombie.
	 */
	public int attack() {
		return hitValue;
	}

	/**
	 * This will decrement the hitThreshold based on the damage it takes.
	 * @param damage the damage that the zombie takes.
	 */
	public void hit(int damage) {
		hitThreshold -= damage;
	}

	/**
	 * Sets the hitThreshold.
	 * @param hitThreshold the amount of hits that the zombie can take.
	 */
	public void setHitThreshold(int hitThreshold) {
		this.hitThreshold = hitThreshold;
	}

	/**
	 * Returns the name of the zombie.
	 * @return the name of the zombie.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return the current X position of the zombie.
	 * @return currentX the x position of the zombie.
	 */
	public int getCurrentX() {
		return currentX;
	}
	
	/**
	 * Set the x position of the zombie.
	 * @param currentX the new x position of the zombie.
	 */
	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}

	/**
	 * Return the row that the zombie is in.
	 * @return yPos the row that the zombie is in.
	 */
	public int getyPos() {
		return yPos;
	}
	
	/**
	 * Returns a string representation of the zombie.
	 */
	public String toString() {
		return "This is a zombie named " + name + " with a damage of " + hitValue +", a HP of "+ hitThreshold + ", with a movement speed of "+ movementSpeed + ", at position x: " + currentX +", y = " + yPos;
	}
}
