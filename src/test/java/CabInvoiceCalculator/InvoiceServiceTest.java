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
		assertEquals(25, fare,0.0);
	}
}
