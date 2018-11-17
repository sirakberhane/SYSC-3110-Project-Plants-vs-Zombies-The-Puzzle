package test;

import junit.framework.TestCase;
import zombie.Zombie;

public class BasicZombieTest extends TestCase{

	private Zombie zombie;
	
	// Set up the test environments 
	public void setUp(){
		zombie = new Zombie(0.5, 2, 10, "Basic");
	}
	
	// Test the position of the Zombie
	public void testZombiesSpeed() {
		assertEquals(0.5, zombie.getMovementSpeed());
	}
	
	// Test that the zombie's Attack is the 
	// same as the BasicZombie type 
	public void testZombiesAttack() {
		assertEquals(2, zombie.getHitThreshold());
	}
	
	// Test that the BasicZombie has a "Basic" tag
	public void testZombiesType() {
		assertEquals("Basic", zombie.getName());
	}
	
	// Test that the zombie is moving
}
