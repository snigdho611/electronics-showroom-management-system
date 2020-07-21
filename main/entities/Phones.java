package entities;

public class Phones{
	private String productID;
	private String modelName;
	private String processorModel;
	private String ramSize;                //GB = Gigabytes
	private String internalStorageSize;    //GB = Gigabytes
	private String cameraQuality;          //MP = Megapixels
	private int price;
	
	public Phones(){
		
	}
	
	public Phones(String productID, String modelName, String processorModel, String ramSize, String internalStorageSize, String cameraQuality, int price){
		this.productID = productID;
		this.modelName = modelName;
		this.processorModel = processorModel;
		this.ramSize = ramSize;
		this.internalStorageSize = internalStorageSize;
		this.cameraQuality = cameraQuality;
		this.price = price;
	}
	
	public void setProductID(String productID){this.productID = productID;}
	public void setModelName(String modelName){this.modelName = modelName;}
	public void setProcessorModel(String processorModel){this.processorModel = processorModel;}
	public void setRamSize(String ramSize){this.ramSize = ramSize;}
	public void setInternalStorageSize(String internalStorageSize){this.internalStorageSize = internalStorageSize;}
	public void setCameraQuality(String cameraQuality){this.cameraQuality = cameraQuality;}
	public void setPrice(int price){this.price = price;}
	
	public String getProductID(){return this.productID;}
	public String getModelName(){return this.modelName;}
	public String getProcessorModel(){return this.processorModel;}
	public String getRamSize(){return this.ramSize;}
	public String getInternalStorageSize(){return this.internalStorageSize;}
	public String getCameraQuality(){return this.cameraQuality;}
	public int getPrice(){return this.price;}
}