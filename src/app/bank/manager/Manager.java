package app.bank.manager;

public class Manager 
{
	private String[] userPass = new String[2];
	private String [] name = new String[2];
	
	public Manager()
	{
		
	}
	
	public Manager(String userPass[], String name[])
	{
		this.setName(name);
		this.setUserPass(userPass);
	}
	
	public void setUserPass(String[] userPass)
	{
		System.arraycopy(userPass, 0, this.userPass, 0, userPass.length);
	}
	
	public String[] getUserPass() 
	{
		return userPass;
	}

	public void setName(String[] name) 
	{
		System.arraycopy(name, 0, this.name, 0, name.length);
	}
	
	
	public String[] getName() 
	{
		return name;
	}
}
