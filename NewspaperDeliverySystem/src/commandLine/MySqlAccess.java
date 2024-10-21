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
	
	final private String host ="jdbc:mysql://GibbytheLaptop:3306/newspaperSystem";
	final private String user = "root";
	final private String password = "Mike";
	
	
	public MySqlAccess() throws Exception {
		
		try {
			
			//Load MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Setup the connection with the DB
			connect = DriverManager.getConnection("jdbc:mysql://" + host + "newspaperSystem" + "user=" + user + "&password=" + password);
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
			preparedStatement = connect.prepareStatement("insert into newpaperSystem.customer values (default, ?, ?, ?, ?, ? ,?, ?, ?, ?)");
			preparedStatement.setInt(1, c. getId());
			preparedStatement.setString(2, c.getName());
			preparedStatement.setString(4, c.getAddress());
			preparedStatement.setString(5, c.getPhoneNumber());
			preparedStatement.setString(6, c.getEircode());
			preparedStatement.setInt(7, c.getFrequency());
			preparedStatement.setString(8, c.getDaysOfDelivery());
			preparedStatement.setString(9, c.getEmail());
			preparedStatement.executeUpdate();
		
	 
		}
		catch (Exception e) {
			insertSucessfull = false;
		}
	
		return insertSucessfull;
		
	}
}