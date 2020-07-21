import entities.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration implements ActionListener{
	
	JFrame RegFrame;
	JButton ButtonRegister, ButtonGoBack;
	JLabel NameLabel, EmployeeIDLabel, UserPasswordLabel, ConfirmUserPasswordLabel, EmailLabel, PhoneNumberLabel;
	JTextField NameField, EmployeeIDField, EmailField, PhoneNumberField;
	JPasswordField UserPasswordField, ConfirmUserPasswordField;
	JOptionPane JOP;
	JPanel P1;
	
	public Registration()
	{
		RegFrame = new JFrame();
		RegFrame.setTitle("Registration");
		RegFrame.setBounds(300, 100, 600, 500);
		RegFrame.setLayout(null);
		RegFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		P1 = new JPanel();
		P1.setBounds(5, 5, 590, 490);
		P1.setLayout(null);
		
		NameLabel = new JLabel("Name: ");
		NameLabel.setBounds(120, 60, 70, 20);
		EmployeeIDLabel = new JLabel("User ID: ");
		EmployeeIDLabel.setBounds(120, 100, 70, 20);
		EmailLabel = new JLabel("E-mail");
		EmailLabel.setBounds(120, 140, 70, 20);
		PhoneNumberLabel = new JLabel("Phone Number:");
		PhoneNumberLabel.setBounds(120, 180, 120, 20);
		UserPasswordLabel = new JLabel("Password: ");
		UserPasswordLabel.setBounds(120, 220, 70, 20);
		ConfirmUserPasswordLabel = new JLabel("Confirm Password: ");
		ConfirmUserPasswordLabel.setBounds(120, 260, 120, 20);
		
		
		NameField = new JTextField();
		NameField.setBounds(250, 60, 150, 20);
		EmployeeIDField = new JTextField();
		EmployeeIDField.setBounds(250, 100, 150, 20);
		EmailField = new JTextField();
		EmailField.setBounds(250, 140, 150, 20);
		PhoneNumberField = new JTextField();
		PhoneNumberField.setBounds(250, 180, 150, 20);
		UserPasswordField = new JPasswordField();
		UserPasswordField.setBounds(250, 220, 150, 20);
		UserPasswordField.setEchoChar('*');
		ConfirmUserPasswordField = new JPasswordField();
		ConfirmUserPasswordField.setBounds(250, 260, 150, 20);
		ConfirmUserPasswordField.setEchoChar('*');
		
		ButtonRegister = new JButton("Confirm");
		ButtonRegister.setBounds(150, 330, 100, 30);
		ButtonRegister.addActionListener(this);
		ButtonGoBack = new JButton("Go Back");
		ButtonGoBack.setBounds(290, 330, 100, 30);
		ButtonGoBack.addActionListener(this);
		
		P1.add(NameLabel);
		P1.add(EmployeeIDLabel);
		P1.add(EmailLabel);
		P1.add(PhoneNumberLabel);
		P1.add(UserPasswordLabel);
		P1.add(ConfirmUserPasswordLabel);
		P1.add(NameField);
		P1.add(EmployeeIDField);
		P1.add(EmailField);
		P1.add(PhoneNumberField);
		P1.add(UserPasswordField);
		P1.add(ConfirmUserPasswordField);
		P1.add(ButtonRegister);
		P1.add(ButtonGoBack);
		RegFrame.add(P1);
		//P1.setBackground(Color.blue);
		RegFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent AE)
	{
		String command = AE.getActionCommand();
		
		if(command.equals(ButtonRegister.getText()))
		{
			if(NameField.getText().isEmpty()==true||EmployeeIDField.getText().isEmpty()==true||EmailField.getText().isEmpty()==true||PhoneNumberField.getText().isEmpty()==true||UserPasswordField.getText().isEmpty()==true||ConfirmUserPasswordField.getText().isEmpty()==true){
				JOP = new JOptionPane();
				JOP.showMessageDialog(RegFrame, "One of the fields is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			else{
				System.out.println("Trying to register new employee");
				Employee e=new Employee();
				EmployeeRepository ER=new EmployeeRepository();
				e.setEmpID(EmployeeIDField.getText());
				e.setName(NameField.getText());
				e.setPassword(ConfirmUserPasswordField.getText());
				e.setEmail(EmailField.getText());
				e.setPhoneNumber(PhoneNumberField.getText());
				ER.insertEmployee(e);
				JOP = new JOptionPane();
				JOP.showMessageDialog(RegFrame, "Welcome to the system, "+e.getName());
			}	
		}
		else if(command.equals(ButtonGoBack.getText()))
		{
			System.out.println("Log In window launched");
			RegFrame.setVisible(false);
			LogIn L = new LogIn();
		}
	}
	
	public static void main(String args[]){
		Registration R = new Registration();
	}
}