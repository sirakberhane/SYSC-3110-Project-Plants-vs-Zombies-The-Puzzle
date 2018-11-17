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
	//Countdown till player generates sun
	private int generateSunCountdown;
	
	//Sun generation amount
	public static final int PLAYER_GENERATED_SUN_AMOUNT = 25;
	//Sun generation countdown length
	public static final int SUN_GENERATION_COUNTDOWN_LENGTH = 4;
	
	private final String[] plantTypes = {"sunflower", "peashooter"};
	private final String[] actions = {"place", "remove", "help", "types", "skip"};
	
	/**
	 * Constructs a player with the given level
	 * @param level
	 */
	public Player(Level level) {
		//Set this player to the level that created it
		this.level = level;
		
		//Starting suntotal
		sunTotal = 100; 
		
		//Start countdown to sun generation
		generateSunCountdown = SUN_GENERATION_COUNTDOWN_LENGTH;
		
		//Initialize the reader for user input
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
		
		//If action was successful
		boolean successful = false;
		
		//Break up the input into parts
		Scanner tokenizer = new Scanner(input);
		
		if (tokenizer.hasNext()) {
			//Read the first word, the action word
            action = tokenizer.next();      
            
            //Check if action is valid
            for (String aAction: actions) {
            	if(aAction.equals(action)) {
            		successful = true;
            	}
            }
            if (!successful) {
            	System.out.println("Invalid action entered: " + action);
            }
            
            //More input required for place and remove
            if (action.equals("place") || action.equals("remove")) {
            	
            	//If action is place
            	if(tokenizer.hasNext() && action.equals("place")) {
            		//Get the plant type to be placed
            		plantType = tokenizer.next();    
                
            		//Reset our successful for next check
            		successful = false;
            		//Check if valid plantType entered
            		for (String type: plantTypes) {
            			if (plantType.equalsIgnoreCase(type)) {
            				successful = true;
            			}
            		}
            		if (!successful) {
            			System.out.println("Invalid plantType entered: " + plantType);
            		}
            	}	
            
            	//Get the x coordinate of placement/removal
            	if (tokenizer.hasNext() && successful) {
            	
            		xPos = Integer.parseInt(tokenizer.next());
            		
            		//Reset our successful for next check
            		successful = false;
            		
            		//Check if xPos is within bounds
            		if (xPos <= Level.X_MAX && xPos >= Level.X_MIN) {
            			successful = true;
            		}
            		if (!successful) 
            			System.out.println("Placement out of bounds.");
            	
            		//Get y coordinate of placement/removal
            		if (tokenizer.hasNext() && successful) {	
            			yPos = Integer.parseInt(tokenizer.next());
            			//Reset our successful for next check
            			
            			successful = false;
            			
            			//Check if yPos is within bounds
                 		if (yPos <= Level.Y_MAX && yPos >= Level.Y_MIN) {
                 			successful = true;
                 		}
                 		if (!successful) 
                 			System.out.println("Placement out of bounds.");
                 	
                	}
            		else if (!tokenizer.hasNext()) {
            			System.out.println("Missing y coordinate");
            			successful = false;
            		}
                 
            	}
            	else if (!tokenizer.hasNext()) {
            		System.out.println("Missing x and y coordinates.");
            		successful = false;
            	}
            	
            	//We aren't expecting anymore input past this point
            	if (tokenizer.hasNext() && successful)
            		successful = false;
            
            }
		}
		
		tokenizer.close();
		
		//Accept if there was no input (User hit enter), will just skip the turn
		if (input.equals("")) {
			successful = true;
			action = "skip";
		}
		
		//Do appropriate action
		if (successful) {
			if (action.equals("place")) {
			
				//Only place plant if enough sun is available
				if (sunTotal >= Sunflower.SUNFLOWER_BUY_THRESHOLD) {
					successful = level.addPlant(xPos, yPos);
					if (!successful)
						System.out.println("You cannot plant that.");
				}
				else {
					//If not enough, print error message and request new player action
					System.out.println("Not enough sun available.");
					successful = false;
				}
			} 
		
			else if (action.equals("remove")) {
				successful = level.removePlant(xPos,yPos);
			
				if (!successful) {
					System.out.println("No plant at those coordinates");
				}
			}
		
			else if (action.equals("skip"));
		
			else if (action.equals("help")) {
				printHelp();
				getPlayerAction();
			}
		
			else if (action.equals("types")) {
				printTypes();
				getPlayerAction();
			}
		}
			
		//If action was not successful, request another action from player
		if (!successful) {
			System.out.println("ERROR. Try another command.");
			getPlayerAction();
		}
	}
	/**
	 * Prints the plant types the user can place
	 */
	public void printTypes() {
		System.out.println(
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
				"PLANT TYPES: \n" +
				"- sunflower = " + Sunflower.SUNFLOWER_BUY_THRESHOLD + " sun\n" +
				"- peashooter = " + Peashooter.PEASHOOTER_BUY_THRESHOLD + " sun\n" +
				"-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	
	/**
	 * Prints the list of player commands
	 */
	public void printHelp() {
		System.out.println(		
						"-------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" +
						"COMMANDS:\n" + 
						"- place plantType x y		Place a plant of plantType at the tile (x, y)\n" +
						"- remove x y			Removes the plant at the tile (x, y)\n" +
						"- skip 				Skips the turn\n" +
						"- types 			Prints the list of valid plantTypes\n" +
						"- help 				Prints the list of valid commands\n\n" +
						"** Bounds: 0 <= x <= 8, 0 <= y <= 4\n" +
						"-------------------------------------------------------------------------------------------------------------------------------------------------------------------"
				);
	}
	
	/**
	 * @return the current suntotal of player
	 */
	public int getSunTotal() {
		return sunTotal;
	}
	
	/**
	 * Generate sun for the player when countdown is up
	 */
	public void gameGenerateSun() {
		//Decrement countdown
		countDownToGenerateSun();
		
		//If countdown is over, generate sun
		if (generateSunCountdown == 0) {
			generateSunCountdown = SUN_GENERATION_COUNTDOWN_LENGTH;
			setSunTotal(getSunTotal() + PLAYER_GENERATED_SUN_AMOUNT);
		} 
	}
	
	/**
	 * Decrement the sun generation countdown
	 */
	private void countDownToGenerateSun() {
		generateSunCountdown --;
	}

	/**
	 * Sets the suntotal of the player
	 * @param newtotal the new suntotal of the player
	 */
	public void setSunTotal(int newtotal) {
		sunTotal = newtotal;
	}
}