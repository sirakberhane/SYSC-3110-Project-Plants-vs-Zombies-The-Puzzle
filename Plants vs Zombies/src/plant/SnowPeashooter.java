package plant;

public class SnowPeashooter extends ShooterPlant{
	public static final int SNOWPEASHOOTER_HIT_THRESHOLD = 10;
	public static final int SNOWPEASHOOTER_BUY_THRESHOLD = 175;
	public static final int SNOWPEASHOOTER_HIT_VALUE = 3;

	public SnowPeashooter(int x, int y) {
		super(SNOWPEASHOOTER_HIT_THRESHOLD, SNOWPEASHOOTER_BUY_THRESHOLD, x, y, SNOWPEASHOOTER_HIT_VALUE);
	}

	/**
	 * Shoots a snow pea at zombie, if zombie is close enough.
	 * @return negative hit value to a zombie object
	 */
	public int shootFrozenPea() {
		return -(getHitValue());
	}
	
	/**
	 * Text-Based PvZ support.
	 */
	public String toString() {
		String Status= "";
		Status = "SP = " + this.getHitThreshold();
		return Status;
	}
}