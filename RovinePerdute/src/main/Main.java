package main;

import java.io.File;
import java.util.ArrayList;

import tree.BuildTree;


public class Main {

	public static void main(String[] args) {
		
		ArrayList<City> c = xmlutilities.ReadCities.readCities(new File("rovine_perdute_maps//test_file//PgAr_Map_5.xml")); 
		BuildTree.buildTree(c, true);
		for(City k : c) {
			System.out.println(k.getName());
			System.out.println(k.getid());
			for(int i : k.getcoords()) {
				System.out.println(i);
			}
			for(Integer i : k.getlinkTo()) {
				System.out.println(i);
			}
			
			
		}
		
		
	}

}
