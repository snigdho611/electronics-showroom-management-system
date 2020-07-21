import entities.*;
import java.sql.*;

public class DatabaseConnection{
	Connection con;
	Statement st;
	ResultSet result;
	
	public DatabaseConnection(){
		
	}
	
	public void openDatabaseConnection(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbproject?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
			st = con.createStatement();
		}
		catch(SQLException e){
			System.out.print("\nError Encountered");
		}
		catch(ClassNotFoundException e){
				throw new Error("Problem", e);
		}
	}
	
	public void closeConnection()
	{
		try
		{
			if(con!=null){con.close();}
			if(st!=null){st.close();}
			if(result!=null){result.close();}
		}
		catch(Exception e){}
	}
	
	/*public static void main(String args[]){
		DatabaseConnection dbc = new DatabaseConnection();
	}*/
}