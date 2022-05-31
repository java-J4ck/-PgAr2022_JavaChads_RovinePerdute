package main;


import java.util.ArrayList;


public class City{

	
	private String name;
	private int id;
	private int[] coords = new int[3];
	private ArrayList<Integer> linkTo = new ArrayList<Integer>();
	
	
	public City(String name, int id, int[] coords, ArrayList<Integer> linkTo) {
		this.name = name;
		this.id = id;
		this.coords = coords;
		this.linkTo = linkTo;
	}
	
	
	 public String getName() {
			return this.name;
		}
	 
	 public int getid() {
			return this.id;
		}
	 
	 
	 
	 public int[] getcoords() {
		 return this.coords;
		 
	  }


	public ArrayList<Integer> getlinkTo() {
		
		return linkTo;
	}


		 
	 
	 
	 
	 
	 
}
	
	
	
	

