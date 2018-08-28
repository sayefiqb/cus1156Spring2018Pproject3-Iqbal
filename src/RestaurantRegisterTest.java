package CUS1156Project3;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class RestaurantRegisterTest {
RestaurantRegister restaurantRegister;
	@Before
	public void setUp() throws Exception {
		restaurantRegister = new RestaurantRegister();
	}

	@Test
	public void testAddRestaurant() {
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		restaurantRegister.addRestaurant(restaurant);
		assertEquals(restaurant,restaurantRegister.restaurantList.get(0));
	}

	@Test
	public void testGetRestaurantById() {
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		restaurantRegister.addRestaurant(restaurant);
		assertEquals(restaurant,restaurantRegister.getRestaurantById("cfc"));
	}

	@Test
	public void testGetRestaurantByName() {
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		restaurantRegister.addRestaurant(restaurant);
		assertEquals(restaurant, restaurantRegister.getRestaurantByName("Crown Fried Chicken"));
	}

	@Test
	public void testGetRestaurantByCuisine() {
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		restaurantRegister.addRestaurant(restaurant);
		Restaurant expected = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		ArrayList<Restaurant> expectedList = new ArrayList<Restaurant>();
		expectedList.add(expected);
		assertEquals(expectedList.get(0).restaurantId, restaurantRegister.getRestaurantByCuisine("Fast Food").get(0).restaurantId);
	}

	@Test
	public void testGetRestaurantByState() {
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		restaurantRegister.addRestaurant(restaurant);
		Restaurant expected = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		ArrayList<Restaurant> expectedList = new ArrayList<Restaurant>();
		expectedList.add(expected);
		assertEquals(expectedList.get(0).restaurantId, restaurantRegister.getRestaurantByState("New York").get(0).restaurantId);
	}

}
