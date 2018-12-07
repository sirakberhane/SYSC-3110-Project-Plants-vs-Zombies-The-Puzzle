package zombie;
/**
 * This is a zombie with a high hit threshold and high hit value. However
 * its downfall is that it is very slow.
 * @author Ryan Tordesillas (101041626)
 *
 */
public class Gargantuar extends Zombie{
	/** The speed of the zombie */
	private final static double TANK_SPEED = 0.2;
	/** The name of the zombie */
	private final static String TANK_NAME = "Gargantuar";
	/** The hit value of the zombie */
	private final static int TANK_HIT = 4;
	/** The hit threshold of the zombie */
	private final static int TANK_THRESHOLD = 35;
	
	/**
	 * The Constructor for the Gargantaur.
	 * @param yPos the row where the zombie spawns.
	 */
	public Gargantuar(int yPos) {
		super(TANK_SPEED,TANK_HIT,TANK_THRESHOLD,TANK_NAME);
		this.setType("Tank");
		this.setYPos(yPos);
	}
	
	
}
