package app.bank.customer;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testSetGetArrUserPass() 
	{
		Customer c = new Customer();
		String[] arrUserPass = new String[] {"User","Pass"};
		c.setUserPass(arrUserPass);
		assertArrayEquals(arrUserPass, c.getUserPass());
	}
	
	@Test
	
	public void testSetGetName() 
	{
		Customer c = new Customer();
		String [] name = new String[]{"First","Last"};
		c.setName(name);
		assertArrayEquals(name, c.getName());
	}
	

}
