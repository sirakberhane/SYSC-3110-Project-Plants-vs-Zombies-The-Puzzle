package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import junit.framework.TestCase;
import player.Player;
import run.Level;

public class PeashooterTest extends TestCase{

	private Player pl;
	private Level l;
	private ArrayList<Integer> lst = new ArrayList<>();
	private int a=5;
	
	public void setUp() throws Exception{
		lst.add(a);
		l  =new Level(lst);
		pl = new Player(l);
		//sf = new Sunflower(1,1);
		l.addPlant("peashooter", 1, 1);
		l.addZombie("zombie", 1);
	}
	
	public void testShootPea(){
		l.plantAction();
		assertEquals(8, l.getLawns(1).getZombies().get(0).getHitThreshold());
	}
}