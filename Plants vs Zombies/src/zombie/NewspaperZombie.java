package zombie;

public class NewspaperZombie extends Zombie{

	/** The speed of the zombie */
	private static double newspaperSpeed = 0.5;
	/** The name of the zombie */
	private final static String NEWSPAPER_NAME = "Newspaper";
	/** The hit value of the zombie */
	private final static int NEWSPAPER_HIT = 1;
	/** The hit threshold of the zombie */
	private final static int NEWSPAPER_THRESHOLD = 20;

	private boolean holdingNewspaper;

	public NewspaperZombie(int yPos) {
		super(newspaperSpeed,NEWSPAPER_HIT,NEWSPAPER_THRESHOLD,NEWSPAPER_NAME);
		this.setType("Newspaper");
		this.setYPos(yPos);
	}
	
	public void setNewspaper(boolean b) {
		holdingNewspaper = b;
	}
	
	public boolean hasNewspaper() {
		return holdingNewspaper;
	}
	
	public void setSpeed(int speed) {
		newspaperSpeed = speed;
	}

}

