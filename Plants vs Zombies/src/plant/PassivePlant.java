package plant;
/**
 * PassivePlant Class:
 * @author Sirak Berhane (101030433)
 */
public class PassivePlant extends Plant{

	/**
	 * Create a new Passive or Non attack type plant (i.e sunflower, walnut etc.)
	 * @param hitThreshold Maximum hits a plant can take before it is dead
	 * @param buyThreshold Constant cost value for different plants 
	 */
	public PassivePlant(int hitThreshold, int buyThreshold) {
		super(hitThreshold, buyThreshold);
	}
}
