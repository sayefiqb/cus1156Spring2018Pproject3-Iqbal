package CUS1156Project3;


import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This is the customer command line interface for customers who write, read and manipulate reviews 
 * that are issued by them. This class also allows customer of restaurants to interact with the 
 * restaurant information and perform filtered search on restaurants.
 * @author sayefiqbal
 *
 */
public class CustomerInterface implements Serializable {
public static RestaurantSystem restaurantSystem;

/**
 * Default constructor that initializes the restaurantSystem with the value passed by the parameter
 * @param restSystem
 */
public CustomerInterface(RestaurantSystem restSystem)
{
	this.restaurantSystem=restSystem;
}

/**
 * This method prints the command line options a customer has and takes a choice and returns the
 * choice.
 * @param input
 * @return
 */
public String getChoice(Scanner input)
{
	
	String choice;
	System.out.println("Please enter a command");
	System.out.println("S:  Search for restaurants");
	System.out.println("D:  Display a restaurant");
	System.out.println("C:  Add a review");
	System.out.println("SR: Show my reviews");
	System.out.println("R:  Create a reservation");
	System.out.println("A:  Show all your reservation");
	System.out.println("B:  Show all your reservation for a particular date");
	System.out.println("F:  Find your reservation for a particular restaurant ");
	System.out.println("N:  Notify me of reviews");
	System.out.println("Q:  Quit");
	System.out.println(">>>>");
	choice = input.nextLine();
	return choice;
	
}
/**
 * This method prints the sub commands available to a customer to search for a restaurant. It takes 
 * in a choice from he user and return the choice.
 * @param input
 * @return
 */
public String getRestaurantSearchOption(Scanner input)
{
	String choice;
	System.out.println("What would you like to search on? Choose one");
	System.out.println("cuisine, city, state, name");
	choice = input.nextLine();
	return choice;
	
}

/**
 * This is a helper method which prints the reviews for the restaurant that a 
 * user has requested to get notifcation from. 
 * @param customerId
 */
public void notifyReview(String customerId)
{
	User customer = restaurantSystem.getCustomerById(customerId);
	ArrayList<Review> reviews = customer.getNotifiedReviews();
	if(!reviews.isEmpty())
	{	
		System.out.println("Reviews for restaurants you are following:");
	
	for(Review review: reviews)
	{
		System.out.println("-------------------------------");
		System.out.println("Restaurant: " +review.getRestaurant().getRestaurantName());
		System.out.println("Review: "+review.getReviewComment());
		System.out.println("Date: "+review.getReviewDate());
		System.out.println("Number of stars: "+review.getReviewStars());
	}
	}
	
}

/**
 * This method is where all the logical actions take place. This method performs action based on
 * the user input and does certain task. It does a filtered search for restaurants, option to write 
 * a review and display information for a particular restaurant and even print all the reviews written 
 * by a particular customer. It also creates a reservation for a restaurant and displays 
 * reservations done by the user.
 * @param in
 * @param customerId
 */
public void customerAction(Scanner in, String customerId)
{
	
	notifyReview(customerId);
	String choice;
	choice = getChoice(in);	  
	while (!choice.equals("Q"))
	{
		if(choice.equals("D"))
	    {
		System.out.println("Enter the restaurant id");
		String restaurantId;
		restaurantId = in.nextLine();
		Restaurant restaurant = restaurantSystem.getRestaurantById(restaurantId);
		printARestaurantInfo(restaurant);	
	    	}
	
		if(choice.equals("S"))
		{
		String option;
		option = getRestaurantSearchOption(in);
			if(option.equals("cuisine"))
			{
			System.out.println("Enter the cuisine");
			String cuisine;
			cuisine = in.nextLine();
			ArrayList<Restaurant> restaurants = restaurantSystem.getRestaurantByCuisine(cuisine);
			printRestaurantReviews(restaurants);	
			}	
		
			if(option.equals("name"))
			{
			System.out.print("Enter the restaurant name");
			String restaurantName;
			restaurantName = in.nextLine();
			Restaurant restaurant = restaurantSystem.getRestaurantByName(restaurantName);
			printARestaurantInfo(restaurant);
		    }
			
			if(option.equals("city"))
			{
				System.out.println("Enter the city");
				String city;
				city = in.nextLine();
				ArrayList<Restaurant> restaurants = restaurantSystem.getRestaurantByCity(city);
				printRestaurantReviews(restaurants);	
			}
	
			if(option.equals("state"))
			{
				System.out.println("Enter the state");
				String state;
				state = in.nextLine();
				ArrayList<Restaurant> restaurants = restaurantSystem.getRestaurantByState(state);
				printRestaurantReviews(restaurants);
			}
	      }
	if(choice.equals("C"))
	{
		Review review;
		System.out.println("which restaurant do you want to review? Type restaurant id.");
		String restId;
		restId = in.nextLine();
		Restaurant restaurant = restaurantSystem.getRestaurantById(restId); 
			if(restaurant!=null)
			{
			System.out.println("Please enter a review for the restaurant");
			String reviewComment;
			reviewComment = in.nextLine();
			System.out.println("Please a rating for the restaurant");
			String reviewStars;
			reviewStars = in.nextLine();
			LocalDateTime reviewDateTime = LocalDateTime.now();
			try
				{
				User customer = restaurantSystem.getCustomerById(customerId);
				review = new Review (reviewComment,reviewStars,reviewDateTime,customer,restaurant);
				restaurantSystem.addReview(review);
				//restaurant.addReview(review);
				System.out.println("Review was added succesfully!!!");
				} 
				catch (ParseException e) 
				{
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		     }
		 else
			{
			System.out.println("The restaurant you entered does not exist");
			}
	}

	if(choice.equals("SR"))
	{
		ArrayList<Review> customerReviews = restaurantSystem.getCustomerReview(customerId);
		if(!customerReviews.isEmpty())
		{		
			for(Review review: customerReviews)
			{
			System.out.println("Comment:         "+review.getReviewComment());
			System.out.println("Rating:          "+review.getReviewStars());
			System.out.println("Reviewed at:     "+review.getReviewDate());
			System.out.println("Restaurant Id:   "+review.getRestaurant().getRestaurantId());
			System.out.println("Restaurant Name: "+review.getRestaurant().restaurantName);
			System.out.println("------------------------------");
			}	
		}
		else
		{
		System.out.println("You have no reviews.");
	    }
	}
	if(choice.equals("R"))
	{
		Reservation reservation;
		System.out.println("For which restaurant do you want to reserve a seat? Type restaurant id.");
		String restId;
		restId = in.nextLine();
		Restaurant restaurant = restaurantSystem.getRestaurantById(restId); 
		User customer = restaurantSystem.getCustomerById(customerId);
		if(restaurant!=null)
		{
			System.out.println("Please enter the date you want to reserve a seat on (yyyy-mm-dd)");
			String reservationDate;
			reservationDate = in.nextLine();
			LocalDate date = LocalDate.parse(reservationDate);
			//LocalDate date = LocalDate.now();
			int seatsReserved = restaurantSystem.getSeatsReservedByRestaurantId(restId, date);
			int seatsAvailable = restaurantSystem.getRestaurantById(restId).getRestaurantCapacity()-seatsReserved;
			System.out.println("There are " + seatsAvailable+" seat left in the restaurant ");
			if(seatsAvailable>0)
			{
				reservation = new Reservation(restaurantSystem.getReservationId(),customer,restaurant,date);
				restaurantSystem.addReservation(reservation);
				System.out.println("Your reserveation was successful!!!");
			}
			else
			{
				System.out.println("Sorry, we are not taking any reservations. We have reached maximum capacity");
			}
		}
		if(restaurant==null)
		{
			System.out.println("Sorry, there is no such restaurant.");
		}
	}
	
	if(choice.equals("A"))
	{
		ArrayList<Reservation> customerReservations = restaurantSystem.getReservationByUser(customerId);
		if(!customerReservations.isEmpty())
		{	System.out.println("Printing all your reservations");	
			for(Reservation reservation: customerReservations)
			{
			System.out.println("------------------------------");
			System.out.println("Reservation Confirmation Number " + reservation.getReservationId());
			System.out.println("Reservation By :                " + reservation.getCustomer().getFirstName() 
					+" "+ reservation.getCustomer().getLastName());
			System.out.println("Reservered for :                "+ 
					reservation.getRestaurant().restaurantName+ " restaurant");
			System.out.println("Reservation date:               " +reservation.getDate());
			System.out.println("------------------------------");
			}	
		}
	}
	if(choice.equals("B"))
	{
		System.out.println("Please enter a date in the form yyyy-mm-dd");
		String reservationDate;
		reservationDate = in.nextLine();
		ArrayList<Reservation> customerReservations = restaurantSystem.getReservationByDate(reservationDate);
		if(!customerReservations.isEmpty())
		{	
			System.out.println("Printing all your reseservations for "+ reservationDate);
			System.out.println("------------------------------");
			for(Reservation reservation: customerReservations)
			{
				if(reservation.getCustomer().getUserId().equals(customerId))	
				{	
					System.out.println("Reservation Confirmation Number " + reservation.getReservationId());
					System.out.println("Reservation By :                " + reservation.getCustomer().getFirstName() 
						+" "+ reservation.getCustomer().getLastName());
					System.out.println("Reservered for :                "+ 
					reservation.getRestaurant().restaurantName+ " restaurant");
					System.out.println("Reservation date:               " +reservation.getDate());
					System.out.println("------------------------------");
				}	
			}	
		}
	}
	if(choice.equals("F"))
	{
		System.out.println("Please enter the id of a restaurant");
		String restaurantId;
		restaurantId = in.nextLine();
		ArrayList<Reservation> customerReservations = restaurantSystem.getReservationByRestaurant(restaurantId);
		if(!customerReservations.isEmpty())
		{	
			System.out.println("Printing all your reseservations for "+ restaurantSystem.restaurantRegister.getRestaurantById(restaurantId).restaurantName);
			System.out.println("------------------------------");
			for(Reservation reservation: customerReservations)
			{
				if(reservation.getCustomer().getUserId().equals(customerId))
				{	
					System.out.println("Reservation Confirmation Number " + reservation.getReservationId());
					System.out.println("Reservation By :                " + reservation.getCustomer().getFirstName() 
					+" "+ reservation.getCustomer().getLastName());
					System.out.println("Reservered for :                "+ 
					reservation.getRestaurant().restaurantName+ " restaurant");
					System.out.println("Reservation date:               " +reservation.getDate());
					System.out.println("------------------------------");
				}
			}	
		}
		
	}
	
	if(choice.equals("N"))
	{
		System.out.println("Which restaurant's reviews would you like to be notified of?");
		String restId;
		restId = in.nextLine();
		Restaurant restaurant = restaurantSystem.getRestaurantById(restId);
		User usr = restaurantSystem.getCustomerById(customerId);
		restaurant.addObserver(usr);
	}
	

	if(!choice.equals("S")&&!choice.equals("SR")&&!choice.equals("D")
			&&!choice.equals("C")&&!choice.equals("R")&&!choice.equals("A")
			&&!choice.equals("B")&&!choice.equals("F")&&!choice.equals("N"))
	{
		System.out.println("Invalid command");
	}
	notifyReview(customerId);
	choice = getChoice(in);
	}
	
	System.out.println("*****Logging Off*****");
}

/**
 * This method takes in a list of restaurant as a parameter and prints the information
 * about each of the restaurant from the list and also any review associated with each 
 * of the restaurant in the list if there is any.
 * @param restaurants
 */
public static void printRestaurantReviews(ArrayList<Restaurant>restaurants)
{
	
	if(!restaurants.isEmpty())	
	{
		for(Restaurant restaurant: restaurants)
		{
		System.out.println("-----------"+restaurant.getRestaurantName()+"-----------");
		System.out.println("Cuisine:  "+restaurant.getRestaurantCuisine());
		System.out.println("Has Liquor license: "+restaurant.getRestaurantLiquor());
		System.out.println("Has a capacity of: "+ restaurant.getRestaurantCapacity());
		System.out.println("Address");
		System.out.println(restaurant.getRestaurantStreet());
		System.out.println(restaurant.getRestaurantCity()+", "+restaurant.getRestaurantState()+", "+restaurant.getRestaurantZip());
		ArrayList<Review> reviews = restaurantSystem.getRestaurantReview(restaurant.getRestaurantId());
		int count =1;
		if(reviews.isEmpty()==false)
		{
		System.out.println("");
		System.out.println("User Reviews");
		System.out.println("");
		for(Review review: reviews)
		{
			System.out.println("REVIEW " + count);
			System.out.println("Comment:         "+review.getReviewComment());
			System.out.println("Rating:          "+review.getReviewStars());
			System.out.println("Reviewed at:     "+review.getReviewDate());
			System.out.println("Reviewd by:      "+review.getUser().getUserId());
			count = count + 1;
		}
		}
		}
     }
	else
	 {
	  System.out.println("There are no restaurants in this category");
	 }
}

/**
 * This method takes in a restaurant as a parameter and prints the information about the restaurant
 * all the reviews associated with it if ther is any.
 * @param restaurant
 */
public static void printARestaurantInfo(Restaurant restaurant)
{
	if(restaurant!=null)
	{
	System.out.println("----------"+restaurant.getRestaurantName()+"----------");
	System.out.println("Cuisine:  "+restaurant.getRestaurantCuisine());
	System.out.println("Has Liquor license: "+restaurant.getRestaurantLiquor());
	System.out.println("Has a capacity of: "+ restaurant.getRestaurantCapacity());
	System.out.println("Address");
	System.out.println(restaurant.getRestaurantStreet());
	System.out.println(restaurant.getRestaurantCity()+", "+restaurant.getRestaurantState()+", "+restaurant.getRestaurantZip());
	ArrayList<Review> reviews = restaurantSystem.getRestaurantReview(restaurant.getRestaurantId());
	int count =1;
	if(reviews.isEmpty()==false)
	{
	System.out.println("");
	System.out.println("User Reviews");
	System.out.println("");
	for(Review review: reviews)
	{
		System.out.println("REVIEW " + count);
		System.out.println("Comment:         "+review.getReviewComment());
		System.out.println("Rating:          "+review.getReviewStars());
		System.out.println("Reviewed at:     "+review.getReviewDate());
		System.out.println("Reviewd by:      "+review.getUser().getUserId());
		count = count + 1;
	}
	}
	}
	else
	{
 	System.out.println("There is no restaurant with this name");
    }
	
}

}

