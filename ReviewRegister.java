package CUS1156Project3;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * This is a wrapper class. It wraps a list of review objects. The wrapper class has a bunch of
 * methods which are particularly invoked on the list containing the reviews.
 * @author sayefiqbal
 *
 */
	public class ReviewRegister implements Serializable {

		ArrayList<Review> reviewList = new ArrayList<Review>();
/**
 * This is method adds review to the central review list and also 
 * to the restaurnat's review list.
 * @param review
 */
		public void addReview(Review review)
		{	
			reviewList.add(review);
			Restaurant restaurant = review.getRestaurant();
			restaurant.addReview(review);
		}
		public Review getReview(Review review)
		{	
			for(Review rview: reviewList)
			{
				if(rview.equals(review))
				{
					return review;
				}
			}
			return null;
		}
/**
 * This method returns a list of reviews written by a user. It searches for the reviews from a list 
 * of all reviews and gets the reviews that were written by a particular user with a unique user id
 * passed as a parameter.		
 * @param userId
 * @return
 */
		public ArrayList<Review> getReviewByUser(String userId)
		{
			ArrayList<Review> reviews = new ArrayList<Review>();
			for(Review review: reviewList)
			{
				if(review.getUser().getUserId().equals(userId))
				{
					reviews.add(review);
				}
			}
			return reviews;
		}

		/**
		 * This method returns a list of reviews by a user. It searches for the reviews from a list 
		 * of all reviews and gets the reviews that were intended for a particular restaurant with a
		 * unique restaurant id passed as a parameter.
		 * @param restaurantId
		 * @return
		 */
		public ArrayList<Review> getReviewForRestaurant(String restaurantId)
		{
			ArrayList<Review> reviews = new ArrayList<Review>();
			for(Review review: reviewList)
			{
				if(review.getRestaurant().getRestaurantId().equals(restaurantId))
				{
					reviews.add(review);
				}
			}
			return reviews;
		}
	/**
	 * This method returns the average of all the review ratings for a specific restaurant	
	 * @param restaurantId
	 * @return
	 */
		public String getAverageStars(String restaurantId)
		{
			int count = 0;
			int length = 0;
		
			for(Review review: reviewList)
			{
				if(review.getRestaurant().getRestaurantId().equals(restaurantId)&&review.getReviewStars()!=null)
				{ 
					length = review.getReviewStars().length()+ length;
						count = count +1 ;
				}
			}
			if(length>0&&count>0)
			{	int average = length/count;
				String averageStar = new String(new char[average]).replace("\0", "*"); 
				return averageStar;
			}
			return null;
		}
		

}
