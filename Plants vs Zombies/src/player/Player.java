package player;
import java.util.Scanner;
import run.Level;

/** 
 * @author Jolar Tabungar
 * 
 *  Player class is responsible for all player input and actions
 *
 */
public class Player {
	
	//The player's suntotal
	private int sunTotal;
	//The player's level
	private Level level;
	//Reads the player input
	private Scanner reader;
	
	/**
	 * Constructs a player with the given level
	 * @param level
	 */
	public Player(Level level) {
		this.level = level;
		//Starting suntotal
		sunTotal = 100; 
		reader = new Scanner(System.in);
	}
	
	/**
	 * Requests the users input for his/her move
	 * Ex. > place sunflower 2 3; places a sunflower at (2, 3) if enough sun is available
	 * 	   > remove 2 3; removes plant at 2 3
	 */
	public void getPlayerAction() {
		System.out.print("> ");
		String input = reader.nextLine();
		
		String action = null;
		String plantType = null;
		int xPos = 0;
		int yPos = 0;
		
		//Break up the input into parts
		Scanner tokenizer = new Scanner(input);
		
		if (tokenizer.hasNext()) {
			//Read the first word, the action word
            action = tokenizer.next();      
            //If action is place
            if(tokenizer.hasNext() && action.equals("place")) {
            	//Get the plant type to be placed
                plantType = tokenizer.next();    
            }
     
            //Get the x and y coordinates of placement
            xPos = Integer.parseInt(tokenizer.next());
            yPos = Integer.parseInt(tokenizer.next());
            
        }
		
		//If action is place, tell level to add the plant
		if (action.equals("place")) {
			//If placement was successful, then nothing else happens
			if (level.addPlant(plantType, xPos, yPos));
			//Else, not enough sun message is printed
			else {
				System.out.println("Not enough sun.");
				getPlayerAction();
			}
		}
		//Else, action is remove, so remove the plant
		else {
			level.removePlant(xPos,yPos);
		}
		tokenizer.close();
	}
	
	/**
	 * @return the current suntotal of player
	 */
	public int getSunTotal() {
		return sunTotal;
	}
	
	/**
	 * Sets the suntotal of the player
	 * @param newtotal the new suntotal of the player
	 */
	public void setSunTotal(int newtotal) {
		sunTotal = newtotal;
	}
}
