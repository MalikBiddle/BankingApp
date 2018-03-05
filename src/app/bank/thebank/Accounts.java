package app.bank.thebank;

public class  Accounts 
{
	private String accNumber;
	//private String[] customer1 = new String[2];
	//private String[] customer2 = new String[2];
	private boolean joint;
	private double balance;
	
	public Accounts()
	{
		
	}
	
	public Accounts(String accNumber, boolean joint, double balance)
	{
		this.accNumber = accNumber;
		this.joint = joint;
		this.balance = balance;
	}
	
	public Accounts(Accounts a)
	{
		this.accNumber = a.getAccNumber();
		this.joint = a.getJoint();
		this.balance = a.getBalance();
	}
	
	public String getAccNumber()
	{
		return this.accNumber;
	}
	
	public void setAccNumber(String accNumber)
	{
		this.accNumber = accNumber;
	}
	
	public boolean getJoint()
	{
		return this.joint;
	}
	
	public void setJoint(boolean j)
	{
		this.joint = j;
	}
	
	public void setBalance(double bal)
	{
		this.balance = bal;
	}
	
	public double getBalance()
	{
		return this.balance;
	}
	
	public void copyTo(Accounts a)
	{
		a.setAccNumber(this.accNumber);
		a.setJoint(this.joint);
		a.setBalance(this.balance);
	}
	
	
}
