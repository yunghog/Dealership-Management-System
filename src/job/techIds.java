package job;
import java.util.*;
import java.sql.*;
public class techIds{
	public static String[] strTech;
	public static void getTech(){
		Connection connection;
		java.sql.Statement Statement;
		String queryBay;
		ArrayList<String> tech = new ArrayList<String>();
		try {
			connection = DataBaseConnection.getConnection();
			Statement = connection.createStatement();
			queryBay = "select tname from technician";
			ResultSet rsTech = Statement.executeQuery(queryBay.toString());
			try {
				while(rsTech.next()) {
				System.out.println(rsTech.getString(1));
				tech.add(rsTech.getString(1));
				}
			}
			catch(SQLException  e) {
			System.out.print(e);
			}
		}
		
		catch(Exception e1) {
			System.out.print(e1);
		}
		String[] str = bayIds.GetStringArray(tech);
		for(int i=0;i<str.length;i++)
			System.out.print(str[i]);
		strTech=str;
	}
}
