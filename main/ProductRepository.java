import java.sql.*;
import entities.*;
import java.util.ArrayList;
import java.lang.*;

public class ProductRepository implements IProductRepository{
	DatabaseConnection DBC;
	
	public ProductRepository(){
		DBC = new DatabaseConnection();
	}
	
	public void insertPhones(Phones P){
		String query = "insert into phones values ('"+P.getProductID()+"','"+P.getModelName()+"','"+P.getProcessorModel()+"','"+P.getRamSize()+"','"+P.getInternalStorageSize()+"','"+P.getCameraQuality()+"',"+P.getPrice()+");";
		try{
			DBC.openDatabaseConnection();
			DBC.st.execute(query);
			DBC.closeConnection();
			System.out.println("Added new phone to database");
		}
		
		catch(SQLException ex){
			System.out.println("Exception: "+ex.getMessage());
		}
	}
	
	public void insertLaptops(Laptops L){
		String query = "insert into laptops values ('"+L.getProductID()+"','"+L.getModelName()+"','"+L.getProcessorModel()+"','"+L.getInternalStorageSize()+"','"+L.getBatteryLife()+"','"+L.getRamSize()+"',"+L.getPrice()+");";
		try{
			DBC.openDatabaseConnection();
			DBC.st.execute(query);
			DBC.closeConnection();
			System.out.println("Added new laptop to database");
		}
		catch(Exception ex){
			System.out.println("Exception: "+ex.getMessage());
		}
	}
	
	public void insertTelevisions(Televisions T){
		String query = "insert into televisions values ('"+T.getProductID()+"','"+T.getModelName()+"','"+T.getScreenSize()+"','"+T.getScreenType()+"','"+T.getSoundType()+"','"+T.getConnectivity()+"',"+T.getPrice()+");";
		try{
			DBC.openDatabaseConnection();
			DBC.st.execute(query);
			DBC.closeConnection();
			System.out.println("Added new television to database");
		}
		catch(Exception ex){
			System.out.println("Exception: "+ex.getMessage());
		}
	}
	
	public void deletePhones(String productID){
		String query = "delete from phones where productid = '"+productID+"';";
		try{
			DBC.openDatabaseConnection();
			DBC.st.execute(query);
			DBC.closeConnection();
			System.out.println("Deleted a phone from database");
		}
		catch(NullPointerException NPE){
			System.out.println("Product does not exist!");
		}
		catch(Exception ex){
			System.out.println("Exception: "+ex.getMessage());
		}
	}
	
	public void deleteLaptops(String productID){
		String query = "delete from laptops where productid = '"+productID+"';";
		try{
			DBC.openDatabaseConnection();
			DBC.st.execute(query);
			DBC.closeConnection();
			System.out.println("Deleted a laptop from database");
		}
		catch(Exception ex){
			System.out.println("Exception: "+ex.getMessage());
		}
	}
	
	public void deleteTelevisions(String productID){
		String query = "delete from televisions where productid = '"+productID+"';";
		try{
			DBC.openDatabaseConnection();
			DBC.st.execute(query);
			DBC.closeConnection();
			System.out.println("Deleted a television from database");
		}
		catch(Exception ex){
			System.out.println("Exception: "+ex.getMessage());
		}
	}
	
	public String[][] searchPhones(String phoneName){
		ArrayList<Phones> PList = new ArrayList<Phones>();
		String query = "select * from phones where model ='"+phoneName+"';";
		
		try{
			DBC.openDatabaseConnection();
			DBC.result = DBC.st.executeQuery(query);
			
			while(DBC.result.next()){
				String productID = DBC.result.getString("productid");
				String model = DBC.result.getString("model");
				String processor = DBC.result.getString("processor");
				String ram = DBC.result.getString("ram");
				String storage = DBC.result.getString("storage");
				String camera = DBC.result.getString("camera");
				int price = DBC.result.getInt("price");
				
				Phones P = new Phones();
				P.setProductID(productID);
				P.setModelName(model);
				P.setProcessorModel(processor);
				P.setRamSize(ram);
				P.setInternalStorageSize(storage);
				P.setCameraQuality(camera);
				P.setPrice(price);
				PList.add(P);
			}
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		DBC.closeConnection();
		
		Object OBJ[] =PList.toArray();
		String data[][] = new String[PList.size()][7];
		
		for(int i=0; i<OBJ.length; i++){
			data[i][0] = ((Phones)OBJ[i]).getProductID();
			data[i][1] = ((Phones)OBJ[i]).getModelName();
			data[i][2] = ((Phones)OBJ[i]).getProcessorModel();
			data[i][3] = ((Phones)OBJ[i]).getRamSize();
			data[i][4] = ((Phones)OBJ[i]).getInternalStorageSize();
			data[i][5] = ((Phones)OBJ[i]).getCameraQuality();
			data[i][6] = Integer.toString(((Phones)OBJ[i]).getPrice());
		}
		return data;
	}
	
	public String[][] searchLaptops(String laptopName){
		ArrayList<Laptops> LList = new ArrayList<Laptops>();
		String query = "select * from laptops where model ='"+laptopName+"';";
		try{
			DBC.openDatabaseConnection();
			DBC.result = DBC.st.executeQuery(query);
			
			while(DBC.result.next()){
				String productID = DBC.result.getString("productid");
				String model = DBC.result.getString("model");
				String processor = DBC.result.getString("processor");
				String ram = DBC.result.getString("ram");
				String storage = DBC.result.getString("storage");
				String battery = DBC.result.getString("battery");
				int price = DBC.result.getInt("price");
				
				Laptops L = new Laptops();
				L.setProductID(productID);
				L.setModelName(model);
				L.setProcessorModel(processor);
				L.setRamSize(ram);
				L.setInternalStorageSize(storage);
				L.setBatteryLife(battery);
				L.setPrice(price);
				LList.add(L);
			}
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		DBC.closeConnection();
		
		Object OBJ[] =LList.toArray();
		String data[][] = new String[LList.size()][7];
		
		for(int i=0; i<OBJ.length; i++){
			data[i][0] = ((Laptops)OBJ[i]).getProductID();
			data[i][1] = ((Laptops)OBJ[i]).getModelName();
			data[i][2] = ((Laptops)OBJ[i]).getProcessorModel();
			data[i][3] = ((Laptops)OBJ[i]).getRamSize();
			data[i][4] = ((Laptops)OBJ[i]).getInternalStorageSize();
			data[i][5] = ((Laptops)OBJ[i]).getBatteryLife();
			data[i][6] = Integer.toString(((Laptops)OBJ[i]).getPrice());
		}
		return data;
	}
	
	public String[][] searchTelevisions(String televisionName){
		ArrayList<Televisions> TList = new ArrayList<Televisions>();
		String query = "select * from televisions where model = '"+televisionName+"';";
		try{
			DBC.openDatabaseConnection();
			DBC.result = DBC.st.executeQuery(query);
			
			while(DBC.result.next()){
				String productID = DBC.result.getString("productid");
				String model = DBC.result.getString("model");
				String screenSize = DBC.result.getString("ScreenSize");
				String screenType = DBC.result.getString("ScreenType");
				String soundType = DBC.result.getString("SoundType");
				String connectivity = DBC.result.getString("Connectivity");
				int price = DBC.result.getInt("price");
				
				Televisions T = new Televisions();
				T.setProductID(productID);
				T.setModelName(model);
				T.setScreenSize(screenSize);
				T.setScreenType(screenType);
				T.setSoundType(soundType);
				T.setConnectivity(connectivity);
				T.setPrice(price);
				TList.add(T);
			}
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		DBC.closeConnection();
		
		Object OBJ[] =TList.toArray();
		String data[][] = new String[TList.size()][7];
		
		for(int i=0; i<OBJ.length; i++){
			data[i][0] = ((Televisions)OBJ[i]).getProductID();
			data[i][1] = ((Televisions)OBJ[i]).getModelName();
			data[i][2] = ((Televisions)OBJ[i]).getScreenSize();
			data[i][3] = ((Televisions)OBJ[i]).getScreenType();
			data[i][4] = ((Televisions)OBJ[i]).getSoundType();
			data[i][5] = ((Televisions)OBJ[i]).getConnectivity();
			data[i][6] = Integer.toString(((Televisions)OBJ[i]).getPrice());
		}
		return data;
	}
	
	public String[][] getAllPhones(){                                      //Fetches all the data from the Phones table in the database
		ArrayList<Phones> PList = new ArrayList<Phones>();
		String query = "select * from phones";                             //query to get all the rows of this table 'phones'
		try{
			DBC.openDatabaseConnection();                                  //launches the database connection
			DBC.result = DBC.st.executeQuery(query);                       //The query is executed, and the result is stored in the resultset variable of the databaseconnection class
			
			while(DBC.result.next()){                                      //this loop runs to get the values from each column of each row, and set it to their respected variables
				String productID = DBC.result.getString("productid");
				String model = DBC.result.getString("model");
				String processor = DBC.result.getString("processor");
				String ram = DBC.result.getString("ram");
				String storage = DBC.result.getString("storage");
				String camera = DBC.result.getString("camera");
				int price = DBC.result.getInt("price");
				
				Phones P = new Phones();                                   //and then the respective variable is created to then set the retrieved values from the database into it
				P.setProductID(productID);
				P.setModelName(model);
				P.setProcessorModel(processor);
				P.setRamSize(ram);
				P.setInternalStorageSize(storage);
				P.setCameraQuality(camera);
				P.setPrice(price);                                         //by this line, an object of our requirement has been created that contains all the necessary values from the database
				PList.add(P);                                              //and each of these required objects are added inside an arraylist, which is dynamic, length and data type wise
			}
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		DBC.closeConnection();
		
		Object OBJ[] = PList.toArray();                                    //the array list is converted to an ordinary array, and those values are set inside an object array
		String data[][] = new String[PList.size()][7];                     //a two dimensional string array is created to set all the values of a table into it
		
		for(int i=0; i<OBJ.length; i++){                                   //this loop continues according to the object array's length
			data[i][0] = ((Phones)OBJ[i]).getProductID();                  //each index's value is typecasted into the required object (phones), and the values are put inside the two dimensional array
			data[i][1] = ((Phones)OBJ[i]).getModelName();
			data[i][2] = ((Phones)OBJ[i]).getProcessorModel();
			data[i][3] = ((Phones)OBJ[i]).getRamSize();
			data[i][4] = ((Phones)OBJ[i]).getInternalStorageSize();
			data[i][5] = ((Phones)OBJ[i]).getCameraQuality();
			data[i][6] = Integer.toString(((Phones)OBJ[i]).getPrice());
		}
		return data;                                                       //the two dimensional string array is returned
	}
	
	public String[][] getAllLaptops(){                                      //Fetches all the data from the Laptops table in the database
		ArrayList<Laptops> LList = new ArrayList<Laptops>();
		String query = "select * from laptops";
		try{
			DBC.openDatabaseConnection();
			DBC.result = DBC.st.executeQuery(query);
			
			while(DBC.result.next()){
				String productID = DBC.result.getString("productid");
				String model = DBC.result.getString("model");
				String processor = DBC.result.getString("processor");
				String ram = DBC.result.getString("ram");
				String storage = DBC.result.getString("storage");
				String battery = DBC.result.getString("battery");
				int price = DBC.result.getInt("price");
				
				Laptops L = new Laptops();
				L.setProductID(productID);
				L.setModelName(model);
				L.setProcessorModel(processor);
				L.setRamSize(ram);
				L.setInternalStorageSize(storage);
				L.setBatteryLife(battery);
				L.setPrice(price);
				LList.add(L);
			}
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		DBC.closeConnection();
		
		Object OBJ[] =LList.toArray();
		String data[][] = new String[LList.size()][7];
		
		for(int i=0; i<OBJ.length; i++){
			data[i][0] = ((Laptops)OBJ[i]).getProductID();
			data[i][1] = ((Laptops)OBJ[i]).getModelName();
			data[i][2] = ((Laptops)OBJ[i]).getProcessorModel();
			data[i][3] = ((Laptops)OBJ[i]).getRamSize();
			data[i][4] = ((Laptops)OBJ[i]).getInternalStorageSize();
			data[i][5] = ((Laptops)OBJ[i]).getBatteryLife();
			data[i][6] = Integer.toString(((Laptops)OBJ[i]).getPrice());
		}
		return data;
	}
	
	public String[][] getAllTelevisions(){                                      //Fetches all the data from the Televisions table in the database
		ArrayList<Televisions> TList = new ArrayList<Televisions>();
		String query = "select * from televisions";
		try{
			DBC.openDatabaseConnection();
			DBC.result = DBC.st.executeQuery(query);
			
			while(DBC.result.next()){
				String productID = DBC.result.getString("productid");
				String model = DBC.result.getString("model");
				String screenSize = DBC.result.getString("ScreenSize");
				String screenType = DBC.result.getString("ScreenType");
				String soundType = DBC.result.getString("SoundType");
				String connectivity = DBC.result.getString("Connectivity");
				int price = DBC.result.getInt("price");
				
				Televisions T = new Televisions();
				T.setProductID(productID);
				T.setModelName(model);
				T.setScreenSize(screenSize);
				T.setScreenType(screenType);
				T.setSoundType(soundType);
				T.setConnectivity(connectivity);
				T.setPrice(price);
				TList.add(T);
			}
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		DBC.closeConnection();
		
		Object OBJ[] =TList.toArray();
		String data[][] = new String[TList.size()][7];
		
		for(int i=0; i<OBJ.length; i++){
			data[i][0] = ((Televisions)OBJ[i]).getProductID();
			data[i][1] = ((Televisions)OBJ[i]).getModelName();
			data[i][2] = ((Televisions)OBJ[i]).getScreenSize();
			data[i][3] = ((Televisions)OBJ[i]).getScreenType();
			data[i][4] = ((Televisions)OBJ[i]).getSoundType();
			data[i][5] = ((Televisions)OBJ[i]).getConnectivity();
			data[i][6] = Integer.toString(((Televisions)OBJ[i]).getPrice());
		}
		return data;
	}
}