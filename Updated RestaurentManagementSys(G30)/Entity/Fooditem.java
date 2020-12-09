package Entity;

import java.lang.*;

public class Fooditem

{
	private String foodId;
	private double price;
	private String name;
	
	public Fooditem(){}
	public Fooditem(String foodId, String name, double price)
	{
		this.foodId = foodId;
		this.name=name;
		this.price=price;
	}
	
	public void setFoodId(String foodId){this.foodId = foodId;}
	public void setFoodName(String name){this.name = name;}
	public void setPrice(double price){this.price = price;}
	
	public String getFoodId(){return foodId;}
	public String getFoodName(){return name;}
	public double getPrice(){return price;}
}