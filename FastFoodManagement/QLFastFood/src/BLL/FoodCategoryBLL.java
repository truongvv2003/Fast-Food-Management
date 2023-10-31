package BLL;

import java.util.ArrayList;

import DAL.FoodCategoryDAL;
import DTO.FoodCategory;

public class FoodCategoryBLL {
	private static FoodCategoryBLL instance;
	private FoodCategoryBLL() {}
	public static FoodCategoryBLL getInstance() {
		if(instance == null) {
			instance = new FoodCategoryBLL();
		}
		return instance;
	}
	public ArrayList<FoodCategory> listFoodCategory()
	{
		return FoodCategoryDAL.getInstance().getListFoodCategory();
	}
	public ArrayList<String> listNameOfCategory()
	{
		return FoodCategoryDAL.getInstance().getNameOfCategory();
	}
}
