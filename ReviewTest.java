package CUS1156Project3;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Before;
import org.junit.Test;

public class ReviewTest {
Review review;
	@Before
	public void setUp() throws Exception {
		
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		User customer =  new User("Iqbal","Sayef","Sj93299347");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt = LocalDateTime.parse("2017-03-09 10:15:30", formatter);
		review = new Review("Love their chicken","****",dt,customer,restaurant);
	}

	@Test
	public void testGetReviewComment() {
		String expected = review.getReviewComment();
		assertEquals(expected,"Love their chicken");
	}

	@Test
	public void testSetReviewComment() {
		review.setReviewComment("Awesome chicken");
		String expected = review.getReviewComment();
		assertEquals(expected,"Awesome chicken");
	}

	@Test
	public void testGetReviewStars() {
		String expected = review.getReviewStars();
		assertEquals(expected,"****");
	}

	@Test
	public void testSetReviewStars() {
		review.setReviewStars("*");
		String expected = review.getReviewStars();
		assertEquals(expected,"*");
	}

	@Test
	public void testGetReviewDate() {
		LocalDateTime actual = review.getReviewDate();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime expected = LocalDateTime.parse("2017-03-09 10:15:30", formatter);
		assertEquals(actual,expected);
		
	}

	@Test
	public void testSetReviewDateTime() {
		String str = "2009-11-26 18:23:47";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime expected = LocalDateTime.parse(str, formatter);
		review.setReviewDateTime(expected);
		LocalDateTime actual = review.getReviewDate();
		assertEquals(actual,expected);
	}

	@Test
	public void testGetUser() {
		User expected =  new User("Iqbal","Sayef","Sj93299347");
		User actual = review.getUser();
		assertEquals(actual.getUserId(),expected.getUserId());
	}

	@Test
	public void testSetUser() {
		User expected =  new User("Torchio","John","Sj00000");
		review.setUser(expected);
		User actual = review.getUser();
		assertEquals(actual,expected);
	}

	@Test
	public void testGetRestaurant() {
		Restaurant expected = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		Restaurant actual = review.getRestaurant();
		assertEquals(actual.getRestaurantId(),expected.getRestaurantId());
	}

	@Test
	public void testSetRestaurant() {
		Restaurant expected = new Restaurant("Popeyes", "pop","Fast Food",
				"199-02 Hillside Aveneue","Jamaica","New York", "11423", 15,false);
		review.setRestaurant(expected);
		Restaurant actual = review.getRestaurant();
		assertEquals(actual,expected);
	}

}
