package plant;

public class PotatoMine extends ExplosivePlant{
	public static final int POTATOMINE_HIT_THRESHOLD = 15;
	public static final int POTATOMINE_BUY_THRESHOLD = 75;

	public PotatoMine(int x, int y) {
		super(POTATOMINE_HIT_THRESHOLD, POTATOMINE_BUY_THRESHOLD, x, y);
	}

}
