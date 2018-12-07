package run;

public class GameData {
	
	//Flags to determine which select option is set
    private boolean sunflowerSelected;
    private boolean peashooterSelected;
    private boolean shovelSelected;
    private boolean snowpeashooterSelected;
    private boolean potatomineSelected;
    private boolean hypnoshroomSelected;
    private boolean wallnutSelected;
    
    public GameData(boolean sun, boolean pea, boolean shovel, boolean snow, boolean potato, boolean hypno, boolean wall) {
    	sunflowerSelected = sun;
    	peashooterSelected = pea;
    	shovelSelected = shovel;
    	snowpeashooterSelected = snow;
    	potatomineSelected = potato;
    	hypnoshroomSelected = hypno;
    	wallnutSelected = wall;
    }
    
    public void callWinScreen() {
    	
    }
}
