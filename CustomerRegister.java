package CUS1156Project3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
/**
 * This is a wrapper class. It wraps a list of Users. The class has three important methods
 * addUser and two getCustomer methods with different parameters. 
 * @author sayefiqbal
 *
 */
public class CustomerRegister implements Serializable {

	//ArrayList<User> customerList = new ArrayList<User>();
	HashMap<String, User> customerList = new HashMap<String, User>();
	
	/**
	 * This method takes in a user as a parameter and adds it to the list(array list) of
	 * users called customerList.
	 * @param customer
	 * @return
	 */
	public void addCustomer(User customer)
	{
		String userId = customer.getUserId();
		customerList.put(userId, customer);
		//customerList.add(customer);
	}

	/**
	 * This method takes in a user and does a linear search through the list of users and 
	 * tries to find the user passed in as a parameter. The user id (customerId)
	 * is unique for each user.
	 * @param customer
	 * @return
	 */
//	public User getCustomer(User customer)
//	{
//		for(User cstmer: customerList)
//		{
//			if(cstmer.equals(customer))
//				return cstmer;
//		}
//		return null;
//	}
	
	/**
	 * This method takes in a user id and does a linear search through the list of users and 
	 * tries to find the user with the particular id passed in as a parameter. The user id (customerId)
	 * is unique for each user.
	 * @param customerId
	 * @return
	 */
	public User getCustomerById(String customerId)
	{
/**		for(User cstmer: customerList)
	{
		if(cstmer.getUserId().equals(customerId))
		{
			return cstmer;
		}
	}
	return null;
**/	
		
		for(String userId: customerList.keySet())
		{
			if(userId.equals(customerId))
			{
				return customerList.get(userId);
			}
		}
		return null;
		
	}
}
