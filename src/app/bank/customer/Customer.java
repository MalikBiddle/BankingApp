package app.bank.customer;

import java.util.ArrayList;
import java.util.Arrays;

import app.bank.thebank.Accounts;

public class Customer 
{
	private String[] userPass = new String[2];
	private String [] name = new String[2];
	private ArrayList<Accounts> accounts = new ArrayList<Accounts>();

/**************** Constructors ****************/	
	public Customer()
	{
		
	}
	
	public Customer(String[] userPass, String[] name)
	{
		setUserPass(userPass);
		setName(name);
	}
	
	public Customer(Customer customer)
	{
		this.setUserPass(customer.userPass);
		this.setName(customer.name);
		this.setAccounts(customer.accounts);
	}
/**********************************************/
	
	public String[] getUserPass()
	{
		return userPass;
	}
	
	public void setUserPass(String[] userPass) 
	{
		System.arraycopy(userPass, 0, this.userPass, 0, userPass.length);
	}
	
	public String[] getName() 
	{
		return name;
	}
	
	public void setName(String[] name) 
	{
		System.arraycopy(name, 0, this.name, 0, name.length);
	}
	
	public ArrayList<Accounts> getAccounts() 
	{
		return accounts;
	}
	
	public void setAccounts(ArrayList<Accounts> accounts) 
	{
		this.accounts.clear();
		
		for(Accounts s: accounts)
		{
			this.accounts.add(s);
		}
		
		this.accounts = accounts;
	}
	
	public void addAccount(Accounts acc)
	{
		accounts.add(acc);
	}
	
	public Accounts findAccount(Accounts acc)
	{
		Accounts temp = new Accounts();
		
		for(Accounts a: accounts)
		{
			if(a.getAccNumber().equals(acc.getAccNumber()))
			{
				return a;
			}
		}
		
		return temp;
	}
	
}
