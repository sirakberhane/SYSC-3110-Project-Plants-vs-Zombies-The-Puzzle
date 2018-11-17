package run;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JTextField;
import javax.swing.border.Border;

import plant.Peashooter;
import plant.Plant;
import plant.Sunflower;
import zombie.Zombie;

public class GameGUI {
	
	private Level level;
	
    private JFrame frame;
    private JPanel lawnMowers[];
    private JPanel lawnTiles[][];
    
    private BufferedImage lawnMowerImage;
    private BufferedImage zombieImage;
    private BufferedImage sunflowerImage;
    private BufferedImage peashooterImage;
    private BufferedImage shovelImage;
    
    private JLabel lawnMowerSprite[];
    
    private Border raisedbevel;
    private Border loweredbevel;
    
    private boolean sunflowerSelected;
    private boolean peashooterSelected;
    private boolean shovelSelected;
    
    private JPanel sunflowerSelect;
    private JPanel peashooterSelect;
    private JPanel shovelSelect;
    
    private JLabel waveNumber;
    private JLabel zombiesRemaining;
    private JLabel availableSun;
    
    private JButton skipTurn;
	
	public GameGUI() {
		ArrayList<Integer> waveSizes = new ArrayList<Integer>();
		waveSizes.add(5);
		waveSizes.add(15);
		waveSizes.add(40);
		
		level = new Level(waveSizes, this);
		
		lawnMowers = new JPanel[5];
		lawnTiles = new JPanel[9][5];
		lawnMowerSprite = new JLabel[5];
		
		try {
			lawnMowerImage = ImageIO.read(new File("images/lawnmower.png"));
			zombieImage = ImageIO.read(new File("images/zombie.png"));
			sunflowerImage = ImageIO.read(new File("images/sunflower.png"));
			peashooterImage = ImageIO.read(new File("images/peashooter.png"));
			shovelImage = ImageIO.read(new File("images/shovelImage.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();
		
		sunflowerSelected = true;
		peashooterSelected = false;
		shovelSelected = false;
		
		waveNumber = new JLabel("Wave Number: ");
		zombiesRemaining = new JLabel("Zombies Remaining: ");
		availableSun = new JLabel("Available Sun: ");
	
		createGUI();
		populateBoard();
		updateStats();
	}
	
	public void createGUI() {
		//Create frame and content pane
        frame = new JFrame("Plants vs Zombies: The Puzzle");
        Container contentPane = frame.getContentPane();
       
        //Set contentPane to BorderLayout
        contentPane.setLayout(new BorderLayout());
        
        JPanel board = new JPanel();
        board.setLayout(new GridBagLayout());
        
        for (int i = 0; i < 9; i ++) {
        	for (int j = 0; j < 5; j ++) {
        	GridBagConstraints c = new GridBagConstraints();
       
        	c.weightx = 0.5;
        	c.weighty = 1;
        	c.fill = GridBagConstraints.BOTH;
        	c.gridx = i;
        	c.gridy = j;
        	
        	lawnTiles[i][j] = new JPanel();
        	lawnTiles[i][j].addMouseListener(new TileController(this, level, i, j));
    		lawnTiles[i][j].setPreferredSize(new Dimension(100, 100)); 
        	lawnTiles[i][j].setBorder(BorderFactory.createLineBorder(Color.black));
        	board.add(lawnTiles[i][j], c);
       
        	}
        	
        }
        
        JPanel lawnMowerCol = new JPanel();
        lawnMowerCol.setLayout(new GridBagLayout());
        
        for (int j = 0; j < 5; j ++) {
        	GridBagConstraints c = new GridBagConstraints();
        	c.weightx = 0.5;
        	c.weighty = 1;
        	c.fill = GridBagConstraints.BOTH;
        	c.gridx = 0;
        	c.gridy = j;
        	
        	lawnMowers[j] = new JPanel();
        	
        	lawnMowerSprite[j] = new JLabel(new ImageIcon(lawnMowerImage));
        	lawnMowers[j].setPreferredSize(new Dimension(100, 100)); 
        	lawnMowers[j].add(lawnMowerSprite[j]);
        	
        	lawnMowerCol.add(lawnMowers[j], c);
        }
        
        JPanel hud = new JPanel();
        hud.setLayout(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        
        c.weightx = 0.5;
    	c.fill = GridBagConstraints.BOTH;
    	c.gridwidth = 2;
    	c.gridx = 0;
    	c.gridy = 0;
    	  
    	sunflowerSelect = new JPanel();
    	sunflowerSelect.addMouseListener(new SunflowerSelectController(this, level));
    	sunflowerSelect.setPreferredSize(new Dimension(100, 100));
    	sunflowerSelect.setBorder(loweredbevel);
    	sunflowerSelect.add(new JLabel(new ImageIcon(sunflowerImage)));
    	
    	hud.add(sunflowerSelect, c);
    	
    	c.gridy = 1;
     	
     	peashooterSelect = new JPanel();
     	peashooterSelect.addMouseListener(new PeashooterSelectController(this, level));
     	peashooterSelect.setPreferredSize(new Dimension(100, 100));
     	peashooterSelect.setBorder(raisedbevel);
     	peashooterSelect.add(new JLabel(new ImageIcon(peashooterImage)));
     	
     	hud.add(peashooterSelect, c);
     	
     	c.gridy = 2;
    
     	shovelSelect = new JPanel();
     	shovelSelect.addMouseListener(new ShovelSelectController(this, level));
     	shovelSelect.setPreferredSize(new Dimension(100, 100));
     	shovelSelect.setBorder(raisedbevel);
     	shovelSelect.add(new JLabel(new ImageIcon(shovelImage)));
     	
     	hud.add(shovelSelect, c);
     	
     	JPanel levelStats = new JPanel();
     	levelStats.setLayout(new GridLayout(1, 3));
     	levelStats.add(waveNumber, 0, 0);
     	levelStats.add(zombiesRemaining, 0, 1);
     	levelStats.add(availableSun, 0 , 2);
 
     	JPanel boardAndStats = new JPanel();
     	boardAndStats.setLayout(new BoxLayout(boardAndStats, BoxLayout.PAGE_AXIS));
     	boardAndStats.add(levelStats);
     	boardAndStats.add(board);
     	
     	//Create the Options Menu bar
        JMenuBar menuBar = new JMenuBar();
        
        //Create the menu
        JMenu optionsMenu = new JMenu("Options");
        
        //Add the menu
        menuBar.add(optionsMenu);
        
        JMenuItem resetGame = new JMenuItem("Reset");
        resetGame.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        
                    }
                }
        );
        
        optionsMenu.add(resetGame);        
        
        skipTurn = new JButton("SKIP TURN");
        skipTurn.addActionListener(new SkipTurnListener(this, level));
        
        
        //Add all the components to the contentPane
        contentPane.add(menuBar, BorderLayout.NORTH);
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
	
	public void populateBoard() {
        for (int j = 0; j < 5; j ++) {
        	if (!level.getLawn(j).isLawnMowerActivated()) {
        		lawnMowers[j].add(lawnMowerSprite[j]);
        		lawnMowers[j].revalidate();
        		lawnMowers[j].repaint();
        	}
        	for (Plant plant: level.getLawn(j).getPlants())	{
        		if (plant instanceof Sunflower) {
        			addSunflower(plant.getxPos(), plant.getyPos());
        		}
        		else if (plant instanceof Peashooter) {
        			addPeashooter(plant.getxPos(), plant.getyPos());
        		}
        	}
        	for (Zombie zombie: level.getLawn(j).getZombies()) {
				
				addZombie((int) Math.round(zombie.getCurrentX()), zombie.getyPos());
			}
		}
        
		
	}
	
	public void updateStats() {
		waveNumber.setText("Wave Number: " + level.currentWave());
		zombiesRemaining.setText("Zombies Remaining: " + level.zombieCount());
		availableSun.setText("Available Sun: " + level.getSunTotal());
	}
	
	public void addSunflower(int x, int y) {
		lawnTiles[x][y].add(new JLabel(new ImageIcon(sunflowerImage)));
		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}
	
	public void addPeashooter(int x, int y) {
		lawnTiles[x][y].add(new JLabel(new ImageIcon(peashooterImage)));
		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}
	
	public void addZombie(int x, int y) {
		lawnTiles[x][y].add(new JLabel(new ImageIcon(zombieImage)));
	}
	
	public void removePlant(int x, int y) {
		lawnTiles[x][y].removeAll();
		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}
	
	public void selectSunflower() {
		sunflowerSelected = true;
		peashooterSelected = false;
		shovelSelected = false;
	}
	
	public boolean sunflowerSelected() {
		return sunflowerSelected;
	}
	
	public void selectPeashooter() {
		sunflowerSelected = false;
		peashooterSelected = true;
		shovelSelected = false;
	}
	
	public boolean peashooterSelected() {
		return peashooterSelected;
	}
	
	public void selectShovel() {
		sunflowerSelected = false;
		peashooterSelected = false;
		shovelSelected = true;
	}
	
	public boolean shovelSelected() {
		return shovelSelected;
	}
	
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
	
	
	
	
	

	
}