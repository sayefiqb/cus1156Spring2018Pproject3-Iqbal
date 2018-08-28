package CUS1156Project3;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is a restaurant class. It stores the name, id, cuisine, street, city, state, zip, capacity 
 * and license information for a restaurant. It has a bunch of setter and getter methods.
 * @author sayefiqbal
 */
public class Restaurant extends MyObservable implements Serializable {

public String restaurantName;
public String restaurantId;
public String restaurantCuisine;
public String restaurantStreet;
public String restaurantCity;
public String restaurantState;
public String restaurantZip;
public int restaurantCapacity;
public boolean restaurantLiquor;
public ArrayList<Review>reviewList = new ArrayList<Review>();
	
/**
 * Default constructor which initializes everything to default values (null in case of string,
 * false in case of boolean and 0 in case of integer).
 */
public Restaurant()
{
	this.restaurantName="";
	this.restaurantId="";
	this.restaurantCuisine="";
	this.restaurantStreet="";
	this.restaurantCity="";
	this.restaurantState="";
	this.restaurantZip= "" ;
	this.restaurantCapacity= 0;
	this.restaurantLiquor= false;
	reviewList = new ArrayList<Review>();
}

/**
 * Constructor for restaurant. Takes in a bunch of parameters to intialize all 
 * the instance variable of a restaurant.
 * @param name
 * @param id
 * @param cuisine
 * @param street
 * @param city
 * @param state
 * @param zip
 * @param capacity
 * @param liquor
 * @param reviewList
 */
public Restaurant(String name, String id, String cuisine,
		String street, String city, String state, String zip, int capacity, boolean liquor)
{
	this.restaurantName=name;
	this.restaurantId=id;
	this.restaurantCuisine=cuisine;
	this.restaurantStreet=street;
	this.restaurantCity=city;
	this.restaurantState=state;
	this.restaurantZip= zip;
	this.restaurantCapacity= capacity;
	this.restaurantLiquor=liquor;
	reviewList = new ArrayList<Review>();
}

/**
 * Returns the restaurant name
 * @return
 */
public String getRestaurantName() {
	return restaurantName;
}

/**
 * Sets the restaurant name
 * @param restaurantName
 */
public void setRestaurantName(String restaurantName) {
	this.restaurantName = restaurantName;
}

/**
 * gets the restaurant id
 * @return
 */
public String getRestaurantId() {
	return restaurantId;
}

/**
 * sets the restaurant id
 * @param restaurantId
 */
public void setRestaurantId(String restaurantId) {
	this.restaurantId = restaurantId;
}

/**
 * gets the restaurant cuisine
 * @return
 */
public String getRestaurantCuisine() {
	return restaurantCuisine;
}

/**
 * sets restaurant cuisine
 * @param restaurantCuisine
 */
public void setRestaurantCuisine(String restaurantCuisine) {
	this.restaurantCuisine = restaurantCuisine;
}

/**
 * gets the restaurant street
 * @return
 */
public String getRestaurantStreet() {
	return restaurantStreet;
}

/**
 * sets the restaurant's street address
 * @param restaurantStreet
 */
public void setRestaurantStreet(String restaurantStreet) {
	this.restaurantStreet = restaurantStreet;
}

/**
 * gets the restaurant city address
 * @return
 */
public String getRestaurantCity() {
	return restaurantCity;
}

/**
 * sets the restaurant's city address
 * @param restaurantCity
 */
public void setRestaurantCity(String restaurantCity) {
	this.restaurantCity = restaurantCity;
}

/**
 * gets the restauran't state address
 * @return
 */
public String getRestaurantState() {
	return restaurantState;
}

/**
 * sets the restaurant's state address
 * @param restaurantState
 */
public void setRestaurantState(String restaurantState) {
	this.restaurantState = restaurantState;
}

/**
 * gets the restaurant zip code
 * @return
 */
public String  getRestaurantZip() {
	return restaurantZip;
}

/**
 * sets the restaurant zip code
 * @param restaurantZip
 */
public void setRestaurantZip(String restaurantZip) {
	this.restaurantZip = restaurantZip;
}

/**
 * gets the restaurant capacity
 * @return
 */
public int getRestaurantCapacity() {
	return restaurantCapacity;
}
public void SetRestaurantCapacity(int capacity)
{
	this.restaurantCapacity=capacity;
}

/**
 * sets the restaurant's phone number
 * @param restaurantPhone
 */
public void setRestaurantPhone(int restaurantPhone) {
	this.restaurantCapacity = restaurantPhone;
}

/**
 * gets the restaurant's liquor license
 * @return
 */
public boolean getRestaurantLiquor() {
	return restaurantLiquor;
}

/**
 * sets the restaurant's liquor license
 * @param restaurantLiquor
 */
public void setRestaurantLiquor(boolean restaurantLiquor) {
	this.restaurantLiquor = restaurantLiquor;
}
	
/**
 * This method adds review to the restaurant's review list and then calls
 * the notifyObservers method which is an abstract method in the Observable class.
 * It basically notifies the users who are observing this particular restaurant.
 * @param object
 */
public void addReview(Review object)
{
	reviewList.add(object);
	notifyObservers(object);
}
/**
 * This method sets the reviews to a particular review list.
 * This method is never used in the program because of its wierd implementation
 * @param reviews
 */
public void setReviews(ArrayList<Review> reviews)
{
	this.reviewList = reviews;
}

/**
 * This method returns the list of review for the restaurant.
 * @return
 */
public ArrayList<Review> getReviews()
{
	return reviewList;
}

}