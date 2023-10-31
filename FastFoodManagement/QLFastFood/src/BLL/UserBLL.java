package BLL;

import java.sql.SQLException;

import DAL.CheckUser;
import DTO.User;

public class UserBLL {
private static UserBLL instance;
	
	private UserBLL() {}
	
	public static UserBLL getInstance()
	{
		if(instance == null)
		{
			instance = new UserBLL();
		}
		return instance;
	}
	
	public int checkLogin(String taiKhoan, String matKhau) throws SQLException // 0 la sai tk mk , 1 la sinh vien , 2 la giao vien
	{
		return CheckUser.getInstance().checkLogin(taiKhoan, matKhau);
	}
	
	public Object[] getThongTinUser(String taiKhoan)
	{
		return CheckUser.getInstance().getThongTinUser(taiKhoan);
	}
	
	public boolean doiMatKhau(String taiKhoan, String newpwd)
	{
		return CheckUser.getInstance().doiMatKhau(taiKhoan, newpwd);
	}
	
	public boolean resetMatKhau(int taiKhoan)
	{
		return CheckUser.getInstance().resetMatKhau(taiKhoan);
	}

	public String getMatKhauUser(int taiKhoan)
	{
		return CheckUser.getInstance().getMatKhauUser(taiKhoan);
	}
	public boolean checkTaiKhoanDaCo(String taiKhoan)
	{
		return CheckUser.getInstance().checkTaiKhoanDaCo(taiKhoan);
	}
	public User getIdUser(String taiKhoan, String Matkhau) {
		return CheckUser.getInstance().getIdUser(taiKhoan, Matkhau);
	}
	public void deleteUser(String id)
	{
		CheckUser.getInstance().deleteUser(id);
	}
	public void addUser(User user)
	{
		CheckUser.getInstance().addUser(user);
	}
	public void updateUser(User user)
	{
		CheckUser.getInstance().updateUser(user);
	}
}
