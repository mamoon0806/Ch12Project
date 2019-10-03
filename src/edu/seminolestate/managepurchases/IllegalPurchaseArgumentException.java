package edu.seminolestate.managepurchases;

public class IllegalPurchaseArgumentException extends Exception {
	public IllegalPurchaseArgumentException() {
		super();
	}
	
	public IllegalPurchaseArgumentException(String message) {
		super(message);
	}
}
