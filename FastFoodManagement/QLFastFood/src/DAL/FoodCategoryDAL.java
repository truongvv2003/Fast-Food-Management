package DAL;

import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Food;
import DTO.FoodCategory;

public class FoodCategoryDAL {
	private static FoodCategoryDAL instance;
	private FoodCategoryDAL() {}
	public static FoodCategoryDAL getInstance() {
		if(instance == null) {
			instance = new FoodCategoryDAL();
		}
		return instance;
	}
	public ArrayList<FoodCategory> getListFoodCategory(){
		ArrayList<FoodCategory> dsFoodCategory = new ArrayList<FoodCategory>();
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select * from Foodcategory";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				FoodCategory fc = new FoodCategory(connectSQL.getInstance().result.getInt("Id"), connectSQL.getInstance().result.getString("Name"));
				dsFoodCategory.add(fc);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsFoodCategory;
	}
	public FoodCategory getCategoryId(int id) {
		FoodCategory FC = null;
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select * from foodcategory where Id = " + id;
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				FC = new FoodCategory(connectSQL.getInstance().result.getInt("Id"), connectSQL.getInstance().result.getString("Name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return FC;
	}
	
	public ArrayList<String> getNameOfCategory()
	{
		ArrayList<String> data = new ArrayList<>();
		String sql = "select Name from foodcategory ";
		connectSQL.getInstance().ConnectToDatabase();
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				data.add(connectSQL.getInstance().result.getString("Name"));
			}
			return data;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
