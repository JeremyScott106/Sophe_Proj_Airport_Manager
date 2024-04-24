package prob1;

import java.io.File;
import java.util.*;

public class AirportManagerTest {
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

		testAirportManagerConstructor();
		testAirportClosestTo();
		testGetAirport();
		testGetAirportsByCity();
		testGetAirportsByCityState();
		testGetAirportClosestTo();
		testGetAirportsClosestTo();
		testGetAirportsWithinDDD();
		testGetAirportsWithinSD();
		testGetAirportsWithinSSD();
		testGetAirportsSortedBy();
		testGetDistanceBetweenAA();
		testGetDistanceBetweenSS();
		testGetNWSNamedAirports();
	}
	
	public static AirportManager createAirportManagerAll() {
		System.out.println("--Created Map Using AirportLoader, Loaded File airportsAllFile--");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager mm = new AirportManager(airports);
		return mm;
	}
	
	public static AirportManager createAirportManagerSmall() {
		System.out.println("--Created Map Using AirportLoader, Loaded File airportsSmallFile--");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager mm = new AirportManager(airports);
		return mm;
	}
	
	public static AirportManager createAirportManagerMed() {
		System.out.println("--Created Map Using AirportLoader, Loaded File airportsMediumFile--");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsMediumFile);
		AirportManager mm = new AirportManager(airports);
		return mm;
	}
	
	public static AirportManager createAirportManagerSameCities() {
		System.out.println("--Created Map Using AirportLoader, Loaded File airportsSameCitiesFile--");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSameCitiesFile);
		AirportManager mm = new AirportManager(airports);
		return mm;
	}
	
	public static void testAirportManagerConstructor() {
		System.out.println("**Start testAirportManagerConstructor()**\n--------------------");
		System.out.println("Creating Map Using AirportLoader, Loaded File airportsAllFile");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		System.out.println("Using \"airports\" Map to create a AirportManager");
		AirportManager mm = new AirportManager(null);
		System.out.println("-->Before Loading Constructor mm.toString()\n" + mm.toString().indent(16));
				mm = new AirportManager(airports);
		System.out.println("-->After Loading Constructor mm.toString()\n" + mm.toString().indent(16));	
	}
	
	public static void testAirportClosestTo() {
		System.out.println("\n**Start testAirportClosestTo()**\n--------------------");
		
		System.out.println("-->Test 1 Using airportsSmallFile: test AirportClosestTo(\"VLD\")");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager mm = new AirportManager(airports);
		Airport test = mm.getAirportClosestTo("VLD");
		System.out.println("\tExpected Result: (CSG-Columbus, GA:  32.5,  84.9)\n\tActual Result:   " + test);
		
		System.out.println("-->Test 2 Using airportsSameCitiesFile: test AirportClosestTo(\"ALB\")");
		Map<String,Airport> airports2 = AirportLoader.getAirportMap(airportsSameCitiesFile);
		AirportManager mm2 = new AirportManager(airports2);
		Airport test2 = mm2.getAirportClosestTo("ALB");
		System.out.println("\tExpected Result: (BTV-Burlington, VT:  44.5,  73.2)\n\tActual Result:   " + test2);
		
		System.out.println("-->Test 3 Using airportsAllFile to check for lag: test AirportClosestTo(\"RBD\")");
		Map<String,Airport> airports3 = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager mm3 = new AirportManager(airports3);
		Airport test3 = mm3.getAirportClosestTo("RBD");
		System.out.println("\tExpected Result: (NBE-DallasNAS, TX:  32.7,  97.0)\n\tActual Result:   " + test3);
	}
	
	public static void testGetAirport() {
		System.out.println("\n**Start testGetAirport()**\n--------------------");
		
		System.out.println("-->Testing with airportsMediumFileName: test getAirport(\"VLD\")");
		Map<String,Airport> airports1 = AirportLoader.getAirportMap(airportsMediumFile);
		AirportManager mm1 = new AirportManager(airports1);
		Airport test1 = mm1.getAirport("VLD");
		System.out.println("\tExpected Result: (VLD-Valdosta, GA:  30.8,  83.3)\n\tActual Result:   " + test1);
		
		System.out.println("-->Testing with airportsMediumFileName: test getAirport(\"PNS\")");
		test1 = mm1.getAirport("PNS");
		System.out.println("\tExpected Result: (PNS-Pensacola, FL:  30.5,  87.2)\n\tActual Result:   " + test1);
	}
	
	public static void testGetAirportsByCity() {
		System.out.println("\n**Start testGetAirportsByCity()**\n--------------------");
		System.out.println("\tCreating Map Using AirportLoader, Loaded File airportsAllFile");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager mm = new AirportManager(airports);
		
		List<Airport> aps = mm.getAirportsByCity("LittleRock");
		System.out.println("-->Testing mm.getAirportsByCity(\"LittleRock\")\n\tExpected Results: "
				+ "[(LIT-LittleRock, AR:  35.2,  92.4), (LRF-LittleRock, AR:  34.9,  92.2), (LZK-LittleRock, AR:  34.8,  92.3)]"
				+ "\n\tActual Result:    " + aps);
		
		aps = mm.getAirportsByCity("WilliamsAFB");
		System.out.println("-->Testing mm.getAirportsByCity(\"WilliamsAFB\")\n\tExpected Results: "
				+ "[(CHD-WilliamsAFB, AZ:  33.3,  111.7)]"
				+ "\n\tActual Result:    " + aps);

	}
	
	public static void testGetAirportsByCityState() {
		System.out.println("\n**Start testGetAirportsByCityState()**\n--------------------");
		System.out.println("\tCreating Map Using AirportLoader, Loaded File airportsAllFile");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager mm = new AirportManager(airports);
		
		List<Airport> aps = mm.getAirportsByCityState("Springfield", "MO");
		System.out.println("-->Testing mm.getAirportsByCityState(\"Springfield\", \"MO\")\n\tExpected Results: "
				+ "[(SGF-Springfield, MO:  37.2,  93.4)]"
				+ "\n\tActual Result:    " + aps);
		
		aps = mm.getAirportsByCityState("Charleston", "WV");
		System.out.println("-->Testing mm.getAirportsByCityState(\"Charleston\", \"WV\")\n\tExpected Results: "
				+ "[(CRW-Charleston, WV:  38.4,  81.6)]"
				+ "\n\tActual Result:    " + aps);
	}
	
	public static void testGetAirportsClosestTo() {
		System.out.println("\n**Start testGetAirportsClosestTo()**\n--------------------");
		System.out.println("Creating Map Using AirportLoader, Loaded File airportsAllFile");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsAllFile);
		AirportManager mm = new AirportManager(airports);
		System.out.println("-->Testing mm.getAirportsClosestTo(\"DAL\", 7)");
		List<Airport> result = mm.getAirportsClosestTo("DAL", 7);
		for (Airport a : result) {
			System.out.println("\t" + a +"\tDistance Between Airports : " + mm.getDistanceBetweenAirports(mm.getAirport("DAL"), a));
		}
		
		System.out.println("-->Testing mm.getAirportsClosestTo(\"STL\", 7)");
		List<Airport> result2 = mm.getAirportsClosestTo("STL", 7);
		for (Airport a : result2) {
			System.out.println("\t" + a +"\tDistance Between Airports : " + mm.getDistanceBetweenAirports(mm.getAirport("STL"), a));
		}
		
		System.out.println("-->Testing mm.getAirportsClosestTo(\"JFK\", 4)");
		List<Airport> result3 = mm.getAirportsClosestTo("JFK", 4);
		for (Airport a : result3) {
			System.out.println("\t" + a +"\tDistance Between Airports : " + mm.getDistanceBetweenAirports(mm.getAirport("JFK"), a));
		}
		
		airports.clear();
		airports = AirportLoader.getAirportMap(airportsSmallFile);
		mm = new AirportManager(airports);
		System.out.println("-->Testing Non-Existant Aiport Code, mm.getAirportsClosestTo(\"JFK\", 7)");
		System.out.print("\tExpected Result: Airport Code Not In System, Please Double Check Airport Code"
				+ "\n\tAcutal Result:   ");
		List<Airport> result4 = mm.getAirportsClosestTo("JFK", 7);
		
		System.out.println("-->Testing Too Many Airports, mm.getAirportsClosestTo(\"VLD\", 7)");

		result4 = mm.getAirportsClosestTo("VLD", 7);
		for (Airport a : result4) {
			System.out.println("\t" + a +"\tDistance Between Airports : " + mm.getDistanceBetweenAirports(mm.getAirport("VLD"), a));
		}
	}

	public static void testGetAirportClosestTo() {
		System.out.println("**Start testGetAirportClosestTo()**\n--------------------");
		System.out.println("Creating Map Using AirportLoader, Loaded File airportsSmallFile");
		Map<String,Airport> airports = AirportLoader.getAirportMap(airportsSmallFile);
		AirportManager mm = new AirportManager(airports);
		Airport result = mm.getAirportClosestTo("CSG");
		System.out.println("-->Testing mm.testGetAirportClosestTo(\"CSG\")"
				+ "\n\tExpected Results: (MXF-MaxwellAFB, AL:  32.4,  86.4)"
				+ "\n\tActual Result:    " + result);
		
		
		System.out.println("-->Testing mm.testGetAirportClosestTo(\"XDD\")");
		result = mm.getAirportClosestTo("XDD");
		System.out.println("\tExpected Results: null"
				+ "\n\tActual Result:    " + result);
	}
	
	public static void testGetAirportsWithinDDD() {
		System.out.println("\n**Start testGetAirportsWithinDDD()**\n--------------------");
		AirportManager mm = createAirportManagerAll();
		
		System.out.println("-->Testing mm.testGetAirportsWithin(30.0, 32.85, 96.85)");
		List<Airport> result1 = mm.getAirportsWithin(30.0, 32.85, 96.85);
		for (Airport a : result1) {
			System.out.println("\t" + a);
		}
		
		System.out.println("-->Testing mm.testGetAirportsWithin(5.0, 32.85, 96.85)");
		List<Airport> result2 = mm.getAirportsWithin(5.0, 32.85, 96.85);
		for (Airport a : result2) {
			System.out.println("\t" + a);
		}
	}
	
	public static void testGetAirportsWithinSD() {
		System.out.println("\n**Start testGetAirportsWithinSD()**\n--------------------");
		AirportManager mm = createAirportManagerAll();
		System.out.println("-->Testing mm.getAirportsWithin(\"STL\", 50.0)");
		List<Airport> result1 = mm.getAirportsWithin("STL", 50.0);
		System.out.println("Results: ");
		for (Airport a : result1) {
			System.out.println("\t" + a);
		}
		
		System.out.println("-->Testing mm.getAirportsWithin(\"STL\", 100.0)");
		result1 = mm.getAirportsWithin("STL", 100.0);
		System.out.println("Results: ");
		for (Airport a : result1) {
			System.out.println("\t" + a);
		}
		
		System.out.println("-->Testing mm.getAirportsWithin(\"STL\", 150.0)");
		result1 = mm.getAirportsWithin("STL", 150.0);
		System.out.println("Results: ");
		for (Airport a : result1) {
			System.out.println("\t" + a);
		}
	}
	
	public static void testGetAirportsWithinSSD() {
		System.out.println("\n**Start testGetAirportsWithinSSD()**\n--------------------");
		AirportManager mm = createAirportManagerAll();
		
		System.out.println("-->Testing mm.getAirportsWithin(\"STL\", \"VLD\", 350.0)");
		List<Airport> result1 = mm.getAirportsWithin("STL", "VLD", 350.0);
		System.out.println("Results: ");
		for (Airport a : result1) {
			System.out.println("\t" + a);
		}
		
		System.out.println("-->Testing mm.getAirportsWithin(\"PNS\", \"VLD\", 50.0)");
		result1 = mm.getAirportsWithin("PNS", "VLD", 50.0);
		System.out.println("Results: ");
		for (Airport a : result1) {
			System.out.println("\t" + a);
		}
		
		System.out.println("-->Testing mm.getAirportsWithin(\"PNS\", \"VLD\", 100.0)");
		result1 = mm.getAirportsWithin("PNS", "VLD", 100.0);
		System.out.println("Results: ");
		for (Airport a : result1) {
			System.out.println("\t" + a);
		}
		
		System.out.println("-->Testing mm.getAirportsWithin(\"PNS\", \"VLD\", 150.0)");
		result1 = mm.getAirportsWithin("PNS", "VLD", 150.0);
		System.out.println("Results: ");
		for (Airport a : result1) {
			System.out.println("\t" + a);
		}

	}

	public static void testGetAirportsSortedBy() {
		System.out.println("\n**Start testGetAirportsSortedBy()**\n--------------------");
		AirportManager mm = createAirportManagerMed();
		System.out.println("\n-->Testing testGetAirportsSortedBy()");
		System.out.println("\tCurrent Airport Manager");
		System.out.print(mm.toString().indent(16));
		System.out.println("\tCalling getAirportsSortedBy(\"City\")\n\tResults:");
		List<Airport> result = mm.getAirportsSortedBy("City");
		for (Airport a : result) {
			System.out.print(a.toString().indent(16));
		}
		
		System.out.println("\n\tCalling getAirportsSortedBy(\"State\")\n\tResults:");
		result = mm.getAirportsSortedBy("State");
		for (Airport a : result) {
			System.out.print(a.toString().indent(16));
		}		
	}

	public static void testGetDistanceBetweenAA() {
		System.out.println("\n**Start testGetDistanceBetweenAA()**\n--------------------");
		AirportManager mm = createAirportManagerAll();
		System.out.printf("\n-->Testing getDistanceBetweenAirports(mm.getAirport(\"VLD\"), mm.getAirport(\"STL\"))"
				+ "\n\tExpected Result: 681.52"
				+ "\n\tActual Result:   %.2f", mm.getDistanceBetweenAirports(mm.getAirport("VLD"), mm.getAirport("STL")));
		System.out.printf("\n-->Testing getDistanceBetweenAirports(mm.getAirport(\"MML\"), mm.getAirport(\"DAB\"))"
				+ "\n\tExpected Result: 1329.89"
				+ "\n\tActual Result:   %.2f", mm.getDistanceBetweenAirports(mm.getAirport("MML"), mm.getAirport("DAB")));
		System.out.printf("\n-->Testing getDistanceBetweenAirports(mm.getAirport(\"LVM\"), mm.getAirport(\"TRK\"))"
				+ "\n\tExpected Result: 661.24"
				+ "\n\tActual Result:   %.2f", mm.getDistanceBetweenAirports(mm.getAirport("LVM"), mm.getAirport("TRK")));
		System.out.printf("\n-->Testing getDistanceBetweenAirports(mm.getAirport(\"VTN\"), mm.getAirport(\"BAL\"))"
				+ "\n\tExpected Result: 1266.07"
				+ "\n\tActual Result:   %.2f", mm.getDistanceBetweenAirports(mm.getAirport("VTN"), mm.getAirport("BAL")));
	}

	public static void testGetDistanceBetweenSS() {
		System.out.println("\n**Start testGetDistanceBetweenSS()**\n--------------------");
		AirportManager mm = createAirportManagerAll();
		System.out.printf("\n-->Testing getDistanceBetweenAirports(\"VLD\", \"STL\")"
				+ "\n\tExpected Result: 681.52"
				+ "\n\tActual Result:   %.2f", mm.getDistanceBetweenAirports("VLD", "STL"));
		System.out.printf("\n-->Testing getDistanceBetweenAirports(\"MML\", \"DAB\")"
				+ "\n\tExpected Result: 1329.89"
				+ "\n\tActual Result:   %.2f", mm.getDistanceBetweenAirports("MML", "DAB"));
		System.out.printf("\n-->Testing getDistanceBetweenAirports(\"LVM\", \"TRK\")"
				+ "\n\tExpected Result: 661.24"
				+ "\n\tActual Result:   %.2f", mm.getDistanceBetweenAirports("LVM", "TRK"));
		System.out.printf("\n-->Testing getDistanceBetweenAirports(\"VTN\", \"BAL\")"
				+ "\n\tExpected Result: 1266.07"
				+ "\n\tActual Result:   %.2f", mm.getDistanceBetweenAirports("VTN", "BAL"));
	}

	public static void testGetNWSNamedAirports() {
		System.out.println("\n**Start testGetNWSNamedAirports()**\n--------------------");
		AirportManager mm = createAirportManagerSmall();
		System.out.println("-->Testing mm.getNWSNamedAirports()"
				+ "\n\tExpected Result: "
				+ "\n\tActual Result:   ");
		List<Airport> result = mm.getNWSNamedAirports();
		for (Airport a : result) {
			System.out.println("\t" + a);
		}
		
		mm.clearAll();
		System.out.println();
		mm = createAirportManagerMed();
		System.out.println("-->Testing mm.getNWSNamedAirports()"
				+ "\n\tExpected Result: "
				+ "\n\t\t(JAX-Jacksonville, FL:  30.5,  81.7)"
				+ "\n\t\t(NQX-KeyWestNAS, FL:  24.6,  81.7)"
				+ "\n\t\t(TIX-Titusville, FL:  28.5,  80.8)"
				+ "\n\tActual Result:   ");
		result = mm.getNWSNamedAirports();
		for (Airport a : result) {
			System.out.println("\t\t" + a);
		}
		
		mm.clearAll();
		System.out.println();
		mm = createAirportManagerAll();
		System.out.println("-->Testing mm.getNWSNamedAirports()"
				+ "\n\tResults:   ");
		result = mm.getNWSNamedAirports();
		for (Airport a : result) {
			System.out.println("\t\t" + a);
		}
	}
}
