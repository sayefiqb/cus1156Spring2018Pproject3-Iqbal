package CUS1156Project3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerRegisterTest {

	CustomerRegister customerRegister;
	
	@Before
	public void setUp() throws Exception {
		customerRegister = new CustomerRegister();
	}

	@Test
	public void testAddCustomer() {
		User expected = new User("Iqbal","Sayef","Sj93299347");
		customerRegister.addCustomer(expected);
		assertEquals(expected,customerRegister.customerList.get(0));
	}

//	@Test
//	public void testGetCustomer() {
//		User expected= new User("Iqbal","Sayef","Sj93299347");
//		customerRegister.addCustomer(expected);
//		User actual = customerRegister.getCustomer(expected);
//		assertEquals(actual,expected);
//	}

	@Test
	public void testGetCustomerById() {
		User expected = new User("Iqbal","Sayef","Sj93299347");
		customerRegister.addCustomer(expected);
		User actual = customerRegister.getCustomerById("Sj93299347");
		assertEquals(actual,expected);
	}

}
