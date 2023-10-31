package BLL;

import java.util.ArrayList;

import DAL.BillDAO;
import DTO.Bill;

public class BillBLL {
	private static BillBLL instance;
	private BillBLL() {}
	public static BillBLL getInstance() {
		if(instance == null) {
			instance = new BillBLL();
		}
		return instance;
	}
	public void insertBill(int idUser) {
		BillDAO.getInstance().InsertBill(idUser);
	}
	public int getMaxId() {
		return BillDAO.getInstance().getMaxID();
	}
	public void deleteBill() {
		BillDAO.getInstance().deleteBill();
	}
	public ArrayList<Bill> dsBillThongKe(int idUser){
		return BillDAO.getInstance().dsThongKe(idUser);
	}
	public int getindexBillCheck() {
		return BillDAO.getInstance().getindexBillCheck();
	}
	public void updateStatusBill() {
		BillDAO.getInstance().updateStatusBill();;
	}
	public void updateDiscountandTotalPrice(int discount, double totalPrice,double finalTotalPrice, int idMenu) {
		BillDAO.getInstance().updateDiscountandTotalprice(discount, totalPrice, finalTotalPrice, idMenu);
	}
	public int getIDMenu() {
		return BillDAO.getInstance().getIDMenu();
	}
	public ArrayList<ArrayList<String>> dsThongKeAdmin(){
		return BillDAO.getInstance().dsThongKeAdmin();
	}
}
