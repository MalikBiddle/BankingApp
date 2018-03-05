package app.bank.util.menus.customer;

import java.util.Arrays;
import java.util.Iterator;
import app.bank.customer.Customer;
import app.bank.thebank.Accounts;
import app.bank.thebank.Bank;
import app.bank.util.Utilities;
import app.bank.util.menus.Menus;

public class CustomerMenusNavigation 
{
	public static Customer currCustomer = new Customer();
	public static Accounts currAccount = new Accounts();
	public static Accounts transferAccount = new Accounts();
	
	public static void customerMenu()
	{
		System.out.println("");
		Utilities.createTitle("Customer Menu");
		String[] options = new String[] {"Register", "Login", "Main"};
		Utilities.createMenu(options, "Please Login or Register.");
		int i = Utilities.getSelection();
		
		switch(i)
		{
		
		case 1:
		{
			Utilities.createTitle("Registration");
			String[] temp = new String[4];
			
			temp = CustomerMenus.registerOrNew();
			
			currCustomer.setUserPass(Arrays.copyOfRange(temp, 0, 2));
			currCustomer.setName(Arrays.copyOfRange(temp, 2, temp.length));
			customerActions();
			break;
		}
		
		case 2:
		{
			Utilities.createTitle("Login");
			String[] temp = new String[4];
			
			temp = CustomerMenus.login();
			
			currCustomer.setUserPass(Arrays.copyOfRange(temp, 0, 2));
			currCustomer.setName(Arrays.copyOfRange(temp, 2, temp.length));
			customerActions();
			break;
		}
		
		case 3:
		{
			Menus.mainMenu();
			break;
		}
		}
	}
	
	public static void customerActions()
	{
		String[] options = new String[] {"Create Account", "Create Joint Account", "Access Accounts", "Logout"};	
		Utilities.createTitle("Customer Actions");
		Utilities.createMenu(options);
		
		
		switch(Utilities.getSelection())
		{
		case 1:
		{
			boolean pass = CustomerMenus.createAccount();
			
			while(!pass)
			{
				pass = CustomerMenus.createAccount();
			}
			
			customerActions();
			break;
		}
		
		case 2:
		{			
			boolean pass = CustomerMenus.createJointAccount();
			
			while(!pass)
			{
				pass = CustomerMenus.createJointAccount();
			}
			
			customerActions();
			break;
		}
		
		case 3:
		{
			String accChoice = CustomerMenus.accessAccount();
			
			Iterator<Accounts> it = CustomerMenusNavigation.currCustomer.getAccounts().iterator();
			
			while(it.hasNext())
			{
				Accounts tempAcc = new Accounts(it.next());
				
				if(accChoice.equals(tempAcc.getAccNumber()))
				{
					tempAcc.copyTo(currAccount);
					break;
				}
			}
			
			accountActions();
			break;
		}
		
		case 4:
		{
			Menus.mainMenu();
			break;
		}
		}
	}
	
	public static void accountActions()
	{
		System.out.println(" ");
		
		String[] options = new String[] {"Deposit", "Withdraw", "Transfer", "Display Balance", "Back", "Logout"};
		Utilities.createTitle("Accoint Actions");
		Utilities.createMenu(options);
		
		switch(Utilities.getSelection())
		{
		case 1:
		{
			CustomerMenus.Deposit();
			System.out.println(currAccount.getBalance());
			Bank.updateCustomer(currCustomer, currAccount);
			accountActions();
			break;
		}
		
		case 2:
		{
			CustomerMenus.Withdraw();
			System.out.println(currAccount.getBalance());
			Bank.updateCustomer(currCustomer, currAccount);
			accountActions();
			break;
		}
		
		case 3:
		{
			CustomerMenus.Transfer();
			Bank.updateCustomer(currCustomer, currAccount, transferAccount);
			accountActions();
			break;
		}
		
		case 4:
		{
			System.out.println("The balance on this account is: " + currAccount.getBalance());
			accountActions();
		}
		
		case 5:
		{
			customerActions();
		}
		
		case 6:
		{
			Menus.mainMenu();
			break;
		}
		}
	}

}
