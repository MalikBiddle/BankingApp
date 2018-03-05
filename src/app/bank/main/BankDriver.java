package app.bank.main;

import app.bank.thebank.Bank;
import app.bank.util.Utilities;
import app.bank.util.menus.Menus;

public class BankDriver 
{
	public static Bank myBank = new Bank();
	
	public static void start()
	{
		String[] userPass = new String[] {"x", "x"};
		String[] name = new String[] {"x", "x"};
		myBank.createUserPasstoNameSet(userPass, name);
		
		userPass[0]="Slayer"; userPass[1] = "x";
		name[0] = "M"; name[1] = "B";
		
		myBank.createUserPasstoNameSet(userPass, name);
		
		System.out.println("\n\n");
		
		
		Utilities.createTitle("Main Menu");
		Menus.mainMenu();
	}
}
