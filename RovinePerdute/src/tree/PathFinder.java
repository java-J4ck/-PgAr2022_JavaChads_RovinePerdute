package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.function.BiFunction;
import java.util.function.Function;

import main.City;


public class PathFinder {
	
	
	static private class Label {
		
		double totWeight;
		Node previousNode;
		
		public Label(double totWeight, Node previousNode) {
			this.totWeight = totWeight;
			this.previousNode = previousNode;
		}
		
	}
	
	
	
	/**
	 * Dati due nodi un un grafo, il cammino ottimo che unisce tali nodi (se esiste) e'
	 * composto dall'unione di sotto-cammini ottimi.
	 * 
	 * @param graph
	 * @return
	 */
	public static LinkedList<Node> dijkstra(LinkedList<Node> graph){
		
		
		LinkedList<Node> path = new LinkedList<>();
		LinkedList<Node> nodes = (LinkedList<Node>) graph.clone();
		HashMap<Node, Label> labels = new HashMap<>();
		double calc_dist = 0;
		
		path.add(nodes.getFirst());
		labels.put(nodes.getFirst(), new Label(0, null));
		nodes.remove();
		
		for(Node n : nodes) {
			labels.put(n, new Label(Double.MAX_VALUE, null));
		}
		
		for(Node neighbour : path.getLast().getToCity().keySet()) {
			labels.put(neighbour, new Label(path.getLast().getDistance(neighbour), path.getLast()));
		}
		
		while(!nodes.isEmpty()) {
			Node min = nodes.getFirst();
			for(Node n : nodes) {
				if(path.getLast().getDistance(n) < path.getLast().getDistance(min)) {
					min = n;
				}
			}
			nodes.remove();
			path.add(min);
			for(Node neighbour : min.getToCity().keySet()) {
				calc_dist = path.getFirst().getDistance(min) + min.getDistance(neighbour);
				if(calc_dist < labels.get(neighbour).totWeight) {
					labels.put(neighbour, new Label(calc_dist, min));
				}
			}
			if(path.getLast().getCurrentCity().getName().contains("Rovine Perdute")) break;
		}
		
		
		return path;
		
	}
	
	
	
	
}
