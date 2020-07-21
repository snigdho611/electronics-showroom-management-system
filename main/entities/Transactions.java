package entities; 

public class Transactions{
	private String tranID;
	private String cusName;
	private String cusPhone;
	private String cusEmail;
	private String productID;
	private String modelName;
	private String date;
	private int price;
	
	public Transactions(){
		
	}
	
	public Transactions(String cusName, String cusPhone, String cusEmail, String productID, String date){
		this.cusName = cusName;
		this.cusPhone = cusPhone;
		this.cusEmail = cusEmail;
		this.productID = productID;
		this.date = date;
	}
	
	public void setTranID(String tranID){this.tranID = tranID;}
	public void setCusName(String cusName){this.cusName = cusName;}
	public void setCusPhone(String cusPhone){this.cusPhone = cusPhone;}
	public void setCusEmail(String cusEmail){this.cusEmail = cusEmail;}
	public void setProductID(String productID){this.productID = productID;}
	public void setModelName(String modelName){this.modelName = modelName;}
	public void setDate(String date){this.date = date;}
	public void setPrice(int price){this.price = price;}
	
	public String getTranID(){return this.tranID;}
	public String getCusName(){return this.cusName;}
	public String getCusPhone(){return this.cusPhone;}
	public String getCusEmail(){return this.cusEmail;}
	public String getProductID(){return this.productID;}
	public String getModelName(){return this.modelName;}
	public String getDate(){return this.date;}
	public int getPrice(){return this.price;}
}