package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import main.City;

public class BuildTree {
	
	private static final int ALTITUDE_INDEX = 2;
	private static final int Y_COORD_INDEX = 1;
	private static final int X_COORD_INDEX = 0;
	

	public static LinkedList<City>  buildTree(ArrayList<City> allCity, boolean isTonatiuh){
		 LinkedList<City> tree = new LinkedList<City>();
		for(City city : allCity) tree.add(city);
		for(City city : tree) {
			for(int id : city.getLinkTo()) {
				for(City toCity : tree) {
					if(id == toCity.getId() && isTonatiuh) {
						city.addLink(toCity, getDistance_Tonatiuh(city, toCity));
						break;
					}
					else if	(id == toCity.getId() && !isTonatiuh) {
						city.addLink(toCity, getDistance_Metztli(city, toCity));
						break;
					}
					
				}
			}
		}
		return tree;
	}
	
	private static double getDistance_Tonatiuh(City fromCity, City toCity) {
		double distance=0;
		distance=Math.sqrt(Math.pow(fromCity.getCoords()[X_COORD_INDEX]-toCity.getCoords()[X_COORD_INDEX], 2)+ Math.pow(fromCity.getCoords()[Y_COORD_INDEX]-toCity.getCoords()[Y_COORD_INDEX], 2));
		return distance;
	}
	
	private static double getDistance_Metztli(City fromCity, City toCity) {
		double distance=0;
		distance=Math.abs(fromCity.getCoords()[ALTITUDE_INDEX]-toCity.getCoords()[ALTITUDE_INDEX]);
		return distance;
	}

}
