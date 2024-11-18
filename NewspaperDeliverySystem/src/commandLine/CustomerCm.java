package commandLine;

import java.sql.ResultSet;
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
		System.out.println("99. Main Menu");
		System.out.println("=============================================");
		System.out.println(" ");
	}
	
private static boolean printCustomerTable(ResultSet rs) throws Exception {
		
		//Print The Contents of the Full Customer Table
		
		System.out.println("------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Table: " + rs.getMetaData().getTableName(1));
		for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
			System.out.printf("%30s",rs.getMetaData().getColumnName(i));
		}
		System.out.println();
		while (rs.next()) {
			int id = rs.getInt("id");
			String fname = rs.getString("FirstName");
			String sname = rs.getString("LastName");
			String addr = rs.getString("Address");
			String phone = rs.getString("PhoneNumber");
			String eircode = rs.getString("Eircode");
			String daysofd = rs.getString("DeliveryDays");
			String email = rs.getString("Email");
			

			
			System.out.printf("%30s", fname);
			System.out.printf("%30s", sname);
			System.out.printf("%30s", addr);
			System.out.printf("%30s", phone);
			System.out.printf("%30s", eircode);
			System.out.printf("%30s", daysofd);
			System.out.printf("%30s", email);
			System.out.printf("%30s", id);

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
					System.out.printf("Enter Customers First Name: \n");
					String custFName = keyboard.next();
					System.out.printf("Enter Customers Second Name: \n");
					String custSName = keyboard.next();
					System.out.printf("Enter Customer Address: \n");
					String custAddr = keyboard.next();
					System.out.printf("Enter Customer PhoneNumber: \n");
					String custPhone = keyboard.next();
					System.out.printf("Enter Customer Eircode: \n");
					String custEircode = keyboard.next();
					System.out.printf("Enter Days of Delivery: \n");
					String daysOfDelivery = keyboard.next();
					System.out.printf("Enter Customer Email: \n");
					String custEmail = keyboard.next();
					System.out.printf("Enter Customer ID: \n");
					int custID = keyboard.nextInt();

				
					Customer custObj = new Customer(custFName, custSName, custAddr, custPhone, custEircode, daysOfDelivery, custEmail, custID);
				
					//Insert Customer Details into the database
					boolean insertResult = dao.insertCustomerDetailsAccount(custObj);
					if (insertResult == true)
						System.out.println("Customer Details Saved");
					else 
						System.out.println("ERROR: Customer Details NOT Saved");
					break;
					
				case "2": 
					ResultSet rSet = dao.retrieveAllCustomerAccounts();
					if (rSet == null) {
						System.out.println("No Records Found");
						break;
					}
					else {
						boolean tablePrinted = printCustomerTable(rSet);
						if (tablePrinted == true)
							rSet.close();
					}
					break;
					
				case "3":
					Scanner scanner3 = new Scanner(System.in);
					
					System.out.println("Update Customer Details");
					System.out.println("Enter what column you wish to edit: ");
					String editTarget = scanner3.nextLine();
					System.out.println("Enter the change here");
					String editValue = scanner3.nextLine();
					System.out.println("Enter the Id you wish to change");
					int editID = scanner3.nextInt();
					boolean editResult = dao.editCustomer(editTarget, editValue, editID);
					if(editResult == true)
					{
						System.out.println("Customer data changed!");
					}
					else
					{
						System.out.println("ERROR: Customer Details NOT Edited or Do not Exist");
					}
					
					break;
				case "4":
					System.out.println("Enter Customer Id to be deleted or -99 to Clear all Rows");
					String deleteCustId = keyboard.next();
					boolean deleteResult = dao.deleteCustomerById(Integer.parseInt(deleteCustId));
					if ((deleteResult == true) && (deleteCustId.equals("-99")))
						System.out.println("Customer Table Emptied");
					else if (deleteResult == true)
						System.out.println("Customer Deleted");
					else 
						System.out.println("ERROR: Customer Details NOT Deleted or Do Not Exist");
					break;
			
				case "99":
					System.out.println("Main Menu");
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
