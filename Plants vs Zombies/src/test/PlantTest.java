package test;
import junit.framework.TestCase;
import plant.Plant;

public class PlantTest extends TestCase{

private Plant pl;
	
	public void setUp() throws Exception{
		pl = new Plant(5,50,1,1);
	}
	
	public void testPlant(){
		assertNotNull(pl);
	}
	public void testPlantCost(){
		assertEquals(50,pl.getBuyThreshold());
	}
	public void testPlantHit(){
		assertEquals(5,pl.getHitThreshold());
	}
	public void setTestPlantHit(){
		pl.setHitThreshold(5);
		assertEquals(5,pl.getHitThreshold());
	}
	public void testXPos(){
		assertEquals(1,pl.getxPos());
	}
	public void testYPos(){
		assertEquals(1,pl.getyPos());
	}
}

