package plant;

public class PotatoMine extends ExplosivePlant{
	public static final int POTATOMINE_HIT_THRESHOLD = 15;
	public static final int POTATOMINE_BUY_THRESHOLD = 75;
	public static final int TURNS_UNTIL_EXPLOSION = 3;
	
	private int countDownStartToExplode;

	public PotatoMine(int x, int y) {
		super(POTATOMINE_HIT_THRESHOLD, POTATOMINE_BUY_THRESHOLD, x, y);
		countDownStartToExplode = TURNS_UNTIL_EXPLOSION;
	}

	public int ExplosionAttack() {
		int currentCountDown = countDownToExplode(countDownStartToExplode);
		if (currentCountDown == 0) {
			countDownStartToExplode = TURNS_UNTIL_EXPLOSION;
			return -10;
		}
		else {
			return 0;
		}
	}
	
	private int countDownToExplode(int startCountDown) {
		if (startCountDown != 0) {
			countDownStartToExplode--;
			startCountDown = countDownStartToExplode;
		}
		return startCountDown;
	}

	/**
	 * Text-Based PvZ support.
	 */
	public String toString() {
		String Status= "";
		Status = "PM = " + this.getHitThreshold();
		return Status;
	}
}
