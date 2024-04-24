package prob1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class AirportLoader {

	public AirportLoader() {
	}
	
	public static Map<String, Airport> getAirportMap(File file){
		try {
			Scanner input = new Scanner(file);
			ArrayList<String> airportLines = new ArrayList<>();
			while (input.hasNext()) {
				airportLines.add(input.nextLine());
			}
			input.close();
			Map<String, Airport> result = arrToMap(airportLines);
			return result;
		}
		catch (IOException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public static Map<String, Airport> arrToMap(ArrayList<String> arr) {
		Map<String, Airport> result = new TreeMap<>();
		
		for (String s : arr) {
			String[] apText = s.split("\t");
			
			String code = apText[0];
			double latitude  = Double.parseDouble(apText[1]);
			double longitude = Double.parseDouble(apText[2]);
			String city = apText[3];
			String state = apText[4];
			
			Airport toMap = new Airport(code, latitude, longitude, city, state);
			result.put(code, toMap);
		}
		
		return result;
	}
}
