package plant;
public class Sunflower extends PassivePlant{

	public Sunflower(int hitThreshold, int buyThreshold) {
		super(5, 25);
	}
	
	public int generateSunflower() {
		return 25;
	}
}
