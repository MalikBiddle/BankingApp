package app.bank.util.menus;

import app.bank.util.Utilities;
import app.bank.util.menus.customer.CustomerMenusNavigation;

public class Menus 
{
	
	public static void mainMenu()
	{
		String[] options = new String[] {"Customer", "Employee", "Manager", "Exit"};
		Utilities.createMenu(options, "Welcome to the Banking App. Who are you?");
		int i = Utilities.getSelection();
		Utilities.createTitle("Main Menu");
		
		switch (i)
		{
		
		case 1:
		{
			CustomerMenusNavigation.customerMenu();
			break;
		}
		
		case 2:
		{
			//employeeMenu();
			break;
		}
		
		case 3:
		{
			//managerMenu();
			break;
		}
		
		case 4:
		{
			break;
		}
		
		}
	}
	
}
