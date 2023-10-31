package DTO;

public class Menu {
	 private String foodName;
     private int count;
     private float price;
     private float totalPrice;
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Menu(String foodName, int count, float price, float totalPrice) {
		super();
		this.foodName = foodName;
		this.count = count;
		this.price = price;
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Menu [foodName=" + foodName + ", count=" + count + ", price=" + price + ", totalPrice=" + totalPrice
				+ "]";
	}
	
}
