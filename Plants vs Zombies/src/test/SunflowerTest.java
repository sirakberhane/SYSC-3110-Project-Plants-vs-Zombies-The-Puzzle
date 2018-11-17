package test;

import junit.framework.TestCase;
import plant.Plant;
import plant.Sunflower;

public class SunflowerTest extends TestCase{
	private Plant plant;
	
	public void setUp() throws Exception{
		plant = new Sunflower(0,0);
	}
	
	// Test the sunflower's position
	public void testSunflowerPosition() {
		assertEquals(0, plant.getxPos());
		assertEquals(0, plant.getyPos());
	}
	
	// Tests if the correct amount of sun points were added
	public void testGenerateSun(){
		((Sunflower) plant).generateSun();
		((Sunflower) plant).generateSun();
		assertEquals(50, plant.getBuyThreshold());
	}
}
