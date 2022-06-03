package main;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

import tree.BuildTree;

import xmlutilities.XMLWriter;


public class Main {

	

	public static void main(String[] args) {
		
		ArrayList<City> c = xmlutilities.ReadCities.readCities(new File("rovine_perdute_maps//test_file//PgAr_Map_5.xml")); 
		LinkedList<City> tree_T = BuildTree.buildTree(c, true);
		LinkedList<City> tree_M = BuildTree.buildTree(c, false);		
		XMLWriter.XmlWrite(tree_T, tree_M);
			
			
		}
		
		
	}


