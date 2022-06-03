package tree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;


import main.City;


public class PathFinder {
	
	
	private static double pathCost;   // Variabile che contine il costo del percorso piu' economico per raggiungere le rovine perdute

	
	/**
	 * Static nested class che rappresenta l'etichetta assegnata a ogni nodo per l'esecuzione dell'algoritmo
	 */
	private static class Label {    
		
		double totWeight;   // Peso (distanza) del cammino piu' corto che collega il nodo associato all'etichetta e il nodo di partenza
		City previousNode;  // Nodo precedente al nodo associato all'etichetta
		
		public Label(double totWeight, City previousNode) {
			this.totWeight = totWeight;
			this.previousNode = previousNode;
		}
		
	}
	
	
	
	/**
	 * Algoritmo che, dato un grafo in cui ogni nodo rappresenta una citta', trova il cammino meno costoso per raggiungere
	 * le Rovine Perdute partendo dal campo base.
	 * 
	 * @param graph
	 * @return La path meno costosa per raggiungere le Rovine Perdute partendo dal campo base
	 */
	
	public static LinkedList<City> dijkstra(LinkedList<City> graph){
		
		LinkedList<City> path = new LinkedList<>();  // LinkedList di citta' per raggiungere le rovine perdute (percorso meno costoso)  
		LinkedList<City> nodes = (LinkedList<City>) graph.clone();  // Copia del grafo di citta'
		HashMap<City, Label> labels = new HashMap<>();  // HashMap contenente le etichette per ogni nodo
		double calc_dist = 0;
		
		for(City n : nodes) {   // Inizialmente non siamo a conoscenza di nessuna path (se non, banalmente, quella che dal primo nodo conduce al primo nodo)
			labels.put(n, new Label(Double.POSITIVE_INFINITY, null));   // Crea una nuova etichetta per tutti i nodi e settala a distanza (dall'orgine) infinita e nodo precedente nullo
		}
		
		labels.put(nodes.peek(), new Label(0, null));  // Setta per il primo nodo (campo base) la distanza 0 (da se stesso) e nodo precedente nullo
		
		City currentNode = nodes.peek();  // Imposta currentNode al primo nodo della LinkedList (campo base)
		
		while(!nodes.isEmpty()) {
			
			// Considera tutti i nodi collegati a currentNode. Per ogni nodo calcola la distanza dal campo base al nodo stesso e, se questa distanza e' minore
			// di quella segnata nell'etichetta (sempre dello stesso nodo), aggiorna il valore alla distanza appena calcolata.
			for(City neighbour : currentNode.getToCity().keySet()) {
				calc_dist = labels.get(currentNode).totWeight + currentNode.getDistance(neighbour); // calc_dist = distanza dal campo base al currentNode (segnata in tabella) + distanza dal currentNode al nodo considerato
				if(calc_dist < labels.get(neighbour).totWeight) {  
					labels.put(neighbour, new Label(calc_dist, currentNode));
				}
			}
			
			nodes.remove(currentNode);   // Rimuovi currentNode dalla lista dei nodi che devono ancora essere analizzati
			
			currentNode = nodes.peek();
			for(City n : nodes) {    // Cerca il nodo con la minor distanza dal campo base, e consideralo come currentNode per la successiva iterazione
				if(labels.get(n).totWeight < labels.get(currentNode).totWeight) {
					currentNode = n;
				}
			}
			
			if(currentNode.getName().contains("Rovine Perdute")) {  // Se currentNode e' le Rovine Perdute, allora e' stato trovato il percorso piu' breve
				break;
			}
			
		}
		
		savePathCost(labels.get(currentNode).totWeight);   // Salva in una variable il costo del percorso piu' breve trovato
		
		while(currentNode != null) {   // Itera dalle Rovine Perdute al campo base, passando per il percorso con il minor costo
			path.push(currentNode);     
			currentNode = labels.get(currentNode).previousNode;
		}
		
		return path;
		
	}
	
	
	
	
	/**
	 * Tentativo brutto (e non funzionante) di implementare l'A*
	 * @param graph
	 * @return
	 */
	
	public static LinkedList<City> astar(LinkedList<City> graph){
		
		LinkedList<City> path = new LinkedList<>();
		HashMap<City, Label> labels = new HashMap<>();
		PriorityQueue<City> openSet = new PriorityQueue<City>(new Comparator<City>() {   // PriorityQueue con comparator per le citta' 
		    public int compare(City n1, City n2) {
		        if(labels.get(n1).totWeight > labels.get(n2).totWeight) return 1;
		        else if(labels.get(n1).totWeight < labels.get(n2).totWeight) return -1;
		        else return 0;
		    }
		});
		double calc_dist = 0;
		
		openSet.add(graph.peek());
		labels.put(graph.poll(), new Label(0, null));
		
		for(City n : graph) {   // Inizialmente non siamo a conoscenza di nessuna path (se non, banalmente, quella che dal primo nodo conduce al primo nodo)
			labels.put(n, new Label(Double.POSITIVE_INFINITY, null));   // Crea una nuova etichetta per tutti i nodi e settala a distanza (dall'orgine) infinita e nodo precedente nullo
		}
		
		
		while(!openSet.isEmpty()) {
			
			City currentNode = openSet.poll();
			
			if(currentNode.getName().contains("Rovine Perdute")) {
				while(currentNode != null) {
					path.push(currentNode);     
					currentNode = labels.get(currentNode).previousNode;
				}
				return path;
			}
			
			for(City neighbor : currentNode.getToCity().keySet()) {
				calc_dist = heuristic(neighbor.getId(), currentNode.getDistance(neighbor));
				calc_dist += labels.get(currentNode).totWeight;
				if(calc_dist < labels.get(neighbor).totWeight) {
					labels.put(neighbor, new Label(calc_dist, currentNode));
					if(!openSet.contains(neighbor)) openSet.add(neighbor);
				}
			}
			
		}
		
		return path;
		
	}
	
	
	private static double heuristic(int id, double dist) {
		
		double w;		
		//w = dist - (id * ((dist*5)/100));   // CAMBIANDO LA PERCENTUALE DAL 10% AL 5%, A* RESTITUISCE LA STESSA STRADA DI DIJKSTRA
		w = dist - (dist%(id));		
		return w;
		
	}
	
	
	
	private static void savePathCost(double newPathCost) {
		pathCost = newPathCost;
	}
	
	public static double getPathCost() {
		return pathCost;
	}
	
}
