package CUS1156Project3;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class ReviewRegisterTest {

	ReviewRegister reviewRegister;
	Restaurant restaurant;
	@Before
	public void setUp() throws Exception {
		reviewRegister = new ReviewRegister();
		restaurant = new Restaurant();
	}

	@Test
	public void testAddReview() throws ParseException {
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		User customer =  new User("Iqbal","Sayef","Sj93299347");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt = LocalDateTime.parse("2017-03-09 10:15:30", formatter);
		Review review = new Review("Love their chicken","****",dt,customer,restaurant);
		restaurant.addReview(review);
		reviewRegister.addReview(review);
		assertEquals(review, reviewRegister.reviewList.get(0));
		assertEquals(review, restaurant.getReviews().get(0));
	}

	@Test
	public void testGetReview() throws ParseException {
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		User customer =  new User("Iqbal","Sayef","Sj93299347");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt1 = LocalDateTime.parse("2017-03-09 10:15:30", formatter1);
		Review review = new Review("Love their chicken","****",dt1,customer,restaurant);
		reviewRegister.addReview(review);
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt2 = LocalDateTime.parse("2017-03-09 10:15:30", formatter2);
		Review expected = new Review("Love their chicken","****",dt2,customer,restaurant);
		assertEquals(expected.getUser().getUserId(),reviewRegister.getReview(review).getUser().getUserId());
	}

	@Test
	public void testGetReviewByUser() throws ParseException {
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		User customer =  new User("Iqbal","Sayef","Sj93299347");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt1 = LocalDateTime.parse("2017-03-09 10:15:30", formatter1);
		Review review = new Review("Love their chicken","****",dt1,customer,restaurant);
		reviewRegister.addReview(review);
		ArrayList<Review> actual = reviewRegister.getReviewByUser("Sj93299347");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt2 = LocalDateTime.parse("2017-03-09 10:15:30", formatter2);
		Review expected = new Review("Love their chicken","****",dt2,customer,restaurant);
		assertEquals(actual.get(0).user.getUserId(),expected.user.getUserId());
	}

	@Test
	public void testGetReviewForRestaurant() throws ParseException {
		Restaurant restaurant = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		User customer =  new User("Iqbal","Sayef","Sj93299347");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt1 = LocalDateTime.parse("2017-03-09 10:15:30", formatter1);
		Review review = new Review("Love their chicken","****",dt1,customer,restaurant);
		reviewRegister.addReview(review);
		ArrayList<Review> actual = reviewRegister.getReviewForRestaurant("cfc");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt2 = LocalDateTime.parse("2017-03-09 10:15:30", formatter2);
		Review expected = new Review("Love their chicken","****",dt2,customer,restaurant);
		assertEquals(actual.get(0).user.getUserId(),expected.user.getUserId());
	}
	
	@Test
	public void testGetAverageStars() throws ParseException
	{
		Restaurant restaurant1 = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		User customer1 =  new User("Iqbal","Sayef","Sj93299347");
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt1 = LocalDateTime.parse("2017-03-09 10:15:30", formatter1);
		Review review1 = new Review("Love their chicken","****",dt1,customer1,restaurant1);
		reviewRegister.addReview(review1);
		Restaurant restaurant2 = new Restaurant("Crown Fried Chicken", "cfc","Fast Food",
				"169-02 Hillside Aveneue","Jamaica","New York", "11423", 20,false);
		User customer2 =  new User("Torchio","John","Sj000000");
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt2 = LocalDateTime.parse("2017-03-09 10:15:30", formatter2);
		Review review2 = new Review("Hate their chicken","*",dt2,customer1,restaurant1);
		reviewRegister.addReview(review2);
		assertEquals("**",reviewRegister.getAverageStars("cfc"));
	}

}
