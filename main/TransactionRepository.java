import java.sql.*;
import entities.*;
import java.util.ArrayList;
import java.lang.*;

public class TransactionRepository implements ITransactionRepository{
	DatabaseConnection DBC;
	
	public TransactionRepository(){
		DBC = new DatabaseConnection();
	}
	
	public void insertTransactionsPhone(Transactions T){
		String query = "insert into transactions (cusname, cusphone, cusemail, productid, modelname, date, price) values('"+T.getCusName()+"','"+T.getCusPhone()+"','"+T.getCusEmail()+"','"+T.getProductID()+"',(Select model from phones where productid = '"+T.getProductID()+"'),'"+T.getDate()+"',(Select price from phones where productid = '"+T.getProductID()+"'));";
		try{
			System.out.println(query);
			DBC.openDatabaseConnection();
			DBC.st.execute(query);
			DBC.closeConnection();
			System.out.println("Added new transaction to database");
		}
		
		catch(Exception ex){
			System.out.println("Exception: "+ex.getMessage());
		}
	}
	
	public void insertTransactionsLaptop(Transactions T){
		String query = "insert into transactions (cusname, cusphone, cusemail, productid, modelname, date, price) values('"+T.getCusName()+"','"+T.getCusPhone()+"','"+T.getCusEmail()+"','"+T.getProductID()+"',(Select model from laptops where productid = '"+T.getProductID()+"'),'"+T.getDate()+"',(Select price from laptops where productid = '"+T.getProductID()+"'));";
		try{
			System.out.println(query);
			DBC.openDatabaseConnection();
			DBC.st.execute(query);
			DBC.closeConnection();
			System.out.println("Added new transaction to database");
		}
		
		catch(Exception ex){
			System.out.println("Exception: "+ex.getMessage());
		}
	}
	
	public void insertTransactionsTelevision(Transactions T){
		String query = "insert into transactions (cusname, cusphone, cusemail, productid, modelname, date, price) values('"+T.getCusName()+"','"+T.getCusPhone()+"','"+T.getCusEmail()+"','"+T.getProductID()+"',(Select model from televisions where productid = '"+T.getProductID()+"'),'"+T.getDate()+"',(Select price from televisions where productid = '"+T.getProductID()+"'));";
		try{
			System.out.println(query);
			DBC.openDatabaseConnection();
			DBC.st.execute(query);
			DBC.closeConnection();
			System.out.println("Added new transaction to database");
		}
		
		catch(Exception ex){
			System.out.println("Exception: "+ex.getMessage());
		}
	}
	
	public String[][] getAllTransactions(){
		ArrayList<Transactions> TraList = new ArrayList<Transactions>();
		String query = "select * from transactions";
		try{
			DBC.openDatabaseConnection();
			DBC.result = DBC.st.executeQuery(query);
			
			while(DBC.result.next()){
				String tranID = DBC.result.getString("tranID");
				String cusName = DBC.result.getString("cusname");
				String cusPhone = DBC.result.getString("cusphone");
				String cusEmail = DBC.result.getString("cusemail");
				String productID = DBC.result.getString("productid");
				String model = DBC.result.getString("modelname");
				String date = DBC.result.getString("date");
				int price = DBC.result.getInt("price");
				
				Transactions Tra = new Transactions();
				Tra.setTranID(tranID);
				Tra.setCusName(cusName);
				Tra.setCusPhone(cusPhone);
				Tra.setCusEmail(cusEmail);
				Tra.setProductID(productID);
				Tra.setModelName(model);
				Tra.setDate(date);
				Tra.setPrice(price);
				TraList.add(Tra);
			}
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		DBC.closeConnection();
		
		Object OBJ[] =TraList.toArray();
		String data[][] = new String[TraList.size()][8];
		
		for(int i=0; i<OBJ.length; i++){
			data[i][0] = ((Transactions)OBJ[i]).getTranID();
			data[i][1] = ((Transactions)OBJ[i]).getCusName();
			data[i][2] = ((Transactions)OBJ[i]).getCusPhone();
			data[i][3] = ((Transactions)OBJ[i]).getCusEmail();
			data[i][4] = ((Transactions)OBJ[i]).getProductID();
			data[i][5] = ((Transactions)OBJ[i]).getModelName();
			data[i][6] = ((Transactions)OBJ[i]).getDate();
			data[i][7] = Integer.toString(((Transactions)OBJ[i]).getPrice());
		}
		return data;
	}
	//Searching for specific transactions with customer's name
	public String[][] searchTransactions(String customerName){
		ArrayList<Transactions> TraList = new ArrayList<Transactions>();
		String query = "select * from transactions where cusname ='"+customerName+"';";
		try{
			DBC.openDatabaseConnection();
			DBC.result = DBC.st.executeQuery(query);
			
			while(DBC.result.next()){
				String tranID = DBC.result.getString("tranID");
				String cusName = DBC.result.getString("cusname");
				String cusPhone = DBC.result.getString("cusphone");
				String cusEmail = DBC.result.getString("cusemail");
				String productID = DBC.result.getString("productid");
				String model = DBC.result.getString("modelname");
				String date = DBC.result.getString("date");
				int price = DBC.result.getInt("price");
				
				Transactions Tra = new Transactions();
				Tra.setTranID(tranID);
				Tra.setCusName(cusName);
				Tra.setCusPhone(cusPhone);
				Tra.setCusEmail(cusEmail);
				Tra.setProductID(productID);
				Tra.setModelName(model);
				Tra.setDate(date);
				Tra.setPrice(price);
				TraList.add(Tra);
			}
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		DBC.closeConnection();
		
		Object OBJ[] =TraList.toArray();
		String data[][] = new String[TraList.size()][8];
		
		for(int i=0; i<OBJ.length; i++){
			data[i][0] = ((Transactions)OBJ[i]).getTranID();
			data[i][1] = ((Transactions)OBJ[i]).getCusName();
			data[i][2] = ((Transactions)OBJ[i]).getCusPhone();
			data[i][3] = ((Transactions)OBJ[i]).getCusEmail();
			data[i][4] = ((Transactions)OBJ[i]).getProductID();
			data[i][5] = ((Transactions)OBJ[i]).getModelName();
			data[i][6] = ((Transactions)OBJ[i]).getDate();
			data[i][7] = Integer.toString(((Transactions)OBJ[i]).getPrice());
		}
		return data;
	}
}