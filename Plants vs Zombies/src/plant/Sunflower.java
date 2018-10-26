package plant;
/**
 * Sunflower Class:
 * @author Sirak Berhane (101030433)
 */
public class Sunflower extends PassivePlant{
	public static final int SUNFLOWER_HIT_THRESHOLD = 5;
	public static final int SUNFLOWER_BUY_THRESHOLD = 50;
	private int countDownStart = 2;
	/**
	 * Creates a new Sunflower Plant type.
	 * @param x grid position x
	 * @param y grid position y
	 */
	public Sunflower(int x, int y) {
		super(SUNFLOWER_HIT_THRESHOLD, SUNFLOWER_BUY_THRESHOLD, x, y);
	}
	
	/**
	 * Generates one sunflower.
	 * @return a sunflower seed
	 */
	public int generateSun() {
		int currentCountDown = countDownToGenerateSun(countDownStart);
		if (currentCountDown == 0) {
			countDownStart = 2;
			return 25;
		}
		else {
			return 0;
		}
	}
	
	private int countDownToGenerateSun(int start) {
		if (start != 0) {
			countDownStart--;
			start = countDownStart;
		}
		return start;
	}
	
	public String toString() {
		String Status= "";
		Status = "S =  " + this.getHitThreshold();
		return Status;
	}
}
