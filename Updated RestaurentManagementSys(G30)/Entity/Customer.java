package Entity;
import java.lang.*;
public class Customer
{
	private String customerId;
	private String name;
	
	
	public Customer(){}
	public Customer(String customerId, String name)
	{
		this.customerId = customerId;
		this.name = name;	
	}
	
	public void setCustomerId(String customerId){this.customerId = customerId;}
	public void setName(String name){this.name = name;}
	public String getCustomerId(){return customerId;}
	public String getName(){return name;}

	

}
