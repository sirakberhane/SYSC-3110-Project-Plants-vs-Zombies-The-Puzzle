package plant;

public class PotatoMine extends ExplosivePlant{
	public static final int POTATOMINE_HIT_THRESHOLD = 15;
	public static final int POTATOMINE_BUY_THRESHOLD = 75;
	public static final int TURNS_UNTIL_EXPLOSION = 3;
	public static final int POTATOMINE_EXPLOSION_DAMAGE = 10;
	
	private int countDownStartToExplode;
	private boolean isPrimed;
	
	public PotatoMine(int x, int y) {
		super(POTATOMINE_HIT_THRESHOLD, POTATOMINE_BUY_THRESHOLD, x, y, POTATOMINE_EXPLOSION_DAMAGE);
		countDownStartToExplode = TURNS_UNTIL_EXPLOSION;
		isPrimed = false;
	}

	public void decrementExplosionCountdown() {
		int currentCountDown = countDownToExplode(countDownStartToExplode);
		if (currentCountDown == 0) {
			countDownStartToExplode = TURNS_UNTIL_EXPLOSION;
			isPrimed = true;
		}
	}
	
	private int countDownToExplode(int startCountDown) {
		if (startCountDown != 0) {
			countDownStartToExplode--;
			startCountDown = countDownStartToExplode;
		}
		return startCountDown;
	}
	
	public boolean isPrimed() {
		return isPrimed;
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
