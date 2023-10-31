package DTO;

public class Table {
	 private int iD;
     private String name;
     private Boolean status;
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Table(int iD, String name, Boolean status) {
		super();
		this.iD = iD;
		this.name = name;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Table [iD=" + iD + ", name=" + name + ", status=" + status + "]";
	}
	
}
