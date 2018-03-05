package app.bank.util;

import java.util.Scanner;

public class Utilities 
{
	public static Scanner scan = new Scanner(System.in);
	
	public static Integer getSelection()
	{
		int selection=0;
		System.out.print("Please select an option: ");			
		selection = scan.nextInt();
		//1scan.close();
		
		return selection;
	}
	
	public static double getAmount()
	{
		double amt;
		
		System.out.print("Please enter the amount: ");	
		amt = scan.nextDouble();
		
		return amt;
	}
	
	public static void createMenu(String options[], String ...message)
	{
		if (message != null)
		{
			for(int i = 0; i < message.length; i++)
			{
				System.out.println(message[i]);	
			}
		}
		
		for(int i = 0; i < options.length; i++)
		{
			System.out.println("(" + (i+1) + ") " + options[i]);
		}
	}
	
	public static void createTitle(String title)
	{
		System.out.println("\n--------------------------------------------------");
		System.out.println("                    " + title);
		System.out.println("--------------------------------------------------");
		System.out.println(" ");
	}
	

}
