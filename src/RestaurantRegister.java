package CUS1156Project3;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * This is a wrapper class. It wraps a list of restaurant objects. This wrapper class has bunch of 
 * methods which are particularly invoked on the list of restaurants to find or add a restaurant.
 * @author sayefiqbal
 *
 */
public class RestaurantRegister implements Serializable {

	ArrayList<Restaurant> restaurantList = new ArrayList<Restaurant>();
	
/**
 * This method adds a restaurant to the restaurant list
 * @param restaurant
 */
	public void addRestaurant(Restaurant restaurant)
	{
		restaurantList.add(restaurant);
	}
/**
 * This method gets a restaurant by doing linear search on the restaurant list. It returns the 
 * restaurant with a matching restaurant id	
 * @param id
 * @return
 */
	public Restaurant getRestaurantById(String id)
	{
		for(Restaurant restaurant: restaurantList)
		{
			if(restaurant.getRestaurantId().equals(id))
			{
				return restaurant;
			}
		}
		
		return null;
	}
	/** 
	 * This method gets a restaurant by doing linear search on the restaurant list. It returns the 
     * restaurant with a matching restaurant NAME
	 * @param name
	 * @return
	 */
	public Restaurant getRestaurantByName(String name)
	{
		for(Restaurant restaurant: restaurantList)
		{
			if(restaurant.getRestaurantName().equals(name))
			{
				return restaurant;
			}
		}
		
		return null;	
	}
	
	/**
	 * 
	 * This method gets a list of restaurant by doing linear search on the restaurant list. It returns the 
	 * a list of restaurant with a matching restaurant cuisine type	
	 * @param cuisine
	 * @return
	 */
	public ArrayList<Restaurant> getRestaurantByCuisine(String cuisine)
	{
		ArrayList<Restaurant> cuisineList = new ArrayList<Restaurant>();
		for(Restaurant restaurant: restaurantList)
		{
			if(restaurant.getRestaurantCuisine().equals(cuisine))
			{
				cuisineList.add(restaurant);
			}
		}
		
		return cuisineList;	
	}

	/**
	 * This method gets a list of restaurant by doing linear search on the restaurant list.
	 * It returns a list of restaurant that are in the same state	
	 * @param state
	 * @return
	 */
	public ArrayList<Restaurant> getRestaurantByState(String state)
	{
		ArrayList<Restaurant> stateList = new ArrayList<Restaurant>();
		for(Restaurant restaurant: restaurantList)
		{
			if(restaurant.getRestaurantState().equals(state))
			{
				stateList.add(restaurant);
			}
		}
		
		return stateList;	
	}
	
	public ArrayList<Restaurant> getRestaurantByCity(String city)
	{
		ArrayList<Restaurant> cityList = new ArrayList<Restaurant>();
		for(Restaurant restaurant: restaurantList)
		{
			if(restaurant.getRestaurantCity().equals(city))
			{
				cityList.add(restaurant);
			}
		}
		return cityList;
	}
	
/**	public boolean isEmpty(String id)
	{
		for(Restaurant restaurant: restaurantList)
		{
			if(restaurant.getRestaurantId().equals(id))
			{
				return false;
			}
		}
		return true;
	}

**/

}
