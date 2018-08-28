package CUS1156Project3;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is a user class. It stores basic information of a user. The class
 * has a bunch of getters and setters.
 * @author sayefiqbal
 *
 */
public class User implements MyObserver,Serializable {

	private String lastName;
	private String firstName;
	private String userId;
	private ArrayList<Review> reviewList;
	private MyObservable restaurant;
	/**
	 * default constructor
	 */
	public User()
	{
		this.lastName="";
		this.firstName="";
		this.userId="";
		reviewList = new ArrayList<Review>();
		restaurant = new Restaurant();
	}

/**
 * The user constructor which takes in last name, first name
 * and user id to create a user object.
 * @param lname
 * @param fname
 * @param id
 */
	public User(String lname, String fname, String id)
	{
		this.lastName=lname;
		this.firstName=fname;
		this.userId=id;
		reviewList = new ArrayList<Review>();
		restaurant = new Restaurant();
	}
	
	/**
	 * Returns last name of a user
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the first nameof a user
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Returns the first name of a user
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name of a user
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * gets the id of a user
	 * @return
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * sets the id for a user 
	 * @param userId
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	/**
	 * adds the object, which is cast to Review type, to the review list 
	 * of the user for the restaurant, which is of Observable type, 
	 * he or she is following.  
	 * @param observable,object
	 */
	public void update(MyObservable observable, Object object) {
		// TODO Auto-generated method stub
		this.restaurant = observable;
		reviewList.add((Review)object);
	}

	/**
	 * This method returns the list of reviews the user wants to get notified with
	 * @return
	 */
	public ArrayList<Review> getNotifiedReviews()
	{
		return reviewList;
	}
}