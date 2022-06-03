package xmlutilities;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;

import main.City;
import tree.BuildTree;
import tree.PathFinder;


/**
 * Classe che gestisce la scrittura del file .xml 
 */



public class XMLWriter {

	public static void XmlWrite(ArrayList<City> allCity) {

    	XMLOutputFactory xmlof = null;
    	XMLStreamWriter xmlw = null;
    	try {
			 xmlof = XMLOutputFactory.newInstance();
			 xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("Routes.xml"), "utf-8");
	
			 try { // blocco try per catturare eccezioni
		
				  xmlw.writeStartElement("routes"); // scrittura del tag radice <routes>
				  //scrittura della rotta del team Tonathiu
				  LinkedList<City> treeT = BuildTree.buildTree(allCity, true);
				  LinkedList<City> path_T = PathFinder.dijkstra(treeT); // Genera la path per il team Tonathiu
				  xmlw.writeStartElement("route"); 			  
				  xmlw.writeAttribute("team","Tonathiu"); // scrittura nome team
				  xmlw.writeAttribute("cost",String.format("%.2f", PathFinder.getPathCost())); // scrittura costo
				  xmlw.writeAttribute("cities",String.format("%d", path_T.size())); //scrittura numero città toccate
				  
				  // Scrivi tutte le citta' toccate
				  for (City c : path_T) {
					  xmlw.writeStartElement("City"); 
					  xmlw.writeAttribute("id", String.format("%d", c.getId())); //scrittura id	
					  xmlw.writeAttribute("nome",c.getName());//scrittura città toccate
					  xmlw.writeEndElement();									  
				  }
				  xmlw.writeEndElement();
				  
				  // Scrittura della rotta per il secondo team
				  LinkedList<City> treeM = BuildTree.buildTree(allCity, false); // Costruisci l'albero con i pesi per il secondo team
				  LinkedList<City> path_M = PathFinder.dijkstra(treeM); // Costruisci la path (percorso ideale) per il secondo team
				  xmlw.writeStartElement("route"); 				  
				  xmlw.writeAttribute("team","Metztli"); // scrittura nome team
				  xmlw.writeAttribute("cost",String.format("%.2f", PathFinder.getPathCost())); // scrittura costo
				  xmlw.writeAttribute("cities",String.format("%d", path_M.size())); // scrittura numero città toccate
				  
				  for (City c : path_M) {
					  xmlw.writeStartElement("City"); 
					  xmlw.writeAttribute("id", String.format("%d", c.getId() )); // scrittura id	
					  xmlw.writeAttribute("nome",c.getName()); // scrittura nome citta'
					  xmlw.writeEndElement();			
				  }
				  
				  xmlw.writeEndElement();
				  xmlw.writeEndElement();
				  
			 } 
			 catch (Exception e) { 
				 System.out.println("Errore nella scrittura");
				 System.out.println(e.getMessage());
			 }

		} 
    	catch (Exception e) {
    		System.out.println(e.getMessage());
			e.printStackTrace();
    	}
    	
    	
    		
	}

}
