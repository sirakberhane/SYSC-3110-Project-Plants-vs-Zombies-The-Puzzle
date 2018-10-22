package plant;
public class Plant {
	
	private final int buyThreshold;
	private int hitThreshold;
	
	public Plant(int hitThreshold, int buyThreshold) {
		this.buyThreshold = buyThreshold;
		this.hitThreshold = hitThreshold;
	}

	public int getBuyThreshold() {
		return buyThreshold;
	}

	public int getHitThreshold() {
		return hitThreshold;
	}

	public void setHitThreshold(int currentHP) {
		this.hitThreshold = currentHP;
	}
	
	public boolean isPlantDead() {
		if (getHitThreshold() == 0) {
			return true;
		} else {
			return false;
		}
	}
}