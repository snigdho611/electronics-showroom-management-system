package entities; 

public class Customer{
	private String cusID;
	private String cusName;
	private String cusPhone;
	private String cusEmail;
	private String cusAddress;
	private int cusTotal;
	
	public Customer(){
		
	}
	
	public Customer(String cusID, String cusName, String cusPhone, String cusEmail, String cusAddress, int cusTotal){
		this.cusID = cusID;
		this.cusName = cusName;
		this.cusPhone = cusPhone;
		this.cusEmail = cusEmail;
		this.cusAddress = cusAddress;
		this.cusTotal= cusTotal;
	}
	
	public void setCusID(String cusid){this.cusID = cusID;}
	public void setCusName(String cusName){this.cusName = cusName;}
	public void setCusPhone(String cusPhone){this.cusPhone = cusPhone;}
	public void setCusEmail(String cusEmail){this.cusEmail = cusEmail;}
	public void setCusAddress(String cusAddress){this.cusAddress = cusAddress;}
	public void setCusTotal(int cusTotal){this.cusTotal = cusTotal;}
	
	public String getCusID(){return this.cusID;}
	public String getCusName(){return this.cusName;}
	public String getCusPhone(){return this.cusPhone;}
	public String getCusEmail(){return this.cusEmail;}
	public String cusAddress(){return this.cusAddress;}
	public int cusTotal(){return this.cusTotal;}
}