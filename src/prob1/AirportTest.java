package prob1;

public class AirportTest {
	public static void main(String[] args) {
		createAirportTest();
		getAirportCityTest();
		getAirportCodeTest();
		getAirportLatTest();
		getAirportLongTest();
		getAirportStateTest();
		testAiportEquals();
	}
	
	/**
	 * Creates an airport and checks creation status using the toString method
	 */
	public static void createAirportTest() {
		System.out.println("**Start createAirportTest()**\n--------------------");
		
		Airport a1 = new Airport("STL", 38.7499, 90.3748, "St. Louis", "MO");
		System.out.println("\tTesting Airport(\"STL\", 38.7499, 90.3748, \"St. Louis\", \"MO\")");
		System.out.println("\t\tExpected Result: (STL-St. Louis, MO:  38.7,  90.4)");
		System.out.println("\t\tActual Result:   " + a1);
		
		Airport a2 = new Airport("ANB", 33.6, 85.9, "Anniston", "AL");
		System.out.println("\tTesting Airport(\"ANB\", 33.6, 85.9, \"Anniston\", \"AL\")");
		System.out.println("\t\tExpected Result: (ANB-Anniston, AL:  33.6,  85.9)");
		System.out.println("\t\tActual Result:   " + a2);
	}
	
	public static void getAirportCityTest() {
		System.out.println("\n**Start getAirportCityTest()**\n--------------------");
		Airport a1 = new Airport("STL", 38.7499, 90.3748, "St. Louis", "MO");
		System.out.println("\tTesting a1.getCity with Airport(\"STL\", 38.7499, 90.3748, \"St. Louis\", \"MO\")");
		System.out.println("\t\tExpected Result: St. Louis");
		System.out.println("\t\tActual Result:   " + a1.getCity());
		
		Airport a2 = new Airport("ANB", 33.6, 85.9, "Anniston", "AL");
		System.out.println("\tTesting a2.getCity with Airport(\"ANB\", 33.6, 85.9, \"Anniston\", \"AL\")");
		System.out.println("\t\tExpected Result: Anniston");
		System.out.println("\t\tActual Result:   " + a2.getCity());
	}
	
	public static void getAirportCodeTest() {
		System.out.println("**Start getAirportCodeTest()**\n--------------------");
		Airport a1 = new Airport("STL", 38.7499, 90.3748, "St. Louis", "MO");
		System.out.println("\tTesting a1.getCode with Airport(\"STL\", 38.7499, 90.3748, \"St. Louis\", \"MO\")");
		System.out.println("\t\tExpected Result: STL");
		System.out.println("\t\tActual Result:   " + a1.getCode());
		
		Airport a2 = new Airport("ANB", 33.6, 85.9, "Anniston", "AL");
		System.out.println("\tTesting a2.getCode with Airport(\"ANB\", 33.6, 85.9, \"Anniston\", \"AL\")");
		System.out.println("\t\tExpected Result: ANB");
		System.out.println("\t\tActual Result:   " + a2.getCode());
	}
	
	public static void getAirportLatTest() {
		System.out.println("\n**Start getAirportLatTest()**\n--------------------");
		Airport a1 = new Airport("STL", 38.7499, 90.3748, "St. Louis", "MO");
		System.out.println("\tTesting a1.getLatitude with Airport(\"STL\", 38.7499, 90.3748, \"St. Louis\", \"MO\")");
		System.out.println("\t\tExpected Result: 38.7499");
		System.out.println("\t\tActual Result:   " + a1.getLatitude());
		
		Airport a2 = new Airport("ANB", 33.6, 85.9, "Anniston", "AL");
		System.out.println("\tTesting a2.getLatitude with Airport(\"ANB\", 33.6, 85.9, \"Anniston\", \"AL\")");
		System.out.println("\t\tExpected Result: 33.6");
		System.out.println("\t\tActual Result:   " + a2.getLatitude());
	}
	
	public static void getAirportLongTest() {
		System.out.println("\n**Start getAirportLongTest()**\n--------------------");
		Airport a1 = new Airport("STL", 38.7499, 90.3748, "St. Louis", "MO");
		System.out.println("\tTesting a1.getLongitude with Airport(\"STL\", 38.7499, 90.3748, \"St. Louis\", \"MO\")");
		System.out.println("\t\tExpected Result: 90.3748");
		System.out.println("\t\tActual Result:   " + a1.getLongitude());
		
		Airport a2 = new Airport("ANB", 33.6, 85.9, "Anniston", "AL");
		System.out.println("\tTesting a2.getLongitude with Airport(\"ANB\", 33.6, 85.9, \"Anniston\", \"AL\")");
		System.out.println("\t\tExpected Result: 85.9");
		System.out.println("\t\tActual Result:   " + a2.getLongitude());
	}
	
	public static void getAirportStateTest() {
		System.out.println("\n**Start getAirportStateTest()**\n--------------------");
		Airport a1 = new Airport("STL", 38.7499, 90.3748, "St. Louis", "MO");
		System.out.println("\tTesting a1.getState with Airport(\"STL\", 38.7499, 90.3748, \"St. Louis\", \"MO\")");
		System.out.println("\t\tExpected Result: MO");
		System.out.println("\t\tActual Result:   " + a1.getState());
		
		Airport a2 = new Airport("ANB", 33.6, 85.9, "Anniston", "AL");
		System.out.println("\tTesting a2.getState with Airport(\"ANB\", 33.6, 85.9, \"Anniston\", \"AL\")");
		System.out.println("\t\tExpected Result: AL");
		System.out.println("\t\tActual Result:   " + a2.getState());
	}
	
	public static void testAiportEquals() {
		System.out.println("**Start testAiportEquals()**\n--------------------");
		Airport a1 = new Airport("STL", 38.7499, 90.3748, "St. Louis", "MO");
		Airport a2 = new Airport("ANB", 33.6, 85.9, "Anniston", "AL");
		Airport a3 = new Airport("STL");
		Airport a4 = new Airport("ANB");
		System.out.println("\ta1 = " + a1);
		System.out.println("\ta2 = " + a2);
		System.out.println("\ta3 = " + a3);
		System.out.println("\ta4 = " + a4);
		
		boolean result1 = (a1.equals(a3));
		System.out.println("\tTesting a1.equals(a3)");
		System.out.println("\t\tExpected Result: true");
		System.out.println("\t\tActual Result:   " + result1);
		
		boolean result2 = (a1.equals(a4));
		System.out.println("\tTesting a1.equals(a4)");
		System.out.println("\t\tExpected Result: false");
		System.out.println("\t\tActual Result:   " + result2);
		
		boolean result3 = (a2.equals(a3));
		System.out.println("\tTesting a2.equals(a3)");
		System.out.println("\t\tExpected Result: false");
		System.out.println("\t\tActual Result:   " + result3);
		
		boolean result4 = (a2.equals(a4));
		System.out.println("\tTesting a2.equals(a4)");
		System.out.println("\t\tExpected Result: true");
		System.out.println("\t\tActual Result:   " + result4);
		
		System.out.println();
	}
}
