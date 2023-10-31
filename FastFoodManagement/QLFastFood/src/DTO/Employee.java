package DTO;

import java.time.LocalDate;
import java.util.Date;

public class Employee {
	private int IDEmployee;
	private String HoTen;
	private String SoDienThoai;
	private LocalDate dateOfbirth;
	private Boolean GioiTinh;
	public int getIDEmployee() {
		return IDEmployee;
	}
	public void setIDEmployee(int iDEmployee) {
		IDEmployee = iDEmployee;
	}
	public String getHoTen() {
		return HoTen;
	}
	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}
	
	public LocalDate getDateOfbirth() {
		return dateOfbirth;
	}
	public void setDateOfbirth(LocalDate dateOfbirth) {
		this.dateOfbirth = dateOfbirth;
	}
	public Boolean getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(Boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public Employee(int iDEmployee, String hoTen, String soDienThoai, LocalDate dateOfbirth, Boolean gioiTinh) {
		super();
		IDEmployee = iDEmployee;
		HoTen = hoTen;
		SoDienThoai = soDienThoai;
		this.dateOfbirth = dateOfbirth;
		GioiTinh = gioiTinh;
	}
	
}
