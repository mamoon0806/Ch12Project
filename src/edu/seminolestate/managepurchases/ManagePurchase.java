package edu.seminolestate.managepurchases;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagePurchase {
	public static void displayMenu() {
		System.out.println("1 - Add a purchase\n"
				+ "2 - Display all purchases\n"
				+ "3 - Exit");
	}
	
	public static void main(String[] args) {
		displayMenu();
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		int input = 0;
		int dateInt = 0;
		Scanner sc = new Scanner(System.in);
		while(input == 0) {
			try {
				System.out.println("Enter a number");
				input = sc.nextInt();
				 
				
			} catch (InputMismatchException e) {
				System.out.println("Error: Please input a number");
				input = 0;
				displayMenu();
			}
		}

		while(input == 1) {
			try {
				System.out.println("Enter a product name");
				String productName = sc.next();
				if(productName.length() < 1) {
					throw new Exception();
				}
				System.out.println("Enter a store name");
				String storeName = sc.next();
				if(storeName.length() < 1) {
					throw new Exception();
				}
				while(dateInt == 0) {
					try {
						System.out.println("Enter a purchase date (like Jun 23, 2015)");
						String purchaseDate = sc.next();
						DateTimeFormatter formatter =
								 DateTimeFormatter.ofPattern("MMM d, yyyy");
						LocalDate date = LocalDate.parse(purchaseDate, formatter);
					} catch (DateTimeParseException e) {
						System.out.println("Enter a valid date");
						dateInt = 0;
					}
				}
				
				System.out.println("Enter a cost");
				double cost = sc.nextDouble();
				if(cost < 0) {
					throw new Exception();
				}
				Purchase purchase = new Purchase(productName, storeName, date, cost);
				list.add(purchase);
				
			} catch (Exception e) {
				System.out.println("Error: please enter valid data");
				input = 1;
			}	
		}
	}
}
