package xmlutilities;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.*;

import main.City;



public class ReadCities {

	//private static Pattern idPattern = Pattern.compile(".Attribute id : ([0-9]+)");
	//private static Pattern namePattern = Pattern.compile(".Attribute name : ([a-zA-Z\s]+)\n");
	//private static Pattern xPattern = Pattern.compile(".Attribute x : ([0-9]+)");
	//private static Pattern yPattern = Pattern.compile(".Attribute y : ([0-9]+)");
	//private static Pattern hPattern = Pattern.compile(".Attribute h : ([0-9]+)");
	private static Pattern cityAttributesPattern = Pattern.compile(".Attribute id : ([0-9]+)\n"
																   + "|.Attribute name : (.+)\n"
																   + "|.Attribute x : ([0-9]+)\n"
																   + "|.Attribute y : ([0-9]+)\n"
																   + "|.Attribute h : ([0-9]+)");
	private static Pattern toPattern = Pattern.compile(".Attribute to : ([0-9]+)");
	
	
		
	public static ArrayList<City> readCities(File map) {
		
		//File map = new File("rovine_perdute_maps//test_file//PgAr_Map_5.xml");
		
		XMLReader r = new XMLReader(map);
		
		ArrayList<City> cities = new ArrayList<>();
		
		int id = 0;
		String name = "";
		int[] coords = new int[3];
		ArrayList<Integer> linkTo = new ArrayList<>();
		
		String last = r.readNext();
		System.out.println(last);
		
		Matcher matcher;
		
		while(!last.contains("closed")) {
			
			if(last.contains("Tag : city") & !last.contains("End")) {
					matcher = cityAttributesPattern.matcher(last);
					for(int i=1; i<=matcher.groupCount(); i++) {
						if(matcher.find()) {
							switch(i) {
								case 1: 
									id = Integer.parseInt(matcher.group(1));
									break;
								case 2: 
									name = matcher.group(2);
									break;
								case 3: 
									coords[0] = Integer.parseInt(matcher.group(3));
									break;
								case 4: 
									coords[1] = Integer.parseInt(matcher.group(4));
									break;
								case 5: 
									coords[2] = Integer.parseInt(matcher.group(5));
									break;
							}							
						}
					}
			}
			
			else if(last.contains("Tag : link") & !last.contains("End")) {
				matcher = toPattern.matcher(last);
				if(matcher.find()) {
					linkTo.add(Integer.parseInt(matcher.group(1)));
				}
				
			}
			
			else if(last.contains("End-Tag : city")) {
				cities.add(new City(name, id, Arrays.copyOf(coords, coords.length), linkTo));
				linkTo = new ArrayList<>();
			}
			
			
			last = r.readNext();
		}
		
		return cities;
		

	}
	
	
	
	
}
