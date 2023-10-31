package DAL;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.BillInfor;

public class BillInforDAL {
	private static BillInforDAL instance;
	private BillInforDAL() {}
	public static BillInforDAL getInstance() {
		if(instance == null) {
			instance = new BillInforDAL();
		}
		return instance;
	}
	// Trả về danh sách BillInfor
	public ArrayList<BillInfor> getListBillInfor(int id){
		ArrayList<BillInfor> dsBillInfor = new ArrayList<BillInfor>();
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select * from BillInfo where idBill = " + id;
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while(connectSQL.getInstance().result.next()) {
				BillInfor BI = new BillInfor(connectSQL.getInstance().result.getInt("id"), connectSQL.getInstance().result.getInt("idBill"),
						connectSQL.getInstance().result.getInt("idFood"), connectSQL.getInstance().result.getInt("Count"));
				dsBillInfor.add(BI);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsBillInfor;
	}
	// Cap nhat BillInfor
	public void InsertBillInfor(int idBill, int idFood, int count)
	{
		connectSQL.getInstance().ConnectToDatabase();
		int isExistBillInfo = 0;
		int foodCount = 1;
		String sql = "select " + isExistBillInfo + " = id, " + foodCount + " = count from billinfo where "
				+ "idBill = " + idBill + " and idFood = " + idFood;
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(isExistBillInfo > 0)
		{
			int newCount = foodCount + count;
			if(newCount > 0) {
				String sql2 = "UPDATE BillInfo SET count = ? where idFood = ?";
				try {
					PreparedStatement statement = connectSQL.getInstance().conn.prepareStatement(sql2);
					statement.setInt(1, newCount);
					statement.setInt(2, idFood);
					statement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			else {
				String sql3 = "Delete from BillInfo where idBill = ? and idFood = ?";
				try {
					PreparedStatement statement = connectSQL.getInstance().conn.prepareStatement(sql3);
					statement.setInt(1, idBill);
					statement.setInt(2, idFood);
					statement.executeUpdate();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else {
			String sql4 = "Insert Into BillInfo (idBill, idFood, count) VALUES (?, ?, ?)";
			try {
				PreparedStatement statement = connectSQL.getInstance().conn.prepareStatement(sql4);
				statement.setInt(1, idBill);
				statement.setInt(2, idFood);
				statement.setInt(3, count);
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void deleteBillInfoByFoodId(int id) {
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "delete from BillInfo where idFood = ?";
		try {
			PreparedStatement statement = connectSQL.getInstance().conn.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void deleteBillInfo() {
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "delete from BillInfo";
		try {
			PreparedStatement statement = connectSQL.getInstance().conn.prepareStatement(sql);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
