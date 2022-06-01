package main;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import tree.*;
import xmlutilities.*;



public class Main {

	public static void main(String[] args) {
		
		ArrayList<City> c = ReadCities.readCities(new File("rovine_perdute_maps//test_file//PgAr_Map_12.xml")); 
		LinkedList<Node> tree = BuildTree.buildTree(c, true);
		LinkedList<Node> path = PathFinder.dijkstra(tree);
		
		
		for(Node n : path) {
			System.out.println(n.getCurrentCity().getName());
		}
		
		
		
	}

}
