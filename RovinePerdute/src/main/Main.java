package main;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

import tree.BuildTree;

import xmlutilities.XMLWriter;


public class Main {

	

	
	public static void main(String[] args) {
		
		ArrayList<City> c = xmlutilities.ReadCities.readCities(new File("rovine_perdute_maps//test_file//PgAr_Map_12.xml")); 
				
		XMLWriter.XmlWrite(c);
			
			
		}
		
		
	}


