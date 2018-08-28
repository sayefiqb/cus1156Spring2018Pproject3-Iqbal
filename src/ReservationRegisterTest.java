package CUS1156Project3;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ReservationRegisterTest {

	ReservationRegister reservationRegister;
	
	@Before
	public void setUp() throws Exception {
		reservationRegister = new ReservationRegister();
	}

	@Test
	public void testAddReservation() {
		User customer = new User ("iqbal","sayef","sj932");
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		Reservation reservation = new Reservation(1,customer,restaurant,LocalDate.now());
		reservationRegister.addReservation(reservation);
		ArrayList<Reservation> reservations = reservationRegister.reservationList.get(LocalDate.now());
		String actual = reservations.get(0).getCustomer().getUserId();
		String expected = "sj932";
		assertEquals(actual,expected);
	}

	@Test
	public void testGetReservationByUser() {
		User customer = new User ("iqbal","sayef","sj932");
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		Reservation reservation = new Reservation(1,customer,restaurant,LocalDate.now());
		reservationRegister.addReservation(reservation);
		ArrayList<Reservation> reservations = reservationRegister.getReservationByUser("sj932");
		String actual = reservations.get(0).getCustomer().getUserId();
		String expected = "sj932";
		assertEquals(actual,expected);
	}

	@Test
	public void testGetReservationByRestaurant() {
		User customer = new User ("iqbal","sayef","sj932");
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		Reservation reservation = new Reservation(1,customer,restaurant,LocalDate.now());
		reservationRegister.addReservation(reservation);
		String actual = reservationRegister.getReservationByRestaurant("cfc").get(0).getRestaurant().getRestaurantName();
		String expected = "Crown Fried Chicken";
		assertEquals(actual,expected);
	}

	@Test
	public void testGetReservationByDate() {
		User customer = new User ("iqbal","sayef","sj932");
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		Reservation reservation = new Reservation(1,customer,restaurant,LocalDate.now());
		reservationRegister.addReservation(reservation);
		LocalDate actual = reservationRegister.getReservationByDate("2018-04-01").get(0).date;
		LocalDate expected = LocalDate.now();
		assertEquals(actual,expected);
	}

}
