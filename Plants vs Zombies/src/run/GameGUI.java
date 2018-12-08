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
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import plant.*;
import zombie.*;

public class GameGUI {

	// Reference to the level
	private Level level;

	// Arraylist to contain all the levelstates
	private ArrayList<Level> levelHistory;
	private int levelIndex;

	// ArrayList for WaveSizes
	ArrayList<Integer> waveSizes;

	// GUI Components
	private JFrame frame;
	private Container gameScreen;
	private Container menuScreen;
	private JPanel lawnMowers[];
	private ImagePanel lawnTiles[][];

	// Action Buttons
	private JPanel skipTurn;
	private JPanel undoTurn;
	private JPanel redoTurn;
	private JPanel saveGame;
	private JPanel loadGame;

	// Select Options for Plant Placement
	private JPanel sunflowerSelect;
	private JPanel peashooterSelect;
	private JPanel shovelSelect;
	private JPanel snowpeashooterSelect;
	private JPanel potatomineSelect;
	private JPanel hypnoshroomSelect;
	private JPanel wallnutSelect;

	// Labels for showing the level's current stats
	private JLabel waveNumber;
	private JLabel zombiesRemaining;
	private JLabel availableSun;
	private JLabel state;

	// Image Buffers for the various images used
	// Lawn Mower
	private BufferedImage lawnMowerImage;

	// Plants
	private BufferedImage sunflowerImage;
	private BufferedImage sunflowerLargeImage;
	private BufferedImage peashooterImage;
	private BufferedImage peashooterLargeImage;
	private BufferedImage snowpeashooterImage;
	private BufferedImage snowpeashooterLargeImage;
	private BufferedImage potatomineImage;
	private BufferedImage potatomineLargeImage;
	private BufferedImage hypnoshroomImage;
	private BufferedImage hypnoshroomLargeImage;
	private BufferedImage wallnutImage;
	private BufferedImage wallnutLargeImage;

	// Zombies
	private BufferedImage zombieImage;
	private BufferedImage bucketzombieImage;
	private BufferedImage gargantuarzombieImage;
	private BufferedImage footballzombieImage;
	private BufferedImage newspaperzombieImage;

	private BufferedImage zombieFrozenImage;
	private BufferedImage bucketzombieFrozenImage;
	private BufferedImage gargantuarzombieFrozenImage;
	private BufferedImage footballzombieFrozenImage;
	private BufferedImage newspaperzombieFrozenImage;

	private BufferedImage zombieHypnoImage;
	private BufferedImage bucketzombieHypnoImage;
	private BufferedImage gargantuarzombieHypnoImage;
	private BufferedImage footballzombieHypnoImage;
	private BufferedImage newspaperzombieHypnoImage;

	// Shovel
	private BufferedImage shovelImage;

	// Action Buttons
	private BufferedImage skip;
	private BufferedImage undo;
	private BufferedImage redo;

	// Save/load buttons
	private BufferedImage save;
	private BufferedImage load;

	// Menu Images
	private BufferedImage titleScreen;
	private BufferedImage play;
	private BufferedImage create;
	private BufferedImage exit;

	// Label to contain each lawn's respective image buffer
	private JLabel lawnMowerSprite[];

	// References to Borders
	private Border raisedbevel;
	private Border loweredbevel;

	// Flags to determine which select option is set
	private boolean sunflowerSelected;
	private boolean peashooterSelected;
	private boolean shovelSelected;
	private boolean snowpeashooterSelected;
	private boolean potatomineSelected;
	private boolean hypnoshroomSelected;
	private boolean wallnutSelected;

	private GameData gameData;

	// Construct a new GameGUI
	public GameGUI() {
		/*
		 * // Initialize the wave sizes for the level waveSizes = new
		 * ArrayList<Integer>(); waveSizes.add(5); waveSizes.add(15); waveSizes.add(20);
		 * waveSizes.add(30); waveSizes.add(40); waveSizes.add(60); waveSizes.add(80);
		 */

		// Initialize JComponenets
		lawnMowers = new JPanel[5];
		lawnTiles = new ImagePanel[9][5];
		lawnMowerSprite = new JLabel[5];

		// Read Image Files for the Image Buffers
		try {
			lawnMowerImage = ImageIO.read(new File("images/lawnmower.png"));

			sunflowerImage = ImageIO.read(new File("images/sunflower.png"));
			sunflowerLargeImage = ImageIO.read(new File("images/sunflowerLarge.png"));
			peashooterImage = ImageIO.read(new File("images/peashooter.png"));
			peashooterLargeImage = ImageIO.read(new File("images/peashooterLarge.png"));
			snowpeashooterImage = ImageIO.read(new File("images/snowpeashooter.png"));
			snowpeashooterLargeImage = ImageIO.read(new File("images/snowpeashooterLarge.png"));
			potatomineImage = ImageIO.read(new File("images/potatomine.png"));
			potatomineLargeImage = ImageIO.read(new File("images/potatomineLarge.png"));
			hypnoshroomImage = ImageIO.read(new File("images/hypnoshroom.png"));
			hypnoshroomLargeImage = ImageIO.read(new File("images/hypnoshroomLarge.png"));
			wallnutImage = ImageIO.read(new File("images/wallnut.png"));
			wallnutLargeImage = ImageIO.read(new File("images/wallnutLarge.png"));

			zombieImage = ImageIO.read(new File("images/zombie.png"));
			gargantuarzombieImage = ImageIO.read(new File("images/gargantuarzombie.png"));
			bucketzombieImage = ImageIO.read(new File("images/bucketzombie.png"));
			newspaperzombieImage = ImageIO.read(new File("images/newspaperzombie.png"));
			footballzombieImage = ImageIO.read(new File("images/footballzombie.png"));

			zombieFrozenImage = ImageIO.read(new File("images/zombieFrozen.png"));
			gargantuarzombieFrozenImage = ImageIO.read(new File("images/gargantuarzombieFrozen.png"));
			bucketzombieFrozenImage = ImageIO.read(new File("images/bucketzombieFrozen.png"));
			newspaperzombieFrozenImage = ImageIO.read(new File("images/newspaperzombieFrozen.png"));
			footballzombieFrozenImage = ImageIO.read(new File("images/footballzombieFrozen.png"));

			zombieHypnoImage = ImageIO.read(new File("images/zombieHypno.png"));
			gargantuarzombieHypnoImage = ImageIO.read(new File("images/gargantuarzombieHypno.png"));
			bucketzombieHypnoImage = ImageIO.read(new File("images/bucketzombieHypno.png"));
			newspaperzombieHypnoImage = ImageIO.read(new File("images/newspaperzombieHypno.png"));
			footballzombieHypnoImage = ImageIO.read(new File("images/footballzombieHypno.png"));

			shovelImage = ImageIO.read(new File("images/shovel.png"));

			skip = ImageIO.read(new File("images/play.png"));
			undo = ImageIO.read(new File("images/undo.png"));
			redo = ImageIO.read(new File("images/redo.png"));

			save = ImageIO.read(new File("images/save.png"));
			load = ImageIO.read(new File("images/load.png"));

			titleScreen = ImageIO.read(new File("images/titleScreen.png"));
			play = ImageIO.read(new File("images/menuPlay.png"));
			create = ImageIO.read(new File("images/menuCreate.png"));
			exit = ImageIO.read(new File("images/menuExit.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Initialize Borders
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		loweredbevel = BorderFactory.createLoweredBevelBorder();

		// Set Default select option for planting sunflower
		sunflowerSelected = true;
		peashooterSelected = false;
		shovelSelected = false;

		// Initialize level stats labels
		waveNumber = new JLabel("Wave Number: ");
		zombiesRemaining = new JLabel("Zombies Remaining: ");
		availableSun = new JLabel("Available Sun: ");
		state = new JLabel("State Num: ");

		// Create the GUI, populate the board and update the labels with the initial
		// stats
		gameData = new GameData(sunflowerSelected, peashooterSelected, shovelSelected, snowpeashooterSelected,
				potatomineSelected, hypnoshroomSelected, wallnutSelected);
		createGUI();

		/*
		 * populateBoard(); updateStats();
		 */
	}

	/**
	 * Initializes all the JComponents and creates the GUI
	 */
	public void createGUI() {
		// Create frame and content pane
		frame = new JFrame("Plants vs Zombies: The Puzzle");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/PvZ_logo.png"));

		createMenuScreen();
		// createGameScreen();

		frame.pack();

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

	public Frame getFrame() {
		return frame;
	}

	public void createMenuScreen() {
		menuScreen = new Container();
		menuScreen.setLayout(new FlowLayout());

		JLayeredPane layeredPane = new JLayeredPane();

		JLabel background = new JLabel();
		Icon titleIcon = new ImageIcon(titleScreen);
		background.setIcon(titleIcon);
		background.setBounds(0, 0, titleIcon.getIconWidth(), titleIcon.getIconHeight());

		JPanel playButton = new JPanel();
		Icon playIcon = new ImageIcon(play);
		playButton.add(new JLabel(playIcon));
		playButton.setBounds(390, 250, playIcon.getIconWidth(), playIcon.getIconHeight());
		playButton.setOpaque(false);
		playButton.addMouseListener(new PlayAction(this));

		JPanel createButton = new JPanel();
		Icon createIcon = new ImageIcon(create);
		createButton.add(new JLabel(createIcon));
		createButton.setBounds(390, 350, createIcon.getIconWidth(), createIcon.getIconHeight());
		createButton.setOpaque(false);
		createButton.addMouseListener(new CreateAction(this));

		JPanel exitButton = new JPanel();
		Icon exitIcon = new ImageIcon(exit);
		exitButton.add(new JLabel(exitIcon));
		exitButton.setBounds(390, 450, exitIcon.getIconWidth(), exitIcon.getIconHeight());
		exitButton.setOpaque(false);
		exitButton.addMouseListener(new ExitAction(this));

		layeredPane.add(background, new Integer(0));
		layeredPane.setPreferredSize(background.getSize());
		layeredPane.add(playButton, new Integer(1));
		layeredPane.add(createButton, new Integer(1));
		layeredPane.add(exitButton, new Integer(1));

		menuScreen.add(layeredPane);

		frame.setContentPane(menuScreen);
	}

	public void createGameScreen(ArrayList<Integer> waveSizes) {

		this.waveSizes = waveSizes;
		// Create a new level with a reference to this GameGUI
		level = new Level(waveSizes, this);

		levelHistory = new ArrayList<Level>();
		levelHistory.add(new Level(this.waveSizes, this));
		levelIndex = 0;

		gameScreen = new Container();
		// Set contentPane to BorderLayout
		gameScreen.setLayout(new BorderLayout());

		// Create the JPanel for the board
		JPanel board = new JPanel();
		board.setLayout(new GridBagLayout());

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 5; j++) {

				// Create a new constraint for each tile
				GridBagConstraints c = new GridBagConstraints();

				c.weightx = 0.5;
				c.weighty = 1;
				c.fill = GridBagConstraints.BOTH;
				c.gridx = i;
				c.gridy = j;

				// Create the JPanel for each tile
				// Alternate tile images
				if (j % 2 == 0) {
					if (i % 2 == 0)
						lawnTiles[i][j] = new ImagePanel(new ImageIcon("images/lawnTile.png").getImage());
					else
						lawnTiles[i][j] = new ImagePanel(new ImageIcon("images/lawnTile2.png").getImage());
				}

				else {
					if (i % 2 == 0)
						lawnTiles[i][j] = new ImagePanel(new ImageIcon("images/lawnTile2.png").getImage());
					else
						lawnTiles[i][j] = new ImagePanel(new ImageIcon("images/lawnTile.png").getImage());
				}

				// Add the MouseListener to each tile so that it responds when clicked
				lawnTiles[i][j].addMouseListener(new TileController(this, level, i, j));
				// Set the same size for each tile
				lawnTiles[i][j].setPreferredSize(new Dimension(100, 100));
				// Create a line border for each tile so that they can be easily seen
				lawnTiles[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				// Add the tile to the board
				board.add(lawnTiles[i][j], c);
			}
		}

		// Create a JPanel to contain the lawnmowers
		JPanel lawnMowerCol = new JPanel();
		lawnMowerCol.setLayout(new GridBagLayout());

		for (int j = 0; j < 5; j++) {
			// Create a grid bag constraint
			GridBagConstraints c = new GridBagConstraints();
			c.weightx = 0.5;
			c.weighty = 1;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = j;

			// Create a new JPanel for the row's lawn mower
			lawnMowers[j] = new JPanel();

			// Create an Image for the lawn mower and add it to the JPanel
			lawnMowerSprite[j] = new JLabel(new ImageIcon(lawnMowerImage));
			lawnMowers[j].setPreferredSize(new Dimension(100, 100));
			lawnMowers[j].add(lawnMowerSprite[j]);

			// Add the JPanel to the Containing JPanel
			lawnMowerCol.add(lawnMowers[j], c);
		}

		// Create a JPanel for the hud (heads up display), the select options for
		// placement/removal
		JPanel hud = new JPanel();
		hud.setLayout(new GridBagLayout());

		// Create a new constraint
		GridBagConstraints c = new GridBagConstraints();

		c.weightx = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 2;
		c.gridx = 0;
		c.gridy = 0;

		// Create the JPanel for the sunflower select option
		sunflowerSelect = new JPanel();
		// Add a MouseListener so that it does an action when clicked
		sunflowerSelect.addMouseListener(new SunflowerSelectController(this, level));
		sunflowerSelect.setPreferredSize(new Dimension(100, 80));
		// Set border to lowered bevel, as it is the default option
		sunflowerSelect.setBorder(loweredbevel);
		// Add the image to the JPanel
		sunflowerSelect.add(new JLabel(new ImageIcon(sunflowerLargeImage)));

		// Add the JPanel to the containing hud
		hud.add(sunflowerSelect, c);

		// Update the constraint, reuse it for the other options just change the grid y
		// value
		c.gridy = 1;

		// Create the JPanel for the peashooter select option
		peashooterSelect = new JPanel();
		// Add a MouseListener so that it does an action when clicked
		peashooterSelect.addMouseListener(new PeashooterSelectController(this));
		peashooterSelect.setPreferredSize(new Dimension(100, 80));
		// Set border to raised bevel
		peashooterSelect.setBorder(raisedbevel);
		// Add the image to the JPanel
		peashooterSelect.add(new JLabel(new ImageIcon(peashooterLargeImage)));

		// Add the JPanel to the containing hud
		hud.add(peashooterSelect, c);

		// Update the constraint, reuse it for the other options just change the grid y
		// value
		c.gridy = 2;

		// Create the JPanel for the peashooter select option
		snowpeashooterSelect = new JPanel();
		// Add a MouseListener so that it does an action when clicked
		snowpeashooterSelect.addMouseListener(new SnowPeashooterSelectController(this));
		snowpeashooterSelect.setPreferredSize(new Dimension(100, 80));
		// Set border to raised bevel
		snowpeashooterSelect.setBorder(raisedbevel);
		// Add the image to the JPanel
		snowpeashooterSelect.add(new JLabel(new ImageIcon(snowpeashooterLargeImage)));

		// Add the JPanel to the containing hud
		hud.add(snowpeashooterSelect, c);

		// Update the constraint, reuse it for the other options just change the grid y
		// value
		c.gridy = 3;

		// Create the JPanel for the peashooter select option
		potatomineSelect = new JPanel();
		// Add a MouseListener so that it does an action when clicked
		potatomineSelect.addMouseListener(new PotatomineSelectController(this));
		potatomineSelect.setPreferredSize(new Dimension(100, 80));
		// Set border to raised bevel
		potatomineSelect.setBorder(raisedbevel);
		// Add the image to the JPanel
		potatomineSelect.add(new JLabel(new ImageIcon(potatomineLargeImage)));

		// Add the JPanel to the containing hud
		hud.add(potatomineSelect, c);

		// Update the constraint, reuse it for the other options just change the grid y
		// value
		c.gridy = 4;

		// Create the JPanel for the peashooter select option
		hypnoshroomSelect = new JPanel();
		// Add a MouseListener so that it does an action when clicked
		hypnoshroomSelect.addMouseListener(new HypnoshroomSelectController(this));
		hypnoshroomSelect.setPreferredSize(new Dimension(100, 80));
		// Set border to raised bevel
		hypnoshroomSelect.setBorder(raisedbevel);
		// Add the image to the JPanel
		hypnoshroomSelect.add(new JLabel(new ImageIcon(hypnoshroomLargeImage)));

		// Add the JPanel to the containing hud
		hud.add(hypnoshroomSelect, c);

		// Update the constraint, reuse it for the other options just change the grid y
		// value
		c.gridy = 5;

		// Create the JPanel for the peashooter select option
		wallnutSelect = new JPanel();
		// Add a MouseListener so that it does an action when clicked
		wallnutSelect.addMouseListener(new WallnutSelectController(this));
		wallnutSelect.setPreferredSize(new Dimension(100, 80));
		// Set border to raised bevel
		wallnutSelect.setBorder(raisedbevel);
		// Add the image to the JPanel
		wallnutSelect.add(new JLabel(new ImageIcon(wallnutLargeImage)));

		// Add the JPanel to the containing hud
		hud.add(wallnutSelect, c);

		// Update the constraint, reuse it for the other options just change the grid y
		// value
		c.gridy = 6;

		// Create the JPanel for the shovel select option
		shovelSelect = new JPanel();
		// Add a MouseListener so that it does an action when clicked
		shovelSelect.addMouseListener(new ShovelSelectController(this));
		shovelSelect.setPreferredSize(new Dimension(100, 80));
		// Set border to raised bevel
		shovelSelect.setBorder(raisedbevel);
		// Add the image to the JPanel
		shovelSelect.add(new JLabel(new ImageIcon(shovelImage)));

		// Add the JPanel to the containing hud
		hud.add(shovelSelect, c);

		// Create a JPanel to contain the stats
		JPanel levelStats = new JPanel();
		// Set Layout for gridlayout with 1 x 3 grids
		levelStats.setLayout(new GridLayout(1, 4));
		// Add the JLabels to the JPanel
		levelStats.add(waveNumber, 0, 0);
		levelStats.add(zombiesRemaining, 0, 1);
		levelStats.add(availableSun, 0, 2);
		levelStats.add(state, 0, 3);

		// Create a JPanel for the board and the stats
		JPanel boardAndStats = new JPanel();
		// Layout is BoxLayout with Vertical Orientation
		boardAndStats.setLayout(new BoxLayout(boardAndStats, BoxLayout.PAGE_AXIS));
		// Add the level stats JPanel and the board JPanel
		boardAndStats.add(levelStats);
		boardAndStats.add(board);

		// Initialize the skip JPanel
		skipTurn = new JPanel();
		// Add the actionlistener
		skipTurn.addMouseListener(new SkipController(this, level));
		// Add the Skip Image and set the size
		skipTurn.add(new JLabel(new ImageIcon(skip)));
		skipTurn.setPreferredSize(new Dimension(110, 110));

		// Initialize the undo JPanel
		undoTurn = new JPanel();
		// Add the actionlistener
		undoTurn.addMouseListener(new UndoController(this, level));
		// Add the Undo Image and set the size
		undoTurn.add(new JLabel(new ImageIcon(undo)));
		undoTurn.setPreferredSize(new Dimension(110, 110));

		// Initialize the redo JPanel
		redoTurn = new JPanel();
		// Add the actionlistener
		redoTurn.addMouseListener(new RedoController(this, level));
		// Add the Undo Image and set the size
		redoTurn.add(new JLabel(new ImageIcon(redo)));
		redoTurn.setPreferredSize(new Dimension(110, 110));

		// Initialize the save JPanel
		saveGame = new JPanel();
		// Add the actionlistener
		saveGame.addMouseListener(new SaveController(this));
		// Add the save Image and set the size
		saveGame.add(new JLabel(new ImageIcon(save)));
		saveGame.setPreferredSize(new Dimension(110, 110));

		// Initialize the save JPanel
		loadGame = new JPanel();
		// Add the actionlistener
		loadGame.addMouseListener(new LoadController(this));
		// Add the save Image and set the size
		loadGame.add(new JLabel(new ImageIcon(load)));
		loadGame.setPreferredSize(new Dimension(110, 110));

		JPanel lowerHUD = new JPanel();
		lowerHUD.setLayout(new GridBagLayout());

		// Create a new constraint
		GridBagConstraints d = new GridBagConstraints();

		d.weighty = 1;
		d.fill = GridBagConstraints.VERTICAL;
		d.gridwidth = 1;
		d.gridx = 0;
		d.gridy = 0;

		lowerHUD.add(undoTurn, d);

		d.gridx = 1;
		lowerHUD.add(skipTurn, d);

		d.gridx = 2;
		lowerHUD.add(redoTurn, d);
		
		d.gridx = 3;
		lowerHUD.add(saveGame, d);
		
		d.gridx = 4;
		lowerHUD.add(loadGame, d);

		// Add all the components to the contentPane
		gameScreen.add(boardAndStats, BorderLayout.EAST);
		gameScreen.add(lawnMowerCol, BorderLayout.CENTER);
		gameScreen.add(hud, BorderLayout.WEST);
		gameScreen.add(lowerHUD, BorderLayout.SOUTH);

		// Pack the frame and its components and set it visible
		frame.setContentPane(gameScreen);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/**
	 * Adds a new level state to the history
	 * 
	 * @param level
	 */
	public void addLevelState() {
		// If back to the start of the level
		if (levelIndex == 0) {
			// Clear the history and add a new empty level state
			levelHistory.clear();
			levelHistory.add(new Level(waveSizes, this));
			// Then add the current state
			levelHistory.add(level.copyLevel());
		}
		// Otherwise add the current state of level
		else {
			levelHistory.add(level.copyLevel());
		}
		// Update levelIndex to the most current move
		levelIndex = levelHistory.size() - 1;
		// Remove all moves past this point
		removeHistory();
	}

	/**
	 * Removes all level states past the current state
	 */
	public void removeHistory() {
		while (levelHistory.size() > levelIndex + 1) {
			levelHistory.remove(levelIndex + 1);
		}
	}

	/**
	 * Go to the previous level state
	 */
	public void getPreviousLevelState() {
		if (levelIndex > 0) {
			levelIndex--;
			this.level = levelHistory.get(levelIndex);
		}

		clearBoard();
		populateBoard();
		updateStats();
	}

	/**
	 * Go to the next level state
	 */
	public void getNextLevelState() {
		if (levelIndex < levelHistory.size() - 1) {
			levelIndex++;
			this.level = levelHistory.get(levelIndex);
		}

		clearBoard();
		populateBoard();
		updateStats();
	}

	/**
	 * Return the current level state
	 * 
	 * @return
	 */
	public Level getCurrentLevelState() {
		return level;
	}

	/**
	 * Clear the board to repopulate with current state
	 */
	public void clearBoard() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 5; j++) {
				lawnMowers[j].repaint();
				lawnMowers[j].removeAll();
				lawnMowers[j].revalidate();

				lawnTiles[i][j].repaint();
				lawnTiles[i][j].removeAll();
				lawnTiles[i][j].revalidate();
			}
		}

	}

	/**
	 * Repopulate the board with current state of level
	 */
	public void populateBoard() {
		for (int j = 0; j < 5; j++) {
			// Add the remaining lawnmowers
			if (!level.getLawn(j).isLawnMowerActivated()) {
				lawnMowers[j].repaint();
				lawnMowers[j].add(lawnMowerSprite[j]);
				lawnMowers[j].revalidate();
			}
			// Add the plants

			for (Plant plant : level.getLawn(j).getPlants()) {
				if (plant instanceof Sunflower) {
					addSunflower(plant.getxPos(), plant.getyPos());
				} else if (plant instanceof Peashooter) {
					addPeashooter(plant.getxPos(), plant.getyPos());
				} else if (plant instanceof SnowPeashooter) {
					addSnowPeashooter(plant.getxPos(), plant.getyPos());
				} else if (plant instanceof PotatoMine) {
					addPotatoMine(plant.getxPos(), plant.getyPos());
				} else if (plant instanceof HypnoShroom) {
					addHypnoShroom(plant.getxPos(), plant.getyPos());
				} else if (plant instanceof Wallnut) {
					addWallnut(plant.getxPos(), plant.getyPos());
				}
			}
			// Add the zombies
			for (Zombie zombie : level.getLawn(j).getZombies()) {
				if (zombie instanceof BasicZombie)
					addZombie(zombie, (int) Math.round(zombie.getCurrentX()), zombie.getyPos());
				else if (zombie instanceof BucketZombie)
					addBucketZombie(zombie, (int) Math.round(zombie.getCurrentX()), zombie.getyPos());
				else if (zombie instanceof NewspaperZombie)
					addNewspaperZombie(zombie, (int) Math.round(zombie.getCurrentX()), zombie.getyPos());
				else if (zombie instanceof FootballZombie)
					addFootballZombie(zombie, (int) Math.round(zombie.getCurrentX()), zombie.getyPos());
				else if (zombie instanceof Gargantuar)
					addGargantuarZombie(zombie, (int) Math.round(zombie.getCurrentX()), zombie.getyPos());
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
		state.setText("State Num: " + levelIndex);
	}

	/**
	 * Add a sunflower to the GUI at the tile (x, y)
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public void addSunflower(int x, int y) {
		lawnTiles[x][y].addSprite(new ImageIcon(sunflowerImage).getImage());
		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}

	/**
	 * Add a SnowPeashooter to the GUI at the tile (x, y)
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public void addSnowPeashooter(int x, int y) {
		lawnTiles[x][y].addSprite(new ImageIcon(snowpeashooterImage).getImage());
		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}

	/**
	 * Add a PotatoMine to the GUI at the tile (x, y)
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public void addPotatoMine(int x, int y) {
		lawnTiles[x][y].addSprite(new ImageIcon(potatomineImage).getImage());
		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}

	/**
	 * Add a HypnoShroom to the GUI at the tile (x, y)
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public void addHypnoShroom(int x, int y) {
		lawnTiles[x][y].addSprite(new ImageIcon(hypnoshroomImage).getImage());
		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}

	/**
	 * Add a Wallnut to the GUI at the tile (x, y)
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public void addWallnut(int x, int y) {
		lawnTiles[x][y].addSprite(new ImageIcon(wallnutImage).getImage());
		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}

	/**
	 * Add a peashooter to the GUI at the tile (x, y)
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public void addPeashooter(int x, int y) {
		lawnTiles[x][y].addSprite(new ImageIcon(peashooterImage).getImage());
		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}

	/**
	 * Add a zombie to the GUI at the tile (x, y)
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public void addZombie(Zombie zombie, int x, int y) {
		if (zombie.isSlowed())
			lawnTiles[x][y].addSprite(new ImageIcon(zombieFrozenImage).getImage());
		else if (zombie.isHypnotized())
			lawnTiles[x][y].addSprite(new ImageIcon(zombieHypnoImage).getImage());
		else
			lawnTiles[x][y].addSprite(new ImageIcon(zombieImage).getImage());

		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}

	/**
	 * Add a zombie to the GUI at the tile (x, y)
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public void addBucketZombie(Zombie zombie, int x, int y) {
		if (zombie.isSlowed())
			lawnTiles[x][y].addSprite(new ImageIcon(bucketzombieFrozenImage).getImage());
		else if (zombie.isHypnotized())
			lawnTiles[x][y].addSprite(new ImageIcon(bucketzombieHypnoImage).getImage());
		else
			lawnTiles[x][y].addSprite(new ImageIcon(bucketzombieImage).getImage());

		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}

	/**
	 * Add a zombie to the GUI at the tile (x, y)
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public void addNewspaperZombie(Zombie zombie, int x, int y) {
		if (zombie.isSlowed())
			lawnTiles[x][y].addSprite(new ImageIcon(newspaperzombieFrozenImage).getImage());
		else if (zombie.isHypnotized())
			lawnTiles[x][y].addSprite(new ImageIcon(newspaperzombieHypnoImage).getImage());
		else
			lawnTiles[x][y].addSprite(new ImageIcon(newspaperzombieImage).getImage());

		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}

	/**
	 * Add a zombie to the GUI at the tile (x, y)
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public void addFootballZombie(Zombie zombie, int x, int y) {
		if (zombie.isSlowed())
			lawnTiles[x][y].addSprite(new ImageIcon(footballzombieFrozenImage).getImage());
		else if (zombie.isHypnotized())
			lawnTiles[x][y].addSprite(new ImageIcon(footballzombieHypnoImage).getImage());
		else
			lawnTiles[x][y].addSprite(new ImageIcon(footballzombieImage).getImage());

		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}

	/**
	 * Add a zombie to the GUI at the tile (x, y)
	 * 
	 * @param x
	 *            the x position
	 * @param y
	 *            the y position
	 */
	public void addGargantuarZombie(Zombie zombie, int x, int y) {
		if (zombie.isSlowed())
			lawnTiles[x][y].addSprite(new ImageIcon(gargantuarzombieFrozenImage).getImage());
		else if (zombie.isHypnotized())
			lawnTiles[x][y].addSprite(new ImageIcon(gargantuarzombieHypnoImage).getImage());
		else
			lawnTiles[x][y].addSprite(new ImageIcon(gargantuarzombieImage).getImage());

		lawnTiles[x][y].revalidate();
		lawnTiles[x][y].repaint();
	}

	/**
	 * Selects the plantType Sunflower for placing
	 */
	public void selectSunflower() {
		gameData.setSunflower(true);
	}

	/**
	 * Selects the plantType Peashooter for placing
	 */
	public void selectPeashooter() {
		gameData.deselectAll();
		gameData.setPeashooter(true);
	}

	/**
	 * Selects the plantType Snowpeashooter for placing
	 */
	public void selectSnowpeashooter() {
		gameData.deselectAll();
		gameData.setSnowpeashooter(true);
	}

	/**
	 * Selects the plantType Potatomine for placing
	 */
	public void selectPotatomine() {
		gameData.deselectAll();
		gameData.setPotatoMine(true);
	}

	/**
	 * Selects the plantType Hypnoshroom for placing
	 */
	public void selectHypnoshroom() {
		gameData.deselectAll();
		gameData.setHypnoshroom(true);
	}

	/**
	 * Selects the plantType Wallnut for placing
	 */
	public void selectWallnut() {
		gameData.deselectAll();
		gameData.setWallnut(true);
	}

	/**
	 * Selects the shovel for removal
	 */
	public void selectShovel() {
		gameData.deselectAll();
		gameData.setShovel(true);
	}

	/**
	 * Lower the Bevels of all the placement options
	 */
	public void raiseBevels() {
		sunflowerSelect.setBorder(raisedbevel);
		peashooterSelect.setBorder(raisedbevel);
		snowpeashooterSelect.setBorder(raisedbevel);
		potatomineSelect.setBorder(raisedbevel);
		hypnoshroomSelect.setBorder(raisedbevel);
		wallnutSelect.setBorder(raisedbevel);

		shovelSelect.setBorder(raisedbevel);
	}

	/**
	 * Update the look of the HUD by applying the lowered bevel border to the
	 * selected option and applying the raised bevel border to the unselected
	 * options
	 */
	public void updateHUD() {
		raiseBevels();

		if (gameData.sunflowerSelected()) {
			sunflowerSelect.setBorder(loweredbevel);
		} else if (gameData.peashooterSelected()) {
			peashooterSelect.setBorder(loweredbevel);
		} else if (gameData.snowpeashooterSelected()) {
			snowpeashooterSelect.setBorder(loweredbevel);
		} else if (gameData.potatomineSelected()) {
			potatomineSelect.setBorder(loweredbevel);
		} else if (gameData.hypnoshroomSelected()) {
			hypnoshroomSelect.setBorder(loweredbevel);
		} else if (gameData.wallnutSelected()) {
			wallnutSelect.setBorder(loweredbevel);
		} else if (gameData.shovelSelected()) {
			shovelSelect.setBorder(loweredbevel);
		}
	}

	public void updateGUI() {
		addLevelState();
		clearBoard();
		populateBoard();
		updateStats();

		if (level.gameWin())
			winScreen();

		if (level.gameLose())
			loseScreen();
	}

	/**
	 * Show a message dialog for completing the level, and close the GUI
	 */
	public void winScreen() {
		updateStats();
		clearBoard();
		populateBoard();
		JOptionPane.showMessageDialog(frame, "LEVEL COMPLETE!");
		System.exit(0);
	}

	/**
	 * Show a message for losing the level, and close the GUI
	 */
	public void loseScreen() {
		updateStats();
		clearBoard();
		populateBoard();
		JOptionPane.showMessageDialog(frame, "GAME OVER!\nZOMBIES ATE YOUR BRAINS!");
		System.exit(0);
	}

	public void importSave() {
		try {
			JFileChooser levelChooser = new JFileChooser();
			levelChooser.setCurrentDirectory(new File(".\\saves"));
			int result = levelChooser.showOpenDialog(this.getFrame());
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedLevel = levelChooser.getSelectedFile();
				FileInputStream fis = new FileInputStream(selectedLevel.getAbsolutePath());
				ObjectInputStream ois = new ObjectInputStream(fis);
				levelIndex = ois.readInt();
				levelHistory = (ArrayList<Level>) ois.readObject();
				level = levelHistory.get(levelIndex);
				updateGUI();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void exportSave() {
		String saveName = JOptionPane.showInputDialog("Enter the name of the save: ");
		try {
			FileOutputStream fos = new FileOutputStream(".//saves//" + saveName + ".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeInt(levelIndex);
			oos.writeObject(levelHistory);
			oos.close();
			fos.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	public GameData getGameData() {
		return gameData;
	}

}