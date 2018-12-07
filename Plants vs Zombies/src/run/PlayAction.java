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

public class PlayAction implements MouseListener {
	// Reference to the GameGUI
	private GameGUI game;

	// Create a new PeashooterSelectController with the reference to the GameGUI
	public PlayAction(GameGUI game) {
		this.game = game;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JFileChooser levelChooser = new JFileChooser();
		levelChooser.setCurrentDirectory(new File(".\\levels"));
		int result = levelChooser.showOpenDialog(game.getFrame());
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedLevel = levelChooser.getSelectedFile();
		    System.out.println("Selected file: " + selectedLevel.getAbsolutePath());
		    
		    File xmlFile = new File(selectedLevel.getAbsolutePath());
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder;
	        ArrayList<Integer> waveSizes = new ArrayList<Integer>();
	        try {
	            dBuilder = dbFactory.newDocumentBuilder();
	            org.w3c.dom.Document doc = dBuilder.parse(xmlFile);
	            doc.getDocumentElement().normalize();
	            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	            Node waveInfo = doc.getElementsByTagName("WaveInfo").item(0);
	            NodeList numZombiesList = ((Element) waveInfo).getElementsByTagName("NumZombies");
	            //now XML is loaded as Document in memory, lets convert it to Object List
	 
	            for (int i = 0; i < numZombiesList.getLength(); i++) {
	            	
	            	Node node = numZombiesList.item(i).getChildNodes().item(0);
	            	System.out.println(node.getNodeValue());
	                waveSizes.add(Integer.parseInt(node.getNodeValue()));
	                
	            }
	        } catch (SAXException | ParserConfigurationException | IOException e1) {
	            e1.printStackTrace();
	        }
	        
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