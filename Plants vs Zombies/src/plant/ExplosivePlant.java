package plant;

public class ExplosivePlant extends Plant {
	private static final long serialVersionUID = -8861911867458144726L;
	private int explosionDamage;
	private boolean hasExploded;
	
	public ExplosivePlant(int hitThreshold, int buyThreshold, int x, int y, int explosionDamage) {
		super(hitThreshold, buyThreshold, x, y);
		this.explosionDamage = explosionDamage;
		hasExploded = false;
	}
	
	public int getExplosionDamage() {
		return explosionDamage;
	}
	
	public boolean hasExploded() {
		return hasExploded;
	}
	
	public void explode() {
		hasExploded = true;
	}
}