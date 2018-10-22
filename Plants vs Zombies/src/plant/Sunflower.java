package plant;
/**
 * Sunflower Class:
 * @author Sirak Berhane (101030433)
 */
public class Sunflower extends PassivePlant{

	/**
	 * Creates a new Sunflower Plant type.
	 * @param hitThreshold Maximum hits a plant can take before it is dead
	 * @param buyThreshold Constant cost value for different plants 
	 */
	public Sunflower(int hitThreshold, int buyThreshold) {
		super(5, 25);
	}
	
	/**
	 * Generates one sunflower.
	 * @return a sunflower
	 */
	public int generateSunflower() {
		return 25;
	}
}
