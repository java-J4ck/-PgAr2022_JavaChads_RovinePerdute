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
 * 
 * Classe che gestisce la scrittura del file .xml 
 *
 */



public class XMLWriter {

	public static void XmlWrite(ArrayList<City> allCity) {
		
		
		
		
		

    	XMLOutputFactory xmlof = null;
    	XMLStreamWriter xmlw = null;
    	try {
    		 LinkedList<City> treeT = BuildTree.buildTree(allCity, true);
			 xmlof = XMLOutputFactory.newInstance();
			 xmlw = xmlof.createXMLStreamWriter(new FileOutputStream("Routes.xml"), "utf-8");
		//	 xmlw.writeStartDocument("utf-8", "1.0");
			 
			 
			 try { // blocco try per raccogliere eccezioni
				//############################STAMPA PERSONE#############################################################
				  xmlw.writeStartElement("routes"); // scrittura del tag radice <rouds>
				  //scrittura della rotta del team Tonathiu
				  LinkedList<City> path_T = PathFinder.dijkstra(treeT);//informazioni primo teams
				  xmlw.writeStartElement("route");//apri output				  
				  xmlw.writeAttribute("team","Tonathiu");//scrittura nome team
				  xmlw.writeAttribute("cost",String.format("%.2f", PathFinder.getPathCost()));//scrittura costo
				  xmlw.writeAttribute("cities",String.format("%d", path_T.size()));//scrittura numero città toccate
				  
				  
				  for (City  c: path_T ) {
					  
					  xmlw.writeStartElement("City"); // start elemento nome
					  xmlw.writeAttribute("id", String.format("%d", c.getId())); //scrittura id	
					  xmlw.writeAttribute("nome",c.getName());//sctrittura città toccate
					  xmlw.writeEndElement();////chiusura città toccate				
					  
				  }
				  xmlw.writeEndElement();
				  
				  
				  LinkedList<City> treeM = BuildTree.buildTree(allCity, false);
				  LinkedList<City> path_M = PathFinder.dijkstra(treeM);//informazioni secondo teams
				  xmlw.writeStartElement("route");//apri output				  
				  xmlw.writeAttribute("team","Metztli");//scrittura nome team
				  xmlw.writeAttribute("cost",String.format("%.2f", PathFinder.getPathCost()));//scrittura costo
				  xmlw.writeAttribute("cities",String.format("%d", path_M.size()));//scrittura numero città toccate
				  
				  
				  for (City  c: path_M ) {
					  
					  xmlw.writeStartElement("City"); // start elemento nome
					  xmlw.writeAttribute("id", String.format("%d", c.getId() )); //scrittura id	
					  xmlw.writeAttribute("nome",c.getName());//sctrittura città toccate
					  xmlw.writeEndElement();//chiusura città toccate					
					  
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
