package app.bank.util.menus.customer;

import java.util.Arrays;
import java.util.Iterator;

import app.bank.main.BankDriver;
import app.bank.thebank.Accounts;
import app.bank.util.Utilities;

public class CustomerMenus 
{
	public static boolean createAccount()
	{
		Utilities.createTitle("Create Account");
		System.out.println("Your request has been sent once approved you will be able to access the account.");
		BankDriver.myBank.createRegAccount(CustomerMenusNavigation.currCustomer);
		return true;
	}

	public static boolean createJointAccount()
	{
		Utilities.createTitle("Create Joint Account");
		System.out.println("Your request has been sent once approved you will be able to access the account.");
		BankDriver.myBank.createRegAccount(CustomerMenusNavigation.currCustomer);
		return true;
	}

	public static String accessAccount()
	{
		Utilities.createTitle("Access Account");
		Iterator<Accounts> it = CustomerMenusNavigation.currCustomer.getAccounts().iterator();
		
		String [] temp = new String[CustomerMenusNavigation.currCustomer.getAccounts().size()];
		int i = 0;
		while(it.hasNext())
		{
			temp[i] = it.next().getAccNumber();
			i++;
		}
		Utilities.createMenu(temp,"Please choose an account");
		i = Utilities.getSelection();
		
		return temp[i-1];
	}

	public static void Deposit()
	{
		Utilities.createTitle("Deposit");
		double currAmount = CustomerMenusNavigation.currAccount.getBalance();
		double toAdd = Utilities.getAmount(); 
		
		if(toAdd < 0)
		{
			while(toAdd < 0)
			{
				toAdd = Utilities.getAmount(); 
			}
		}

		CustomerMenusNavigation.currAccount.setBalance(currAmount+toAdd);
	}

	public static void Withdraw()
	{
		Utilities.createTitle("Withdraw");
		double currAmount = CustomerMenusNavigation.currAccount.getBalance();
		double toSub = Utilities.getAmount(); 
		
		if(toSub < 0)
		{
			while(toSub < 0)
			{
				toSub = Utilities.getAmount(); 
			}
		}

		CustomerMenusNavigation.currAccount.setBalance(currAmount-toSub);
	}

	public static void Transfer()
	{
		Utilities.createTitle("Transfer");
		Iterator<Accounts> it = CustomerMenusNavigation.currCustomer.getAccounts().iterator();
		
		String [] temp = new String[CustomerMenusNavigation.currCustomer.getAccounts().size()];
		int i = 0;
		
		while(it.hasNext())
		{
			temp[i] = it.next().getAccNumber();
			
			if(temp[i].equals(CustomerMenusNavigation.currAccount.getAccNumber()))
			{
				continue;
			}
			
			i++;
		}
		
		Utilities.createMenu(temp,"Please choose an account to transfer to");
		i = Utilities.getSelection()-1;
		
		Iterator<Accounts> it1 = CustomerMenusNavigation.currCustomer.getAccounts().iterator();
		
		while(it1.hasNext())
		{
			Accounts tempAcc = new Accounts(it1.next());
			
			if(temp[i].equals(tempAcc.getAccNumber()))
			{
				tempAcc.copyTo(CustomerMenusNavigation.transferAccount);
				break;
			}
		}
		
		double currAmount = CustomerMenusNavigation.currAccount.getBalance();
		double toSub = Utilities.getAmount(); 
		
		if(toSub < 0)
		{
			while(toSub < 0)
			{
				toSub = Utilities.getAmount(); 
			}
		}
			
		CustomerMenusNavigation.currAccount.setBalance(currAmount-toSub);
		CustomerMenusNavigation.transferAccount.setBalance(CustomerMenusNavigation.transferAccount.getBalance()+toSub);
	}

	public static String[] registerOrNew()
	{	
		String userPassName[] = new String[4];
		System.out.println("\nGreetings customer!");
		boolean pass;
		
		Utilities.scan.nextLine();

		System.out.print("\nUsername: ");	
		userPassName[0] = Utilities.scan.nextLine();

		System.out.print("\nPassword: ");
		userPassName[1] = Utilities.scan.nextLine();

		System.out.print("\nFirst Name: ");
		userPassName[2] = Utilities.scan.nextLine();

		System.out.print("\nLast Name: ");
		userPassName[3] = Utilities.scan.nextLine();

		pass = BankDriver.myBank.createUserPasstoNameSet(Arrays.copyOfRange(userPassName, 0, 2), Arrays.copyOfRange(userPassName, 2, userPassName.length));
		
		if(!pass)
		{
			while(!pass);
			{	
				System.out.println("You have an account and your info is invalid. Please enter correct information.");

				System.out.print("\nUsername: ");	
				userPassName[0] = Utilities.scan.nextLine();

				System.out.print("\nPassword: ");
				userPassName[1] = Utilities.scan.nextLine();

				System.out.print("\nFirst Name: ");
				userPassName[2] = Utilities.scan.nextLine();

				System.out.print("\nLast Name: ");
				userPassName[3] = Utilities.scan.nextLine();
			
				pass = BankDriver.myBank.createUserPasstoNameSet(Arrays.copyOfRange(userPassName, 0, 2), Arrays.copyOfRange(userPassName, 2, userPassName.length));
			}
		}

		System.out.println("You have successfully logged in!\n");

		return userPassName;
	}

	public static String[] login()
	{
		String userPassName[] = new String[4];

		Utilities.scan.nextLine();
		
		boolean pass = true;
		System.out.println("Please enter login information");

		System.out.print("\nUsername: ");	
		userPassName[0] = Utilities.scan.nextLine();

		System.out.print("\nPassword: ");
		userPassName[1] = Utilities.scan.nextLine();

		System.out.print("\nFirst Name: ");
		userPassName[2] = Utilities.scan.nextLine();

		System.out.print("\nLast Name: ");
		userPassName[3] = Utilities.scan.nextLine();

		pass = BankDriver.myBank.login(Arrays.copyOfRange(userPassName, 0, 2), Arrays.copyOfRange(userPassName, 2, userPassName.length));

		if(!pass)
		{
			while(!pass);
			{	
				System.out.println("You have an account and your info is invalid. Please enter correct information.");

				System.out.print("\nUsername: ");	
				userPassName[0] = Utilities.scan.nextLine();

				System.out.print("\nPassword: ");
				userPassName[1] = Utilities.scan.nextLine();

				System.out.print("\nFirst Name: ");
				userPassName[2] = Utilities.scan.nextLine();

				System.out.print("\nLast Name: ");
				userPassName[3] = Utilities.scan.nextLine();
			
				pass = BankDriver.myBank.createUserPasstoNameSet(Arrays.copyOfRange(userPassName, 0, 2), Arrays.copyOfRange(userPassName, 2, userPassName.length));
			}
		}

		System.out.println("You have successfully logged in!\n");

		return userPassName;
	}

}
