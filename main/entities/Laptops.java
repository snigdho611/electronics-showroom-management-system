package entities;

public class Laptops{
	private String productID;
	private String modelName;
	private String processorModel;
	private String internalStorageSize;
	private String batteryLife;
	private String ramSize;
	private int price;
	
	public Laptops(){
		
	}
	
	public Laptops(String productID, String modelName, String processorModel, String ramSize, String internalStorageSize, String batteryLife, int price){
		this.productID = productID;
		this.modelName = modelName;
		this.processorModel = processorModel;
		this.internalStorageSize = internalStorageSize;
		this.batteryLife = batteryLife;
		this.ramSize = ramSize;
		this.price = price;
	}
	
	public void setProductID(String productID){this.productID = productID;}
	public void setModelName(String modelName){this.modelName = modelName;}
	public void setProcessorModel(String processorModel){this.processorModel = processorModel;}
	public void setInternalStorageSize(String internalStorageSize){this.internalStorageSize = internalStorageSize;}
	public void setBatteryLife(String batteryLife){this.batteryLife = batteryLife;}
	public void setRamSize(String ramSize){this.ramSize = ramSize;}
	public void setPrice(int price){this.price = price;}
	
	public String getProductID(){return this.productID;}
	public String getModelName(){return this.modelName;}
	public String getProcessorModel(){return this.processorModel;}
	public String getInternalStorageSize(){return this.internalStorageSize;}
	public String getBatteryLife(){return this.batteryLife;}
	public String getRamSize(){return this.ramSize;}
	public int getPrice(){return this.price;}	
}