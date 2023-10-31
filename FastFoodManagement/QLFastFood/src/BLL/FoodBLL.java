package BLL;

import java.util.ArrayList;

import DAL.FoodDAL;
import DTO.Food;

public class FoodBLL {
	private static FoodBLL instance;
	private FoodBLL() {}
	public static FoodBLL getInstance() {
		if(instance == null) {
			instance = new FoodBLL();
		}
		return instance;
	}
	public ArrayList<Food> getListFood(){
		return FoodDAL.getInstance().getListFood();
	}
	public ArrayList<Food> getListFoodByCateGoryID(int id){
		return FoodDAL.getInstance().getListFoodByCategoryID(id);
	}
	public String[][] getListFoodTable()
	{
		return FoodDAL.getInstance().getListFoodTable();
	}
	public ArrayList<String> getOneFoodInfo(String id)
	{
		return FoodDAL.getInstance().getOneFoodInfo(id);
	}
	public int getIDMax()
	{
		return FoodDAL.getInstance().getIDMax();
	}
	public void deleteFood(int id) {
		FoodDAL.getInstance().deleteFood(id);
	}
	public void addFood(Food food)
	{
		FoodDAL.getInstance().addFood(food);
	}
	public void updateFood(Food food)
	{
		FoodDAL.getInstance().updateFood(food);
	}
}
