package BLL;

import java.util.ArrayList;

import DAL.EmployeeDAL;
import DTO.Employee;

public class EmployeeBLL {
	private static EmployeeBLL instance;
	private EmployeeBLL() {}
	public static EmployeeBLL getInstance() {
		if(instance == null) {
			instance = new EmployeeBLL();
		}
		return instance;
	}
	public String[][] getListThongTinNhanVien()
	{
		return EmployeeDAL.getInstance().getListThongTinNhanVien();
	}
	public ArrayList<String> dsNhanVien(String taiKhoan, String matKhau){
		return EmployeeDAL.getInstance().dsNhanVien(taiKhoan, matKhau);
	}
	public void UpdateNhanVien(int idEmployee, String Phone) {
		EmployeeDAL.getInstance().UpdateNhanVien(idEmployee, Phone);
	}
	public ArrayList<String> getThongTienMotNhanVien(String ID)
	{
		return EmployeeDAL.getInstance().getThongTinMotNhanVien(ID);
	}
	public void deleteEmployee(String id)
	{
		EmployeeDAL.getInstance().deleteEmployee(id);
	}
	public int getIDMax()
	{
		return EmployeeDAL.getInstance().getIDMax();
	}
	public void addEmployee(Employee employee)
	{
		EmployeeDAL.getInstance().addEmployee(employee);
	}
	public void updateEmployee(Employee employee)
	{
		EmployeeDAL.getInstance().updateEmployee(employee);
	}
	
}
