import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ContactProgram {

	public static void main(String[] args) {
		String jdbcURL = "jdbc:postgresql://localhost:5432/db1";
		String username = "postgres";
		String password = "18162026";
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL, username, password);
			System.out.println("Connected to postgresql server");
			
			String sql = "INSERT INTO contacts (first_name, last_name, email) VALUES('Mahesh','chandra','hello@gmail.com')";
			
			java.sql.Statement statement = connection.createStatement();
			
			int rows = statement.executeUpdate(sql);
			if(rows>0) {
				System.out.println("A new row has been added to your database.");
			}
			
			connection.close();
		}
		
		catch (SQLException e)  {
			System.out.println("Error in connecting to postgresql");
			e.printStackTrace();
		}
	}
}
