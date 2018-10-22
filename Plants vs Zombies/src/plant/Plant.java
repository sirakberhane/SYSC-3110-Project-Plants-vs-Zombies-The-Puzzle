package plant;
/**
 * Plant Class:
 * Creates a new Plant Type with variable 
 * cost of plant and health point.
 * @author Sirak Berhane (101030433)
 */
public class Plant {
	private final int buyThreshold; // Constant cost value for different plants 
	private int hitThreshold; // Maximum hits a plant can take before it is dead
	private int xPos; // Grid position x
	private int yPos; // Grid position y
	public enum ShooterPlant {PEASHOOTER};
	public enum PassivePlant {SUNFLOWER};
	/**
	 * Construct a new Plant type. 
	 * @param hitThreshold Maximum hits a plant can take before it is dead
	 * @param buyThreshold Constant cost value for different plants 
	 */
	public Plant(int hitThreshold, int buyThreshold, int x, int y) {
		this.buyThreshold = buyThreshold;
		this.hitThreshold = hitThreshold;
		this.setxPos(x);
		this.setyPos(y);
	}

	/**
	 * Returns Plant's sunflower cost.
	 * @return plant cost in sunflower
	 */
	public int getBuyThreshold() {
		return buyThreshold;
	}

	/**
	 * Health points or maximum hits plants 
	 * can take within a game level.
	 * @return plant maximum hitThreshold before plant dies
	 */
	public int getHitThreshold() {
		return hitThreshold;
	}

	/**
	 * Sets the current health of a plant.
	 * @param currentHP Updates plants health points 
	 * or the current hit count
	 */
	public void setHitThreshold(int currentHP) {
		this.hitThreshold = currentHP;
	}
	
	/**
	 * Checks if current bought plants are alive.
	 * @return true if the plant is dead false if it is still alive
	 */
	public boolean isPlantDead() {
		if (getHitThreshold() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Updates Current Plant Status.
	 */
	public String toString() {
		String Status = "";
		Status = "Plant HP:" + getHitThreshold();
		return Status;
	}

	/**
	 * @return x position
	 */
	public int getxPos() {
		return xPos;
	}

	/**
	 * @param xPos set x to this position 
	 */
	public void setxPos(int xPos) {
		if (xPos >= 0 && xPos <= 8) {
			this.xPos = xPos;
		}	
	}

	/**
	 * @return y position
	 */
	public int getyPos() {
		return yPos;
	}

	/**
	 * @param yPos set y to this position
	 */
	public void setyPos(int yPos) {
		if (xPos >= 0 && xPos <= 4) {
			this.yPos = yPos;
		}
	}
}