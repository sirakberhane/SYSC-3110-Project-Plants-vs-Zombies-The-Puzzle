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


public class WriteFile {

	public void writeXmlFile(ArrayList<Integer> waveSizes, String filename) {

		try {

			DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dFact.newDocumentBuilder();
			Document doc = build.newDocument();

			Element root = doc.createElement("LevelInfo");
			doc.appendChild(root);

			Element Details = doc.createElement("WaveInfo");
			root.appendChild(Details);

			for (int i = 0; i < waveSizes.size(); i++) {

				Element numZombies = doc.createElement("NumZombies");
				numZombies.appendChild(doc.createTextNode(String.valueOf(waveSizes.get(i))));
				Details.appendChild(numZombies);
			}

			// Save the document to the disk file
			TransformerFactory tranFactory = TransformerFactory.newInstance();
			Transformer aTransformer = tranFactory.newTransformer();

			// format the XML nicely
			aTransformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");

			aTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			try {
				//File levelSave = new File("/levels/" + filename + ".xml");
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