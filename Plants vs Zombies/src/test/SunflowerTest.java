package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import junit.framework.TestCase;
import run.Level;

public class SunflowerTest extends TestCase{

	private Level l;
	private ArrayList<Integer> lst = new ArrayList<>();
	private int a=5;
	
	public void setUp() throws Exception{
		lst.add(a);
		l = new Level(lst, null);
		l.addPlant(1, 1);
	}
	
	/**
	 * Tests if the correct amount of sun points were added
	 */
	public void testGenerateSunTest(){
		l.plantAction();
		l.plantAction();
		assertEquals(125, l.getSunTotal());
	}
}
