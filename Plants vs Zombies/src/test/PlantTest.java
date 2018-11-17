package test;
import junit.framework.TestCase;
import plant.Plant;

public class PlantTest extends TestCase{

	private Plant pl;

	public void setUp() throws Exception{
		pl = new Plant(5,50,1,1);
	}
	
	// Test that the plant is not set to null
	public void testPlant(){
		assertNotNull(pl);
	}
	
	// Test that the plant's cost is 50 
	public void testPlantCost(){
		assertEquals(50,pl.getBuyThreshold());
	}
	
	// Test that the pant hit value is set to 5
	public void testPlantHit(){
		assertEquals(5,pl.getHitThreshold());
	}
	
	// Test that the set Plant hit is working
	public void testSetPlantHit(){
		pl.setHitThreshold(2);
		assertEquals(2,pl.getHitThreshold());
	}
	
	// Test that the x-position is working
	public void testXPos(){
		assertEquals(1,pl.getxPos());
	}
	
	// Test that the y-position is working 
	public void testYPos(){
		assertEquals(1,pl.getyPos());
	}
}

