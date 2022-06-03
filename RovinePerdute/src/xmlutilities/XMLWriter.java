package xmlutilities;

import java.io.FileOutputStream;

import java.util.LinkedList;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import main.City;

import tree.PathFinder;




public class XMLWriter {

	public static void XmlWrite(LinkedList<City>  treeT, LinkedList<City> treeM) {
		
		
		
		

    	XMLOutputFactory xmlof = null;
    	XMLStreamWriter xmlw = null;
    	try {
	
			 xmlof = XMLOutputFactory.newInstance();
			 xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("Routes.xml"), "utf-8");
		//	 xmlw.writeStartDocument("utf-8", "1.0");
			 
			 
			 try { // blocco try per raccogliere eccezioni
				//############################STAMPA PERSONE#############################################################
				  xmlw.writeStartElement("routes"); // scrittura del tag radice <programmaArnaldo>
				  //scrittura della rotta del team Tonathiu
				  LinkedList<City> path_T = PathFinder.dijkstra(treeT);
				  xmlw.writeStartElement("route");//apri output				  
				  xmlw.writeAttribute("team","Tonathiu");//apri persone
				  xmlw.writeAttribute("cost",String.format("%.2f", PathFinder.getPathCost()));//apri persone
				  xmlw.writeAttribute("cities",String.format("%d", path_T.size()));//apri persone
				  
				  
				  for (City  c: path_T ) {
					  
					  xmlw.writeStartElement("City"); // start elemento nome
					  xmlw.writeAttribute("id", String.format("%d", c.getId())); //scrittura id	
					  xmlw.writeAttribute("nome",c.getName());
					  xmlw.writeEndElement();//chiusura persone  					
					  
				  }
				  xmlw.writeEndElement();
				
				  LinkedList<City> path_M = PathFinder.dijkstra(treeM);
				  xmlw.writeStartElement("route");//apri output				  
				  xmlw.writeAttribute("team","Metztli");//apri persone
				  xmlw.writeAttribute("cost",String.format("%.2f", PathFinder.getPathCost()));//apri persone
				  xmlw.writeAttribute("cities",String.format("%d", path_M.size()));//apri persone
				  
				  
				  for (City  c: path_M ) {
					  
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
