package plant;

public class HypnoShroom extends PassivePlant{
	private static final long serialVersionUID = 5653936145650945094L;
	public static final int HYPNOSHROOM_HIT_THRESHOLD = 1;
	public static final int HYPNOSHROOM_BUY_THRESHOLD = 125;
	
	public HypnoShroom(int x, int y) {
		super(HYPNOSHROOM_HIT_THRESHOLD, HYPNOSHROOM_BUY_THRESHOLD, x, y);
	}
	
	/**
	 * Text-Based PvZ support.
	 */
	public String toString() {
		String Status= "";
		Status = "HS = " + this.getHitThreshold();
		return Status;
	}
}
