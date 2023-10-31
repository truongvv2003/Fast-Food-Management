package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DTO.User;

public class CheckUser {

		
		private static CheckUser instance;
		
		public static CheckUser getInstance()
		{
			if(instance == null)
			{
				instance = new CheckUser();
			}
			return instance;
		}
		
		public int checkLogin(String taiKhoan, String matKhau) throws SQLException //0 la sai tk mk, 1 la nhan vien, 2 la admin
		{
			//if(isNumber(taiKhoan) == false) return 0;
			String sql = "select Authority from user where Account = '" + taiKhoan + "' and Password = '" + matKhau+"'";
			connectSQL.getInstance().ConnectToDatabase();
			if(connectSQL.getInstance().statement == null) connectSQL.getInstance().ConnectToDatabase();
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			if(connectSQL.getInstance().result.next())
			{
				//connectSQL.getInstance().result.first();
				boolean phanQuyen = connectSQL.getInstance().result.getBoolean("Authority");
				if(phanQuyen == false) return 1;
				else return 2;
			}
			return 0;
		}

		public boolean doiMatKhau(String taiKhoan, String newpwd)
		{
			connectSQL.getInstance().ConnectToDatabase();
			String sql = "update user "
					+ "set Password = ? where Account = ?";
			try {
				PreparedStatement pst = connectSQL.getInstance().getConn().prepareStatement(sql);
				pst.setString(1, newpwd);
				pst.setString(2, taiKhoan);
				pst.executeUpdate();
				return true;
			}catch(Exception e){}
			return false;
		}
		
		public boolean resetMatKhau(int taiKhoan)
		{
			try {
				String sql = "update [User] "
						+ "set MatKhau = '" + taiKhoan
						+"' where TaiKhoan = " + taiKhoan;
				PreparedStatement pst = connectSQL.getInstance().getConn().prepareStatement(sql);
				pst.executeUpdate();
				return true;
			}catch(Exception e){}
			return false;
		}
		public User getIdUser(String taiKhoan, String matKhau) {
			User user = new User();
			String sql = "select * from user where Account = '" + taiKhoan + "' and Password = '" + matKhau + "'";
			connectSQL.getInstance().ConnectToDatabase();
			try {
				connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
				while(connectSQL.getInstance().result.next()) {
					user = new User(connectSQL.getInstance().result.getInt("id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
		}
		

		public Object[] getThongTinUser(String taiKhoan)
		{

			Object[] thongTinUser = new Object[6];
			try
			{	
				String sql = "select employee.Id,Name,Phone,Sex,DateOfBirth,Authority from user join employee on user.id = employee.Id where Account = '" + taiKhoan + "'";
				ResultSet rs = connectSQL.getInstance().getStatement().executeQuery(sql);
				rs.next();
				thongTinUser[0] = rs.getInt("Id");
				thongTinUser[1] = rs.getString("Name");
				thongTinUser[2] = rs.getString("Phone");
				thongTinUser[3] = rs.getBoolean("Sex");
				thongTinUser[4] = rs.getDate("DateOfBirth");
				thongTinUser[5] = rs.getBoolean("Authority");
				return thongTinUser;
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return thongTinUser;
		}
		
		public boolean checkTaiKhoanDaCo(String taiKhoan)
		{
			String sql = "select * from user where Account = " + taiKhoan;
			int i = connectSQL.getInstance().ExcecuteNonQuery(sql);
			if (i>0)
				return true;
			else return false;
		}
		
		public String getMatKhauUser(int taiKhoan)
		{
			String password = new String();
			try
			{	
				String sql = "select MatKhau from [User] where TaiKhoan = " + taiKhoan;
				connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
				connectSQL.getInstance().result.next();
				return connectSQL.getInstance().result.getString("MatKhau");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			return password;
		}
		public void deleteUser(String id)
		{
			try
			{
				connectSQL.getInstance().ConnectToDatabase();
				String sql = "delete from user where id = " +id;
				PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
				pst.executeUpdate();
			}catch(Exception e)
			{
				
			}
		}
		public void addUser(User user)
		{
			try
			{
				connectSQL.getInstance().ConnectToDatabase();
				String sql = "insert into user(id, Account, Password, Authority) values (?,?,?,?)";
				PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
				pst.setInt(1, user.getId());
				pst.setString(2, user.getTaiKhoan());
				pst.setString(3, user.getMatKhau());
				pst.setBoolean(4, user.isPhanQuyen());
				pst.executeUpdate();
			}catch(Exception e)
			{
				
			}
		}
		public void updateUser(User user)
		{
			try
			{
				connectSQL.getInstance().ConnectToDatabase();
				String sql = "update user SET Password=? where id =" + user.getId();
				PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
				pst.setString(1, user.getMatKhau());
				pst.executeUpdate();
			}catch(Exception e)
			{
				
			}
		}
}


