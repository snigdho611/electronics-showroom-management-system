package entities;

public class Employee{
	private String empid;
	private String name;
	private String password;
	private String email;
	private String phoneNumber;
	private String admin;
	
	public Employee()
	{
		
	}
	
	public Employee(String empid, String name, String password, String email, String phoneNumber, String admin){
		this.empid = empid;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.admin = admin;
	}
	
	public void setEmpID(String empid){
		this.empid = empid;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}
	
	public void setAdmin(String admin){
		this.admin = admin;
	}
	
	public String getEmpID(){
		return this.empid;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPassword(){
		return this.password;
	}
	
	public String getEmail(){
		return this.email;
	}
	
	public String getPhoneNumber(){
		return this.phoneNumber;
	}
	
	public String getAdmin(){
		return this.admin;
	}
}