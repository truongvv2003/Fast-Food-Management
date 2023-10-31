package DTO;

public class BillInfor {
	private int iD;
    private int billID;
    private int foodID;
    private int count;
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	public int getFoodID() {
		return foodID;
	}
	public void setFoodID(int foodID) {
		this.foodID = foodID;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public BillInfor(int iD, int billID, int foodID, int count) {
		super();
		this.iD = iD;
		this.billID = billID;
		this.foodID = foodID;
		this.count = count;
	}
    
}
