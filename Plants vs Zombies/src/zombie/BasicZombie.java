package zombie;

/**
 * The basic zombie that will be used in the game.
 * @author Ryan Tordesillas(101041626)
 *
 */
public class BasicZombie extends Zombie {
	/** The basic speed of the zombie */
	private final static double BASIC_SPEED = 0.5;
	/** The basic name of the zombie */
	private final static String BASIC_NAME = "Basic";
	/** The basic hit value of the zombie */
	private final static int BASIC_HIT = 1;
	/** The basic hit threshold of the zombie */
	private final static int BASIC_THRESHOLD = 10;
	
	/**
	 * The Constructor for the basic zombie.
	 * @param yPos the y position where the zombie will start.
	 */
	public BasicZombie(int yPos) {
		super(BASIC_SPEED, BASIC_HIT, BASIC_THRESHOLD, BASIC_NAME);
		this.setType("Basic");
		this.setYPos(yPos);
	}

}
