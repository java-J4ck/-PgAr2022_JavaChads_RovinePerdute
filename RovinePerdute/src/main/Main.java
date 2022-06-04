package main;

import java.io.File;
import java.util.ArrayList;

import xmlutilities.XMLWriter;


public class Main {

	private static final String[] voci= {"5","12","50","200","2000","10000"};

	
	public static void main(String[] args) {
		//menu di scelta della mappa
		MyMenu choseFile = new MyMenu("scegli il tipo di mappa in base al numero di citta",voci);
		String cityNumber;
		
		int choice=choseFile.scegli();//menu di scelta mappa
		
		switch(choice) {//scelta mappa in base al numero di citta
			case 0:
				System.out.println("Grazie per aver usato il programma");
				System.exit(0);
			case 1:
				cityNumber="5";
				break;
			case 2:
				cityNumber="12";
				break;
			case 3:
				cityNumber="50";
				break;
			case 4:
				cityNumber="200";
				break;
			case 5:
				cityNumber="2000";
				break;
			case 6:
				cityNumber="10000";
				break;
			default: 
				cityNumber="5";
				
		}
		//lettura dal file
		ArrayList<City> c = xmlutilities.ReadCities.readCities(new File("rovine_perdute_maps//test_file//PgAr_Map_" + cityNumber+ ".xml")); 
		//scrittura del file		
		XMLWriter.XmlWrite(c);
		System.out.println("Grazie per aver usato il programma");	
			
	 }
		
		
}


