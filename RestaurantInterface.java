package CUS1156Project3;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * This is the command line interface for restaurants who can read reviews for their restaurants
 * This class also allows restaurant manager or owner read all the reviews, view statistics and 
 * see reservations for their restaurants.
 * @author sayefiqbal
 *
 */
public class RestaurantInterface implements Serializable{
RestaurantSystem restaurantSystem;

/**
 * Default constructor which initializes the restaurantSystem object by passing a value as 
 * the parameter.
 * @param restSystem
 */
public RestaurantInterface(RestaurantSystem restSystem)
{
	restaurantSystem = restSystem;
}

/**
 * This method prints all the command line options available to the restaurant owner or mananger.
 * It takes in the input option provided by the manager or owner and returns it.
 * @param input
 * @return
 */
public String getChoice(Scanner input)
{
	String choice;
	System.out.println("Please enter a command");
	System.out.println("SR: Show my reviews");
	System.out.println("S:  Show review statistics");
	System.out.println("R:  Show reservations for my restaurant");
	System.out.println("D:  Show reservations for a particular date");
	System.out.println("Q:  Quit");
	System.out.println(">>>>");
	choice = input.nextLine();
	return choice;
	
}

/**
 * 
 * This method is where all the logical actions take place. This method performs action based on
 * the user (manager and owner) input and does certain task. It invokes and calls other methods 
 * to view all the reviews for their restaurant and get statistics. It also displays the seats
 * occupied because of reservation and the users who reserved a seat at this restaurant.
 * @param input
 * @param restaurantId
 */
public void restaurantAction(Scanner input,String restaurantId)
{
	String choice;
	choice = getChoice(input);
	while (!choice.equals("Q"))
	{
	if(choice.equals("SR"))
	{
		ArrayList<Review> reviews = restaurantSystem.getRestaurantReview(restaurantId);
		if(!reviews.isEmpty())
		{	
			int countReview = 1;
			for(Review review: reviews)
		{   System.out.println("REVIEW       "+countReview);
			System.out.println("--------------------------------------------");
			System.out.println("Comment:     "+review.getReviewComment());
			System.out.println("Rating:      "+review.getReviewStars());
			System.out.println("Reviewed on: "+review.getReviewDate());
			System.out.println("Revied By:   "+review.getUser().getFirstName() + review.getUser().getLastName());
			System.out.println("--------------------------------------------");
			System.out.println("");
			countReview = countReview + 1;
		}	
		}
		else
		{
		System.out.println("Sorry, your restaurant has no reviews");
		}
	}
	
	if (choice.equals("S"))
	{
		String stars;
		stars = restaurantSystem.getAverageStars(restaurantId);
		if(stars!=null)
			{
			System.out.println(stars);
			}
		else
		{
			System.out.println("Sorry your restauranthas no ratings :(");
		}
	}

	
	if(choice.equals("R"))
	{
		ArrayList<Reservation> restaurantReservations = restaurantSystem.getReservationByRestaurant(restaurantId);
		if(!restaurantReservations.isEmpty())
		{	System.out.println(restaurantSystem.getRestaurantById(restaurantId).getRestaurantName()+
				" restaurant reservation system:");
			System.out.println("Printing all the reservations");	
			for(Reservation reservation: restaurantReservations)
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
	if(choice.equals("D"))
	{
		System.out.println("Please enter a date");
		String date;
		date = input.nextLine();
		ArrayList<Reservation> restaurantReservations = restaurantSystem.getReservationByDate(date);
		if(!restaurantReservations.isEmpty())
		{	System.out.println(restaurantSystem.getRestaurantById(restaurantId).getRestaurantName()+
				" restaurant reservation system:");
			System.out.println("Printing all the reservations for the date: " + date);
			LocalDate localDate = LocalDate.parse(date);
			int seatsOccupied = restaurantSystem.getSeatsReservedByRestaurantId(restaurantId, localDate);
			System.out.println("The restaurant has "+ seatsOccupied+" seats occupied");
			for(Reservation reservation: restaurantReservations)
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
	choice = getChoice(input);
	}

	System.out.println("*****Logging off*****");

}
}
