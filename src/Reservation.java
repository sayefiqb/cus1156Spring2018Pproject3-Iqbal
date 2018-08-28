package CUS1156Project3;

import java.io.Serializable;
import java.time.LocalDate;
/**
 * This is a reservation class. It stores a global reservation id, the user who creates the
 * reservation, the restaurant for which the reservation is created and the date on which the
 * reservation was created.
 * @author sayefiqbal
 *
 */
public class Reservation implements Serializable{

	public int reservationId;
	public User customer;
	public Restaurant restaurant;
	public LocalDate date;
	
	/**
	 * Default constructor which initializes everything to default values (null in case of string
	 * and LocalDate and -1 in case of integer).
	 */
	public Reservation()
	{
		this.reservationId=-1;
		this.customer=null;
		this.restaurant=null;
		this.date=null;
	}
	/**
	 * Constructor for reservation. Takes in a bunch of parameters to initialize all 
	 * the instance variable of a reservation.
	 * @param reservationId
	 * @param customer
	 * @param restaurant
	 * @param date
	 */
	public Reservation(int reservationId, User customer, Restaurant restaurant, LocalDate date)
	{
		this.reservationId=reservationId;
		this.customer=customer;
		this.restaurant=restaurant;
		this.date=date;
	}
	/**
	 * Returns the global unique reservation id
	 * @return
	 */
	public int getReservationId() {
		return reservationId;
	}

	/**
	 * Sets the global unique reservation id
	 * @param reservationId
	 */
	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	/**
	 * Returns the user who created the reservation
	 * @return
	 */
	public User getCustomer() {
		return customer;
	}

	/**
	 * Sets the user who created the reservation
	 * @param customer
	 */
	public void setCustomer(User customer) {
		this.customer = customer;
	}

	/**
	 * Returns the restaurant for which the reservation was created
	 * @return
	 */
	public Restaurant getRestaurant() {
		return restaurant;
	}

	/**
	 * Sets the restaurant for which the reservation is created
	 * @param restaurant
	 */
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	/**
	 * Returns the date on which the reservation was created
	 * @return
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Sets the date on which the reservation was created
	 * @param date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
