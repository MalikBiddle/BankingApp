package app.bank.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class UtilitiesTest {

	@Test
	public void testGetLogin() 
	{
		String arrTest[] = new String[] {"A", "B"};
		System.out.println("Enter A for Username B for Password");
		//assertArrayEquals(arrTest, Utilities.getLogin());
	}
	
	/*@Test
	public void testCreateBankNumberRegular()
	{
		assertEquals('R', Utilities.createBankNumber(false).charAt(0));
	}
	
	@Test
	public void testCreateBankNumberJoint()
	{
		assertEquals('J', Utilities.createBankNumber(true).charAt(0));
	}*/
}
