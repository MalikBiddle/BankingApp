package app.bank.thebank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import app.bank.customer.Customer;
import app.bank.util.employee.Employee;
import app.bank.util.menus.customer.CustomerMenusNavigation;

public class Bank 
{
	ArrayList<Accounts> accNumbersTaken = new ArrayList<Accounts>();
	Set<String> validRegNumbers = new HashSet<String>();
	Set<String> validJointNumbers = new HashSet<String>();
	public ArrayList<Customer> customers = new ArrayList<Customer>();
	public ArrayList<Employee> employees = new ArrayList<Employee>();
	public ArrayList<Manager> managers = new ArrayList<Managers>();
	public static int currRegAccountNumber = 0;
	public static int currJointAccountNumber = 0;
	HashMap<Customer, String> pendingAccounts = new HashMap<Customer,String>();
	
	public Bank()
	{
		while(validRegNumbers.size() <100)
		{
			validRegNumbers.add(createBankNumber(false));
		}
		
		while(validRegNumbers.size() <100)
		{
			validRegNumbers.add(createBankNumber(false));
		}
	}
	
	public boolean createUserPasstoNameSet(String[] userPass, String[] name)
	{
		if (customers.isEmpty())
		{
			Customer temp = new Customer();
			temp.setUserPass(userPass);
			temp.setName(name);
			customers.add(temp);
			System.out.println("You have successfully created a new account!");
			return true;
		}
		
		else
		{
			Iterator<Customer> itCustomer = customers.iterator();
			
			while (itCustomer.hasNext())
			{
				Customer currCustomer = new Customer(itCustomer.next());
				
				if(Arrays.equals(currCustomer.getName(),name))
				{
					if(Arrays.equals(currCustomer.getUserPass(), userPass))
					{
						//Don't need to add new customer because it's already there
						System.out.println("Your details are in the system. You have been logged in");
						return true;
					}
					
					else
					{
						System.out.println("You already have an account and entered incorrect data. Please try again");
						return false;
					}
				}
			}
			
			Customer temp = new Customer(userPass,name);
			customers.add(temp);
			System.out.println("You have successfully created a new account!");
			return true;
		}		
	}
	
	public boolean login(String[] userPass, String[] name)
	{

		if (customers.isEmpty())
		{
			Customer temp = new Customer();
			temp.setUserPass(userPass);
			temp.setName(name);
			customers.add(temp);
			System.out.println("You have successfully created a new account!");
			return true;
		}
		
		else
		{
			Iterator<Customer> itCustomer = customers.iterator();
			
			while (itCustomer.hasNext())
			{
				Customer currCustomer = new Customer(itCustomer.next());
				
				if(Arrays.equals(currCustomer.getName(),name))
				{
					if(Arrays.equals(currCustomer.getUserPass(), userPass))
					{
						//Don't need to add new customer because it's already there
						return true;
					}
					
					else
					{
						System.out.println("You entered the incorrect details.");
						return false;
					}
				}
			}
		}
		
		System.out.println("Information not found.");
		return false;
	}

	public void createRegAccount(Customer c)
	{
		Object[] a;
		//String num = createBankNumber(false);
		//pendingAccounts.put(c,num);
		int temp = 0;
		String tempString;
		Iterator<String> it = validRegNumbers.iterator();
		
		while (temp != currRegAccountNumber)
		{
			it.next();
			temp++;
		}
		
		System.out.println(temp);
		Accounts acc = new Accounts(it.next(), false, 0);
		CustomerMenusNavigation.currCustomer.addAccount(acc);
		currRegAccountNumber++;
		//System.out.println(pendingAccounts.size());
	}
	
	public void createJointAccount(Customer c, Customer c2)
	{
		String num = createBankNumber(false);
		//pendingAccounts.put(c,num);
		Accounts acc = new Accounts(num, true, 0);
		//CustomerMenusNavigation.currCustomer.addAccount(acc);
		//System.out.println(pendingAccounts.size());
	}

	public ArrayList<Accounts> getAccountsMap()
	{
		return this.accNumbersTaken;
	}
	
	public static String createBankNumber(boolean joint)
	{
		Random randGen = new Random();
		int min = 1000000, max = 9999999;
		
		int accNum = randGen.nextInt((max - min) + 1) + min;
		String bankNum;
		
		if(joint)
		{
			bankNum = "J" + Integer.toString(accNum);
		}
		
		else
		{
			bankNum = "R" + Integer.toString(accNum);
		}
		
		return bankNum;
	}
	
	public static void updateCustomer(Customer c, Accounts... account)
	{
		c.findAccount(account[0]).setBalance(account[0].getBalance());
		
		if(account.length > 1)
		{
			c.findAccount(account[1]).setBalance(account[1].getBalance());
		}
	}

	
}
