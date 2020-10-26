package CabInvoiceCalculator;

public class InvoiceSummary {
	private double totalFare;
	private int rides;
	private double averageFare;

	public InvoiceSummary(double totalFare, int rides) {
		super();
		this.totalFare = totalFare;
		this.rides = rides;
		this.averageFare = totalFare / rides;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(averageFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + rides;
		temp = Double.doubleToLongBits(totalFare);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(other.averageFare))
			return false;
		if (rides != other.rides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		return true;
	}
}
