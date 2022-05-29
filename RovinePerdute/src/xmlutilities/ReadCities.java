package xmlutilities;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.*;



public class ReadCities {

	private static Pattern idPattern = Pattern.compile(".id : ([0-9]+)");
	
		
	public static void readCities() {
		
		/*TEST*/
		File map = new File("rovine_perdute_maps//test_file//PgAr_Map_10000.xml");
		
		XMLReader r = new XMLReader(map);
		
		String last = r.readNext();
		
		Matcher m;
		ArrayList<String> i = new ArrayList<>();
		
		while(!last.contains("closed")) {
			
			m = idPattern.matcher(last);
			if(m.find()) {
				i.add(m.group());
			}
			
			last = r.readNext();
		}
		
		for(String s : i) {
			System.out.println(s);
		}
		
		
		
		
		
		
		
	}
	
	
	
	
}
