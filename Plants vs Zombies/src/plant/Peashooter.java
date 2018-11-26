package plant;
/**
 * Peashooter Class:
 * Peashooters are your first line 
 * of defense. They shoot peas at attacking zombies.
 * 
 * @author Sirak Berhane (101030433)
 */
public class Peashooter extends ShooterPlant{
	public static final int PEASHOOTER_HIT_THRESHOLD = 10;
	public static final int PEASHOOTER_BUY_THRESHOLD = 100;
	public static final int PEASHOOTER_HIT_VALUE = 2;
	/**
	 * Extends a ShooterPlant type, any shooter plant type 
	 * has the ability to do damage to any zombie type. 
	 * @param x grid position x
	 * @param y grid position y
	 */
	public Peashooter(int x, int y) {
		super(PEASHOOTER_HIT_THRESHOLD, PEASHOOTER_BUY_THRESHOLD, x, y, PEASHOOTER_HIT_VALUE);
	}
	
	/**
	 * Shoots a pea at zombie, if zombie is close enough.
	 * @return negative hit value to a zombie object
	 */
	public int shootPea() {
		return -(getHitValue());
	}
	
	public String toString() {
		String Status= "";
		Status = "P = " + this.getHitThreshold();
		return Status;
	}
}
