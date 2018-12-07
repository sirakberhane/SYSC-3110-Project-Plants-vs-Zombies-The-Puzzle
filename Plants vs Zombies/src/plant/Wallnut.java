package plant;

public class Wallnut extends PassivePlant{
	public static final int WALLNUT_HIT_THRESHOLD = 20;
	public static final int WALLNUT_BUY_THRESHOLD = 50;

	public Wallnut(int x, int y) {
		super(WALLNUT_HIT_THRESHOLD, WALLNUT_BUY_THRESHOLD, x, y);
	}
	
	/**
	 * Text-Based PvZ support.
	 */
	public String toString() {
		String Status= "";
		Status = "WN = " + this.getHitThreshold();
		return Status;
	}
}