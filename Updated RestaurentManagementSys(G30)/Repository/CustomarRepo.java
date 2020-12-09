package Repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import Interfaces.*;

public class CustomerRepo implements ICustomerRepo
{
	DatabaseConnection dbc;
	
	public CustomerRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Customer c)
	{
		String query = "INSERT INTO customer VALUES ('"+c.getCustomerId()+"','"+c.getName()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String customerId)
	{
		String query = "DELETE from customer WHERE CustomerId='"+customerId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Customer c)
	{
		String query = "UPDATE customer SET CustomerId='"+c.getCustomerId()+"', Name = '"+c.getName()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	/*public Fooditem searchFooditem(String foodidId)
	{
		Fooditem fa = null;
		String query = "SELECT `FoodName`, `Price` FROM `Fooditem` WHERE `FoodId`='"+foodId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("FoodName");
				String price = dbc.result.getString("Price");
				
				fa = new Fooditem();
				fa.setFoodId(foodId);
				fa.setFoodName(name);
			    fa.setPrice(price);
			
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return emp;
	}*/
	public String[][] getAllTable()
	{
		ArrayList<Table> t1 = new ArrayList<Table>();
		String query = "SELECT * FROM table;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String tableId = dbc.result.getString("TableId");
				int name = dbc.result.getInteger("NumberOfChairs");
				int tstatus = dbc.result.getInteger("TableStatus");
				Table r = new Table(tableID,numofchairs,tstatus);
				t1.add(r);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = t1.toArray();
		String data[][] = new String [t1.size()][3];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Table)obj[i]).getTableId();
			data[i][2] = ((Table)obj[i]).getNumberOfChairs();
			data[i][2] = (((Table)obj[i]).getTableStatus())+"";
		}
		return data;
	}

	public String[][] getAllFooditem()
	{
		ArrayList<Fooditem> r1 = new ArrayList<Fooditem>();
		String query = "SELECT * FROM fooditem;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String foodId = dbc.result.getString("FoodId");
				String name = dbc.result.getString("FoodName");
				double price = dbc.result.getDouble("Price");
				Fooditem r = new Fooditem(foodId,name,price);
				r1.add(r);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = r1.toArray();
		String data[][] = new String [r1.size()][3];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Fooditem)obj[i]).getfoodId();
			data[i][1] = ((Fooditem)obj[i]).getFoodName();
			data[i][2] = (((Fooditem)obj[i]).getPrice())+"";
		}
		return data;
	}

	public Table BookTable(String tableId)
	{
		Table t1 = null;
		String query = "SELECT `TableStatus` FROM `table` WHERE `TableID`='"+tableId+"';";
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			if(dbc.result==0)
			{
				String query = "UPDATE Table SET TableStatus='"+t1.getTableStatus(1)+"'";
				dbc.st.executeUpdate(query);
				
			}
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	
	}
}