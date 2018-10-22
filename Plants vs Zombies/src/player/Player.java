package player;
import java.util.Scanner;

import run.Level;
import run.Level.plant;

public class Player {
	
	private int sunTotal;
	private Level level;
	private Scanner reader;
	
	public Player(Level level) {
		this.level = level;
		sunTotal = 100;
		reader = new Scanner(System.in);
	}
	
	public void getPlayerAction() {
		System.out.print("> ");
		String input = reader.nextLine();
		
		String action = null;
		String plantType = null;
		int xPos = 0;
		int yPos = 0;
		
		Scanner tokenizer = new Scanner(input);
		
		if (tokenizer.hasNext()) {
            action = tokenizer.next();      
            if(tokenizer.hasNext() && action.equals("place")) {
                plantType = tokenizer.next();    
            }
     
            xPos = Integer.parseInt(tokenizer.next());
            yPos = Integer.parseInt(tokenizer.next());
            
        }
		
		if (action.equals("place")) {
			if (level.addPlant(plantType, xPos, yPos)) {
				
			}
			else {
				System.out.println("Not enough sun.");
				getPlayerAction();
			}
		}
		else {
			level.removePlant(xPos,yPos);
		}
		
	}
	
	
	public int getSunTotal() {
		return sunTotal;
	}
	
	public void setSunTotal(int newtotal) {
		sunTotal = newtotal;
	}

}
