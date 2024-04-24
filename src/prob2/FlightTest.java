package prob2;

import java.time.LocalDate;

import prob1.Airport;

public class FlightTest {
	
	public static void main(String args[]) {
		testConstructorAndToString();
	}
	
	/**
	 * This test will test all methods in Flight at the same time, I know it is not preferred
	 * but the constructor requires all other methods to be working first.
	 * toString will make sure all the getMethods work properly
	 */
	public static void testConstructorAndToString() {
		System.out.println("**Start testConstructorAndToString()**\n--------------------");
		System.out.println("-->Testing Constructor using helper method createFlight1()\n-->Then using toString to show results");
		Flight test = createFlight1();
		System.out.println(test.toString().indent(8));
		System.out.println("-->Testing Constructor using helper method createFlight2()\n-->Then using toString to show results");
		Flight test2 = createFlight2();
		System.out.println(test2.toString().indent(8));
	}
	
	public static Flight createFlight1() {
				
		double cost = 150.0;
		int day = LocalDate.now().getDayOfMonth();
		int month = LocalDate.now().getMonthValue();
		int year = LocalDate.now().getYear();
		LocalDate date = LocalDate.of(year, month, day);
		Airport a1 = new Airport("HSV", 34.65, 86.77, "Huntsville", "AL");
		Airport a2 = new Airport("MXF", 32.38, 86.37, "MaxwellAFB", "AL");	
		
		Flight result = new Flight(cost, date, a1, "1", a2);
		
		return result;
	}
	
	public static Flight createFlight2() {
		
		double cost = 1550.0;
		int day = LocalDate.now().getDayOfMonth();
		int month = LocalDate.now().getMonthValue();
		int year = LocalDate.now().getYear();
		LocalDate date = LocalDate.of(year, month, day);
		date = date.minusDays(3);
		Airport a1 = new Airport("ANC", 61.17, 150.02, "Anchorage", "AK");
		Airport a2 = new Airport("MXF", 32.38, 86.37, "MaxwellAFB", "AL");	
		
		Flight result = new Flight(cost, date, a1, "2", a2);
		
		return result;
	}
	
}