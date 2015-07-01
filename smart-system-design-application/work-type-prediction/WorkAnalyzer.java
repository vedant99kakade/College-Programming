/*
* Implement Naive Bayes to predict the work type for a person with following parameters: age: 30,
* Qualification: MTech, Experience: 8
* Following table provides the details of the available data: in WorkDB.xml
*/

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
 
public class ReadXML1 {
 
  public static void main(String argv[]) {
 
    try {
 
	File fXmlFile = new File("Desktop/WorkDB.xml");
	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	Document doc = dBuilder.parse(fXmlFile);
 
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
