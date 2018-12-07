package zombie;
/**
 * This zombie has a higher hit threshold, same hit as the basic zombie and same speed as the basic zombie.
 * When it loses its newspaper it's speed increases.
 * @author Ryan Tordesillas (101041626)
 *
 */
public class NewspaperZombie extends Zombie{
	private static final long serialVersionUID = 1852841735862189615L;
	/** The speed of the zombie */
	private static double newspaperSpeed = 0.5;
	/** The name of the zombie */
	private final static String NEWSPAPER_NAME = "Newspaper";
	/** The hit value of the zombie */
	private final static int NEWSPAPER_HIT = 1;
	/** The hit threshold of the zombie */
	private final static int NEWSPAPER_THRESHOLD = 20;
	
	/** The new speed of the zombie when it loses its newspaper */
	private final static double NEWSPAPER_NEWSPEED = 1.5;
	
	/** The boolean the determines if the zombie is holding the NewsPaper */
	private boolean holdingNewspaper;

	/**
	 * The constructor for the NewspaperZombie.
	 * @param yPos the row that the zombie spawns in.
	 */
	public NewspaperZombie(int yPos) {
		super(newspaperSpeed,NEWSPAPER_HIT,NEWSPAPER_THRESHOLD,NEWSPAPER_NAME);
		this.setType("Newspaper");
		this.setYPos(yPos);
	}
	
	/**
	 * Thie method will set the zombie holding the newspaper or not.
	 * @param b true if to set zombie holding newspaper, false if the zombie is not holding the zombie.
	 */
	public void setNewspaper(boolean b) {
		holdingNewspaper = b;
	}
	
	/**
	 * Returns true if the zombie is holding the newspaper, false otherwise.
	 * @return true if the zombie is holding the newspaper, false otherwise.
	 */
	public boolean hasNewspaper() {
		return holdingNewspaper;
	}
	
	/**
	 * This method will set a new speed when the zombie loses its newspaper.
	 */
	public void lostNewspaper() {
		newspaperSpeed = NEWSPAPER_NEWSPEED;
	}

}

