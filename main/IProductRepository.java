import java.lang.*;
import entities.*;

public interface IProductRepository{
	
	public void insertPhones(Phones P);
	public void insertLaptops(Laptops L);
	public void insertTelevisions(Televisions T);
	public void deletePhones(String productID);
	public void deleteLaptops(String productID);
	public void deleteTelevisions(String productID);
	public String[][] getAllPhones();
	public String[][] getAllLaptops();
	public String[][] getAllTelevisions();
	public String[][] searchPhones(String phoneName);
	public String[][] searchLaptops(String laptopName);
	public String[][] searchTelevisions(String televisionName);
}