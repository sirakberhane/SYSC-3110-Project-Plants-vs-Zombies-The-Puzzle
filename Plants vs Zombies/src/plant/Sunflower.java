package plant;
/**
 * Sunflower Class:
 * @author Sirak Berhane (101030433)
 */
public class Sunflower extends PassivePlant{
	/**
	 * Creates a new Sunflower Plant type.
	 * @param x grid position x
	 * @param y grid position y
	 */
	public Sunflower(int x, int y) {
		super(5, 25, x, y);
	}
	
	/**
	 * Generates one sunflower.
	 * @return a sunflower seed
	 */
	public int generateSunflower() {
		return 25;
	}
	
	public String toString() {
		String Status= "";
		Status = "S = " + this.getHitThreshold();
		return Status;
	}
}
