package CUS1156Project3;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

public class ReservationTest {
Reservation reservation;
	@Before
	public void setUp() throws Exception {
		User customer = new User ("iqbal","sayef","sj932");
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		reservation = new Reservation(1,customer,restaurant,LocalDate.now());
	}

	@Test
	public void testGetReservationId() {
		int actualId = reservation.getReservationId();
		assertEquals(actualId,1);
	}

	@Test
	public void testSetReservationId() {
		reservation.setReservationId(2);
		int actualId = reservation.getReservationId();
		assertEquals(actualId,2);
		
	}

	@Test
	public void testGetCustomer() {
		User customer = new User ("iqbal","sayef","sj932");
		String expected= customer.getUserId();
		String actual = reservation.getCustomer().getUserId();
		assertEquals(actual,expected);
	}

	@Test
	public void testSetCustomer() {
		User customer = new User ("smith","sam","xyz");
		reservation.setCustomer(customer);
		String actual = reservation.getCustomer().getUserId();
		String expected = customer.getUserId();
		assertEquals(actual,expected);
	}

	@Test
	public void testGetRestaurant() {
		
		String actual = reservation.getRestaurant().getRestaurantId();
		String expected = "cfc";
		assertEquals(actual,expected);
	}

	@Test
	public void testSetRestaurant() {
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "abcd","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		reservation.setRestaurant(restaurant);
		String actual = reservation.getRestaurant().getRestaurantId();
		String expected = "abcd";
		assertEquals(actual,expected);
	}

	@Test
	public void testGetDate() {
		LocalDate actual = reservation.getDate();
		LocalDate expected = LocalDate.now();
		assertEquals(actual,expected);
	}

	@Test
	public void testSetDate() {
	String date  = "2018-02-19";
	LocalDate localDate = LocalDate.parse(date);
	reservation.setDate(localDate);
	LocalDate actual = reservation.getDate();
	LocalDate expected = localDate;
	assertEquals(actual,expected);
	}

}
