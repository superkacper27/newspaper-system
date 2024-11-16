package commandLine;

import java.sql.ResultSet;
import java.util.Scanner;

public class OrderCm {
	
	public static void CustomerOptions() {
		System.out.println(" ");
		System.out.println("==============================================");
		System.out.println("Please choose ONE of the following options:");
		System.out.println("1. Create a new Order");
		System.out.println("2. View Order");
		System.out.println("3. Update Order");
		System.out.println("4. Delete Order");
		System.out.println("99. Main Menue");
		System.out.println("=============================================");
		System.out.println(" ");
	}
	
	
private static boolean printOrderTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Full Customer Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int id = rs.getInt("id");
			String publication = rs.getString("orderpublication");
			String days = rs.getString("orderdays");


			System.out.printf("%30s", id);
			System.out.printf("%30s", publication);
			System.out.printf("%30s", days);


			System.out.println();
		}// end while
		System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
		
		return true;
		
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
				System.out.printf("Enter Publication Name: \n");
				String orderPublication = keyboard.next();
				System.out.printf("Enter Days of Delivery: \n");
				String daysOfDelivery = keyboard.next();
				System.out.printf("Enter Customer Id: \n");
				String custID = keyboard.next();
			

			
//				Order orderObj = new Order(custID, orderPublication, daysOfDelivery);
//			
//				//Insert Customer Details into the database
//				boolean insertResult = dao.insertOrderDetailsAccount(orderObj);
//				if (insertResult == true)
//					System.out.println("Order Details Saved");
//				else 
//					System.out.println("ERROR: Order Details NOT Saved");
//				break;
//				
//			case "2": 
//				ResultSet rSet = dao.retrieveAllOrderAccounts();
//				if (rSet == null) {
//					System.out.println("No Records Found");
//					break;
//				}
//				else {
//					boolean tablePrinted = printOrderTable(rSet);
//					if (tablePrinted == true)
//						rSet.close();
//				}
				break;
				
			case "3":
				Scanner scanner3 = new Scanner(System.in);
				
				System.out.println("Update Order Details");
				
				System.out.println("Press any key to return to the main menu...");
		        scanner3.nextLine();
				break;
			case "4":
				System.out.println("Enter Customer Id to be deleted or -99 to Clear all Rows");
				String deleteCustId = keyboard.next();
				boolean deleteResult = dao.deleteCustomerById(Integer.parseInt(deleteCustId));
				if ((deleteResult == true) && (deleteCustId.equals("-99")))
					System.out.println("Order Table Emptied");
				else if (deleteResult == true)
					System.out.println("Order Deleted");
				else 
					System.out.println("ERROR: Order Details NOT Deleted or Do Not Exist");
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
