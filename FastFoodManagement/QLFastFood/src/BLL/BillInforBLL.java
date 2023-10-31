package BLL;

import DAL.BillInforDAL;

public class BillInforBLL {
	private static BillInforBLL instance;
	private BillInforBLL() {}
	public static BillInforBLL getInstance() {
		if(instance == null) {
			instance = new BillInforBLL();
		}
		return instance;
	}
	public void InsertBillInfor(int idBill,int idFood,int count) {
		BillInforDAL.getInstance().InsertBillInfor(idBill, idFood, count);
	}
	public void deleteBillInfo() {
		BillInforDAL.getInstance().deleteBillInfo();
	}
}
