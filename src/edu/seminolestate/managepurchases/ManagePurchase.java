//Qazi Ulhaq 10/10/19
package edu.seminolestate.managepurchases;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



public class ManagePurchase {
	public static void displayMenu() {
		System.out.println("1 - Add a purchase\n"
				+ "2 - Display all purchases\n"
				+ "3 - Exit");
	}
	
	public static void main(String[] args) throws InputMismatchException {
		String filename = "purchases.txt";
		ArrayList<Purchase> list = new ArrayList<Purchase>();
		File tmpDir = new File(filename);
		boolean exists = tmpDir.exists();
		if(exists) {
			try(Scanner scanner = new Scanner(new File(filename))){
				while(scanner.hasNextLine()) {
					String line1 = scanner.nextLine();
					String line2 = scanner.nextLine();
					LocalDate line3 = LocalDate.parse(scanner.nextLine());
					double line4 = Double.parseDouble(scanner.nextLine());
					
					Purchase purchase = new Purchase(line1, line2, line3, line4);
					list.add(purchase);
			
				}
			}
			catch(FileNotFoundException | IllegalPurchaseArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
		Format formatter = new SimpleDateFormat("yyyy-mm-dd");		
		int input = 0;
		int dateInt = 0;
		int productInt = 0;
		int storeInt = 0;
		int costInt = 0;
		LocalDate date = LocalDate.parse("2000-01-01");
		String productName = "";
		String storeName = "";
		double cost = 0;
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
					while(productInt == 0) {
						try {
							System.out.println("Enter a product name");
							productName = sc.next();
							if(productName.length() < 1) {
								throw new Exception();
							}
							productInt = 1;
						} catch(Exception e) {
							System.out.println("Enter a valid product name");
							productInt = 0;
						}

					}
					while(storeInt == 0) {
						try {
							System.out.println("Enter a store name");
							storeName = sc.next();
							if(storeName.length() < 1) {
								throw new Exception();
							}
							storeInt = 1;
						} catch (Exception e) {
							System.out.println("Enter a valid store name");
							storeInt = 0;
						}

						
					}

					while(dateInt == 0) {
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
					
					while(costInt == 0) {
						try {
							System.out.println("Enter a cost");
							cost = Double.parseDouble(sc.next());
							if(cost < 0) {
								throw new Exception();
							}
							costInt = 1;
						} catch(Exception e) {
							System.out.println("Enter a valid cost");
							costInt = 0;
						}

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
				try (FileWriter fileWriter = new FileWriter(filename);
					    PrintWriter printWriter = new PrintWriter(fileWriter)){
					if(list.size() > 0) {
						for(Purchase purchases : list) {
							printWriter.println(purchases.getProductName() + "\n" 
									+ purchases.getStoreName() + "\n"
									+ purchases.getPurchaseDate().toString() + "\n"
									+ Double.toString(purchases.getCost()));
						}
						printWriter.close();
						System.out.println("Thank you for using the Purchase Tracker");
						System.exit(0);
					}
				} catch(IOException e) {
					System.out.println("Error writing file " + e.getMessage());
				}
			}
		}
	}
}
