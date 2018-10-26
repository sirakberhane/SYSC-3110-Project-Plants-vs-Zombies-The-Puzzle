package run;
import java.util.ArrayList;
import plant.*;
import zombie.*;
import player.*;

public class Level {
	private ArrayList<Plant> plants;
	private ArrayList<Zombie> zombies;
	private Player player;
	private PrintState printState;
	public enum plant {sunflower, peashooter};
	public enum zombie {zombie};
	
	public Level() {
		plants = new ArrayList<Plant>();
		zombies = new ArrayList<Zombie>();
		player = new Player(this);
		printState = new PrintState(this, player);
	}
	
	public void addZombie() {
	}
	
	public boolean addPlant(String plantType, int x, int y) {
		Plant plant = null;
		
		if (plantType.equalsIgnoreCase("sunflower")) {
			plant = new Sunflower(x, y);
		}
		else if (plantType.equalsIgnoreCase("peashooter")) {
			plant = new Peashooter(x, y);
		}
		
		if (player.getSunTotal() >= plant.getBuyThreshold()) {
			plants.add(plant);
			player.setSunTotal(player.getSunTotal() - plant.getBuyThreshold());
			return true;
		}
			
		return false;
	}
	
	public boolean removePlant(int x, int y) {
		for (Plant plant: plants) {
			if (plant.getxPos() == x && plant.getyPos() == y) {
				plants.remove(plant);
				return true;
			}
		}
		return false;
	}
	
	public void NextTurn() {
		player.getPlayerAction();
		printState.updateState(plants);
		printState.print();
	}
}
