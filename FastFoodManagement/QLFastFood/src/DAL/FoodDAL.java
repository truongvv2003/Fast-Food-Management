package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import DTO.Food;


public class FoodDAL {
	private static FoodDAL instance;
	private FoodDAL() {}
	public static FoodDAL getInstance() {
		if(instance == null) {
			instance = new FoodDAL();
		}
		return instance;
	}
	public ArrayList<Food> getListFood(){
		ArrayList<Food> dsFood = new ArrayList<Food>();
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select * from food";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				Food F = new Food(connectSQL.getInstance().result.getInt("id"), connectSQL.getInstance().result.getString("Name"),
						connectSQL.getInstance().result.getInt("idCategory"), connectSQL.getInstance().result.getFloat("price"));
				dsFood.add(F);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsFood;
	}
	public ArrayList<Food> getListFoodByCategoryID(int id){
		ArrayList<Food> dsFood = new ArrayList<Food>();
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select * from food where idCategory = " + id;
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				Food F = new Food(connectSQL.getInstance().result.getInt("id"), connectSQL.getInstance().result.getString("Name"),
						connectSQL.getInstance().result.getInt("idCategory"), connectSQL.getInstance().result.getFloat("price"));
				dsFood.add(F);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsFood;
	}
	public Boolean insertFood(String name, int idCategory, float price)
    {
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "INSERT INTO food (Name, idCategory, price) VALUES (?, ?, ?)";
        int result = 0;
		try {
			PreparedStatement statement = connectSQL.getInstance().conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, idCategory);
			statement.setFloat(3, price);
			result = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result > 0;
    }
	public Boolean updateFood(String name, int idCategory, float price, int id)
    {
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "UPDATE food SET name = ?, idCategory = ?, price = ? where id = ?";
		//ALTER TABLE Food MODIFY COLUMN idFood INT AUTO_INCREMENT PRIMARY KEY;
        int result = 0;
		try {
			PreparedStatement statement = connectSQL.getInstance().conn.prepareStatement(sql);
			statement.setString(1, name);
			statement.setInt(2, idCategory);
			statement.setFloat(3, price);
			statement.setInt(4, id);
			result = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return result > 0;
    }
	public Boolean deleteFood(int id)
	{
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "DELETE FROM food WHERE id = ?";
		int result = 0;
		try {
			PreparedStatement statement = connectSQL.getInstance().conn.prepareStatement(sql);
			statement.setInt(1, id);
			result =  statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result > 0; 
	}
	public ArrayList<Food> SearchFoodByName(String name){
		ArrayList<Food> dsFood = new ArrayList<Food>();
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "Select * from food where name = " + name;
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				Food F = new Food(connectSQL.getInstance().result.getInt("id"), connectSQL.getInstance().result.getString("Name"),
						connectSQL.getInstance().result.getInt("idCategory"), connectSQL.getInstance().result.getFloat("price"));
				dsFood.add(F);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsFood;
	}
	public String[][] getListFoodTable()
	{
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select food.id, food.Name, foodcategory.Name, price from food join foodcategory on food.idCategory = foodcategory.id";
		String[][] data = new String[connectSQL.getInstance().ExcecuteNonQuery(sql)][5];
		try
		{
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			int i = 0;
			while(connectSQL.getInstance().result.next())
			{
				data[i][0] = Integer.toString(i+1);
				data[i][1] = Integer.toString(connectSQL.getInstance().result.getInt("Id"));
				data[i][2] = connectSQL.getInstance().result.getString("Name");
				data[i][3] = connectSQL.getInstance().result.getString("Name");
				data[i][4] = Integer.toString(connectSQL.getInstance().result.getInt("price"));
				i++;
			}
			return data;
		}
		catch(Exception e)
		{
			
		}
		return data;
	}
	public ArrayList<String> getOneFoodInfo(String id)
	{
		ArrayList<String> FoodInfo = new ArrayList<>();
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select food.id, food.Name, foodcategory.id, price from food join foodcategory on food.idCategory = foodcategory.id where food.id =" + id;
		try
		{
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next())
			{
				FoodInfo.add(Integer.toString(connectSQL.getInstance().result.getInt("food.id")));
				FoodInfo.add(connectSQL.getInstance().result.getString("Name"));
				FoodInfo.add(Integer.toString(connectSQL.getInstance().result.getInt("foodcategory.id")));
				FoodInfo.add(Integer.toString(connectSQL.getInstance().result.getInt("price")));
			}
			return FoodInfo;
		}
		catch(Exception e)
		{
			
		}
		return FoodInfo;
	}
	public int getIDMax() {
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select MAX(id) from food";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			connectSQL.getInstance().result.next();
			int ID = connectSQL.getInstance().result.getInt("MAX(id)");
			return ID;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	public void addFood(Food food)
	{
		try
		{
			connectSQL.getInstance().ConnectToDatabase();
			String sql = "insert into food(id,Name, idCategory, price) values (?,?,?,?)";
			PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
			pst.setInt(1, food.getiD());
			pst.setString(2, food.getName());
			pst.setInt(3, food.getiDCategory());
			pst.setFloat(4, food.getPrice());
			pst.executeUpdate();
		}catch(Exception e)
		{
			
		}
	}
	
	public void updateFood(Food food)
	{
		try
		{
			connectSQL.getInstance().ConnectToDatabase();
			String sql = "update food SET Name=?, idCategory=?, price=? where id = " + food.getiD();
			PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
			pst.setString(1, food.getName());
			pst.setInt(2, food.getiDCategory());
			pst.setFloat(3, food.getPrice());
			pst.executeUpdate();
		}catch(Exception e)
		{
			
		}
	}
}
