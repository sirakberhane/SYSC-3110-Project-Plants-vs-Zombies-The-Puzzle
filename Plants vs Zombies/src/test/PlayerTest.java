package test;
import java.util.ArrayList;
import junit.framework.TestCase;
import player.Player;
import run.Level;

public class PlayerTest extends TestCase{
	private Level level;
	private Player player;
	private ArrayList<Integer> waves;
	
	public void setUp() throws Exception{
		waves = new ArrayList<Integer>();
		waves.add(new Integer(5));
		level = new Level(waves);
		player = new Player(level);
	}
	
	public void testPlayerSunTotalFunction() {
		// Check that the default sun is 100
		assertEquals(100, player.getSunTotal());
		
		// Set Sun Total to 200
		player.setSunTotal(200);
		
		// Check the new change
		assertEquals(200, player.getSunTotal());
	}
}
