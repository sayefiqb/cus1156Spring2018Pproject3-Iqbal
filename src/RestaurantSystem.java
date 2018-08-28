package CUS1156Project3;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ListIterator;
/**
 * This class contains all the tree types of wrapper class objects.It invokes methods on those
 * objects from a higher level. The purpose of this class is to keep the business logic of
 * the whole system and implementation as abstract and hidden as possible. The user will mostly 
 * interact with this class instead of the three wrapper classes.
 * @author sayefiqbal
 *
 */
public class RestaurantSystem implements Serializable{

RestaurantRegister restaurantRegister;
CustomerRegister customerRegister;
ReviewRegister reviewRegister;
ReservationRegister reservationRegister;
private int reservationId = 1;


/**
 * This is the default constructor which intializes the restaurntSystem object with objects from the 
 * wrapper class that are passed as parameters
 * @param restRegister
 * @param custRegister
 * @param revRegister
 */
public RestaurantSystem(RestaurantRegister restRegister, CustomerRegister custRegister
		,ReviewRegister revRegister, ReservationRegister reservRegister)
{
	restaurantRegister = restRegister;
	customerRegister = custRegister;
	reviewRegister = revRegister;
	reservationRegister= reservRegister;
}
/**
 * Returns restaurantRegister (restaurant list)
 * @return
 */
public RestaurantRegister getRestaurantRegister() {
	return restaurantRegister;
}
/**
 * sets the restaurantRegister (restaurant list)
 * @param restaurantRegister
 */
public void setRestaurantRegister(RestaurantRegister restaurantRegister) {
	this.restaurantRegister = restaurantRegister;
}
/**
 * gets the customerRegister (customer list)
 * @return
 */
public CustomerRegister getCustomerRegister() {
	return customerRegister;
}
/**
 * sets the customerRegister (customer list)
 * @param customerRegister
 */
public void setCustomerRegister(CustomerRegister customerRegister) {
	this.customerRegister = customerRegister;
}
/**
 * gets the reviewRegister (review list)
 * @return
 */
public ReviewRegister getReviewRegister() {
	return reviewRegister;
}
/**
 * sets the reviewRegister (review list)
 * @param reviewRegister
 */
public void setReviewRegister(ReviewRegister reviewRegister) {
	this.reviewRegister = reviewRegister;
}
public ReservationRegister getReservationRegister() {
	return reservationRegister;
}
public void setReservationRegister(ReservationRegister reservationRegister) {
	this.reservationRegister = reservationRegister;
}
/**
 * This method adds a customer to the customerRegister (customer list) but from a higher level.
 * The implementation is hidden to keep abstraction.
 * @param customer
 */
public void addCustomer(User customer)
{
	customerRegister.addCustomer(customer);
}
/**
 * This method gets a user by passing the id
 * @param id
 * @return
 */
public User getCustomerById(String id)
{
	User customer = customerRegister.getCustomerById(id);
	return customer;
}
/**
 * This method adds a restaurant to the restaurantRegister (restaurant list) but from a higher level
 * The implementation is hidden to keep abstraction.
 * @param restaurant
 */
public void addRestaurant(Restaurant restaurant)
{
	restaurantRegister.addRestaurant(restaurant);
	
}
/**
 * This method returns the restaurant with a particular name.
 * @param name
 * @return
 */
public Restaurant getRestaurantByName(String name)
{
	Restaurant restaurant = restaurantRegister.getRestaurantByName(name);
	return restaurant;
}
/**
 * This method returns a restaurant with a particular id. The implementation is hidden to 
 * maintain abstraction.
 * @param id
 * @return
 */
public Restaurant getRestaurantById(String id)
{
	Restaurant restaurant = restaurantRegister.getRestaurantById(id);
	return restaurant;
}

/**
 * This method returns a list of restaurants with a particular cuisine
 * @param cuisine
 * @return
 */
public ArrayList<Restaurant> getRestaurantByCuisine(String cuisine)
{
	ArrayList<Restaurant> restaurants = restaurantRegister.getRestaurantByCuisine(cuisine);
	return restaurants;
}
/**
 * This method returns a list of restaurants located in a particular state.
 * @param state
 * @return
 */
public ArrayList<Restaurant> getRestaurantByState(String state)
{
	ArrayList<Restaurant> restaurants = restaurantRegister.getRestaurantByState(state);
	return restaurants;
}

public ArrayList<Restaurant> getRestaurantByCity(String city)
{
	ArrayList<Restaurant> restaurants = restaurantRegister.getRestaurantByCity(city);
	return restaurants;
}
/**
 * This method adds a review to the reviewRegister (review list maintainer) but from a higher level. 
 * The implementation is hidden to maintain abstraction.
 * @param review
 */
public void addReview(Review review)
{
	reviewRegister.addReview(review);
}
/**
 * This method returns a list of reviews written by a user.
 * @param customerId
 * @return
 */
public ArrayList<Review> getCustomerReview(String customerId)
{
	ArrayList<Review> reviews = reviewRegister.getReviewByUser(customerId);
	return reviews;
}
/**
 * This method return a list of reviews written for a restaurant.
 * @param restaurantId
 * @return
 */
public ArrayList<Review> getRestaurantReview(String restaurantId)
{
	ArrayList<Review> reviews = reviewRegister.getReviewForRestaurant(restaurantId);
	return reviews;
}
/**
 * This method returns the average rating for a restaurant 
 * @param restaurantId
 * @return
 */
public String getAverageStars(String restaurantId)
{
	return reviewRegister.getAverageStars(restaurantId);	
}

/**
 * This method adds a reservation to the restaurant system
 * @param reservation
 */
public void addReservation (Reservation reservation)
{
	//reservationRegister = new ReservationRegister();
	reservationRegister.addReservation(reservation);
	reservationId = reservationId + 1;
	
}
/**
 * This method returns the reservation id.
 * @return
 */
public int getReservationId()
{
	return reservationId;
}

/**
 * This method returns a list of reservations reserved by a user.
 * @param userId
 * @return
 */
public ArrayList<Reservation> getReservationByUser(String userId)
{
	ArrayList<Reservation> reservations = reservationRegister.getReservationByUser(userId);
	return reservations;
}

/**
 * This method returns a list of reservations reserved for a restaurant
 * @param restaurantId
 * @return
 */
public ArrayList<Reservation> getReservationByRestaurant(String restaurantId)
{
	ArrayList<Reservation> reservations = reservationRegister.getReservationByRestaurant(restaurantId);
	return reservations;
}

/**
 * This method returns a list of reservation reserved on a particular date
 * @param date
 * @return
 */
public ArrayList<Reservation> getReservationByDate(String date)
{
	ArrayList<Reservation> reservations = reservationRegister.getReservationByDate(date);
	return reservations;
}

/**
 * This method returns the number of seats occupied for a restaurant on a particular date.
 * @param restId
 * @param localDate
 * @return
 */
public int getSeatsReservedByRestaurantId(String restId, LocalDate localDate)
{
	int seatsReserved = reservationRegister.getSeatsReservedByRestaurantId(restId, localDate);
	return seatsReserved;
}

}
