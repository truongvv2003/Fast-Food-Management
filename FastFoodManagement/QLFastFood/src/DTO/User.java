package DTO;

public class User {
	private int id;
	private String taiKhoan;
	private String matKhau;
	private boolean phanQuyen;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public boolean isPhanQuyen() {
		return phanQuyen;
	}
	public void setPhanQuyen(boolean phanQuyen) {
		this.phanQuyen = phanQuyen;
	}
	public User(int id) {
		super();
		this.id = id;
	}
	public User() {}
	public User(int id, String taiKhoan, String matKhau, boolean phanQuyen) {
		super();
		this.id = id;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.phanQuyen = phanQuyen;
	}
}
