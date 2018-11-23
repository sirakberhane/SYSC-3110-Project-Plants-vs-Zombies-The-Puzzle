package plant;

public class HypnoShroom extends PassivePlant{
	public static final int HYPNOSHROOM_HIT_THRESHOLD = 1;
	public static final int HYPNOSHROOM_BUY_THRESHOLD = 125;
	
	public HypnoShroom(int x, int y) {
		super(HYPNOSHROOM_HIT_THRESHOLD, HYPNOSHROOM_BUY_THRESHOLD, x, y);
	}
}
