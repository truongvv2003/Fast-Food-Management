package DTO;

import java.util.Date;

public class Bill {
	private int idBill;
	private int idUser;
	private int idMenu;
	private int discount;
	private int status;
	private Date dateURIBA; 
	private float totalPrice;
	public int getIdBill() {
		return idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Date getDateURIBA() {
		return dateURIBA;
	}
	public void setDateURIBA(Date dateURIBA) {
		this.dateURIBA = dateURIBA;
	}
	
	public int getIdMenu() {
		return idMenu;
	}
	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}
	public Bill(int idBill, int discount, int status, float totalPrice) {
		super();
		this.idBill = idBill;
		this.discount = discount;
		this.status = status;
		this.totalPrice = totalPrice;
	}
	
	public Bill(int idBill, int idMenu, int discount, Date dateURIBA, float totalPrice) {
		super();
		this.idBill = idBill;
		this.idMenu = idMenu;
		this.discount = discount;
		this.dateURIBA = dateURIBA;
		this.totalPrice = totalPrice;
	}
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
