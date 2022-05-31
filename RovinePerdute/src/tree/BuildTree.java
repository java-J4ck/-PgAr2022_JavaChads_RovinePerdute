package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

import main.City;

public class BuildTree {
	
	private static final int ALTITUDE_INDEX = 2;
	private static final int Y_COORD_INDEX = 1;
	private static final int X_COORD_INDEX = 0;

	public static LinkedList<Node> buildTree(ArrayList<City> allCity,boolean isTonatiuh){
		LinkedList<Node> tree = new LinkedList<Node>();
		
		//aggiungiamo tutti i nodi
		for(City city : allCity) tree.add(new Node(city)); 
		//aggiungiamo i link
		Node node;
		City currentCity;
		ListIterator<Node> iter = tree.listIterator();
		while(iter.hasNext()) {
			node=iter.next();
			currentCity=node.getCurrentCity();
			for(int id : currentCity.getlinkTo()) {
				for(City city : allCity) {
					if(city.getid() == id && isTonatiuh) 
						node.addLink(city, getDistance_Tonatiuh(currentCity,city));
					else if(city.getid() == id && !isTonatiuh)  
						node.addLink(city, getDistance_Metztli(currentCity,city));
				}
			}
		}
		return tree;
	}
	
	private static double getDistance_Tonatiuh(City fromCity,City toCity) {
		double distance=0;
		distance=Math.sqrt(Math.pow(fromCity.getcoords()[X_COORD_INDEX]-toCity.getcoords()[X_COORD_INDEX], 2)+ Math.pow(fromCity.getcoords()[Y_COORD_INDEX]-toCity.getcoords()[Y_COORD_INDEX], 2));
		return distance;
	}
	
	private static double getDistance_Metztli(City fromCity,City toCity) {
		double distance=0;
		distance=Math.abs(fromCity.getcoords()[ALTITUDE_INDEX]-toCity.getcoords()[ALTITUDE_INDEX]);
		return distance;
	}

}
