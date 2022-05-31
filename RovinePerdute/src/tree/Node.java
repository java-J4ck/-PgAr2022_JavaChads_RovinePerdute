package tree;

import java.util.HashMap;

import main.City;

public class Node {
	
	private City currentCity;
	
	private HashMap<City,Double> toCity = new HashMap<City,Double>();

	public Node(City currentCity) {
		this.currentCity = currentCity;
	}
	
	public void addLink(City city, double distance) {
		toCity.put(city, distance);
	}
	
	public double getDistance(City destination) {
		return toCity.get(destination);
	}

	public City getCurrentCity() {
		return currentCity;
	}
	

}
