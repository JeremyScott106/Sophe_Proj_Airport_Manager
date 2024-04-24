package prob1;

import java.util.Comparator;

public class AirportStateComparator implements Comparator<Airport> {

	public int compare(Airport a1, Airport a2) {
		if (a1.getState().compareTo(a2.getState()) == 0) {
			return a1.getCity().compareTo(a2.getCity());
		}
		else
			return a1.getState().compareTo(a2.getState());
	}
	
}
