package zombie;
/**
 * This zombie has a high speed, a greater hit value and and moderate hit threshold.
 * It moves a small amount faster than the basic zombie.
 * @author Ryan Tordesillas (101041626)
 *
 */
public class FootballZombie extends Zombie{
	

	/** The speed of the zombie */
	private final static double FOOTBALL_SPEED = 0.8;
	/** The name of the zombie */
	private final static String FOOTBALL_NAME = "Football";
	/** The hit value of the zombie */
	private final static int FOOTBALL_HIT = 2;
	/** The hit threshold of the zombie */
	private final static int FOOTBALL_THRESHOLD = 20;
	/** Boolean that determines if the helmet is on the zombie */
	private boolean helmetOn;
	
	/**\
	 * The constructor for the FootballZombie.
	 * @param yPos the row the zombie will spawn in.
	 */
	public FootballZombie(int yPos) {
		super(FOOTBALL_SPEED,FOOTBALL_HIT,FOOTBALL_THRESHOLD,FOOTBALL_NAME);
		this.setType("Football");
		this.setYPos(yPos);
	}
	
	/**
	 * This method will set the helemet of the zombie on and off.
	 * @param b
	 */
	public void setHelmet(boolean b) {
		helmetOn = b;
	}
	
	/**
	 * This will return a boolean representing if the helemet is on the zombie.
	 * @return true if helmet is on, false otherwise.
	 */
	public boolean isHelmetOn() {
		return helmetOn;
	}
}
