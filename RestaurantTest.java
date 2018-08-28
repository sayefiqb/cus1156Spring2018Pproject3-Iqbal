package CUS1156Project3;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class RestaurantTest {

	Restaurant restaurant;
	ArrayList<Review> reviewList;
	@Before
	public void setUp() throws Exception {
		restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		User customer =  new User("Iqbal","Sayef","Sj93299347");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt = LocalDateTime.parse("2017-03-09 10:15:30", formatter);
		Review review = new Review("Love their chicken","****",dt,customer,restaurant);
		reviewList = new ArrayList<>();
		reviewList.add(review);
		
	}

	@Test
	public void testGetRestaurantName() {
		String expected = restaurant.getRestaurantName();
		assertEquals(expected,"Crown Fried Chicken");
	}

	@Test
	public void testSetRestaurantName() {
		restaurant.setRestaurantName("POPEYES");
		String expected = restaurant.getRestaurantName();
		assertEquals(expected,"POPEYES");
	}

	@Test
	public void testGetRestaurantId() {
		String expected  = restaurant.getRestaurantId();
		assertEquals(expected,"cfc");
	}

	@Test
	public void testSetRestaurantId() {
		restaurant.setRestaurantId("py");
	    String expected = restaurant.getRestaurantId();
	    assertEquals(expected,"py");
	}

	@Test
	public void testGetRestaurantCuisine() {
		String expected  = restaurant.getRestaurantCuisine();
		assertEquals(expected,"Fast Food");
	}

	@Test
	public void testSetRestaurantCuisine() {
		restaurant.setRestaurantCuisine("Chinese");
	    String expected = restaurant.getRestaurantCuisine();
	    assertEquals(expected,"Chinese");
	}

	@Test
	public void testGetRestaurantStreet() {
		String expected  = restaurant.getRestaurantStreet();
		assertEquals(expected,"169-02 Hillside Aveneue");
	}

	@Test
	public void testSetRestaurantStreet() {
		restaurant.setRestaurantStreet("198-04 90th Avenue");
	    String expected = restaurant.getRestaurantStreet();
	    assertEquals(expected,"198-04 90th Avenue");
	}

	@Test
	public void testGetRestaurantCity() {
		String expected  = restaurant.getRestaurantCity();
		assertEquals(expected,"Jamaica");
	}

	@Test
	public void testSetRestaurantCity() {
		restaurant.setRestaurantCity("Elmhurst");
	    String expected = restaurant.getRestaurantCity();
	    assertEquals(expected,"Elmhurst");
	}

	@Test
	public void testGetRestaurantState() {
		String expected  = restaurant.getRestaurantState();
		assertEquals(expected,"New York");
	}

	@Test
	public void testSetRestaurantState() {
		restaurant.setRestaurantState("New Jersey");
	    String expected = restaurant.getRestaurantState();
	    assertEquals(expected,"New Jersey");
	}

	@Test
	public void testGetRestaurantZip() {
		String expected  = restaurant.getRestaurantZip();
		assertEquals(expected,"11423");
	}

	@Test
	public void testSetRestaurantZip() {
		restaurant.setRestaurantZip("11373");
	    String expected = restaurant.getRestaurantZip();
	    assertEquals(expected,"11373");
	}

	@Test
	public void testGetRestaurantCapacity() {
		int expected  = restaurant.getRestaurantCapacity();
		assertEquals(expected,20);
	}

	@Test
	public void testGetRestaurantLiquor() {
		boolean expected  = restaurant.getRestaurantLiquor();
		assertEquals(expected,false);
	}

	@Test
	public void testSetRestaurantLiquor() {
		restaurant.setRestaurantLiquor(true);
	   boolean expected = restaurant.getRestaurantLiquor();
	    assertEquals(expected,true);
	}

	@Test
	public void testAddReview()
	{
		String actual = reviewList.get(0).getReviewComment();
		String expected = "Love their chicken";
		assertEquals(expected,actual);
	}
	
	public void testGetReviews() {
		String actual = reviewList.get(0).getRestaurant().getRestaurantName();
		String expected = "Crown Fried Chicken";
		assertEquals(expected,actual);
	}
}
