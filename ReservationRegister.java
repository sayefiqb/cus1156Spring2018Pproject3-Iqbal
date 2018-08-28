package CUS1156Project3;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

/**
 * This is a wrapper class. It wraps a list of reservation objects. This class uses a hash 
 * map to store reservations by date. This wrapper class has bunch of methods which are 
 * particularly invoked on the list of reservations to find or add a reservation.
 * @author sayefiqbal
 *
 */
public class ReservationRegister implements Serializable {
public HashMap<LocalDate, ArrayList<Reservation>> 
reservationList = new HashMap<LocalDate,ArrayList<Reservation>>();

/**
 * This method creates an array list of reservations for a particular date and the stores 
 * the date as the key for the hash map and the array list contain the reservations as the
 * value of the hash map. This is done so that the reservation list can be accessed via date. 
 * @param reservation
 */
public void addReservation(Reservation reservation)
{
	if(reservationList.containsKey(reservation.date))
			{
		ArrayList<Reservation> reservations = reservationList.get(reservation.date);
		reservationList.remove(reservation.date);
		reservations.add(reservation);
		reservationList.put(reservation.date, reservations);
			}
	if(!reservationList.containsKey(reservation.date))
	{	
		ArrayList<Reservation> newReservation = new ArrayList<Reservation>();
		newReservation.add(reservation);
		reservationList.put(reservation.date, newReservation);
	}
}

/**
 * This method takes the user id of the user and then finds ALL the reservations 
 * ever created by the user and returns a list of those reservations.
 * @param userId
 * @return
 */
public ArrayList<Reservation> getReservationByUser(String userId)
{
	ArrayList<Reservation> userReservationList = new ArrayList<Reservation>();
	
	for(LocalDate date: reservationList.keySet())
	{
		ListIterator<Reservation> iterator = reservationList.get(date).listIterator();
		while(iterator.hasNext())
		{
			Reservation reservation = iterator.next();
			if(reservation.customer.getUserId().equals(userId))
			{
				userReservationList.add(reservation);
			}
		}
		
	}
	return userReservationList;

}

/**
 * This method takes the restaurant id of the restaurant for which the reservation was
 * created and then finds ALL the reservations ever created for that restaurant and 
 * returns a list of those reservations.
 * @param restaurantId
 * @return
 */
public ArrayList<Reservation> getReservationByRestaurant(String restaurantId)
{
	ArrayList<Reservation> restaurantReservationList = new ArrayList<Reservation>();
	
	for(LocalDate date: reservationList.keySet())
	{
		ListIterator<Reservation> iterator = reservationList.get(date).listIterator();
		while(iterator.hasNext())
		{
			Reservation reservation = iterator.next();
			if(reservation.restaurant.restaurantId.equals(restaurantId))
			{
				restaurantReservationList.add(reservation);
			}
		}
		
	}
	return restaurantReservationList;

}

/**
 * This method takes the date a reservation was created as a parameter and then finds ALL the
 * reservations ever created on that date and returns a list of those reservations.
 * @param reservationDate
 * @return
 */
public ArrayList<Reservation> getReservationByDate(String reservationDate)
{
	ArrayList<Reservation> reservationListByDate = new ArrayList<Reservation>();
	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-MM-DD");
	LocalDate localDate = LocalDate.parse(reservationDate);
	for(LocalDate date: reservationList.keySet())
	{
		if(date.equals(localDate))
		{
			reservationListByDate = reservationList.get(date);
		}
	}
	
	return reservationListByDate;

}

/**
 * This method takes a list of reservations for a particular date as a parameter and then 
 * finds a list of reservations for a particular restaurant on particular date from that
 * list and returns a list of those reservations.
 * @param reservations
 * @param restId
 * @return
 */
public ArrayList<Reservation> findRestaurantFromReservation(ArrayList<Reservation> reservations,String restId)
{
	ArrayList<Reservation> resList = new ArrayList<Reservation>();
	for(Reservation reservation: reservations)
	{
		if(reservation.getRestaurant().getRestaurantId().equals(restId))
		{
			resList.add(reservation);
		}
	}

	return resList;
}
/**
 * This method keeps track of how many seats have been occupied for a restaurant on a 
 * given date. It returns the number of seats occupied.
 * @param restId
 * @param localDate
 * @return
 */
public int getSeatsReservedByRestaurantId(String restId, LocalDate localDate)
{
	int seatsReserved = 0;
	for(LocalDate date: reservationList.keySet())
	{
		if(date.equals(localDate))
		{
			for(Reservation reservation: reservationList.get(date))
			{
				if(reservation.getRestaurant().getRestaurantId().equals(restId))
				{
					seatsReserved = seatsReserved +1 ;
				}
			}
		}
	}
	
	return seatsReserved;
}

}
