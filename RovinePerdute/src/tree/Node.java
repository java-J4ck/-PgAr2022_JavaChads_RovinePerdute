package tree;

import java.util.HashMap;

import main.City;

public class Node {
	
	private City currentCity;
	
	private HashMap<Node,Double> toCity = new HashMap<Node,Double>();

	public Node(City currentCity) {
		this.currentCity = currentCity;
	}
	
	public void addLink(Node node, double distance) {
		toCity.put(node, distance);
	}
	
	public double getDistance(Node destination) {
		double dist;
		try {
			dist = toCity.get(destination);
		} catch (NullPointerException e) {
			dist = Double.MAX_VALUE;
		}
		return dist;
	}

	public City getCurrentCity() {
		return currentCity;
	}

	public HashMap<Node, Double> getToCity() {
		return toCity;
	}
	
	
	

}
