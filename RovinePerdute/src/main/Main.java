package main;

import java.io.File;
import java.util.ArrayList;



public class Main {

	public static void main(String[] args) {
		
		ArrayList<City> c = xmlutilities.ReadCities.readCities(new File("rovine_perdute_maps//test_file//PgAr_Map_10000.xml")); 

		/**
		for(City k : c) {
			System.out.println(k.getName());
			System.out.println(k.getId());
			for(int i : k.getCoords()) {
				System.out.println(i);
			}
			for(Integer i : k.getLinkTo()) {
				System.out.println(i);
			}
			
			
		}
		*/
		
	}

}
