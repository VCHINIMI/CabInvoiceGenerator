package CabInvoiceCalculator;

public class InvoiceService {
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5;
	private static final double MINIMUM_COST_PER_KILOMETER = 10;
	private RideRepository rideRepository;

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
		return Math.max(MINIMUM_FARE, totalFare);
	}
}