package prob2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import prob1.*;



public class FlightManager {
	
	private AirportManager airportManager;
	private Map<String, Flight> flights;
	
	public FlightManager(AirportManager ap) {
		this.airportManager = ap; 
		this.flights = new TreeMap<String, Flight>();
	}
	
	public boolean addFlight(Flight flight) {
		boolean result = true;
		String key = flight.getDate() + ":" + flight.getNumber(); 			// Add Date to this?????? //
		if (flights.containsKey(key)) 
			result = false;
		flights.put(key, flight);
		return result;
	}
	
	public AirportManager getAirportManager() {
		return airportManager;
	}

	@SuppressWarnings("finally")
	public boolean addFlight(String number, String date, String originCode, String destinationCode, double cost) {
		boolean result = false;
		try {
			Airport destination = airportManager.getAirport(destinationCode);
			Airport origin = airportManager.getAirport(originCode);
			LocalDate newDate = LocalDate.parse(date);
			Flight f1 = new Flight(cost, newDate, destination, number, origin);
			result = addFlight(f1);
		}catch (Exception e) {
			System.out.println(e);
		}finally {
		return result;	
		}
	}
	
	public Flight getFlight(String key) {
		
		return flights.get(key);
	}
	
	public List<Flight> getFlightsByOrigin(String originCode) {
		List<Flight> result = new ArrayList<>();
		for (Flight a : flights.values()) {
			if (a.getOrigin().getCode().equals(originCode)) {
				result.add(a);
			}
		}
		return result;
	}
	
	public List<Flight> getFlightsByOrigin(String originCode, String date) {
		List<Flight> result = new ArrayList<>();
		LocalDate date2 = LocalDate.parse(date);
		for (Flight a : flights.values()) {
			if (a.getOrigin().getCode().equals(originCode) && a.getDate().compareTo(date2)==0) {
				result.add(a);
			}
		}
		return result;
	}
	
	public List<Flight> getFlightsByOriginAndDestination(String originCode, String destinationCode, String date) {
		List<Flight> result = new ArrayList<>();
		LocalDate date2 = LocalDate.parse(date);
		for (Flight a : flights.values()) {
			if (a.getOrigin().getCode().equals(originCode) && a.getDestination().getCode().equals(destinationCode) && a.getDate().compareTo(date2)==0) {
				result.add(a);
			}
		}
		return result;
	}
	
	public int getNumFlights() {
		return flights.size();
	}
	
	public Flight removeFlight(String key) {
		return flights.remove(key);
	}
	
	@Override
	public String toString() {
		String report = "";
		report += String.format("Flight Manager\nNumber of Flights: %d\nFlights Available: \n\t", this.getNumFlights());
		for (Flight f : flights.values()) {
			report += f.getNumber() + ", ";
		}
		return report;
	}

}
