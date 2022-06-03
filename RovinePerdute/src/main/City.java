package main;


import java.util.ArrayList;

import tree.Node;


public class City extends Node{

	
	private String name;
	private int id;
	private int[] coords = new int[3];
	private ArrayList<Integer> linkTo = new ArrayList<Integer>();
	
	
	public City(String name, int id, int[] coords, ArrayList<Integer> linkTo) {
		super();
		this.name = name;
		this.id = id;
		this.coords = coords;
		this.linkTo = linkTo;
	}


	public String getName() {
		return name;
	}


	public int getId() {
		return id;
	}


	public int[] getCoords() {
		return coords;
	}


	public ArrayList<Integer> getLinkTo() {
		return linkTo;
	}
	
	
	

		 
	 
	 
	 
	 
	 
}
	
	
	
	

