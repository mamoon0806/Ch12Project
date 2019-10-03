package edu.seminolestate.managepurchases;

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
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		int input;
		
		try {
			Scanner sc = new Scanner(System.in);
			input = sc.nextInt();
			
			if(input == 1) {
				System.out.println("Enter ")
			}
			
		} catch (InputMismatchException e) {
			System.out.println("Error: Please input a number");
			displayMenu();
		}
	}
}
