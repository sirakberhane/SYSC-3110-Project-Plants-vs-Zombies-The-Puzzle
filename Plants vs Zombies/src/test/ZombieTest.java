package test;

import junit.framework.TestCase;
import zombie.BasicZombie;
import zombie.Zombie;

class ZombieTest extends TestCase{
	private Zombie zombie;
	
	public void setUp() throws Exception{
		zombie = new BasicZombie(0);
	}
	
	public void testGetMethodsInZombies() {
		assertEquals(0, zombie.getCurrentX());
	}
	
	

}
