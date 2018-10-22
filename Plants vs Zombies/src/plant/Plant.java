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
	public enum ShooterPlant {PEASHOOTER};
	public enum PassivePlant {SUNFLOWER};
	
	/**
	 * Construct a new Plant type. 
	 * @param hitThreshold Maximum hits a plant can take before it is dead
	 * @param buyThreshold Constant cost value for different plants 
	 */
	public Plant(int hitThreshold, int buyThreshold) {
		this.buyThreshold = buyThreshold;
		this.hitThreshold = hitThreshold;
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
		Status = "Current Plant Health" + getHitThreshold() + "\nIs Plant Alive:" + isPlantDead() + "\nCost of Plant:" + getBuyThreshold();
		return Status;
	}
}