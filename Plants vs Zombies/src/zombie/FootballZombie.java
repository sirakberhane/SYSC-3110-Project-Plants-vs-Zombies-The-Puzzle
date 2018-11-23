package zombie;

public class FootballZombie extends Zombie{
	

	/** The speed of the zombie */
	private final static double FOOTBALL_SPEED = 1;
	/** The name of the zombie */
	private final static String FOOTBALL_NAME = "Football";
	/** The hit value of the zombie */
	private final static int FOOTBALL_HIT = 2;
	/** The hit threshold of the zombie */
	private final static int FOOTBALL_THRESHOLD = 20;
	
	private boolean helmetOn;
	
	public FootballZombie(int yPos) {
		super(FOOTBALL_SPEED,FOOTBALL_HIT,FOOTBALL_THRESHOLD,FOOTBALL_NAME);
		this.setType("Football");
		this.setYPos(yPos);
	}
	
	public void setHelmet(boolean b) {
		helmetOn = b;
	}
	
	public boolean isHelmetOn() {
		return helmetOn;
	}
}
