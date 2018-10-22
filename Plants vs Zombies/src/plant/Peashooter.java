package plant;
/**
 * Peashooter Class:
 * Peashooters are your first line 
 * of defense. They shoot peas at attacking zombies.
 * 
 * @author Sirak Berhane (101030433)
 */
public class Peashooter extends ShooterPlant{
	/**
	 * Extends a ShooterPlant type, any shooter plant type 
	 * has the ability to do damage to any zombie type. 
	 * @param hitThreshold Maximum hits a plant can take before it is dead
	 * @param buyThreshold Constant cost value for different plants 
	 * @param hitValue Attack value of Peashooter
	 */
	public Peashooter(int hitThreshold, int buyThreshold, int hitValue) {
		super(10, 100, 2);
	}
	
	/**
	 * Shoots a pea at zombie, if zombie is close enough.
	 * @return negative hit value to a zombie object
	 */
	public int shootPea() {
		return -(getHitValue());
	}
}
