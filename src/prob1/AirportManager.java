package prob1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AirportManager extends DistanceCalculator {
	
	private Map<String,Airport> airports;
	
	public AirportManager(Map<String,Airport> airports) {
		this.airports = airports;
	}
	
	public Airport getAirport(String code) {
		return airports.get(code);
	}
	
	public Airport getAirportClosestTo(String code) {
		List<Airport> aps = getAirportsClosestTo(code, 1);
		if (aps != null)
			return getAirportsClosestTo(code, 1).get(0);
		return null;
	}
	
	public List<Airport> getAirportsClosestTo(String code, int num) {
		if (!airports.containsKey(code)) {
			System.out.println("Airport Code Not In System, Please Double Check Airport Code");
			return null;
		}
		if (this.getSize() < num) {
			num = airports.size()-1;
			System.out.printf("**Error** Only %d Airports Available To Return, Return Amount Changed\n", num);
		}
		Airport a1 = airports.get(code);
		Map<Double, Airport> byD = mapByDist(a1);
		List<Airport> result = new ArrayList<>();
		for (Airport a : byD.values()) {
			if (a.getCode().equals(code)) {
			}
			else if (num > 0) {
				result.add(a);
				num--;
			}
			else
				break;
		}
		return result;
	}

	public List<Airport> getAirportsByCity(String city){
		List<Airport> result = new ArrayList<>();
		for (Airport ap : airports.values()) {
			if (ap.getCity().equals(city))
				result.add(ap);
		}
		return result;
	}
	
	public List<Airport> getAirportsByCityState(String city,
            String state) {
		List<Airport> result = new ArrayList<>();
		for (Airport ap : airports.values()) {
			if (ap.getCity().equals(city) && ap.getState().equals(state))
				result.add(ap);
		}
		return result;
	}
	
	public List<Airport> getAirportsWithin(double withinDist, double lat, double lon) {
		Airport key = new Airport("ZZZ",lat,lon,"","");
		Map<Double, Airport> aps = mapByDist(key);
		List<Airport> result = new ArrayList<>();
		for (Airport a : aps.values()) {
			if (a.getCode().equals("ZZZ")) {
			}
			else if (getDistanceBetweenAirports(key, a) < withinDist) {
				result.add(a);
			}
			else
				break;
		}
		return result;
	}
	
	public List<Airport> getAirportsWithin(String code, double withinDist) {
		if (!airports.containsKey(code)) {
			return null;
		}
		Airport key = getAirport(code);
		Map<Double, Airport> aps = mapByDist(key);
		List<Airport> result = new ArrayList<>();
		for (Airport a : aps.values()) {
			if (a.getCode().equals(code)) {
			}
			else if (getDistanceBetweenAirports(key, a) < withinDist) {
				result.add(a);
			}
			else
				break;
		}
		return result;
	}
	
	public List<Airport> getAirportsWithin(String code1, String code2, double withinDist) {
		List<Airport> inRange1 = getAirportsWithin(code1, withinDist);
		List<Airport> inRangeBoth = new ArrayList<>();
		for (Airport a : inRange1) {
			if (a.getCode().equals(code2)) {
			}
			else if (getDistanceBetweenAirports(getAirport(code2), a) < withinDist) {
				inRangeBoth.add(a);
			}
		}
		return inRangeBoth;
	}
	
	public Map<Double, Airport> mapByDist(Airport ap) {
		Map<Double, Airport> result = new TreeMap<>();
		for (Airport a : airports.values()) { 
			double dist = getDistanceBetweenAirports(ap, a);
			result.put(dist, a);
		}
		return result;
	}
	
	public double getDistanceBetweenAirports(Airport a1, Airport a2) {
		double long1 = a1.getLongitude();
		double lat1 = a1.getLatitude();
		double long2 = a2.getLongitude();
		double lat2 = a2.getLatitude();
		return getDistance(lat1,long1,lat2,long2);
	}
	
	public double getDistanceBetweenAirports(String a1, String a2) {
		if (!airports.containsKey(a1) || !airports.containsKey(a2)) {
			System.out.println("One of the airports is not in the list, check your codes and try again.");
			return 0;
		}
		return getDistanceBetweenAirports(airports.get(a1), airports.get(a2));
	}
	
	public List<Airport> getAirportsSortedBy(String sortType) {
		List<Airport> result = new ArrayList<>(airports.values());	
		sortType = sortType.toLowerCase();
		if (sortType.equals("city"))
			Collections.sort(result, new AirportCityComparator());
		
		if (sortType.equals("state"))
			Collections.sort(result, new AirportStateComparator());
		
		return result;
	}
	
	public List<Airport> getNWSNamedAirports() {
		List<Airport> result = new ArrayList<>();
		for (Airport a : airports.values()) {
			String test = a.getCode().substring(2);
			if (test.equals("X")) {
				result.add(a);
			}
		}
		return result;
	}
	
	public int getSize() {
		if (this.airports != null) {
			return airports.size();
		}
		return 0;
	}
	
	@Override
	public String toString() {
		if (this.airports != null) {
			String report = "";
			report += String.format("Airport Manager Information\nTotal Airports: %d\nListed Below Are The Current Airports (Up To 25 Airports)\n", this.getSize());
			int i = 25;
			for (Airport a : airports.values()) {
				if (i <= 0) {
					break;
				}
				report += a.toString() + "\n";
				i--;
			}
			return report;
		}
		return "No Airport Manager Exist";
	}
	
	public void clearAll() {
		airports.clear();
	}
	
	public Airport getRandomAirport() {
		List<Airport> aps = new ArrayList<>(airports.values());
		int size = aps.size();
		int i = (int) (size*Math.random());
		return aps.get(i);
	}
}
