package DAL;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Calendar;

import DTO.Employee;

public class EmployeeDAL {
	private static EmployeeDAL instance;

	private EmployeeDAL() {
	}

	public static EmployeeDAL getInstance() {
		if (instance == null)
			instance = new EmployeeDAL();
		return instance;
	}

	public String[][] getListThongTinNhanVien() {
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select * from employee";
		String[][] data = new String[connectSQL.getInstance().ExcecuteNonQuery(sql)][7];
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			int i = 0;
			while (connectSQL.getInstance().result.next()) {
				data[i][0] = Integer.toString(i + 1);
				data[i][1] = Integer.toString(connectSQL.getInstance().result.getInt("ID"));
				data[i][2] = connectSQL.getInstance().result.getString("Name");
				data[i][3] = connectSQL.getInstance().result.getString("Phone");
				if (connectSQL.getInstance().result.getBoolean("Sex") == true)
					data[i][4] = "Nam";
				else data[i][4] = "Nữ";
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				data[i][5] = sdf.format(connectSQL.getInstance().result.getDate("DateOfBirth"));
				i++;
			}
			return data;
		} catch (Exception e) {

		}
		return data;
	}
	public void UpdateNhanVien(int idEmployee, String Phone) {
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "Update employee set phone = ? where id = ?";
		try {
			PreparedStatement statement = connectSQL.getInstance().conn.prepareStatement(sql);
			statement.setString(1, Phone);
			statement.setInt(2, idEmployee);
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> dsNhanVien(String taiKhoan, String matKhau){
		ArrayList<String> thongTinNhanVien = new ArrayList<String>();
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "Select * from employee join user on employee.id = user.id where user.Account = '" + taiKhoan + "' and user.Password = '" + matKhau + "'";
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while (connectSQL.getInstance().result.next()) {
				thongTinNhanVien.add(Integer.toString(connectSQL.getInstance().result.getInt("Id")));
				thongTinNhanVien.add(connectSQL.getInstance().result.getString("Name"));
				thongTinNhanVien.add(connectSQL.getInstance().result.getString("Phone"));
				if (connectSQL.getInstance().result.getBoolean("Sex") == true)
					thongTinNhanVien.add("Nam");
				else
					thongTinNhanVien.add("Nữ");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				thongTinNhanVien.add(sdf.format(connectSQL.getInstance().result.getDate("DateOfBirth")));
				connectSQL.getInstance().result.getInt("id");
				thongTinNhanVien.add(connectSQL.getInstance().result.getString("Account"));
				thongTinNhanVien.add(connectSQL.getInstance().result.getString("Password"));
				if (connectSQL.getInstance().result.getBoolean("Authority") == true)
					thongTinNhanVien.add("Quản lý");
				else
					thongTinNhanVien.add("Nhân Viên");
				return thongTinNhanVien;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thongTinNhanVien;
	}
	
	

	public ArrayList<String> getThongTinMotNhanVien(String ID) {
		ArrayList<String> thongTinNhanVien = new ArrayList<String>();
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select * from employee join user on employee.Id = user.id where user.id = " + ID;
		try {
			connectSQL.getInstance().result = connectSQL.getInstance().statement.executeQuery(sql);
			while (connectSQL.getInstance().result.next()) {
				thongTinNhanVien.add(Integer.toString(connectSQL.getInstance().result.getInt("Id")));
				thongTinNhanVien.add(connectSQL.getInstance().result.getString("Name"));
				thongTinNhanVien.add(connectSQL.getInstance().result.getString("Phone"));
				if (connectSQL.getInstance().result.getBoolean("Sex") == true)
					thongTinNhanVien.add("0");
				else
					thongTinNhanVien.add("1");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				thongTinNhanVien.add(sdf.format(connectSQL.getInstance().result.getDate("DateOfBirth")));
				connectSQL.getInstance().result.getInt("id");
				thongTinNhanVien.add(connectSQL.getInstance().result.getString("Account"));
				thongTinNhanVien.add(connectSQL.getInstance().result.getString("Password"));
				if (connectSQL.getInstance().result.getBoolean("Authority") == false)
					thongTinNhanVien.add("0");
				else
					thongTinNhanVien.add("1");
				return thongTinNhanVien;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return thongTinNhanVien;
	}

	public int getIDMax() {
		connectSQL.getInstance().ConnectToDatabase();
		String sql = "select MAX(id) from employee";
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
	public void deleteEmployee(String id)
	{
		try
		{
			connectSQL.getInstance().ConnectToDatabase();
			String sql = "delete from employee where Id = " +id;
			PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
			pst.executeUpdate();
		}catch(Exception e)
		{
			
		}
	}
	public void addEmployee(Employee employee)
	{
		try
		{
			connectSQL.getInstance().ConnectToDatabase();
			String sql = "insert into employee(Id, Name, Phone, Sex, DateOfBirth) values (?,?,?,?,?)";
			PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
			pst.setInt(1, employee.getIDEmployee());
			pst.setString(2, employee.getHoTen());
			pst.setString(3, employee.getSoDienThoai());
			pst.setBoolean(4, employee.getGioiTinh());
	        ZonedDateTime zonedDateTime = employee.getDateOfbirth().atStartOfDay(ZoneId.systemDefault());
	        Date date = Date.valueOf(zonedDateTime.toLocalDate());
			pst.setDate(5,date);
			pst.executeUpdate();
		}catch(Exception e)
		{
			
		}
	}
	public void updateEmployee(Employee employee)
	{
		try
		{
			connectSQL.getInstance().ConnectToDatabase();
			String sql = "update employee SET Name=?, Phone=?, Sex=?, DateOfBirth=? where Id = " + employee.getIDEmployee();
			PreparedStatement pst = connectSQL.getInstance().conn.prepareStatement(sql);
			pst.setString(1, employee.getHoTen());
			pst.setString(2, employee.getSoDienThoai());
			pst.setBoolean(3, employee.getGioiTinh());
	        ZonedDateTime zonedDateTime = employee.getDateOfbirth().atStartOfDay(ZoneId.systemDefault());
	        Date date = Date.valueOf(zonedDateTime.toLocalDate());
			pst.setDate(4,date);
			pst.executeUpdate();
		}catch(Exception e)
		{
			
		}
	}
}