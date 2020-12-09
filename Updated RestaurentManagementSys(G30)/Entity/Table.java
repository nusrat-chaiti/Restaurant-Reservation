package Entity;

import java.lang.*;

public class Table

{
	private String tableId;
	private int numofchairs;
	private String tstatus;
	
	public Table(){}
	public Table(String tableId, int numofchairs, String tstatus)
	{
		this.tableId = tableId;
		this.numofchairs=numofchairs;
		this.tstatus=tstatus;
		
	}
	
	public void setTableId(String tableId){this.tableId = tableId;}
	public void setNumberOfChairs(int numofchairs){this.numofchairs = numofchairs;}
	public void setTableStatus(String tstatus ){this.tstatus = tstatus;}

	
	public String getTableId(){return tableId;}
	public int getNumberOfChairs(){return numofchairs;}
	public String getTableStatus(){return tstatus;}
}