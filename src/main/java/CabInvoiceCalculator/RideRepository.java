package CabInvoiceCalculator;

import java.util.HashMap;
import java.util.Map;

public class RideRepository {
	public Map<String, Ride[]> userRides = null;

	public RideRepository() {
		super();
		this.userRides = new HashMap<>();
	}

	public void addRides(String userId, Ride[] rides) {
		userRides.put(userId, rides);
	}

	public Ride[] getRidesData(String userId) {
		return userRides.get(userId);
	}
}
