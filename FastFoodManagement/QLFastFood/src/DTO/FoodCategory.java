package DTO;

public class FoodCategory {
	 private int iDFoodCategory;
     private String nameFoodCategory;
	public int getiDFoodCategory() {
		return iDFoodCategory;
	}
	public void setiDFoodCategory(int iDFoodCategory) {
		this.iDFoodCategory = iDFoodCategory;
	}
	public String getNameFoodCategory() {
		return nameFoodCategory;
	}
	public void setNameFoodCategory(String nameFoodCategory) {
		this.nameFoodCategory = nameFoodCategory;
	}
	public FoodCategory(int iDFoodCategory, String nameFoodCategory) {
		super();
		this.iDFoodCategory = iDFoodCategory;
		this.nameFoodCategory = nameFoodCategory;
	}
	@Override
	public String toString() {
		return nameFoodCategory;
	}
	
}
