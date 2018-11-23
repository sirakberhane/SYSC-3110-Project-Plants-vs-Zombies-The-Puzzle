package zombie;
/**
 * This zombie has a higher 
 * @author rtord
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
	
	private boolean bucketOn;
	
	public BucketZombie(int yPos) {
		super(BUCKET_SPEED,BUCKET_HIT,BUCKET_THRESHOLD,BUCKET_NAME);
		this.setType("Bucket");
		this.setYPos(yPos);
		bucketOn = true;
	}
	
	public void setBucket(boolean b) {
		bucketOn = b;
	}
	
	public boolean isBucketOn() {
		return bucketOn;
	}

}
