package test;

import junit.framework.TestCase;
import zombie.BucketZombie;
import zombie.FootballZombie;
import zombie.Gargantuar;
import zombie.NewspaperZombie;

public class ZombieTypeTest extends TestCase{
	public BucketZombie bz;
	public FootballZombie fb;
	public Gargantuar g;
	public NewspaperZombie npz;

	public void setUp() throws Exception {
		bz = new BucketZombie(0);
		fb = new FootballZombie(0);
		g = new Gargantuar(0);
		npz = new NewspaperZombie(0);
	}

	public void testBucketZombieType() {

	}

	public void testFootballZombieType() {

	}

	public void testGargantuarType() {

	}

	public void testNewspaperZombieType() {

	}
}