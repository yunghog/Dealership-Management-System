package job;
import java.util.*;
import java.sql.*;
public class bayIds{
	public static String[] strBay;
	 public static String[] GetStringArray(ArrayList<String> arr) 
	    { 
	        String str[] = new String[arr.size()]; 
	        for (int j = 0; j < arr.size(); j++) { 
	            str[j] = arr.get(j); 
	        } 
	        return str; 
	    } 
	
	public static void getBay(){
		Connection connection;
		java.sql.Statement Statement;
		String queryBay;
		ArrayList<String> bay = new ArrayList<String>();
		try {
			connection = DataBaseConnection.getConnection();
			Statement = connection.createStatement();
			queryBay = "select bname from bay";
			ResultSet rsTech = Statement.executeQuery(queryBay.toString());
			try {
				while(rsTech.next()) {
				System.out.println(rsTech.getString(1));
				bay.add(rsTech.getString(1));
				}
			}
			catch(SQLException  e) {
			System.out.print(e);
			}
		}
		
		catch(Exception e1) {
			System.out.print(e1);
		}
		String[] str = GetStringArray(bay);
		for(int i=0;i<str.length;i++)
			System.out.print(str[i]);
		strBay=str;
	}
}
