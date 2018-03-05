package app.bank.util.menus.employee;

import java.util.Arrays;
import java.util.Iterator;

import app.bank.thebank.Accounts;
import app.bank.thebank.Bank;
import app.bank.util.Utilities;
import app.bank.util.menus.Menus;
import app.bank.util.menus.customer.CustomerMenus;
import app.bank.util.menus.customer.CustomerMenusNavigation;

public class EmployeeMenus
{
	public static void employeeMenu()
	{
		System.out.println("");
		Utilities.createTitle("Employee Menu");
		String[] options = new String[] {"Login", "Main"};
		Utilities.createMenu(options);
		int i = Utilities.getSelection();
		
		switch(i)
		{		
		case 1:
		{
			Utilities.createTitle("Login");
			String[] temp = new String[4];
			
			temp = CustomerMenus.login();
			
			//currCustomer.setUserPass(Arrays.copyOfRange(temp, 0, 2));
			//currCustomer.setName(Arrays.copyOfRange(temp, 2, temp.length));
			//customerActions();
			break;
		}
		
		case 2:
		{
			Menus.mainMenu();
			break;
		}
		}
	}
	
	public static void employeeActions()
	{
		String[] options = new String[] {"Approve Account", "Approve Joint Account", "View Customer", "Logout"};	
		Utilities.createTitle("Customer Actions");
		Utilities.createMenu(options);
		
		
		switch(Utilities.getSelection())
		{
		case 1:
		{
			boolean pass = CustomerMenus.createAccount();
			
			//customerActions();
			break;
		}
		
		case 2:
		{			
			boolean pass = CustomerMenus.createJointAccount();
			
			while(!pass)
			{
				pass = CustomerMenus.createJointAccount();
			}
			
			//customerActions();
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
					//tempAcc.copyTo(currAccount);
					break;
				}
			}
			
			//accountActions();
			break;
		}
		
		case 4:
		{
			Menus.mainMenu();
			break;
		}
		}
	}
}
