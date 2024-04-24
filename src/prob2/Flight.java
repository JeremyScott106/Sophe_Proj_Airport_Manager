package prob2;

import java.time.LocalDate;

import prob1.*;

public class Flight{
	
	private double cost;
	private LocalDate date;
	private Airport destination;
	private double distance;
	private String number;
	private Airport origin;
	
	
	public Flight(double cost, LocalDate date, Airport destination, String number, Airport origin) {
		this.cost = cost;
		this.date = date;
		this.destination = destination;
		this.number = number;
		this.origin = origin;
		this.distance = this.getDistanceBetween(origin, destination);
	}


	public double getCost() {
		return cost;
	}


	public LocalDate getDate() {
		return date;
	}


	public Airport getDestination() {
		return destination;
	}


	public double getDistance() {
		return distance;
	}


	public String getNumber() {
		return number;
	}


	public Airport getOrigin() {
		return origin;
	}

	public double getDistanceBetween(Airport a1, Airport a2) {
		double long1 = a1.getLongitude();
		double lat1 = a1.getLatitude();
		double long2 = a2.getLongitude();
		double lat2 = a2.getLatitude();
		return prob1.DistanceCalculator.getDistance(lat1,long1,lat2,long2);
	}
	
	@Override
	public String toString() {
		String report = "";
		report += String.format("  Flight: %s, Date: %s\n", this.getNumber(), this.getDate());
		report += String.format("    From: %s-%s, %s\n", this.getOrigin().getCode(), this.getOrigin().getCity(), this.getOrigin().getState());
		report += String.format("      To: %s-%s, %s\n", this.getDestination().getCode(), this.getDestination().getCity(), this.getDestination().getState());
		report += String.format("Distance: %,.0f miles, Cost: $%,.2f\n", this.getDistance(), this.getCost());
		return report;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Flight) {
			if (((Flight) o).getNumber() == this.getNumber()) {
				return (this.getDate().equals(((Flight) o).getDate()));
			}
			else
				return this.getNumber().equals(((Flight) o).getNumber());
		}
		return false;
	}
}
