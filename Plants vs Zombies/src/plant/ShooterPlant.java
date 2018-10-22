package plant;

public class ShooterPlant extends Plant{

	private final int hitValue;
	public ShooterPlant(int hitThreshold, int buyThreshold, int hitValue) {
		super(10, 100);
		this.hitValue = hitValue;
	}
	
	public int getHitPoints() {
		return hitValue;
	}
}
