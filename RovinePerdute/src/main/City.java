package main;


import java.util.ArrayList;

import tree.Node;

/**
 * classe che rappressenta una citta
 * la classe estende un nodo perch� ogni nodo rappresenta una classe
 * 
 *
 */
public class City extends Node{

	
	private String name;// nome citta
	private int id;//id citta
	private int[] coords = new int[3];//array con le tre coordinate [x,y,h]
	private ArrayList<Integer> linkTo = new ArrayList<Integer>();//array che contiene gli id delle citta collegate
	
	
	public City(String name, int id, int[] coords, ArrayList<Integer> linkTo) {
		super();
		this.name = name;
		this.id = id;
		this.coords = coords;
		this.linkTo = linkTo;
	}

	/**
	 * @return Il nome della citt�
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return id citt�
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return Raccogli le cordinate delle citt�
	 */
	public int[] getCoords() {
		return coords;
	}

	/**
	 * @return Fornisce collegamenti tra citt�
	 */
	public ArrayList<Integer> getLinkTo() {
		return linkTo;
	}
	
	
	

		 
	 
	 
	 
	 
	 
}
	
	
	
	

