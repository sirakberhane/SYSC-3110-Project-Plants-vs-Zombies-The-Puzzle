package test;

import junit.framework.TestCase;
import plant.HypnoShroom;
import plant.PotatoMine;
import plant.SnowPeashooter;
import plant.Wallnut;

public class PlantTypeTest extends TestCase{
	public HypnoShroom hs;
	public PotatoMine pm;
	public SnowPeashooter sps;
	public Wallnut wn;

	public void setUp() throws Exception {
		hs = new HypnoShroom(0, 0);
		pm = new PotatoMine(0, 1);
		sps = new SnowPeashooter(0, 2);
		wn = new Wallnut(0,3);
	}

	public void testHypnoShroomPlantType() {
		// Check that the super class is initializing everything
		assertEquals(0, hs.getxPos());
		assertEquals(0, hs.getyPos());

		// Check that the plant is still alive
		assertFalse(hs.isPlantDead());
	}

	public void testPotatoMinePlantType() {
		// Check that the super class is initializing everything
		assertEquals(0, pm.getxPos());
		assertEquals(1, pm.getyPos());

		// Check that the plant is still alive
		assertFalse(pm.isPlantDead());
	}

	public void testSnowPeashooterPlantType() {
		// Check that the super class is initializing everything
		assertEquals(0, sps.getxPos());
		assertEquals(2, sps.getyPos());

		// Check that the plant is still alive
		assertFalse(sps.isPlantDead());
	}

	public void testWallnutPlantType() {
		// Check that the super class is initializing everything
		assertEquals(0, wn.getxPos());
		assertEquals(3, wn.getyPos());

		// Check that the plant is still alive
		assertFalse(wn.isPlantDead());
	}
}