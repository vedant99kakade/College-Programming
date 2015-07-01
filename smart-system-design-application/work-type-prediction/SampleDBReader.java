/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
 
public class SampleDBReader {
 
  public static void main(String argv[]) {
 
    try {
 
	File fXmlFile = new File("Desktop/SampleDB.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
	//doc.getDocumentElement().normalize();
 
	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
 
	NodeList nList = doc.getElementsByTagName("row");
 
	
 int totalsamples=nList.getLength();
 System.out.println("TOTAL Samples"+totalsamples);
 int malesamples=0,femalesamples=0;
	for (int temp = 0; temp < nList.getLength(); temp++) {
 
		Node nNode = nList.item(temp);
 
		//System.out.println("\nCurrent Element :" + nNode.getNodeName());
 
		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
 
			Element eElement = (Element) nNode;
 String gender=eElement.getElementsByTagName("gender").item(0).getTextContent();
  if(gender.equals("female"))
     femalesamples++;
 else malesamples++;
 System.out.println("Female"+femalesamples);    
 System.out.println("Male"+malesamples);    
			
		}
	}
    } catch (Exception e) {
	e.printStackTrace();
    }
  }
 
}
