package DAL;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import DTO.Bill;

public class BillDAO {
	private static BillDAO instance;
	private BillDAO() {}
	public static BillDAO getInstance() {
		if(instance == null) {
			instance = new BillDAO();
		}
		return instance;
	}
	public int getUnCheckedBillIdByTableId(int id)
	{
		// Lấy những bàn chưa checkout
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select * from bill where idTable = " + id + " and status = 0";
		ArrayList<Bill> dsBill = new ArrayList<Bill>();
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				Bill B = new Bill(connectSQL.getInstance().result.getInt("id"), connectSQL.getInstance().result.getInt("discount"),
						connectSQL.getInstance().result.getInt("status"),connectSQL.getInstance().result.getFloat("totalPrice"));
				dsBill.add(B);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(dsBill.size() > 0) {
			return dsBill.get(0).getIdBill();
		}
		else return -1;
	}
	public void InsertBill(int idUser) {
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "INSERT INTO Bill (status, discount, dateOfUriba, idUser) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement statement = connectSQL.getInstance().conn.prepareStatement(sql);
			statement.setInt(1, 1);
			statement.setInt(2, 0);
			Date currentDate = new Date(System.currentTimeMillis());
			statement.setDate(3, currentDate);
			statement.setInt(4, idUser);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int getindexBillCheck() {
		int maxID = 0;
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select Max(indexBillCheck) from bill";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			
			while(connectSQL.getInstance().result.next()) {
				maxID = connectSQL.getInstance().result.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxID;
	}
	public int getMaxID() {
		int maxID = 0;
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select Max(id) from bill";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			
			while(connectSQL.getInstance().result.next()) {
				maxID = connectSQL.getInstance().result.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxID;
	}
	
	public void deleteBill() {
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "delete from Bill";
		try {
			PreparedStatement statement = connectSQL.getInstance().conn.prepareStatement(sql);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<ArrayList<String>> dsThongKeAdmin() {
		connectSQL.getInstance().ConnectToDatabase();
		ArrayList<ArrayList<String>> dsThongKeAdmin = new ArrayList<ArrayList<String>>();
		String sql = "SELECT employee.Name, TABLE1.dateOfUriba, Sum(finalTotalPrice) as DoanhThu FROM (Select b.idUser, b.dateOfUriba, finalTotalPrice from Bill as b group by dateOfUriba, iduser, finalTotalPrice) as TABLE1 JOIN user on TABLE1.idUser = user.id JOIN employee on employee.Id = user.id GROUP BY TABLE1.idUser, TABLE1.dateOfUriba\r\n"
				+ "";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				ArrayList<String> dsDong = new ArrayList<String>();
				dsDong.add(connectSQL.getInstance().result.getString("Name"));
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				dsDong.add(formatter.format(connectSQL.getInstance().result.getDate("dateOfUriba")));
				dsDong.add(connectSQL.getInstance().result.getDouble("Doanhthu") + "");
				dsThongKeAdmin.add(dsDong);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsThongKeAdmin;
	}
	
	public ArrayList<Bill> dsThongKe(int idUser) {
		connectSQL.getInstance().ConnectToDatabase();
		ArrayList<Bill> dsBill = new ArrayList<Bill>();
		String sql = "Select * from Bill as b where idUser = " + idUser + " group by idMenu";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				Bill b = new Bill(connectSQL.getInstance().result.getInt("id"), connectSQL.getInstance().result.getInt("idMenu"),
						connectSQL.getInstance().result.getInt("discount"),
						connectSQL.getInstance().result.getDate("dateOfUriba"),connectSQL.getInstance().result.getFloat("totalPrice"));
				dsBill.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsBill;
	}
	public void updateStatusBill() {
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "update bill set status = ?";
		try {
			PreparedStatement statement = connectSQL.getInstance().conn.prepareStatement(sql);
			statement.setInt(1, 0);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void updateDiscountandTotalprice(int discount, double totalPrice, double finalTotal, int idMenu) {
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "update bill set discount = ? ,totalPrice = ?,finalTotalPrice = ?, idMenu = ? where status = ?";
		try {
			PreparedStatement statement = connectSQL.getInstance().conn.prepareStatement(sql);
			statement.setInt(1, discount);
			statement.setDouble(2, totalPrice);
			statement.setDouble(3, finalTotal);
			statement.setInt(4, idMenu);
			statement.setInt(5, 1);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int getIDMenu() {
		int maxID = 0;
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select Max(idMenu) from bill";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			
			while(connectSQL.getInstance().result.next()) {
				maxID = connectSQL.getInstance().result.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return maxID;
	}
	// Sau khi thanh toán thì các mục sau đây sẽ được cập nhật.
	public void Checkout(int id, int discount, float totalPrice)
	{
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "update Bill set status = 1, discount = " + discount + " , totalPrice = " + totalPrice + " where Id = " + id;
		connectSQL.getInstance().ExcecuteNonQuery(sql);
	}
}
