import java.lang.*;
import entities.*;

public interface ITransactionRepository{
	public void insertTransactionsPhone(Transactions T);
	public void insertTransactionsLaptop(Transactions T);
	public void insertTransactionsTelevision(Transactions T);
	public String[][] getAllTransactions();
	public String[][] searchTransactions(String customerName);
}