package edu.seminolestate.managepurchases;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class ManagePurchase {
	public static void displayMenu() {
		System.out.println("1 - Add a purchase\n"
				+ "2 - Display all purchases\n"
				+ "3 - Exit");
	}
	
	public static void main(String[] args) {
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		int input = 0;
		int dateInt = 0;
		LocalDate date = LocalDate.parse("2000-01-01");
		Scanner sc = new Scanner(System.in);
		while(true) {
			if(input == 0) {
				try {
					displayMenu();
					System.out.println("Enter a number");
					input = sc.nextInt();
					 
					
				} catch (InputMismatchException e) {
					System.out.println("Error: Please input a number");
					input = 0;
					displayMenu();
				}
			}
	
			if(input == 1) {
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
					
					if(dateInt == 0) {
						try {
							System.out.println("Enter a purchase date (FORMAT: 2000-01-01)");
							String userDate = sc.next();
							date = LocalDate.parse(userDate);
							dateInt = 1;
						} catch (Exception e) {
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
					input = 0;
					dateInt = 0;
					
				} catch (Exception e) {
					System.out.println("Error: please enter valid data");
					input = 1;
				}	
			}
			if(input == 2) {
				for(Purchase purchases : list) {
					System.out.println(purchases.toString());
				}
				input = 0;
			}
			if(input == 3) {
				
			}
		}
	}
}
