package Repository;

import java.lang.*;
import java.util.ArrayList;
import Entity.*;
import Interfaces.*;
public class ManagerRepo implements IManagerRepo
{
	DatabaseConnection dbc;
	public ManagerRepo()
	{
		dbc = new DatabaseConnection();
	}
	public void insertFoodInDB(Fooditem f)
	{
		String query = "INSERT INTO fooditem VALUES ('"+f.getFoodId()+"','"+f.getFoodName()+"',"+f.getPrice()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFoodFromDB(String foodId)
	{
		String query = "DELETE from fooditem WHERE foodId='"+foodId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
	public void updateFoodInDB(Fooditem f)
	{
		{
			String query = "UPDATE fooditem SET FoodName='"+f.getFoodName()+"', Price= "+f.getPrice()+" WHERE FoodId='"+f.getFoodId()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		}
	}
	public Fooditem searchFood(String foodId)
	{
		Fooditem food = null;
		String query = "SELECT `FoodName`,`Price` FROM `fooditem` WHERE `FoodId`='"+foodId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String name = dbc.result.getString("FoodName");
				double price = dbc.result.getDouble("Price");
				
				food = new Fooditem();
				food.setFoodId(foodId);
				food.setFoodName(name);
	
				food.setPrice(price);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return food;
	}
	public String[][] getAllFood()
	{
		
		ArrayList<Fooditem> ar = new ArrayList<Fooditem>();
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
				
				Fooditem f = new Fooditem(foodId,name,price);
				ar.add(f);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][3];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Fooditem)obj[i]).getFoodId();
			data[i][1] = ((Fooditem)obj[i]).getFoodName();
			data[i][2] = (((Fooditem)obj[i]).getPrice())+"";
		}
		return data;
	}
		public void insertTableInDB(Table t)
		{
			String query = "INSERT INTO `table` VALUES ('"+t.getTableId()+"','"+t.getNumberOfChairs()+"',"+t.getTableStatus()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		}
		public void deleteTableFromDB(String tableId)
		{
			String query = "DELETE from `table` WHERE `TableId`='"+tableId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
			
			
		}
		public void updateTableInDB(Table t)
		{
		{
			String query = "UPDATE `table` SET `NumberOfChairs`='"+t.getNumberOfChairs()+"', `TableStatus` ='"+t.getTableStatus()+" WHERE `TableId`='"+t.getTableId()+"'";
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		}
			
		}
		public Table searchTable(String tableId)
		{
				Table tbl = null;
		String query = "SELECT `NumberOfChairs`,`TableStatus` FROM `table` WHERE `TableId`='"+tableId+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				int noOfChairs = dbc.result.getInt("NumberOfChairs");
				String stat = dbc.result.getString("TableStatus");
				
				tbl = new Table();
				tbl.setTableId(tableId);
				tbl.setTableStatus(stat);
				tbl.setNumberOfChairs(noOfChairs);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return tbl;
		}
		public String[][] getAllTable()
		{
			ArrayList<Table> ar = new ArrayList<Table>();
		    String query = "SELECT * FROM `table`;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String  tableId = dbc.result.getString("TableId");
				int noofchairs = dbc.result.getInt("NumberOfChairs");
				String status = dbc.result.getString("TableStatus");
				
				Table t = new Table(tableId,noofchairs,status);
				ar.add(t);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][3];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Table)obj[i]).getTableId();
			data[i][1] = ((Table)obj[i]).getNumberOfChairs()+"";
			data[i][2] = (((Table)obj[i]).getTableStatus());
		}
		return data;	
		}
		
		
		
		
		
}

