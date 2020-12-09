package Repository;

import java.lang.*;
import java.util.ArrayList;
import Entity.*;
import Interfaces.*;

public class TableRepo implements ITableRepo
{
	DatabaseConnection dbc;
	
	public TableRepo()
	{
		dbc = new DatabaseConnection();
	}
	
	public void insertInDB(Table t)
	{
		String query = "INSERT INTO table VALUES ('"+t.getTableId()+"','"+t.getNumberOfChairs()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	public void deleteFromDB(String tableId)
	{
		Table t = null;
		String query = "DELETE from table WHERE TableId='"+tableId+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
		
	}
	public String updateTableStatus(String tableid, String userId)
	{
		 String t = tableid;
		 String u=userId;
		String query = "UPDATE `table` SET `TableStatus`='"+u+"'WHERE `TableID` ='"+t+"';";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return t;
	}
	public Table searchTable(String tableid)
	{
		Table t = null;
		String query = "SELECT `TableId`, `NumberOfChairs` FROM `table` WHERE `TableId`='"+tableid+"';";
		//String query="SELECT TableId,NumberOfChairs FROM `table` WHERE TableId="+tableid+",TableStatus=0;";
		
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String tableId = dbc.result.getString("TableID");
				int numofchairs = dbc.result.getInt("NumberOfChairs");
				//int tstatus=dbc.result.getInt("TableStatus");
				
				t = new Table();
				t.setTableId(tableId);
				t.setNumberOfChairs(numofchairs);
				//t.setTableStatus(tstatus);
			
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return t;
	}
	public String[][] getAllTable()
	{
		ArrayList<Table> t1 = new ArrayList<Table>();
		//String query = "SELECT * FROM table;"; 
		String query="SELECT * FROM `table` WHERE TableStatus=0;"; 
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String tableId = dbc.result.getString("TableID");
				int numofchairs = dbc.result.getInt("NumberOfChairs");
				String tstatus = dbc.result.getString("TableStatus");
				
				
				
				Table t = new Table(tableId,numofchairs,tstatus);
				t1.add(t);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = t1.toArray();
		String data[][] = new String [t1.size()][3];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Table)obj[i]).getTableId();
			data[i][1] = ((Table)obj[i]).getNumberOfChairs()+"";
			data[i][2] = (((Table)obj[i]).getTableStatus())+"";
		}
		return data;
	}
}
