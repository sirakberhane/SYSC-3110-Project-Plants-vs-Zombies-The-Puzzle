package zombie;

public class Gargantuar extends Zombie{
	/** The speed of the zombie */
	private final static double TANK_SPEED = 0.5;
	/** The name of the zombie */
	private final static String TANK_NAME = "Gargantuar";
	/** The hit value of the zombie */
	private final static int TANK_HIT = 3;
	/** The hit threshold of the zombie */
	private final static int TANK_THRESHOLD = 35;
	
	public Gargantuar(int yPos) {
		super(TANK_SPEED,TANK_HIT,TANK_THRESHOLD,TANK_NAME);
		this.setType("Tank");
		this.setYPos(yPos);
	}
	
	
}
