package test;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import junit.framework.TestCase;
import plant.Peashooter;
import plant.Plant;
import run.Level;

public class PeashooterTest extends TestCase{

	private Plant plant;
	
	public void setUp() throws Exception{
		plant = new Peashooter(0, 0);
	}
	
	public void testShootPeaPosition(){
		assertEquals(0, plant.getxPos());
		assertEquals(0, plant.getyPos());
	}
}
