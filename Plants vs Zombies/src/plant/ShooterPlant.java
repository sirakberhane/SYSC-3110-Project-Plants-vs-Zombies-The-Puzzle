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
	 * @param hitThreshold Maximum hits a plant can take before it is dead
	 * @param buyThreshold Constant cost value for different plants 
	 * @param hitValue max hit value of the attack plant type 
	 */
	public ShooterPlant(int hitThreshold, int buyThreshold, int x, int y, int hitValue) {
		super(hitThreshold, buyThreshold, x , y);
		this.hitValue = hitValue;
	}
	
	/**
	 * Returns the hit value of any shooter/attack type plants.
	 * @return the max hit value of the attack plant type 
	 */
	public int getHitValue() {
		return hitValue;
	}
}
