package plant;

public class SnowPea extends ShooterPlant{
	public static final int SNOWPEA_HIT_THRESHOLD = 10;
	public static final int SNOWPEA_BUY_THRESHOLD = 175;

	public SnowPea(int x, int y, int hitValue) {
		super(SNOWPEA_HIT_THRESHOLD, SNOWPEA_BUY_THRESHOLD, x, y, 2);
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