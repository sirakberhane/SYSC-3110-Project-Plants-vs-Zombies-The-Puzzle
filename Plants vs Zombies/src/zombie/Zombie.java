package zombie;

import plant.Plant;

/**
 * This class will create zombies that will be used in the main class.
 * @author Ryan Tordesillas(101041626)
 *
 */
public class Zombie implements Cloneable {
	
	/** The left most point of the board*/
	private final int ENDOFBOARD = 8;
	
	/** The speed of the zombie */
	private double movementSpeed;
	/** The amount of damage the zombie can deal */
	private int hitValue;
	/** The amount of hits the zombie can take before dying */
	private int hitThreshold;
	/** The name/type of the zombie */
	private String name;
	/** The current X position of the zombie */
	private double currentX;
	/** The row where the zombie will move */
	private int yPos;
	/** Indicates whether the zombie is moving */
	private boolean moving;
	/** Indicates whether the zombie is hypnotized */
	private boolean hypnotized;
	/** Indicates whether the zombie is slowed */
	private boolean slowed;
	
	/** The different types of zombie */
	public enum Type {BASIC,BUCKET, FOOTBALL, TANK};
	
	/** The current type of zombie */
	private Type type;
	/**
	 * This is the default constructor that will be used my majority of the sub-classes.
	 * @param movementSpeed the speed of the zombie
	 * @param hitValue the damage of the zombie
	 * @param hitThreshold the amount of hits the zombie can take
	 * @param name the name of the zombie
	 * @param yPos the row where the zombie will spawn
	 */
	public Zombie(double movementSpeed, int hitValue, int hitThreshold, String name) {
		this.movementSpeed = movementSpeed;
		this.hitValue = hitValue;
		this.hitThreshold = hitThreshold;
		this.name = name;
		currentX = ENDOFBOARD;
		moving = true;
		hypnotized = false;
		slowed = false;
	}

	/**
	 * Returns the movement of the zombie.
	 * @return movementSpeed the speed of the zombie.
	 */
	public double getMovementSpeed() {
		//If slowed, moves half as fast
		if (isSlowed())
			return 0.5 * movementSpeed;
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
	 * Returns the hitThreshold
	 * @return the hitThreshold
	 */
	public int getHitThreshold() {
		return hitThreshold;
	}
	
	/**
	 * Return true if zombie is dead, ie. hitThreshold falls to 0
	 * @return true if zombie is dead, ie. hitThreshold falls to 0
	 */
	public boolean isDead() {
		if (getHitThreshold() <= 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if zombie is moving, false if standing
	 * @return true if zombie is moving, false if standing
	 */
	public boolean isMoving() {
		return moving;
	}
	
	/**
	 * Set the moving variable to true or false
	 * @param moving indicates whether the zombie is moving
	 */
	public void setMoving(boolean moving) {
		this.moving = moving;
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
	public double getCurrentX() {
		return currentX;
	}
	
	/**
	 * Set the x position of the zombie.
	 * @param currentX the new x position of the zombie.
	 */
	public void setCurrentX(double currentX) {
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
	 * Returns a string representation of the zombie's hit threshold.
	 */
	public String toString() {
		return "Z = " + hitThreshold;
	}
	
	/**
	 * This will set the type of the zombie
	 * @param type a String representation of the type of zombie.
	 */
	public void setType(String s) {
		if (s.equals("Basic")) {
			type = Type.BASIC;
		}
		else if (s.equals("Bucket")) {
			type = Type.BUCKET;
		}
		else if (s.equals("Football")) {
			type = Type.FOOTBALL;
		}else {
			type = Type.TANK;
		}
	}
	
	/**
	 * Gets the type of the zombie.
	 * @return the type of the zombie.
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Set the yPos of the zombie.
	 * @param y the int of the row for the zombie.
	 */
	public void setYPos(int y) {
		yPos = y;
	}
	
	/**
	 * Returns true if the zombie is hypnotized, false otherwise
	 * @return true if zombie is hypnotized, false otherwise
	 */
	public boolean isHypnotized() {
		return hypnotized;
	}
	
	/**
	 * Sets whether the zombie is hypnotized or not
	 * @param hypnotized indicates whether the zombie is hypnotized or not
	 */
	public void setHypnotized(boolean hypnotized) {
		this.hypnotized = hypnotized;
	}
	
	/**
	 * Returns true if the zombie is slowed, false otherwise
	 * @return true if the zombie is slowed, false otherwise
	 */
	public boolean isSlowed() {
		return slowed;
	}
	
	/**
	 * Sets whether the zombie is slowed or not
	 * @param slowed indicates whether the zombie is slowed or not
	 */
	public void setSlowed(boolean slowed) {
		this.slowed = slowed;
	}
	
	/**
	 * Returns a copy of the zombie (for undo/redo purposes)
	 * @return a copy of the zombie
	 */
	public Zombie clone() throws CloneNotSupportedException {
		return (Zombie) super.clone();
	}
	
}
