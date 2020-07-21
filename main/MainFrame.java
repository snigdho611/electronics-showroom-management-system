import entities.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;
import java.util.ArrayList;

public class MainFrame implements ActionListener{
	//Main
	private JFrame MFrame;
	private JButton ButtonAllEmployee, ButtonShowProducts, ButtonAddProducts, ButtonDeleteProduct, ButtonSearchProduct, ButtonAddTransaction, ButtonSearchTransaction, ButtonShowTransactions, ButtonLogout;
	private JTextField TextFieldSearch, TextFieldDelete, TextFieldPurchase;
	private JPanel ButtonPanel, TablePanel, LogOutPanel, ImagePanel;
	private JTable ETable;
	private JLabel LabelDeleteProduct, LabelSelectProduct, LabelPurchaseOption, LabelPurchase, LabelTable, LabelBorder1, LabelBorder2, LabelBorder3, LabelBorder4, LabelImage, LabelCurrentUser, LabelModelText, LabelIDText;
	private JScrollPane ESPane;
	private JComboBox<String> ProductMenu;
	private JOptionPane JOP, JOP2;
	private EmployeeRepository ER = new EmployeeRepository();
	private ProductRepository PR = new ProductRepository();
	private TransactionRepository TR = new TransactionRepository();
	
	public MainFrame(String currentUserID){
		MFrame = new JFrame();
		MFrame.setTitle("Alpha Database Management System");
		MFrame.setBounds(100, 50, 1100, 650);
		MFrame.setLayout(null);
		MFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ButtonPanel = new JPanel();
		ButtonPanel.setBounds(5, 15, 250, 540);
		ButtonPanel.setLayout(null);
		TablePanel = new JPanel();
		TablePanel.setBounds(270, 15, 760, 440);
		TablePanel.setLayout(null);		
		LogOutPanel = new JPanel();
		LogOutPanel.setBounds(270, 460, 760, 160);
		LogOutPanel.setLayout(null);
		ImagePanel = new JPanel();
		ImagePanel.setBounds(5, 5, 200, 150);
		
		ImageIcon icon = new ImageIcon("3-512.png");
		LabelImage = new JLabel(icon);
		LabelImage.setLayout(null);
		LabelImage.setBounds(5,5,300,300);
		
		LabelCurrentUser = new JLabel("Logged in as: Employee-"+currentUserID);
		LabelCurrentUser.setBounds(580, 80, 200, 25);
		
		ETable = new JTable();
		ESPane = new JScrollPane(ETable);		
		
		LabelBorder1 = new JLabel("----------------------------------------");
		LabelBorder1.setBounds(45, 10, 180, 10);
		LabelBorder2 = new JLabel("----------------------------------------");
		LabelBorder2.setBounds(45, 250, 180, 10);
		LabelBorder3 = new JLabel("----------------------------------------");
		LabelBorder3.setBounds(45, 270, 180, 10);
		LabelBorder4 = new JLabel("----------------------------------------");
		LabelBorder4.setBounds(45, 125, 180, 10);
		
		LabelSelectProduct = new JLabel("Select a Product:");
		LabelSelectProduct.setBounds(77, 20, 100, 20);
		
		String choices[] = {"Phones", "Laptops", "Televisions"};
		ProductMenu = new JComboBox<String>(choices);
		ProductMenu.setBounds(77, 40, 100, 25);
		
		ButtonShowProducts = new JButton("Show Products");       //shows all the products depending on the value of the combo box
		ButtonShowProducts.setBounds(60, 75, 130, 25);
		ButtonShowProducts.addActionListener(this);
		ButtonAddProducts = new JButton("Add Product");          //shows all the products depending on the value of the combo box
		ButtonAddProducts.setBounds(60, 105, 130, 25);
		ButtonAddProducts.addActionListener(this);
		LabelDeleteProduct = new JLabel("Product ID");
		LabelDeleteProduct.setBounds(90, 135, 130, 20);
		TextFieldSearch = new JTextField();
		TextFieldSearch.setBounds(60, 140, 130, 20);
		LabelModelText = new JLabel("Model:");
		LabelModelText.setBounds(13, 139, 100, 20);
		ButtonSearchProduct = new JButton("Search Product");
		ButtonSearchProduct.setBounds(60, 165, 130, 25);
		ButtonSearchProduct.addActionListener(this);
		TextFieldDelete = new JTextField();
		TextFieldDelete.setBounds(60, 200, 130, 20);
		LabelIDText = new JLabel("ID:");
		LabelIDText.setBounds(36, 200, 100, 20);
		ButtonDeleteProduct = new JButton("Delete Product");     //deletes products depending on their product id
		ButtonDeleteProduct.setBounds(60, 225, 130, 25);
		ButtonDeleteProduct.addActionListener(this);
		
		LabelPurchaseOption = new JLabel("Purchase Options");
		LabelPurchaseOption.setBounds(75, 255, 130, 25);
		LabelPurchase = new JLabel("Enter a valid customer name:");
		LabelPurchase.setBounds(45, 315, 170, 25);
		TextFieldPurchase = new JTextField();
		TextFieldPurchase.setBounds(60, 340, 130, 20);
		
		ButtonAddTransaction = new JButton("Purchase Product");
		ButtonAddTransaction.setBounds(52, 285, 145, 25);
		ButtonAddTransaction.addActionListener(this);
		ButtonSearchTransaction = new JButton("Search Customer");
		ButtonSearchTransaction.setBounds(45, 365, 160, 25);
		ButtonSearchTransaction.addActionListener(this);
		ButtonShowTransactions = new JButton("All Transactions");
		ButtonShowTransactions.setBounds(45, 400, 160, 25);
		ButtonShowTransactions.addActionListener(this);
		
		ButtonAllEmployee = new JButton("Show Employee");        //shows all employees
		ButtonAllEmployee.setBounds(60, 483, 130, 25);
		ButtonAllEmployee.addActionListener(this);
		
		LabelTable = new JLabel("Table View");
		LabelTable.setBounds(330, 2, 130, 25);
		LabelTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		
		ButtonLogout = new JButton("Log Out");
		ButtonLogout.setBounds(610, 40, 130, 25);
		ButtonLogout.addActionListener(this);
		
		ButtonPanel.add(LabelBorder1);
		ButtonPanel.add(LabelBorder2);
		ButtonPanel.add(LabelBorder3);
		ButtonPanel.add(LabelBorder4);
		ButtonPanel.add(ProductMenu);
		ButtonPanel.add(ButtonShowProducts);
		ButtonPanel.add(ButtonAddProducts);
		ButtonPanel.add(TextFieldSearch);
		ButtonPanel.add(ButtonSearchProduct);
		ButtonPanel.add(LabelModelText);
		ButtonPanel.add(TextFieldDelete);
		ButtonPanel.add(LabelIDText);
		ButtonPanel.add(ButtonDeleteProduct);
		ButtonPanel.add(LabelDeleteProduct);
		ButtonPanel.add(LabelSelectProduct);
		ButtonPanel.add(LabelPurchaseOption);
		ButtonPanel.add(LabelPurchase);
		ButtonPanel.add(TextFieldPurchase);
		ButtonPanel.add(ButtonAddTransaction);
		ButtonPanel.add(ButtonShowTransactions);
		ButtonPanel.add(ButtonSearchTransaction);
		ButtonPanel.add(ButtonAllEmployee);
		TablePanel.add(ESPane);
		LogOutPanel.add(ButtonLogout);
		LogOutPanel.add(LabelTable);
		LogOutPanel.add(ImagePanel);
		LogOutPanel.add(LabelCurrentUser);
		ImagePanel.add(LabelImage);
		//LogOutPanel.setBackground(Color.yellow);
		//ButtonPanel.setBackground(Color.blue);
		TablePanel.setBackground(Color.gray);
		MFrame.add(ButtonPanel);
		MFrame.add(TablePanel);
		MFrame.add(LogOutPanel);
		MFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent AE){
		String command = AE.getActionCommand();
		String comboChoice = ProductMenu.getSelectedItem().toString();
		//Show all employee button verification and operations
		if(command.equals(ButtonAllEmployee.getText()))
		{
			JPanel panel = new JPanel();
			JLabel label = new JLabel("Only admins are allowed for this operation. Please re-enter your password: ");
			JPasswordField pass = new JPasswordField(10);
			panel.add(label);
			panel.add(pass);
			String options[] = new String[]{"Submit", "Cancel"};
			int option = JOptionPane.showOptionDialog(MFrame, panel, "Verification", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
			String password = pass.getText();
			Employee Emp = ER.getEmployee(password);
			try{
				if(Emp.getAdmin().equals("yes")){
					System.out.println("Welcome to the System, Admin");
				    JOP2 = new JOptionPane();
				    JOP2.showMessageDialog(MFrame, "Welcome to the system, admin");
				    String data[][]= ER.getAllEmployee();
				    String head[] = {"Employee ID", "Name", "Password", "Email", "Phone Number"};
				    TablePanel.removeAll();
				    TablePanel.revalidate();
				    TablePanel.repaint();
				    ETable = new JTable(data, head);
				    ESPane = new JScrollPane(ETable);
				    ESPane.setBounds(5, 25, 750, 400);
				    TablePanel.add(ESPane);
				    TablePanel.setVisible(true);
					}
		
			     else{
					JOP2 = new JOptionPane();
					JOP2.showMessageDialog(MFrame, "Access denied", "Denied", JOptionPane.WARNING_MESSAGE);
			}
			}
			catch(NullPointerException NP){
				    JOP2 = new JOptionPane();
					JOP2.showMessageDialog(MFrame, "User not found!", "Denied", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		//Show tables of products
		else if(command.equals(ButtonShowProducts.getText())&&comboChoice.equals("Phones")){                      //If Phones is selected, and the Show Products button is pressed
			String data[][] = PR.getAllPhones();
			String head[] = {"Product ID", "Model", "Processor", "Ram Size", "Storage Size", "Camera", "Price"};
			TablePanel.removeAll();
			TablePanel.revalidate();
			TablePanel.repaint();
			ETable = new JTable(data, head);
			ESPane = new JScrollPane(ETable);
			ESPane.setBounds(5, 25, 750, 400);
			TablePanel.add(ESPane);
			TablePanel.setVisible(true);
		}
		
		else if(command.equals(ButtonShowProducts.getText())&&comboChoice.equals("Laptops")){                      //If Laptops is selected, and the Show Products button is pressed
			String data[][] = PR.getAllLaptops();
			String head[] = {"Product ID", "Model", "Processor", "Ram Size", "Storage Size", "Battery", "Price"};
			TablePanel.removeAll();
			TablePanel.revalidate();
			TablePanel.repaint();
			ETable = new JTable(data, head);
			ESPane = new JScrollPane(ETable);
			ESPane.setBounds(5, 25, 750, 400);
			TablePanel.add(ESPane);
			TablePanel.setVisible(true);
		}
		
		else if(command.equals(ButtonShowProducts.getText())&&comboChoice.equals("Televisions")){                  //If Televisions is selected, and the Show Products button is pressed
			String data[][] = PR.getAllTelevisions();
			String head[] = {"Product ID", "Model", "Screen Size", "Screen Type", "Sound Type", "Connectivity", "Price"};
			TablePanel.removeAll();
			TablePanel.revalidate();
			TablePanel.repaint();
			ETable = new JTable(data, head);
			ESPane = new JScrollPane(ETable);
			ESPane.setBounds(5, 25, 750, 400);
			TablePanel.add(ESPane);
			TablePanel.setVisible(true);
		}
		
		//Add an individual product selected
		else if(command.equals(ButtonAddProducts.getText())){
			if(comboChoice.equals("Phones")){
				addPhoneFrame APF = new addPhoneFrame();
				System.out.println("Selected Phones");
			}
			else if(comboChoice.equals("Laptops")){
				addLaptopFrame ALF = new addLaptopFrame();
				System.out.println("Selected Laptops");
			}
			else if(comboChoice.equals("Televisions")){
				addTelevisionFrame ATF = new addTelevisionFrame();
				System.out.println("Selected Televisions");
			}
		}
		
		//Search Products
		else if(command.equals(ButtonSearchProduct.getText())&&TextFieldSearch.getText().isEmpty()==true){
			JOP2 = new JOptionPane();
			JOP2.showMessageDialog(MFrame, "Please enter the product ID to search for it!", "Cannot Delete!", JOptionPane.WARNING_MESSAGE);
		}
		
		else if(command.equals(ButtonSearchProduct.getText())&&comboChoice.equals("Phones")&&TextFieldSearch.getText().isEmpty()==false){
			String data[][] = PR.searchPhones(TextFieldSearch.getText());
			String head[] = {"Product ID", "Model", "Processor", "Ram Size", "Storage Size", "Camera", "Price"};
			TablePanel.removeAll();
			TablePanel.revalidate();
			TablePanel.repaint();
			ETable = new JTable(data, head);
			ESPane = new JScrollPane(ETable);
			ESPane.setBounds(5, 25, 750, 400);
			TablePanel.add(ESPane);
			TablePanel.setVisible(true);
			if(data[0][0] == null){
				JOP2 = new JOptionPane();
				JOP2.showMessageDialog(MFrame, "No entries found under this name!", "Error 404", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				JOP2 = new JOptionPane();
				JOP2.showMessageDialog(MFrame, "Found searched results!");
			}
		}
		
		else if(command.equals(ButtonSearchProduct.getText())&&comboChoice.equals("Laptops")&&TextFieldSearch.getText().isEmpty()==false){
			String data[][] = PR.searchLaptops(TextFieldSearch.getText());
			String head[] = {"Product ID", "Model", "Processor", "Ram Size", "Storage Size", "Battery", "Price"};
			TablePanel.removeAll();
			TablePanel.revalidate();
			TablePanel.repaint();
			ETable = new JTable(data, head);
			ESPane = new JScrollPane(ETable);
			ESPane.setBounds(5, 25, 750, 400);
			TablePanel.add(ESPane);
			TablePanel.setVisible(true);
			if(data[0][0] == null){
				JOP2 = new JOptionPane();
				JOP2.showMessageDialog(MFrame, "No entries found under this name!", "Error 404", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				JOP2 = new JOptionPane();
				JOP2.showMessageDialog(MFrame, "Found searched results!");
			}
		}
		
		else if(command.equals(ButtonSearchProduct.getText())&&comboChoice.equals("Televisions")&&TextFieldSearch.getText().isEmpty()==false){
			String data[][] = PR.searchTelevisions(TextFieldSearch.getText());
			String head[] = {"Product ID", "Model", "Screen Size", "Screen Type", "Sound Type", "Connectivity", "Price"};
			TablePanel.removeAll();
			TablePanel.revalidate();
			TablePanel.repaint();
			ETable = new JTable(data, head);
			ESPane = new JScrollPane(ETable);
			ESPane.setBounds(5, 25, 750, 400);
			TablePanel.add(ESPane);
			TablePanel.setVisible(true);
			if(data[0][0] == null){
				JOP2 = new JOptionPane();
				JOP2.showMessageDialog(MFrame, "No entries found under this name!", "Error 404", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				JOP2 = new JOptionPane();
				JOP2.showMessageDialog(MFrame, "Found searched results!");
			}
		}
		
		//Delete Products
		else if(command.equals(ButtonDeleteProduct.getText())&&TextFieldDelete.getText().isEmpty()==true){
			JOP2 = new JOptionPane();
			JOP2.showMessageDialog(MFrame, "Please enter the product ID to delete it", "Cannot Delete!", JOptionPane.WARNING_MESSAGE);
		}
		
		else if(command.equals(ButtonDeleteProduct.getText())&&comboChoice.equals("Phones")&&TextFieldDelete.getText().isEmpty()==false){
			JPanel panel = new JPanel();
			JLabel label = new JLabel("Only admins are allowed for this operation. Please re-enter your password: ");
			JPasswordField pass = new JPasswordField(10);
			panel.add(label);
			panel.add(pass);
			String options[] = new String[]{"Submit", "Cancel"};
			int option = JOptionPane.showOptionDialog(MFrame, panel, "Verification", JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
			String password = pass.getText();
			Employee Emp = ER.getEmployee(password);
			try{
				if(Emp.getAdmin().equals("yes")){
					System.out.println("Welcome to the System, Admin");
				    JOP2 = new JOptionPane();
				    JOP2.showMessageDialog(MFrame, "Welcome to the system, admin");
				    String productID = TextFieldDelete.getText();
					System.out.println("Attempting to delete a phone");
					PR.deletePhones(productID);
					JOP = new JOptionPane();
					JOP.showMessageDialog(MFrame, "Deleted a phone from the Database!");
				}
		
			     else{
					JOP2 = new JOptionPane();
					JOP2.showMessageDialog(MFrame, "Access denied", "Denied", JOptionPane.WARNING_MESSAGE);
				}
			}
			catch(NullPointerException NP){
				    JOP2 = new JOptionPane();
					JOP2.showMessageDialog(MFrame, "User not found!", "Denied", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		else if(command.equals(ButtonDeleteProduct.getText())&&comboChoice.equals("Laptops")&&TextFieldDelete.getText().isEmpty()==false){
			String productID = TextFieldDelete.getText();
			System.out.println("Attempting to delete a laptop");
			PR.deleteLaptops(productID);
			JOP = new JOptionPane();
			JOP.showMessageDialog(MFrame, "Deleted a laptop from the Database!");
		}
		
		else if(command.equals(ButtonDeleteProduct.getText())&&comboChoice.equals("Televisions")&&TextFieldDelete.getText().isEmpty()==false){
			String productID = TextFieldDelete.getText();
			System.out.println("Attempting to delete a television");
			PR.deleteTelevisions(productID);
			JOP = new JOptionPane();
			JOP.showMessageDialog(MFrame, "Deleted a television from the Database!");
		}
		
		//Add Transactions
		else if(command.equals(ButtonAddTransaction.getText())){
			addTransactionFrame ATF = new addTransactionFrame();
		}
		
		//Show All Transactions
		else if(command.equals(ButtonShowTransactions.getText())){
			String data[][] = TR.getAllTransactions();
			String head[] = {"Transaction ID", "Customer Name", "Phone Number", "Email", "Product ID", "Product", "Date", "Price"};
			TablePanel.removeAll();
			TablePanel.revalidate();
			TablePanel.repaint();
			ETable = new JTable(data, head);
			ESPane = new JScrollPane(ETable);
			ESPane.setBounds(5, 25, 750, 400);
			TablePanel.add(ESPane);
			TablePanel.setVisible(true);
		}
		
		//Search for specific Transaction
		else if(command.equals(ButtonSearchTransaction.getText())&&TextFieldPurchase.getText().isEmpty()==true){
			JOP2 = new JOptionPane();
			JOP2.showMessageDialog(MFrame, "Please enter a valid customer's name to search with!", "Cannot Search!", JOptionPane.WARNING_MESSAGE);
		}
		
		else if(command.equals(ButtonSearchTransaction.getText())&&TextFieldPurchase.getText().isEmpty()==false){
			String data[][] = TR.searchTransactions(TextFieldPurchase.getText());
			String head[] = {"Transaction ID", "Customer Name", "Phone Number", "Email", "Product ID", "Product", "Date", "Price"};
			TablePanel.removeAll();
			TablePanel.revalidate();
			TablePanel.repaint();
			ETable = new JTable(data, head);
			ESPane = new JScrollPane(ETable);
			ESPane.setBounds(5, 25, 750, 400);
			TablePanel.add(ESPane);
			TablePanel.setVisible(true);
		}
		
		//Logout
		else if(command.equals(ButtonLogout.getText())){
			MFrame.dispose();
			LogIn L = new LogIn();
		}
	}
}