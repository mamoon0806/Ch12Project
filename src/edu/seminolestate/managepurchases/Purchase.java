package edu.seminolestate.managepurchases;

import java.time.LocalDate;

public class Purchase {
	private String productName;
	private String storeName;
	private LocalDate purchaseDate;
	private double cost;
	
	public Purchase(String newProduct, String newStore, LocalDate newDate, double newCost) throws IllegalPurchaseArgumentException{
		if(newProduct != null && newProduct.length() > 0 && newStore != null 
				&& newStore.length() > 0 && newDate != null && newCost >=0) {
			this.productName = newProduct;
			this.storeName = newStore;
			this.purchaseDate = newDate;
			this.cost = newCost;
		}
		else {
			throw new IllegalPurchaseArgumentException();
		}
	}
	
	public String toString() {
		return this.getClass() + " productName: " + productName + " storeName: " + storeName + 
				" purchaseDate: " + purchaseDate + " cost: " + cost;
	}
	
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String newProduct) {
		this.productName = newProduct;
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public void setStoreName(String newStore) {
		this.storeName = newStore;
	}
	
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	
	public void setPurchaseDate(LocalDate newDate) {
		this.purchaseDate = newDate;
	}
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double newCost) {
		this.cost = newCost;
	}
	
}
