package run;

import java.awt.event.MouseEvent;

import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import org.w3c.dom.NodeList;

/**
 * 
 * @author Jolar Tabungar
 * 
 * Implements the play feature on the menu screen
 * Loads a level template from levels and creates a new game using that level template
 *
 */
public class PlayAction implements MouseListener {
	// Reference to the GameGUI
	private GameGUI game;

	// Create a new PlayAction with the reference to the GameGUI
	public PlayAction(GameGUI game) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Open a JFilechooser Dialog in the levels directory
		JFileChooser levelChooser = new JFileChooser();
		levelChooser.setCurrentDirectory(new File(".\\levels"));
		int result = levelChooser.showOpenDialog(game.getFrame());
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedLevel = levelChooser.getSelectedFile();
		    
		    //Read File as XML
		    File xmlFile = new File(selectedLevel.getAbsolutePath());
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
	        //Create an empty waveSizes array to be filled after reading the file
	        ArrayList<Integer> waveSizes = new ArrayList<Integer>();
	        try {
	        	//Build a new document from the parsed xmlFile and normalize it
	            dBuilder = dbFactory.newDocumentBuilder();
	            org.w3c.dom.Document doc = dBuilder.parse(xmlFile);
	            doc.getDocumentElement().normalize();
	      
	            //Retrieve a list of all the waveSize elements
	            Node waveInfo = doc.getElementsByTagName("WaveInfo").item(0);
	            NodeList numZombiesList = ((Element) waveInfo).getElementsByTagName("NumZombies");
	 
	            //Convert Nodes retrieved from XML into their values and add them to the waveSizes array
	            for (int i = 0; i < numZombiesList.getLength(); i++) {
	            	
	            	//Convert Node Values into waveSize elements
	            	Node node = numZombiesList.item(i).getChildNodes().item(0);
	                waveSizes.add(Integer.parseInt(node.getNodeValue()));
	                
	            }
	        } catch (SAXException | ParserConfigurationException | IOException e1) {
	            e1.printStackTrace();
	        }
	        
	        //Create the game from the waveSizes array
	        game.createGameScreen(waveSizes);
		}
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}