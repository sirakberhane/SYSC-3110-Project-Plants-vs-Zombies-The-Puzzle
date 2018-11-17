package run;

/**
 * @author Jolar Tabungar
 * 
 * GameGUI class
 * 
 * The view for the level class.
 * 
 */
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import plant.Peashooter;
import plant.Plant;
import plant.Sunflower;
import zombie.Zombie;

public class GameGUI {
	
	//Reference to the level
	private Level level;
	
	//GUI Components
    private JFrame frame;
    private JPanel lawnMowers[];
    private JPanel lawnTiles[][];
    
    //Skip Turn button
    private JButton skipTurn;
    
    private JPanel sunflowerSelect;
    private JPanel peashooterSelect;
    private JPanel shovelSelect;
    
    //Labels for showing the level's current stats
    private JLabel waveNumber;
    private JLabel zombiesRemaining;
    private JLabel availableSun;
    
    //Image Buffers for the various images used
    private BufferedImage lawnMowerImage;
    private BufferedImage zombieImage;
    private BufferedImage sunflowerImage;
    private BufferedImage sunflowerLargeImage;
    private BufferedImage peashooterImage;
    private BufferedImage peashooterLargeImage;
    private BufferedImage shovelImage;
    
    //Label to contain each lawn's respective image buffer
    private JLabel lawnMowerSprite[];
    
    //References to Borders
    private Border raisedbevel;
    private Border loweredbevel;
    
    //Flags to determine which select option is set
    private boolean sunflowerSelected;
    private boolean peashooterSelected;
    private boolean shovelSelected;
    
    //Construct a new GameGUI
	public GameGUI() {
		//Initialize the wave sizes for the level
		ArrayList<Integer> waveSizes = new ArrayList<Integer>();
		waveSizes.add(5);
		waveSizes.add(15);
		waveSizes.add(40);
		
		//Create a new level with a reference to this GameGUI
		level = new Level(waveSizes, this);
		
		//Initialize JComponenets
		lawnMowers = new JPanel[5];
		lawnTiles = new JPanel[9][5];
		lawnMowerSprite = new JLabel[5];
		
		//Read Image Files for the Image Buffers
		try {
			lawnMowerImage = ImageIO.read(new File("images/lawnmower.png"));
			zombieImage = ImageIO.read(new File("images/zombie.png"));
			sunflowerImage = ImageIO.read(new File("images/sunflower.png"));
			sunflowerLargeImage = ImageIO.read(new File("images/sunflowerLarge.png"));
			peashooterImage = ImageIO.read(new File("images/peashooter.png"));
			peashooterLargeImage = ImageIO.read(new File("images/peashooterLarge.png"));
			shovelImage = ImageIO.read(new File("images/shovel.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Initialize Borders
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		
		//Set Default select option for planting sunflower
		sunflowerSelected = true;
		peashooterSelected = false;
		shovelSelected = false;
		
		//Initialize level stats labels
		waveNumber = new JLabel("Wave Number: ");
		zombiesRemaining = new JLabel("Zombies Remaining: ");
		availableSun = new JLabel("Available Sun: ");
	
		//Create the GUI, populate the board and update the labels with the initial stats
		createGUI();
		populateBoard();
		updateStats();
	}
	
	/**
	 * Initializes all the JComponents and creates the GUI
	 */
	public void createGUI() {
		//Create frame and content pane
        frame = new JFrame("Plants vs Zombies: The Puzzle");
        Container contentPane = frame.getContentPane();
       
        //Set contentPane to BorderLayout
        contentPane.setLayout(new BorderLayout());
        
        //Create the JPanel for the board
        JPanel board = new JPanel();
        board.setLayout(new GridBagLayout());
        
        
        for (int i = 0; i < 9; i ++) {
        	for (int j = 0; j < 5; j ++) {
        		
        	//Create a new constraint for each tile
        	GridBagConstraints c = new GridBagConstraints();
       
        	c.weightx = 0.5;
        	c.weighty = 1;
        	c.fill = GridBagConstraints.BOTH;
        	c.gridx = i;
        	c.gridy = j;
        	
        	//Create the JPanel for each tile
        	lawnTiles[i][j] = new JPanel();
        	//Add the MouseListener to each tile so that it responds when clicked
        	lawnTiles[i][j].addMouseListener(new TileController(this, level, i, j));
        	//Set the same size for each tile
    		lawnTiles[i][j].setPreferredSize(new Dimension(100, 100)); 
    		//Create a line border for each tile so that they can be easily seen
        	lawnTiles[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
        	//Add the tile to the board
        	board.add(lawnTiles[i][j], c);
       
        	}
        	
        }
        
        //Create a JPanel to contain the lawnmowers
        JPanel lawnMowerCol = new JPanel();
        lawnMowerCol.setLayout(new GridBagLayout());
        
        for (int j = 0; j < 5; j ++) {
        	//Create a grid bag constraint
        	GridBagConstraints c = new GridBagConstraints();
        	c.weightx = 0.5;
        	c.weighty = 1;
        	c.fill = GridBagConstraints.BOTH;
        	c.gridx = 0;
        	c.gridy = j;
        	
        	//Create a new JPanel for the row's lawn mower
        	lawnMowers[j] = new JPanel();
        	
        	//Create an Image for the lawn mower and add it to the JPanel
        	lawnMowerSprite[j] = new JLabel(new ImageIcon(lawnMowerImage));
        	lawnMowers[j].setPreferredSize(new Dimension(100, 100)); 
        	lawnMowers[j].add(lawnMowerSprite[j]);
        	
        	//Add the JPanel to the Containing JPanel
        	lawnMowerCol.add(lawnMowers[j], c);
        }
        
        //Create a JPanel for the hud (heads up display), the select options for placement/removal
        JPanel hud = new JPanel();
        hud.setLayout(new GridBagLayout());
        
        //Create a new constraint
        GridBagConstraints c = new GridBagConstraints();
        
        c.weightx = 0.5;
    	c.fill = GridBagConstraints.BOTH;
    	c.gridwidth = 2;
    	c.gridx = 0;
    	c.gridy = 0;
    	  
    	//Create the JPanel for the sunflower select option
    	sunflowerSelect = new JPanel();
    	//Add a MouseListener so that it does an action when clicked
    	sunflowerSelect.addMouseListener(new SunflowerSelectController(this, level));
    	sunflowerSelect.setPreferredSize(new Dimension(100, 100));
    	//Set border to lowered bevel, as it is the default option
    	sunflowerSelect.setBorder(loweredbevel);
    	//Add the image to the JPanel
    	sunflowerSelect.add(new JLabel(new ImageIcon(sunflowerLargeImage)));
    	
    	//Add the JPanel to the containing hud
    	hud.add(sunflowerSelect, c);
    	
    	//Update the constraint, reuse it for the other options just change the grid y value
    	c.gridy = 1;
     	
    	//Create the JPanel for the peashooter select option
     	peashooterSelect = new JPanel();
     	//Add a MouseListener so that it does an action when clicked
     	peashooterSelect.addMouseListener(new PeashooterSelectController(this));
     	peashooterSelect.setPreferredSize(new Dimension(100, 100));
     	//Set border to raised bevel
     	peashooterSelect.setBorder(raisedbevel);
     	//Add the image to the JPanel
     	peashooterSelect.add(new JLabel(new ImageIcon(peashooterLargeImage)));
     	
     	//Add the JPanel to the containing hud
     	hud.add(peashooterSelect, c);
     	
     	//Update the constraint, reuse it for the other options just change the grid y value
     	c.gridy = 2;
    
     	//Create the JPanel for the shovel select option
     	shovelSelect = new JPanel();
     	//Add a MouseListener so that it does an action when clicked
     	shovelSelect.addMouseListener(new ShovelSelectController(this));
     	shovelSelect.setPreferredSize(new Dimension(100, 100));
     	//Set border to raised bevel
     	shovelSelect.setBorder(raisedbevel);
     	//Add the image to the JPanel
     	shovelSelect.add(new JLabel(new ImageIcon(shovelImage)));
     	
     	//Add the JPanel to the containing hud
     	hud.add(shovelSelect, c);
     	
     	//Create a JPanel to contain the stats
     	JPanel levelStats = new JPanel();
     	//Set Layout for gridlayout with 1 x 3 grids
     	levelStats.setLayout(new GridLayout(1, 3));
     	//Add the JLabels to the JPanel
     	levelStats.add(waveNumber, 0, 0);
     	levelStats.add(zombiesRemaining, 0, 1);
     	levelStats.add(availableSun, 0 , 2);
 
     	//Create a JPanel for the board and the stats
     	JPanel boardAndStats = new JPanel();
     	//Layout is BoxLayout with Vertical Orientation
     	boardAndStats.setLayout(new BoxLayout(boardAndStats, BoxLayout.PAGE_AXIS));
     	//Add the level stats JPanel and the board JPanel
     	boardAndStats.add(levelStats);
     	boardAndStats.add(board);
     	
     	//Initialize the skip Jbutton
        skipTurn = new JButton("SKIP TURN");
        //Add the actionlistener
        skipTurn.addActionListener(new SkipTurnListener(this, level));
        
        
        //Add all the components to the contentPane
        contentPane.add(boardAndStats, BorderLayout.EAST);
        contentPane.add(lawnMowerCol, BorderLayout.CENTER);
        contentPane.add(hud, BorderLayout.WEST);
        contentPane.add(skipTurn, BorderLayout.SOUTH);
        
        
        //Pack the frame and its components and set it visible
        frame.pack();
        frame.setResizable(false);
        //frame.setSize(800, 800);
        frame.setLocation(100, 25);
        frame.setVisible(true);
	}
	
	/**
	 * Clear the board to repopulate with current state
	 */
	public void clearBoard() {
		for (int i = 0; i < 9; i ++) {
        	for (int j = 0; j < 5; j ++) {
        		lawnMowers[j].removeAll();
        		lawnMowers[j].revalidate();
        		lawnMowers[j].repaint();
        		
        		lawnTiles[i][j].removeAll();
        		lawnTiles[i][j].revalidate();
        		lawnTiles[i][j].repaint();
        	}
		}
	
	}
	
	/**
	 * Repopulate the board with current state of level
	 */
	public void populateBoard() {
        for (int j = 0; j < 5; j ++) {
        	//Add the remaining lawnmowers
        	if (!level.getLawn(j).isLawnMowerActivated()) {
        		lawnMowers[j].add(lawnMowerSprite[j]);
        		lawnMowers[j].revalidate();
        		lawnMowers[j].repaint();
        	}
        	//Add the plants
        	for (Plant plant: level.getLawn(j).getPlants())	{
        		if (plant instanceof Sunflower) {
        			addSunflower(plant.getxPos(), plant.getyPos());
        		}
        		else if (plant instanceof Peashooter) {
        			addPeashooter(plant.getxPos(), plant.getyPos());
        		}
        	}
        	//Add the zombies
        	for (Zombie zombie: level.getLawn(j).getZombies()) {
				addZombie((int) Math.round(zombie.getCurrentX()), zombie.getyPos());
			}
		}
        
		
	}
	
	/**
	 * Update the stat labels
	 */
	public void updateStats() {
		waveNumber.setText("Wave Number: " + level.currentWave());
		zombiesRemaining.setText("Zombies Remaining: " + level.zombieCount());
		availableSun.setText("Available Sun: " + level.getSunTotal());
	}
	
	/**
	 * Add a sunflower to the GUI at the tile (x, y)
	 * @param x the x position
	 * @param y the y position
	 */
	public void addSunflower(int x, int y) {
		lawnTiles[x][y].add(new JLabel(new ImageIcon(sunflowerImage)));
		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}
	
	/**
	 * Add a peashooter to the GUI at the tile (x, y)
	 * @param x the x position
	 * @param y the y position
	 */
	public void addPeashooter(int x, int y) {
		lawnTiles[x][y].add(new JLabel(new ImageIcon(peashooterImage)));
		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}
	
	/**
	 * Add a zombie to the GUI at the tile (x, y)
	 * @param x the x position
	 * @param y the y position
	 */
	public void addZombie(int x, int y) {
		lawnTiles[x][y].add(new JLabel(new ImageIcon(zombieImage)));
	}
	
	/**
	 * Selects the plantType Sunflower for placing
	 */
	public void selectSunflower() {
		sunflowerSelected = true;
		peashooterSelected = false;
		shovelSelected = false;
	}
	
	/**
	 * Return true if sunflower is selected for placing, false otherwise
	 * @return true if sunflower is selected for placing, false otherwise
	 */
	public boolean sunflowerSelected() {
		return sunflowerSelected;
	}
	
	/**
	 * Selects the plantType Peashooter for placing
	 */
	public void selectPeashooter() {
		sunflowerSelected = false;
		peashooterSelected = true;
		shovelSelected = false;
	}
	
	/**
	 * Return true if peashooter is selected for placing, false otherwise
	 * @return true if peashooter is selected for placing, false otherwise
	 */
	public boolean peashooterSelected() {
		return peashooterSelected;
	}
	
	/**
	 * Selects the shovel for removal
	 */
	public void selectShovel() {
		sunflowerSelected = false;
		peashooterSelected = false;
		shovelSelected = true;
	}
	
	/**
	 * Returns true if shovel is selected, false otherwise
	 * @return true if shovel is selected, false otherwise
	 */
	public boolean shovelSelected() {
		return shovelSelected;
	}
	
	/**
	 * Update the look of the HUD by applying the lowered bevel border to the selected
	 * option and applying the raised bevel border to the unselected options
	 */
	public void updateHUD() {
		if (sunflowerSelected) {
			sunflowerSelect.setBorder(loweredbevel);
			peashooterSelect.setBorder(raisedbevel);
			shovelSelect.setBorder(raisedbevel);
		}
		else if (peashooterSelected) {
			sunflowerSelect.setBorder(raisedbevel);
			peashooterSelect.setBorder(loweredbevel);
			shovelSelect.setBorder(raisedbevel);
		}
		else if (shovelSelected) {
			sunflowerSelect.setBorder(raisedbevel);
			peashooterSelect.setBorder(raisedbevel);
			shovelSelect.setBorder(loweredbevel);
		}
	}
	
	/**
	 * Show a message dialog for completing the level, and close the GUI
	 */
	public void winScreen() {
		JOptionPane.showMessageDialog(frame, "LEVEL COMPLETE!");
		System.exit(0);
	}
	
	/**
	 * Show a message for losing the level, and close the GUI
	 */
	public void loseScreen() {
		JOptionPane.showMessageDialog(frame, "GAME OVER!\nZOMBIES ATE YOUR BRAINS!");
		System.exit(0);
	}
	
	
	
	
	

	
}