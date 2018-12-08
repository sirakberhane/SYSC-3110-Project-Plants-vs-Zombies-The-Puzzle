package run;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.*;
import org.w3c.dom.*;

/**
 * 
 * @author Jolar Tabungar
 * WriteFile converts the array and creates and builds and saves an XML File using the given filename
 *
 */
public class WriteFile {

	/**
	 * @param waveSizes the wavesizes array
	 * @param filename the name of the level to be saved
	 */
	public void writeXmlFile(ArrayList<Integer> waveSizes, String filename) {

		try {

			//Create and build a new document
			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();

			//Create the root element
			Element root = doc.createElement("LevelInfo");
			doc.appendChild(root);

			//Create a sub element
			Element Details = doc.createElement("WaveInfo");
			root.appendChild(Details);

			//Add each value in wavesizes to the XML Document
			for (int i = 0; i < waveSizes.size(); i++) {

				Element numZombies = doc.createElement("NumZombies");
				numZombies.appendChild(doc.createTextNode(String.valueOf(waveSizes.get(i))));
				Details.appendChild(numZombies);
			}

			//Save the document to the disk file
			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer = tranFactory.newTransformer();

			//Format the XML nicely
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			try {
				//Write the XML Document to a file with thte given filename
				FileOutputStream out = new FileOutputStream(".//levels//" + filename + ".xml");
				StreamResult result = new StreamResult(out);
				aTransformer.transform(source, result);
				out.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		} catch (TransformerException ex) {
			System.out.println("Error outputting document");

		} catch (ParserConfigurationException ex) {
			System.out.println("Error building document");
		}
	}
}