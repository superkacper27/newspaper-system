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
			preparedStatement = connect.prepareStatement("insert into customer values (?, ?, ?, ?, ?, ?, ?)");
			//preparedStatement.setString(1, c. getId());
			preparedStatement.setString(1, c.getFname());
			preparedStatement.setString(2, c.getSname());
			preparedStatement.setString(3, c.getAddress());
			preparedStatement.setString(4, c.getPhoneNumber());
			preparedStatement.setString(5, c.getEircode());
			//preparedStatement.setInt(7, c.getFrequency());
			preparedStatement.setString(6, c.getDaysOfDelivery());
			preparedStatement.setString(7, c.getEmail());
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
		
		public boolean deleteCustomerById(int custID) {
			
			boolean deleteSucessfull = true;
			
			try {
				
				if(custID == -99)
					preparedStatement = connect.prepareStatement("delete from newpaperSystem.customer");
				else
					preparedStatement = connect.prepareStatement("delete from newpaperSystem.customer where id = " + custID);
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
		
}