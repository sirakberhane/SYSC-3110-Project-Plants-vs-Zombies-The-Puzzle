package plant;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import player.Player;
import run.Level;

public class SunflowerTest {

	//private Sunflower sf;
	private Player pl;
	private Level l;
	private ArrayList<Integer> lst = new ArrayList<>();
	private int a=5;
	
	public void setUp() throws Exception{
		lst.add(a);
		l  =new Level(lst);
		pl = new Player(l);
		//sf = new Sunflower(1,1);
		l.addPlant("sunflower", 1, 1);
	}
	
	/**
	 * tests if the correct amount of sun points were added
	 */
	public void generateSunTest(){
		l.plantAction();
		l.plantAction();
		assertEquals(100, pl.getSunTotal());
	}
	
	
	
	

}
