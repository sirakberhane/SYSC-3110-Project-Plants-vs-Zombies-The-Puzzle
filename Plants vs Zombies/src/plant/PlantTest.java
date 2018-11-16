package plant;

import static org.junit.Assert.*;

import org.junit.Test;

public class PlantTest {

private Plant pl;
	
	
	public void setUp() throws Exception{

		pl = new Plant(5,50,1,1);
	}
	
	public void testPlant(){
		assertNotNull(pl);
	}
	public void testPlantCost(){
		assertEquals(10,pl.getBuyThreshold());
	}
	public void testPlantHit(){
		assertEquals(3,pl.getHitThreshold());
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

