package CabInvoiceCalculator;

import CabInvoiceCalculator.Ride.TYPE;

public class InvoiceService {
	private static final int COST_PER_TIME = 1;
	private static final int COST_PER_TIME_PREMIUM = 2;
	private static final double MINIMUM_FARE = 5;
	private static final double MINIMUM_FARE_PREMIUM = 20;
	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private static final double MINIMUM_COST_PER_KILOMETER_PREMIUM = 15;

	private RideRepository rideRepository = new RideRepository();

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(MINIMUM_FARE, totalFare);
	}

	public double calculateFareForPremium(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER_PREMIUM + time * COST_PER_TIME_PREMIUM;
		return Math.max(MINIMUM_FARE_PREMIUM, totalFare);
	}

	public double calculateFare(Ride[] rides) {
		double totalFare = 0;
		for (Ride ride : rides) {
			totalFare += (ride.type == TYPE.REGULAR) ? calculateFare(ride.distance, ride.time)
					: calculateFareForPremium(ride.distance, ride.time);
		}
		return totalFare;
	}

	public InvoiceSummary calculateFareInvoiceSummary(Ride[] rides) {
		return new InvoiceSummary(calculateFare(rides), rides.length);
	}

	public void addRides(String userId, Ride[] rides) {
		rideRepository.addRides(userId, rides);
	}

	public InvoiceSummary getInvoiceFromUserId(String userId) {
		return (this.rideRepository.getRidesData(userId) == null) ? null
				: this.calculateFareInvoiceSummary(this.rideRepository.getRidesData(userId));
	}
}
