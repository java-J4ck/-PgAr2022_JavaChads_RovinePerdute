package tree;

import java.util.HashMap;

import main.City;

/**
 * classe che definisce le proprieta di un nodo(ovvero i collegamenti)
 * 
 *
 */
public class Node {
	
	/*
	 la hashmap definisce tutti i collegamenti 
	 le chiavi sono le citta a cui è collegata
	 mentre i valori sono i pesi dei collegamenti 
	 
	 */
	 
	private HashMap<City,Double> toCity = new HashMap<City,Double>();

	/**
	 * aggiunge un collegamento
	 * @param city
	 * @param distance
	 */
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

	
	/**
	 * ritorna tutti i collegamenti
	 * @return
	 */
	public HashMap<City, Double> getToCity() {
		return toCity;
	}
	
	
	

}
