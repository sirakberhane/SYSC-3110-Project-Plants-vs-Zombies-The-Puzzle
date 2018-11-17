package test;

import junit.framework.TestCase;
import zombie.BasicZombie;
import zombie.Zombie;

public class BasicZombieTest extends TestCase{

	private Zombie zombie;
	
	// Set up the test environments 
	public void setup() throws Exception{
		zombie = new Zombie(0.5, 2, 10, "Basic");
	}
	
	// Test the position of the Zombie
	public void testZombiesPosition() {
		assertEquals(0, zombie.getyPos());
	}
	
	// Test that the zombie's Attack is the 
	// same as the BasicZombie type 
	public void testZombiesAttack() {
		assertEquals(10, zombie.getHitThreshold());
	}
	
	// Test that the BasicZombie has a "Basic" tag
	public void testZombiesType() {
		assertEquals("Basic", zombie.getName());
	}
	
	// Test that the zombie is moving
}
