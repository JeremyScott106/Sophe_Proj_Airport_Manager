package prob1;

public class Airport {
	private String city;
	private String code;
	private double latitude;
	private double longitude;
	private String state;
	
	protected Airport(String code) {
		this(code,0.0,0.0,"","");
	}
	
	public Airport(String code, double latitude, double longitude, String city, String state) {
		this.code = code;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public String getCode() {
		return code;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public String getState() {
		return state;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean result = false;
		if (o instanceof Airport) {
			Airport aaa = (Airport) o;
			if (aaa.getCode().equals(this.getCode()))
				result = true;
		}
		return result;
	}
	
	public String toString() {
		return String.format("(%s-%s, %s:  %.1f,  %.1f)",code,city,state,latitude,longitude);
	}

}
