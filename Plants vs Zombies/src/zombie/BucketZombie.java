package zombie;
/**
 * This zombie has a higher hit threshold than the basic zombie but it has the 
 * same stats as the basic zombie.
 * @author Ryan Tordesillas (101041626)
 *
 */
public class BucketZombie extends Zombie{

	/** The speed of the zombie */
	private final static double BUCKET_SPEED = 0.5;
	/** The name of the zombie */
	private final static String BUCKET_NAME = "Bucket";
	/** The hit value of the zombie */
	private final static int BUCKET_HIT = 1;
	/** The hit threshold of the zombie */
	private final static int BUCKET_THRESHOLD = 15;
	/** The boolean that determines if the bucket is on the zombie. */
	private boolean bucketOn;
	
	/**
	 * The constructor for the BucketZombie.
	 * @param yPos the row that the zombie will spawn in.
	 */
	public BucketZombie(int yPos) {
		super(BUCKET_SPEED,BUCKET_HIT,BUCKET_THRESHOLD,BUCKET_NAME);
		this.setType(BUCKET_NAME);
		this.setYPos(yPos);
		bucketOn = true;
	}
	
	/**
	 * This method will set whether the bucket is on the zombie
	 * or not.
	 * @param b a boolean that determines if the bucket is still on the zombie.
	 */
	public void setBucket(boolean b) {
		bucketOn = b;
	}
	
	/**
	 * Returns a boolean depending on whether or not the bucket is on the zombie.
	 * @return true if bucket is on zombie, false otherwise
	 */
	public boolean isBucketOn() {
		return bucketOn;
	}

}
