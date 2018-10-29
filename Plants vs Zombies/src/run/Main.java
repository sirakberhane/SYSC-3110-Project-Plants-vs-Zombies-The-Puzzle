package run;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Integer> waveSizes = new ArrayList<Integer>();
		waveSizes.add(5);
		waveSizes.add(10);
		waveSizes.add(15);
		
		Level level = new Level(waveSizes);
		level.NextTurn();
	}
}
