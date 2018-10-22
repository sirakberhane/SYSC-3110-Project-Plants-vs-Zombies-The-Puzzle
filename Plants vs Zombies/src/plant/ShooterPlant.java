package plant;
/**
 * ShooterPlant Type Class
 * @author Sirak Berhane (101030433)
 *
 */
public class ShooterPlant extends Plant{

	private final int hitValue; // Hit value of the Attack type plant
	
	/**
	 * Creates a new attack type plant.
	 * 
	 * @param hitThreshold Maximum hits a plant can take before it is dead
	 * @param buyThreshold
	 * @param hitValue 
	 */
	public ShooterPlant(int hitThreshold, int buyThreshold, int hitValue) {
		super(10, 100);
		this.hitValue = hitValue;
	}
	
	public int getHitValue() {
		return hitValue;
	}
}
