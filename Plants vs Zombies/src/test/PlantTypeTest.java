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

	}

	public void testPotatoMinePlantType() {

	}

	public void testSnowPeashooterPlantType() {

	}

	public void testWallnutPlantType() {

	}
}
