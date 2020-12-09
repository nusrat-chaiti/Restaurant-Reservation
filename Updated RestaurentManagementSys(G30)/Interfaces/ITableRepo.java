package Interfaces;

import java.lang.*;

import Entity.*;

public interface ITableRepo
{
	public void insertInDB(Table r);
	public void deleteFromDB(String tableId);
	public String updateTableStatus(String tableid,String userId);
	public Table searchTable(String tableId);
	public String[][] getAllTable();
}