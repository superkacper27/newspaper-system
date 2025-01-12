package commandLine;

import java.util.Scanner;

public class InvoiceCm {
	
	public static void CustomerOptions() {
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create a new Invoice");
		System.out.println("2. View Invoices");
		System.out.println("3. Update Invoices");
		System.out.println("4. Delete Invoices");
		System.out.println("99. Main Menue");
		System.out.println("=============================================");
		System.out.println(" ");
	}
	
	
	
public static void main(String[] args) {
		

		
		//Create the Database Object
		
		try {
			
			
		
			// Configure System for Running
			Scanner keyboard = new Scanner(System.in); 
			String functionNumber = "-99";
			boolean keepAppOpen = true;
		
			while (keepAppOpen == true) {
			
				//Present list of functionality and get selection
				CustomerOptions();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {
		
				case "1":
			        Scanner scanner = new Scanner(System.in);

					System.out.println("Create a new Invoice");
					
			        System.out.println("Press any key to return to the main menu...");
			        scanner.nextLine();
					break;
					
				case "2": 
			        Scanner scanner2 = new Scanner(System.in);

					System.out.println("View Invoices");
					
			        System.out.println("Press any key to return to the main menu...");
			        scanner2.nextLine();
					break;
					
				case "3":
			        Scanner scanner3 = new Scanner(System.in);

					System.out.println("Update Invoices");
					
			        System.out.println("Press any key to return to the main menu...");
			        scanner3.nextLine();
					break;
				case "4":
			        Scanner scanner4 = new Scanner(System.in);

					System.out.println("Delete Invoices");
					
			        System.out.println("Press any key to return to the main menu...");
			        scanner4.nextLine();
					break;
			
				case "99":
					System.out.println("Main Menue");
					CommandLine.main(args);
					break;
			
				default:
					System.out.println("No Valid Function Selected");
					break;
				} // end switch
		
			}// end while
		
			//Tidy up Resources
			keyboard.close();
		
		}
	
		catch(Exception e) {
			System.out.println("PROGRAM TERMINATED - ERROR MESSAGE:" + e.getMessage());
		} // end try-catch
	}

}
