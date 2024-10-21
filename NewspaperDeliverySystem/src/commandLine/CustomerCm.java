package commandLine;

import java.util.Scanner;

public class CustomerCm {
	
	public static void CustomerOptions() {
		System.out.println(" ");
		System.out.println("=============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Add new Customer");
		System.out.println("2. View Customer Table");
		System.out.println("3. Update Customer Details");
		System.out.println("4. Delete Customer");
		System.out.println("99. Main Menue");
		System.out.println("=============================================");
		System.out.println(" ");
	}
	
	
	
public static void main(String[] args) {
		

		
		//Create the Database Object
		
		try {
			
			
			MySqlAccess dao = new MySqlAccess();
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
					System.out.printf("Enter Customers first Name: \n");
					String custFName = keyboard.next();
					System.out.printf("Enter Customers second Name: \n");
					String custSName = keyboard.next();
					System.out.printf("Enter Customer Address: \n");
					String custAddr = keyboard.next();
					System.out.printf("Enter Customer PhoneNumber: \n");
					String custphone = keyboard.next();
					System.out.printf("Enter Customer Eircode: \n");
					String custEircode = keyboard.next();
					System.out.printf("Enter Customer Eircode: \n");
					String custDeliveryDays = keyboard.next();
					System.out.printf("Enter Customer Eircode: \n");
					String custEmail = keyboard.next();
				
					Customer custObj = new Customer(custFName, custSName, custAddr, custphone, custEircode, custDeliveryDays, custEmail);
				
					//Insert Customer Details into the database
					boolean insertResult = dao.insertCustomerDetailsAccount(custObj);
					if (insertResult == true)
						System.out.println("Customer Details Saved");
					else 
						System.out.println("ERROR: Customer Details NOT Saved");
					break;
					
				case "2": 
					Scanner scanner2 = new Scanner(System.in);
					
					System.out.println("View Customer Table");
					
					System.out.println("Press any key to return to the main menu...");
			        scanner2.nextLine();
					break;
					
				case "3":
					Scanner scanner3 = new Scanner(System.in);
					
					System.out.println("Update Customer Details");
					
					System.out.println("Press any key to return to the main menu...");
			        scanner3.nextLine();
					break;
				case "4":
					Scanner scanner4 = new Scanner(System.in);
					
					System.out.println("Delete Customer");
					
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
