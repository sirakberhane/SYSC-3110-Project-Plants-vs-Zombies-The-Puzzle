package plant;
/**
 * PassivePlant Class:
 * @author Sirak Berhane (101030433)
 */
public class PassivePlant extends Plant{
	private static final long serialVersionUID = 681996245081199261L;

	/**
	 * Create a new Passive or Non attack type plant (i.e sunflower, walnut etc.)
	 * @param hitThreshold Maximum hits a plant can take before it is dead
	 * @param buyThreshold Constant cost value for different plants
	 * @param x grid position x
	 * @param y grid position y 
	 */
	public PassivePlant(int hitThreshold, int buyThreshold, int x, int y) {
		super(hitThreshold, buyThreshold, x, y);
	}
}
