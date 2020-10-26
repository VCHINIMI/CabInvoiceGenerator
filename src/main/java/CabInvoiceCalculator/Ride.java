package CabInvoiceCalculator;

public class Ride {
	public enum TYPE{
		REGULAR,
		PREMIUM
	}
	
	public TYPE type;
	public double distance;
	public int time;

	public Ride(double distance, int time, TYPE type) {
		super();
		this.distance = distance;
		this.time = time;
		this.type = type;
	}
}
