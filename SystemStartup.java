package CUS1156Project3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

/**
 * This is the user interactive class that loads all the files to initialize restaurant sysytem.
 * It provides a command line option to select user type and for login promtps. This where all the 
 * system starts up.
 * @author sayefiqbal
 *
 */
public class SystemStartup implements Serializable{

 public static void main(String [] args) throws ParseException, ClassNotFoundException, IOException
{
		CustomerInterface customerInterface;
		RestaurantInterface restaurantInterface;
		String customerId;
		String restaurantId;
		RestaurantSystem restaurantSystem;
	   
	if(serializedFileExists("rsys.txt"))	
	{
		restaurantSystem = loadReservationSystem();
	}
	else
	{	CustomerRegister customers = loadUsers();
	    RestaurantRegister restaurants = loadRestaurants();
	    ReviewRegister reviews = loadReviews();
	    ReservationRegister reservationRegister = new ReservationRegister();
	    restaurantSystem = new RestaurantSystem(restaurants,customers,reviews,reservationRegister);
	}
		Scanner in = new Scanner(System.in);
	    String userType;
	    userType = getUserType(in);
	while(!userType.equals("Q"))
	{		
		if (userType.equals("customer"))
		{    	   
	        customerInterface = new CustomerInterface(restaurantSystem);
	        customerId = customerLogin(in);
	        while(!customerId.equals("exit"))
	        {   if(restaurantSystem.getCustomerById(customerId)!=null)
	        		{
	        	customerInterface.customerAction(in,customerId);
	        		}
	        customerId = customerLogin(in);
	        }
	        System.out.println("***Exiting customer interface***");
	    }
		
	    if(userType.equals("restaurant"))
	    {
	    	restaurantInterface = new RestaurantInterface(restaurantSystem);
	    restaurantId = restaurantLogin(in);
	    		while(!restaurantId.equals("exit"))
	    		{
	    			if(restaurantSystem.getRestaurantById(restaurantId)!=null)
	    			{
	    				restaurantInterface.restaurantAction(in,restaurantId);
	    			}
	    			restaurantId = restaurantLogin(in);
	    		}
	    		System.out.println("***Exiting restaurant interface***");
	    }
	   userType = getUserType(in);
	}
		System.out.println("***Exiting the restaurant management system***");
		System.out.println("Bye!");
		try {
			writeResSystem(restaurantSystem);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		in.close();
}
	private static Boolean serializedFileExists(String filePath) {
		File tmpDir = new File(filePath);
		return tmpDir.exists();
	}
	
	private static void writeResSystem(RestaurantSystem rsys) throws Exception, IOException {
		ObjectOutputStream out=null;
		out = new ObjectOutputStream( new FileOutputStream("rsys.txt"));
		out.writeObject(rsys); 
		out.close();
	}
	
	private static RestaurantSystem loadReservationSystem() throws IOException, ClassNotFoundException {
		RestaurantSystem resSystem= new RestaurantSystem(null,null,null,null);
			FileInputStream fin = new FileInputStream("rsys.txt");
			ObjectInputStream oin = new ObjectInputStream(fin);
			resSystem = (RestaurantSystem) oin.readObject();

		return resSystem;
	}
	
	/**
	 * Returns the user type(restaurant or customer) typed by the user 	
	 * @param in
	 * @return
	 */
	public static String getUserType(Scanner in)
	{
		 System.out.println("What type of user are you? Type customer or restaurant. Type Q to exit.");
		 String type = in.nextLine();
		 return type;
	}
	
	/**
	 * This method prompts the customer for a user id. Returns the user id typed by customer.
	 * @param input
	 * @return
	 */
	public static String customerLogin(Scanner input)
	{
		System.out.println("Please enter your user id. Type exit to leave.");
		String customerId = input.nextLine();
		return customerId;	
	}
	/**
	 * This method prompts the restaurant owner/manager for a restaurant id. Returns the restaurant id
	 * typed by the  owner/manger.
	 * @param input
	 * @return
	 */
	public static String restaurantLogin(Scanner input)
	{
		System.out.println("Please enter your restaurant id. Type exit to leave");
		String restaurantId = input.nextLine();
		return restaurantId;
	}
	
	/**
	 * This method reads in the review.txt file and loads/adds each review to the review list.
	 * @return
	 * @throws ParseException
	 */
	private static ReviewRegister loadReviews() throws ParseException {
		ReviewRegister revList = new ReviewRegister();
		Scanner fileIn;
		try {
			fileIn = new Scanner(new File("review.txt"));
			
			while (fileIn.hasNextLine())
			{
				String line = fileIn.nextLine();
				Review review = processReviewInputLine(line);
				revList.addReview(review);
			}
			fileIn.close();
	    } catch (FileNotFoundException e) {
			 System.err.println("Error reading restaurant file");
			e.printStackTrace();
		}
		return revList;
		}
		// TODO Auto-generated method stub
		
/**
 * This is a helper method. It reads each line and tokenizes all the words in the line and
 * initializes a review object with the tokens (user object and restuarant object are also created 
 * from the tokens) and returns the review object.
 * @param line
 * @return
 * @throws ParseException
 */
	private static Review processReviewInputLine(String line) throws ParseException {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(",");
		String reviewComment = lineScanner.next();
		String reviewRating = lineScanner.next();
		String reviewDateTime = lineScanner.next();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		LocalDateTime dt = LocalDateTime.parse(reviewDateTime, formatter);
		String customerId = lineScanner.next();
		String customerLastName = lineScanner.next();
		String customerFirstName = lineScanner.next();
		String id = lineScanner.next();
		String name = lineScanner.next();
		String cuisine = lineScanner.next();
		String street = lineScanner.next();
		String city = lineScanner.next();
		String state = lineScanner.next();
		String zip = lineScanner.next();
		char liqFlag = lineScanner.next().charAt(0);
		Boolean hasLic;
		if (liqFlag == 'T')
			hasLic=true;
		else
			hasLic = false;
		int capacity = lineScanner.nextInt();

	    Restaurant rest = new Restaurant(name,id, cuisine, street,city,state,zip, capacity, hasLic);
	    User customer = new User (customerLastName,customerFirstName,customerId);
	    Review review = new Review (reviewComment,reviewRating,dt,customer,rest);
		lineScanner.close();
		return review;
	}

	/**
	 * This method reads in the restaurant.txt file and add/loads all the restaurants into the 
	 * restaurant list.
	 * @return
	 */
	private static RestaurantRegister loadRestaurants() {
		RestaurantRegister restList = new RestaurantRegister();
		Scanner fileIn;
	    try {
			fileIn = new Scanner(new File("restaurant.txt"));


		while (fileIn.hasNextLine()) {
		 String line = fileIn.nextLine();
		 Restaurant rest = processRestInputLine(line);

		 restList.addRestaurant(rest);
   	}
		fileIn.close();
	    } catch (FileNotFoundException e) {
			 System.err.println("Error reading restaurant file");
			e.printStackTrace();
		}
		return restList;
	}

	/**
	 * This is a helper method. It reads in each line and tokenizes each word and uses it to
	 * instantiate a restaurant object and then returns the restaurant object.
	 * @param line
	 * @return
	 */
	private static Restaurant processRestInputLine(String line) {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(",");
		String id = lineScanner.next();
		String name = lineScanner.next();
		String cuisine = lineScanner.next();
		String street = lineScanner.next();
		String city = lineScanner.next();
		String state = lineScanner.next();
		String zip = lineScanner.next();
		char liqFlag = lineScanner.next().charAt(0);
		Boolean hasLic;
		if (liqFlag == 'T')
			hasLic=true;
		else
			hasLic = false;
		int capacity = lineScanner.nextInt();

	    Restaurant rest = new Restaurant(name,id, cuisine, street,city,state,zip, capacity, hasLic);

		 lineScanner.close();
		return rest;
	}

	/**
	 * This is a helper method. It reads in each line and tokenizes each word and uses it to 
	 * instantiate a user object and then returns the user object.
	 * @param line
	 * @return
	 */
	private static User processUserInputLine(String line) {
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(",");
		String id = lineScanner.next();
		String fname = lineScanner.next();
		String lname = lineScanner.next();

	    User user = new User(fname,lname,id);

		 lineScanner.close();
		return user;
	}

	/**
	 * This method reads in the user.txt file and adds/loads all the users into the user list.
	 * @return
	 */
	private static CustomerRegister loadUsers() {
		CustomerRegister customerList = new CustomerRegister();
		Scanner fileIn;
	    try {
			fileIn = new Scanner(new File("users.txt"));


		while (fileIn.hasNextLine()){
		 String line = fileIn.nextLine();
		 User user = processUserInputLine(line);

		 customerList.addCustomer(user);
   	}
		fileIn.close();
	    } catch (FileNotFoundException e) {
		    System.err.println("error reading user file");
			e.printStackTrace();
		}

		return customerList;
	}
	}

