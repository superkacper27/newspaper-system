package commandLine;

import java.util.Scanner;

public class CommandLine {
	
	private static void listCustomerFuctionalityAvailable() {
		
		//Present Customer with Functionality Options
		
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Customer");
		System.out.println("2. Delivery Docket");
		System.out.println("3. Invoice");
		System.out.println("4. Orders");
		System.out.println("99. Log out");
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
				listCustomerFuctionalityAvailable();
				functionNumber = keyboard.next();
		
				switch (functionNumber) {
		
				case "1":
					CustomerCm.main(args);
					break;
					
				case "2": 
					DeliveryDocketCm.main(args);
					break;
					
				case "3":
					InvoiceCm.main(args);
					break;
				case "4":
					OrderCm.main(args);
					break;
			
				case "99":
					System.out.println("Logging Out");
					LoginCm.main(args);
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
		

	} // end main
	
	
}
