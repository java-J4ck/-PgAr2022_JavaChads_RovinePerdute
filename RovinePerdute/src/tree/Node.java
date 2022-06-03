package tree;

import java.util.HashMap;

import main.City;

public class Node {
	

	
	private HashMap<City,Double> toCity = new HashMap<City,Double>();

	
	public void addLink(City city, double distance) {
		toCity.put(city, distance);
	}
	
	public double getDistance(City destination) {
		double dist;
		try {
			dist = toCity.get(destination);
		} catch (NullPointerException e) {
			dist = Double.POSITIVE_INFINITY;
		}
		return dist;
	}

	

	public HashMap<City, Double> getToCity() {
		return toCity;
	}
	
	
	

}
