import entities.*;
import java.util.ArrayList;
import java.lang.*;

public class EmployeeRepository implements IEmployeeRepository{
	DatabaseConnection DBC;
	
	public EmployeeRepository()
	{
		DBC = new DatabaseConnection();
	}
	
	public Employee getEmployee(String empid, String password){
		Employee Emp = null;
		String query = "Select empid, password from employee where empid ='"+empid+"' and password ='"+password+"';";
		try{
			//System.out.println(query);
			DBC.openDatabaseConnection();
			DBC.result = DBC.st.executeQuery(query);
			
			while(DBC.result.next()){
				Emp = new Employee();
				Emp.setEmpID(DBC.result.getString("empid"));
				Emp.setEmpID(DBC.result.getString("password"));
			}
		}
		
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		DBC.closeConnection();
		return Emp;
	}
	
	public Employee getEmployee(String password){
		Employee Emp = null;
		String query = "Select * from employee where password ='"+password+"';";
		try{
			System.out.println(query);
			DBC.openDatabaseConnection();
			DBC.result = DBC.st.executeQuery(query);
			
			while(DBC.result.next()){
				Emp = new Employee();
				Emp.setAdmin(DBC.result.getString("admin"));
			}
		}
		
		catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
		DBC.closeConnection();
		return Emp;
	}
		
	public void insertEmployee(Employee e){
		String query = "insert into employee values('"+e.getEmpID()+"','"+e.getName()+"','"+e.getPassword()+"','"+e.getEmail()+"','"+e.getPhoneNumber()+"','no');";
		try{
			DBC.openDatabaseConnection();
			DBC.st.execute(query);
			DBC.closeConnection();
			System.out.println("Welcome to the system, "+e.getName());
		}
		catch(Exception ex){
			System.out.println("Exception: "+ex.getMessage());
		}
	}
	
	public String[][] getAllEmployee(){
		ArrayList<Employee> AList= new ArrayList<Employee>();
		String query = "Select * from employee";
		try{
			DBC.openDatabaseConnection();
			DBC.result = DBC.st.executeQuery(query);
			
			while(DBC.result.next()){
				String empid = DBC.result.getString("empid");
				String name = DBC.result.getString("name");
				String password = DBC.result.getString("password");
				String email = DBC.result.getString("email");
				String phoneNumber = DBC.result.getString("phonenumber");
				
				Employee e = new Employee();
				e.setEmpID(empid);
				e.setName(name);
				e.setPassword(password);
				e.setEmail(email);
				e.setPhoneNumber(phoneNumber);
				AList.add(e);
			}
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		DBC.closeConnection();
		
		Object OBJ[] = AList.toArray();
		String data[][] = new String[AList.size()][5];
		
		for(int i=0; i<OBJ.length; i++){
			data[i][0] = ((Employee)OBJ[i]).getEmpID();
			data[i][1] = ((Employee)OBJ[i]).getName();
			data[i][2] = ((Employee)OBJ[i]).getPassword();
			data[i][3] = ((Employee)OBJ[i]).getEmail();
			data[i][4] = ((Employee)OBJ[i]).getPhoneNumber();
		}
		return data;
	}
}