package player;
import java.util.Scanner;
import run.Level;
import plant.*;

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
	
	private final String[] plantTypes = {"sunflower", "peashooter"};
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
	 * @throws InputException, InsufficientSunException 
	 */
	public void getPlayerAction() {
		printHelp();
						 
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
                
                //Check if valid plantType entered
                for (String type: plantTypes) {
    				if (!plantType.equals(type)) {
    					System.out.println("Invalid plantType entered: " + plantType);
    					getPlayerAction();
    				}
    			}
            }
            
            //Get the x coordinate of placement
            if (tokenizer.hasNext()) {
            	
            	xPos = Integer.parseInt(tokenizer.next());
            	yPos = Integer.parseInt(tokenizer.next());
            	
            	if (xPos > 4 || xPos < 0 || yPos > 8 || yPos < 0) {
            		System.out.println("Placement out of bounds.");
            		getPlayerAction();
            	}
            }
            
        }
		
		tokenizer.close();
		
		//Do appropriate action
		
		//If action was successful
		boolean successful = false;
		
		if (action.equals("place")) {
			
			//Only place plant if enough sun is available
			if (sunTotal >= Sunflower.SUNFLOWER_BUY_THRESHOLD) {
				successful = level.addPlant(plantType, xPos, yPos);
			}
			else {
				//If not enough, print error message and request new player action
				if (!successful) {
					System.out.println("Not enough sun available.");
				}
			}
		} 
		
		else if (action.equals("remove")) {
			successful = level.removePlant(xPos,yPos);
			
			if (!successful) {
				System.out.println("No plant at those coordinates");
			}
		}
		
		else if (action.equals("skip"));
		
		else if (action.equals("help")) 
			printHelp();
		
		else if (action.equals("types")) 
			printTypes();
		
		
		//Else, invalid input entered
		else {
			System.out.println(
					"Error in input:\n" +
					"	No such command as: " + input);
		}
		
		//If action was not successful, request another action from player
		if (!successful)
			getPlayerAction();
	}
	
	/**
	 * Prints the plant types the user can place
	 */
	public void printTypes() {
		System.out.println(
				"----------------------------------\n" +
				"Plant Types: " +
				"sunflower = " + Sunflower.SUNFLOWER_BUY_THRESHOLD + " sun" +
				"peashooter = " + Peashooter.PEASHOOTER_BUY_THRESHOLD + " sun" +
				"----------------------------------");
	}
	
	/**
	 * Prints the list of player commands
	 */
	public void printHelp() {
		System.out.println(
				"----------------------------------\n" +
				"Commands:\n" + 
				"place plantType x y\n" +
				"remove x y\n" +
				"skip\n" +
				"types\n" +
				"help\n" +
				"----------------------------------"
				);
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
