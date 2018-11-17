package test;

import junit.framework.TestCase;
import zombie.Zombie;

public class BasicZombieTest extends TestCase{

	// Zombie-Object
	private Zombie zombie;
	
	// Set up the test environments 
	public void setUp(){
		zombie = new Zombie(0.5, 2, 10, "Basic");
	}
	
	// Test the position of the Zombie
	public void testZombieSpeed() {
		assertEquals(0.5, zombie.getMovementSpeed());
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
	public void testZombieMovement() {
		assertEquals(true, zombie.isMoving());
	}
	
	// Test the zombie is not dead
	public void testZombieIsNotDead() {
		assertEquals(false, zombie.isDead());
	}
	
	// Test the zombie is health is zero when dead
	public void testZombieIsDead() {
		// Zombie is Dead
		zombie.setHitThreshold(0);
		
		// Check that the zombie is dead
		assertEquals(true, zombie.isDead());
	}
}
