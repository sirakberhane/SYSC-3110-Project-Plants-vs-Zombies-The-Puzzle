package test;

import junit.framework.TestCase;
import plant.Peashooter;
import plant.Plant;

public class PeashooterTest extends TestCase{

	private Plant plant;
	
	public void setUp() throws Exception{
		plant = new Peashooter(0, 0);
	}
	
	// Test that  the position is being set properly
	public void testPeaShooterPosition(){
		assertEquals(0, plant.getxPos());
		assertEquals(0, plant.getyPos());
	}
	
	// Test that the peashooter's health is set to 10
	public void testPeaShooterHealth() {
		assertEquals(10, plant.getHitThreshold());
	}
	
	// Test that peashooter's buy threshold is set to 100
	public void testPeaShooterBuyThreshold() {
		assertEquals(100, plant.getBuyThreshold());
	}
}
