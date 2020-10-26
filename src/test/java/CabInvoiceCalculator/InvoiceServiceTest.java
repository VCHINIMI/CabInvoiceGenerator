package CabInvoiceCalculator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

	InvoiceService invoiceService = null;

	@Before
	public void initialize() {
		invoiceService = new InvoiceService();
	}

	@Test
	public void givenDistanceandTimeShouldReturnFare() {
		double distance = 2.0;
		int time = 5;
		double fare = invoiceService.calculateFare(distance, time);
		assertEquals(25, fare, 0.0);
	}

	@Test
	public void givenMultipleRidesShouldReturnAggregateFare() {
		Ride[] rides = { new Ride(2.0, 5), new Ride(3.0, 5), new Ride(4.0, 6) };
		double fare = invoiceService.calculateFare(rides);
		assertEquals(106, fare, 0.0);
	}
}
