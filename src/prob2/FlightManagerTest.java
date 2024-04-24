package prob2;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import prob1.Airport;
import prob1.AirportLoader;
import prob1.AirportManager;

public class FlightManagerTest {
	
	static final String path = "src/prob1/";
	static final String airportsSmallFileName = path + "airportsSmall.txt";
	static final String airportsMediumFileName = path + "airportsMedium.txt";
	static final String airportsSameCitiesFileName = path + "airportsSameCities.txt";
	static final String airportsAllFileName = path + "airports.txt";
	static final File airportsSmallFile = new File(airportsSmallFileName);
	static final File airportsMediumFile = new File(airportsMediumFileName);
	static final File airportsSameCitiesFile = new File(airportsSameCitiesFileName);
	static final File airportsAllFile = new File(airportsAllFileName);
	
	public static void main(String[] args) {
		testConstructor();
		testAddFlightFLT();
		testAddFlightSSSSD();
		testGetFlight();
		testGetFlightsByOriginS();
		testGetFlightsByOriginSS();
		testGetFlightsByOriginAndDestination();
		testGetNumFlight();
		testRemoveFlight();
	}
	
	public static void testConstructor() {
		System.out.println("**Start testConstructor()**\n--------------------");
		FlightManager fm = createFlightManager();
		fm.getFlight("testing for error and to remove stupid yellow box");
		System.out.println("Test Complete");
	}
	
	public static void testAddFlightFLT() {
		System.out.println("\n**Start testAddFlight()**\n--------------------");
		FlightManager fm = createFlightManager();
		System.out.println("-->Testing Flight Manager's ability to add a new flight with a flight");
		System.out.println("\tNumber of Flights before add:\n\t\tExpected: 0\n\t\tActual:   " + fm.getNumFlights());
		fm.addFlight(createRandomFlt());
		System.out.println("\tNumber of Flights after add:\n\t\tExpected: 1\n\t\tActual:   " + fm.getNumFlights());
		fm.addFlight(createRandomFlt());
		System.out.println("\tNumber of Flights after second add:\n\t\tExpected: 2\n\t\tActual:   " + fm.getNumFlights());
	}
	
	public static void testAddFlightSSSSD() {
		System.out.println("\n**Start testAddFlightSSSSD()**\n--------------------");
		FlightManager fm = createFlightManager();
		String date1 = "2006-06-06";
		String fltNum = "1234";
		String oCode = "VLD";
		String dCode = "STL";
		double cost = 400.0;
		System.out.println("-->Testing adding a flight to Flight Manager using flight information instead of a flight");
		System.out.println("\tNumber of Flights before add:\n\t\tExpected: 0\n\t\tActual:   " + fm.getNumFlights());
		fm.addFlight(fltNum, date1, oCode, dCode, cost);
		System.out.println("\tNumber of Flights before add:\n\t\tExpected: 1\n\t\tActual:   " + fm.getNumFlights());
		System.out.println("-->Testing adding the exact same flight to Flight Manager, nothing should change");
		fm.addFlight(fltNum, date1, oCode, dCode, cost);
		System.out.println("\tNumber of Flights before add:\n\t\tExpected: 1\n\t\tActual:   " + fm.getNumFlights());
		
	}
	
	public static void testGetFlight() {
		System.out.println("\n**Start testGetFlight()**\n--------------------");
		FlightManager fm = createFlightManager();
		List<Flight> flightsToAdd = createRandomFlts(10, fm.getAirportManager());
		String fltNum = flightsToAdd.get(4).getDate() + ":" + flightsToAdd.get(4).getNumber();
		System.out.println("-->Created 10 Random Flights, Using Flight Number From Index (4)");
		for (Flight f : flightsToAdd) {
			fm.addFlight(f);
		}
		System.out.println(fm.toString().indent(8));
		System.out.printf("\tCalling fm.getFlight(\"%s\")\n", fltNum);
		System.out.println("\tResult: \n" + fm.getFlight(fltNum).toString().indent(16));
	}

	public static void testGetFlightsByOriginS() {
		System.out.println("\n**Start testGetFlightsByOriginS()**\n--------------------");
		FlightManager fm = createFlightManager2();
		List<Flight> fltsToAdd = createRandomFlts(1000, fm.getAirportManager());
		for (Flight f : fltsToAdd) {
			fm.addFlight(f);
		}
		System.out.println("\t\tADDED 1000 FLIGHTS\n\tCalling fm.getFlightsByOrigin(\"VLD\")\nResults:");
		List<Flight> results = fm.getFlightsByOrigin("VLD");
		for (Flight f : results) {
			System.out.println(f.toString().indent(8));
		}
		
	}
	
	public static void testGetFlightsByOriginSS() {
		System.out.println("\n**Start testGetFlightsByOriginSS()**\n--------------------");
		FlightManager fm = createFlightManager3();
		List<Flight> fltsToAdd = createRandomFlts(5000, fm.getAirportManager());
		for (Flight f : fltsToAdd) {
			fm.addFlight(f);
		}

		List<Flight> results = fm.getFlightsByOrigin("VLD");
		Flight fu = results.get(0);
		String date = fu.getDate().toString();
		System.out.printf("\t\tADDED 5000 FLIGHTS\n\tCalling fm.getFlightsByOrigin(\"VLD\", %s)\nResults:\n", date);
		List<Flight> results2 = fm.getFlightsByOrigin("VLD", date);
		for (Flight f : results2) {
			System.out.println(f.toString().indent(8));
		}
	}
	
	public static void testGetFlightsByOriginAndDestination() {
		System.out.println("\n**Start testGetFlightsByOriginAndDestination()**\n--------------------");
		FlightManager fm = createFlightManager3();
		List<Flight> fltsToAdd = createRandomFlts(10000, fm.getAirportManager());
		for (Flight f : fltsToAdd) {
			fm.addFlight(f);
		}

		List<Flight> results = fm.getFlightsByOrigin("VLD");
		Flight fu = results.get(0);
		String date = fu.getDate().toString();
		System.out.printf("\t\tADDED %d FLIGHTS\n\tCalling fm.getFlightsByOriginAndDestination(\"VLD\", \"CSG\", %s)\nResults:\n",fm.getNumFlights() , date);
		List<Flight> results2 = fm.getFlightsByOriginAndDestination("VLD", "CSG", date);
		for (Flight f : results2) {
			System.out.println(f.toString().indent(8));
		}
	}
	
	public static void testGetNumFlight() {
		System.out.println("\n**Start testGetNumFlight()**\n--------------------");
		FlightManager fm = createFlightManager();
		System.out.println("-->Attempting to create 10,000 flights");
		List<Flight> fltsToAdd = createRandomFlts(10000, fm.getAirportManager());
		for (Flight f : fltsToAdd) {
			fm.addFlight(f);
		}
		System.out.println("-->Testing fm.getNumFlights()\n\tExpected > 9900\n\tActual:   " + fm.getNumFlights());
	}
	
	public static void testRemoveFlight() {
		System.out.println("\n**Start testRemoveFlight()**\n--------------------");
		FlightManager fm = createFlightManager();
		System.out.println("-->Attempting to create 10,000 flights");
		List<Flight> fltsToAdd = createRandomFlts(10000, fm.getAirportManager());
		for (Flight f : fltsToAdd) {
			fm.addFlight(f);
		}
		System.out.println("-->Testing fm.RemoveFlight()\n\tFlight Count Before Removal: " + fm.getNumFlights());
		Flight f = fltsToAdd.get(4353);
		String key = f.getDate() + ":" + f.getNumber(); 
		fm.removeFlight(key);
		System.out.println("\tFlight Count Before Removal: " + fm.getNumFlights());
	}
	
	public static AirportManager createAirportManagerAll() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager am = new AirportManager(airports);
		return am;
	}
	
	public static AirportManager createAirportManagerMed() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsMediumFile);
		AirportManager am = new AirportManager(airports);
		return am;
	}
	
	public static AirportManager createAirportManagerSmall() {
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager am = new AirportManager(airports);
		return am;
	}
	
	public static FlightManager createFlightManager() {
		FlightManager fm = new FlightManager(createAirportManagerAll());
		return fm;
	}
	
	public static FlightManager createFlightManager2() {
		FlightManager fm = new FlightManager(createAirportManagerMed());
		return fm;
	}
	
	public static FlightManager createFlightManager3() {
		FlightManager fm = new FlightManager(createAirportManagerSmall());
		return fm;
	}

	public static Flight createRandomFlt() {
		String fltNum = "" + (int)(100 + 900*Math.random());
		AirportManager am = createAirportManagerAll();
		Airport o = am.getRandomAirport();
		Airport d = am.getRandomAirport();
		while (o.equals(d)) {
			d = am.getRandomAirport();
		}
		double cost = 23 + Math.round(am.getDistanceBetweenAirports(o, d)) + Math.round(am.getDistanceBetweenAirports(o, d))/100.0;
		int randDay = (int) (1+27*Math.random());
		int randMo = (int) (1+11*Math.random());
		int randYear = (int) (2000+22*Math.random());
		LocalDate date = LocalDate.of(randYear, randMo, randDay);
		
		Flight result = new Flight(cost, date, d, fltNum, o);
		return result;
	}
	
	public static List<Flight> createRandomFlts(int num, AirportManager am) {
		List<Flight> flights = new ArrayList<>();
		for (int i = num; i > 0; i--) {
			String fltNum = "" + (int)(100 + 9899*Math.random());
			Airport o = am.getRandomAirport();
			Airport d = am.getRandomAirport();
			while (o.equals(d)) {
				d = am.getRandomAirport();
			}
			double cost = 23 + Math.round(am.getDistanceBetweenAirports(o, d)) + Math.round(am.getDistanceBetweenAirports(o, d))/100.0;
			int randDay = (int) (1+27*Math.random());
			int randMo = (int) (1+11*Math.random());
			int randYear = 2022;
			LocalDate date = LocalDate.of(randYear, randMo, randDay);
			
			Flight result = new Flight(cost, date, d, fltNum, o);
			flights.add(result);
		}
		return flights;
	}
}
