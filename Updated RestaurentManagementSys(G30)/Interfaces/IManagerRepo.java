package Interfaces;
import java.lang.*;
import Entity.*;

public interface IManagerRepo
{
	public void insertFoodInDB(Fooditem f);
	public void deleteFoodFromDB(String foodId);
	public void updateFoodInDB(Fooditem f);
	public Fooditem searchFood(String foodId);
	public String[][] getAllFood();
	public void insertTableInDB(Table t);
	public void deleteTableFromDB(String tableId);
	public void updateTableInDB(Table t);
	public Table searchTable(String tableId);
	public String[][] getAllTable();
	
}