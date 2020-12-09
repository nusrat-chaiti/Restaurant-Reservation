package Interfaces;

import java.lang.*;

import Entity.*;

public interface IFooditemRepo
{
	public void insertInDB(Fooditem r);
	public void deleteFromDB(String foodId);
	public void updateInDB(Fooditem r);
	public Fooditem searchFooditem(String foodId);
	public String[][] getAllFooditem();
}