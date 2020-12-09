package Repository;

import java.lang.*;
import java.util.ArrayList;
import Entity.*;
import Interfaces.*;

public class FooditemRepo implements IFooditemRepo
{
	DatabaseConnection dbc;
	
	public FooditemRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Fooditem f)
	{
		String query = "INSERT INTO fooditem VALUES ('"+f.getFoodId()+"','"+f.getFoodName()+"','"+f.getPrice()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String foodId)
	{
		String query = "DELETE from fooditem WHERE FoodId='"+foodId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateInDB(Fooditem f)
	{
		String query = "UPDATE fooditem SET FoodName='"+f.getFoodName()+"', Price = '"+f.getPrice()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public Fooditem searchFooditem(String foodName)
	{
		Fooditem fa = null;
		String query = "SELECT `FoodName`, `Price` FROM `fooditem` WHERE `FoodName`='"+foodName+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("FoodName");
				double price = dbc.result.getDouble("Price");
				
				fa = new Fooditem();
				//fa.setFoodId(foodId);
				fa.setFoodName(name);
			    fa.setPrice(price);
			
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return fa;
	}
	public String[][] getAllFooditem()
	{
		ArrayList<Fooditem> r1=new ArrayList<Fooditem>();
		//ArrayList<Fooditem> r1 = new ArrayList<Fooditem>();
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
			data[i][0] = ((Fooditem)obj[i]).getFoodId();
			data[i][1] = ((Fooditem)obj[i]).getFoodName();
			data[i][2] = (((Fooditem)obj[i]).getPrice())+"";
		}
		return data;
	}
}












































