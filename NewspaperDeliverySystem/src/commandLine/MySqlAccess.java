package commandLine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySqlAccess {
	
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	final private String host ="localhost:3306";
	final private String user = "root";
	final private String password = "Mike";
	
	
	public MySqlAccess() throws Exception {
		
		try {
			
			//Load MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/library?useTimezone=true&serverTimezone=UTC";
			//Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "/newspaperSystem?" + "user=" + user + "&password=" + password);
		}
		catch (Exception e) {
			throw e;
		}
		
		
	}	

		public boolean insertCustomerDetailsAccount(Customer c) {

		boolean insertSucessfull = true;
	
		//Add Code here to call embedded SQL to insert Customer into DB
	
		try {
		
			//Create prepared statement to issue SQL query to the database
			preparedStatement = connect.prepareStatement("insert into customer values (?, ?, ?, ?, ?, ?, ?, ?)");
			
			preparedStatement.setString(1, c.getFname());
			preparedStatement.setString(2, c.getSname());
			preparedStatement.setString(3, c.getAddress());
			preparedStatement.setString(4, c.getPhoneNumber());
			preparedStatement.setString(5, c.getEircode());
			//preparedStatement.setInt(7, c.getFrequency());
			preparedStatement.setString(6, c.getDaysOfDelivery());
			preparedStatement.setString(7, c.getEmail());
			preparedStatement.setInt(8, c.getId());
			preparedStatement.executeUpdate();
		
	 
		}
		catch (Exception e) {
			insertSucessfull = false;
			e.printStackTrace();
		}
	
		return insertSucessfull;
		
	}
		
		public ResultSet retrieveAllCustomerAccounts() {
			
			try {
				statement = connect.createStatement();
				resultSet = statement.executeQuery("Select * from customer");
			}catch(Exception e) {
				resultSet = null;
			}
			return resultSet;
		}
		
		public boolean editCustomer(String editTarget,String editValue ,int custID)
		{
			boolean editSucessfull = true;
			
			try {
				preparedStatement = connect.prepareStatement("update customer set " + editTarget + " = '"+ editValue + "'where id = "+ custID);
				preparedStatement.executeUpdate();
			}
			catch(Exception e)
			{
				editSucessfull = false;
			}
			return editSucessfull;
		}
		public boolean deleteCustomerById(int custID) {
			
			boolean deleteSucessfull = true;
			
			try {
				
				if(custID == -99)
					preparedStatement = connect.prepareStatement("delete from customer");
				else
					preparedStatement = connect.prepareStatement("delete from customer where id = " + custID);
				preparedStatement.executeUpdate();

			}catch (Exception e) {
				deleteSucessfull = false;
			}
			
			return deleteSucessfull;
			
		}
//		public boolean insertOrderDetails(Order d)
//		{
//			boolean insertSucessfull = true;
//			
//			
//			
//		}
		
public ResultSet retrieveAllOrderAccounts() {
			
			try {
				statement = connect.createStatement();
				resultSet = statement.executeQuery("Select * from order");
			}catch(Exception e) {
				resultSet = null;
			}
			return resultSet;
		}
		
		public boolean editOrder(String editTarget,String editValue ,int orderID)
		{
			boolean editSucessfull = true;
			
			try {
				preparedStatement = connect.prepareStatement("update order set " + editTarget + " = '"+ editValue + "'where id = "+ orderID);
				preparedStatement.executeUpdate();
			}
			catch(Exception e)
			{
				editSucessfull = false;
			}
			return editSucessfull;
		}
		public boolean deleteOrderById(int orderID) {
			
			boolean deleteSucessfull = true;
			
			try {
				
				if(orderID == -99)
					preparedStatement = connect.prepareStatement("delete from order");
				else
					preparedStatement = connect.prepareStatement("delete from order where id = " + orderID);
				preparedStatement.executeUpdate();

			}catch (Exception e) {
				deleteSucessfull = false;
			}
			
			return deleteSucessfull;
			
		}
		
//		public boolean insertDeliveryDocket(DeliveryDocket f){
//			boolean insertSucessfull = true;
//		}
		
		public ResultSet retrieveAllDeliveryDockets() {
			
			try {
				statement = connect.createStatement();
				resultSet = statement.executeQuery("Select * from deliverydocket");
			}catch(Exception e) {
				resultSet = null;
			}
			return resultSet;
		}
		
		public boolean editDeliveryDocket(String editTarget,String editValue ,int deliveryDocketID)
		{
			boolean editSucessfull = true;
			
			try {
				preparedStatement = connect.prepareStatement("update deliverydocket set " + editTarget + " = '"+ editValue + "'where id = "+ deliveryDocketID);
				preparedStatement.executeUpdate();
			}
			catch(Exception e)
			{
				editSucessfull = false;
			}
			return editSucessfull;
		}
		public boolean deleteDeliveryDocketById(int deliveryDocketID) {
			
			boolean deleteSucessfull = true;
			
			try {
				
				if(deliveryDocketID == -99)
					preparedStatement = connect.prepareStatement("delete from deliverydocket");
				else
					preparedStatement = connect.prepareStatement("delete from deliverydocket where id = " + deliveryDocketID);
				preparedStatement.executeUpdate();

			}catch (Exception e) {
				deleteSucessfull = false;
			}
			
			return deleteSucessfull;
			
		}
}