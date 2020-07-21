package entities;

public class Televisions{
	private String productID;
	private String modelName;
	private String screenSize;
	private String screenType;
	private String soundType;
	private String connectivity;
	private int price;
	
	public Televisions(){
		
	}
	
	public Televisions(String productID, String modelName, String screenSize, String screenType, String soundType, String connectivity, int price){
		this.productID = productID;
		this.modelName = modelName;
		this.screenSize = screenSize;
		this.screenType = screenType;
		this.soundType = soundType;
		this.connectivity = connectivity;
		this.price = price;
	}
	
	public void setProductID(String productID){this.productID = productID;}
	public void setModelName(String modelName){this.modelName = modelName;}
	public void setScreenSize(String screenSize){this.screenSize = screenSize;}
	public void setScreenType(String screenType){this.screenType = screenType;}
	public void setSoundType(String soundType){this.soundType = soundType;}
	public void setConnectivity(String connectivity){this.connectivity = connectivity;}
	public void setPrice(int price){this.price = price;}
	
	public String getProductID(){return this.productID;}
	public String getModelName(){return this.modelName;}
	public String getScreenSize(){return this.screenSize;}
	public String getScreenType(){return this.screenType;}
	public String getSoundType(){return this.soundType;}
	public String getConnectivity(){return this.connectivity;}
	public int getPrice(){return this.price;}
}