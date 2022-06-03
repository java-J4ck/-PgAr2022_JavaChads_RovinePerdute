package xmlutilities;

import java.io.FileOutputStream;
import java.nio.file.Path;
import java.util.LinkedList;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import main.City;
import tree.PathFinder;




public class XMLWriter {

	public static void XmlWrite(LinkedList<City>  path1, LinkedList<City> path2) {
		
		
		

    	XMLOutputFactory xmlof = null;
    	XMLStreamWriter xmlw = null;
    	try {
	
			 xmlof = XMLOutputFactory.newInstance();
			 xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("Routes.xml"), "utf-8");
		//	 xmlw.writeStartDocument("utf-8", "1.0");
			 
			 
			 try { // blocco try per raccogliere eccezioni
				//############################STAMPA PERSONE#############################################################
				  xmlw.writeStartElement("routes"); // scrittura del tag radice <programmaArnaldo>
				  xmlw.writeStartElement("route");//apri output				  
				  xmlw.writeAttribute("team","Tonathiu");//apri persone
				  xmlw.writeAttribute("cost",String.format("%.2f", PathFinder.getPathCost()  ));//apri persone
				  xmlw.writeAttribute("cities",String.format("%.2f", path1.size()  ));//apri persone
				  
				  for (City  c: path1 ) {
					  
					  xmlw.writeStartElement("City"); // start elemento nome
					  xmlw.writeAttribute("id", String.format("%d", c.getId() )); //scrittura id	
					  xmlw.writeAttribute("nome",c.getName());
					  xmlw.writeEndElement();//chiusura persone  					
					  
				  }
				  
				
				  
				  
				  
				  xmlw.writeEndElement();//chiusura output
				  
				  
				  
				  xmlw.writeStartElement("route");//apri output				  
				  xmlw.writeAttribute("team","Metztli");//apri persone
				  xmlw.writeAttribute("cost",String.format("%.2f", PathFinder.getPathCost()  ));//apri persone
				  xmlw.writeAttribute("cities",String.format("%.2f", path2.size()  ));//apri persone
				  
				  for (City  c: path2 ) {
					  
					  xmlw.writeStartElement("City"); // start elemento nome
					  xmlw.writeAttribute("id", String.format("%d", c.getId() )); //scrittura id	
					  xmlw.writeAttribute("nome",c.getName());
					  xmlw.writeEndElement();//chiusura persone  					
					  
				  }
				  
				
				  
				  
				  
				  xmlw.writeEndElement();//chiusura output			  
				  
				  xmlw.writeEndElement(); // chiusura di </programmaArnaldo>
			 } 
			 catch (Exception e) { // se c’è un errore viene eseguita questa parte
				 System.out.println("Errore nella scrittura");
			 }

		} 
    	catch (Exception e) {
			e.printStackTrace();
    	}
    	
    	
    		
	}

}
