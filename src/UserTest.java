package CUS1156Project3;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	User customer;
	ArrayList<Review> reviews;
	@Before
	public void setUp() throws Exception {
		customer = new User("Iqbal","Sayef","Sj93299347");
		reviews = new ArrayList<Review>();
		reviews.add(new Review("Love their chicken","****",LocalDateTime.now(),customer,
					new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
									"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false)));
	}
	@Test
	public void testGetLastName() {
		String expected = customer.getLastName();
		assertEquals(expected,"Iqbal");
	}

	@Test
	public void testSetLastName() {
		customer.setLastName("Chen");
		String expected = customer.getLastName();
		assertEquals(expected,"Chen");
	}

	@Test
	public void testGetFirstName() {
		String expected = customer.getFirstName();
		assertEquals(expected,"Sayef");
	}

	@Test
	public void testSetFirstName() {
		customer.setFirstName("John");
		String expected = customer.getFirstName();
		assertEquals(expected,"John");
	}

	@Test
	public void testGetUserId() {
		String expected = customer.getUserId();
		assertEquals(expected,"Sj93299347");
	}

	@Test
	public void testSetUserId() {
		customer.setUserId("X034230");
		String expected = customer.getUserId();
		assertEquals(expected,"X034230"); 
	}
	
	@Test 
	public void testUpdate() {
		String actual = reviews.get(0).getReviewComment();
		String expected = "Love their chicken";
		assertEquals(expected,actual);
	}
	
	@Test
	public void testGetNotified() {
		String actual = reviews.get(0).getRestaurant().getRestaurantName();
		String expected = "Crown Fried Chicken";
		assertEquals(expected,actual);
	}

}
