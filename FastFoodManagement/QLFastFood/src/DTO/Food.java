package DTO;

public class Food {
	private int iD;
    private String name;
    private int iDCategory;
    private float price;
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
	public int getiDCategory() {
		return iDCategory;
	}
	public void setiDCategory(int iDCategory) {
		this.iDCategory = iDCategory;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Food(int iD, String name, int iDCategory, float price) {
		super();
		this.iD = iD;
		this.name = name;
		this.iDCategory = iDCategory;
		this.price = price;
	}
	@Override
	public String toString() {
		return name;
	}
    
    
}
