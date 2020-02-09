package job;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DataBaseConnection {
	private static Connection con;
	public static void main(String[] args) {
			getConnection();
	}
			public static Connection getConnection() {
			try {
					System.out.println("..............................");
					Class.forName("oracle.jdbc.driver.OracleDriver");
					// step2 create the connection object
					con = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe", "Garage", "samartha");
					System.out.println("Database Connected");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return con;

			}
		}

