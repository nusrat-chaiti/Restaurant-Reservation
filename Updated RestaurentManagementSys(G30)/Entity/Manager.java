package Entity;

import java.lang.*;

public class Manager
{
	private String managerId;
	private String name;
	

	
	public Manager(){}
	public Manager(String managerId, String name)
	{
		this.managerId = managerId;
		this.name = name;

	}
	
	public void setManagerId(String managerId){this.managerId = managerId;}
	public void setName(String name){this.name = name;}
	public String getManagerId(){return managerId;}
	public String getName(){return name;}
	
}