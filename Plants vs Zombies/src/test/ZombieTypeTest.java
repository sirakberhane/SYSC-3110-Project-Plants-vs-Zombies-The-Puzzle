package test;

import junit.framework.TestCase;
import zombie.BucketZombie;
import zombie.FootballZombie;
import zombie.Gargantuar;
import zombie.NewspaperZombie;
import zombie.Zombie.Type;

public class ZombieTypeTest extends TestCase{
	public BucketZombie bz;
	public FootballZombie fb;
	public Gargantuar g;
	public NewspaperZombie npz;

	Type type;

	public void setUp() throws Exception {
		bz = new BucketZombie(0);
		fb = new FootballZombie(0);
		g = new Gargantuar(0);
		npz = new NewspaperZombie(0);
	}

	@SuppressWarnings("static-access")
	public void testBucketZombieType() {
		// Check the type of the zombie
		type = bz.getType();
		assertEquals("BUCKET", type.BUCKET.toString());

		// Check that the zombie's bucket is off
		bz.setBucket(false);
		assertFalse(bz.isBucketOn());

		// Check that the zombie's bucket is on
		bz.setBucket(true);
		assertTrue(bz.isBucketOn());

		// Check other bucket zombie stats
		assertEquals(0, bz.getyPos());

		// Get HP
		bz.setHitThreshold(10);
		assertEquals(10, bz.getHitThreshold());
	}

	@SuppressWarnings("static-access")
	public void testFootballZombieType() {
		// Check the type of the zombie
		type = fb.getType();
		assertEquals("FOOTBALL", type.FOOTBALL.toString());

		// Check the y-position
		assertEquals(0, fb.getyPos());

		// Check that the foootball zombie's helmet is knocked off by plants
		fb.setHelmet(false);
		assertFalse(fb.isHelmetOn());

		fb.setHelmet(true);
		assertTrue(fb.isHelmetOn());

		// Check zombie stats
		assertEquals(false, fb.isHypnotized());

		// Get HP
		fb.setHitThreshold(10);
		assertEquals(10, fb.getHitThreshold());
	}

	@SuppressWarnings("static-access")
	public void testGargantuarType() {
		// Check the type of the zombie
		type = g.getType();
		assertEquals("GARGANTUAR", type.GARGANTUAR.toString());
		
		// Check if the new zombie is alive
		assertFalse(g.isDead());

		// Get HP
		g.setHitThreshold(10);
		assertEquals(10, g.getHitThreshold());
	}

	@SuppressWarnings("static-access")
	public void testNewspaperZombieType() {
		// Check the type of the zombie
		type = npz.getType();
		assertEquals("NEWSPAPER", type.NEWSPAPER.toString());

		// Check if the zombie is alive or not
		assertFalse(npz.isDead());
		
		// Get HP
		npz.setHitThreshold(10);
		assertEquals(10, npz.getHitThreshold());
	}
}