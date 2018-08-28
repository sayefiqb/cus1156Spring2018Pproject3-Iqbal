package CUS1156Project3;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This is a review class. It stores all the necessary information a review has. It stores the
 * comment, ratings, date and time review was created, the user who created the review and 
 * the restaurant the review was intended for.
 * @author sayefiqbal
 *
 */
public class Review implements Serializable{

	public String reviewComment;
	public String reviewStars;
	public LocalDateTime reviewDateTime;
	public User user;
	public Restaurant restaurant;
/**
 * default constructor	
 */
public Review()
{
	this.reviewComment="";
	this.reviewStars="";
	this.reviewDateTime=null;
	this.user=null;
	this.restaurant=null;
}
/**
 * Regular constructor that creates an object with all the necessary details a review can have
 * @param comment
 * @param stars
 * @param dateTime
 * @param user
 * @param restaurant
 * @throws ParseException
 */
public Review(String comment, String stars, LocalDateTime dateTime, User user, 
		Restaurant restaurant) throws ParseException
{
   this.reviewComment=comment;
   this.reviewStars=stars;
   //String localDateTime = dateTime;
   //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
   //LocalDateTime dt = LocalDateTime.parse(localDateTime, formatter);
   this.reviewDateTime=dateTime;
   this.user=user;
   this.restaurant=restaurant;
}

/**
 * gets the review comment
 * @return
 */
public String getReviewComment() {
	return reviewComment;
}

/**
 * sets the review comment
 * @param reviewComment
 */
public void setReviewComment(String reviewComment) {
	this.reviewComment = reviewComment;
}

/**
 * gets the review stars or ratings a user puts in the review for a restaurant
 * @return
 */
public String getReviewStars() {
	return reviewStars;
}

/**
 * sets the review stars or ratings a user puts in the review for a restaurant
 * @param reviewStars
 */
public void setReviewStars(String reviewStars) {
	this.reviewStars = reviewStars;
}

/**
 * gets the date and time the review was created in the form of LocalDateTime
 * @return
 */
public LocalDateTime getReviewDate() {
	return reviewDateTime;
}

/**
 * sets the date and time the review was created in the form of LocalDateTime
 * @param reviewDateTime
 */
public void setReviewDateTime(LocalDateTime reviewDateTime) {
	this.reviewDateTime = reviewDateTime;
}

/**
 * gets the user who wrote the review
 * @return
 */
public User getUser() {
	return user;
}

/**
 * sets the user who wrote the review
 * @param user
 */
public void setUser(User user) {
	this.user = user;
}

/**
 * gets the restaurant the review was intended for
 * @return
 */
public Restaurant getRestaurant() {
	return restaurant;
}

/**
 * sets the restaurant the review is intended for
 * @param restaurant
 */
public void setRestaurant(Restaurant restaurant) {
	this.restaurant = restaurant;
}

}


