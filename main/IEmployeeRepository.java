import java.lang.*;
import entities.*;

public interface IEmployeeRepository{
	public Employee getEmployee(String empid, String password);     //verify user
	public Employee getEmployee(String password);                   //verify admin
	public void insertEmployee(Employee e);
	public String[][] getAllEmployee();
}