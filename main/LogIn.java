import entities.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogIn implements ActionListener{
	
	private JFrame LogInFrame;
	private JButton ButtonLogIn, ButtonRegister;
	private JLabel UserIDLabel, UserPasswordLabel, ImageLabel, WelcomeLabel, NewUserLabel;
	private JTextField UserIDField;
	private JPasswordField PasswordField;
	private JOptionPane JOP;
	private JPanel P1, P2;
	
	public LogIn()
	{
		LogInFrame = new JFrame();
		LogInFrame.setTitle("Alpha Database Management");
		LogInFrame.setBounds(500,100, 350, 470);
		LogInFrame.setLayout(null);
		LogInFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		P1 = new JPanel();
		P1.setBounds(5,5,330,430);
		//P1.setBackground(Color.blue);
		P1.setLayout(null);
		P2 = new JPanel();
		P2.setBounds(180, 0, 150, 150);
		
		ImageIcon icon = new ImageIcon("3-512.png");
		ImageLabel = new JLabel(icon);
		ImageLabel.setLayout(null);
		ImageLabel.setBounds(5,5,300,400);
		
		WelcomeLabel = new JLabel("Welcome to Alpha!");
		WelcomeLabel.setBounds(0, 25, 150, 20);
		WelcomeLabel.setFont(new Font("Arial", Font.ITALIC, 15));
		
		NewUserLabel = new JLabel("New here? Click below to register!");
		NewUserLabel.setBounds(70, 332, 250, 20);
		
		ButtonLogIn = new JButton("Log In");
		ButtonLogIn.setBounds(115, 240, 100, 30);
		ButtonLogIn.addActionListener(this);
		ButtonRegister = new JButton("Register");
		ButtonRegister.setBounds(115, 360, 100, 30);
		ButtonRegister.addActionListener(this);
		
		UserIDLabel = new JLabel("User ID:");
		UserIDLabel.setBounds(66, 170, 100, 25);	
		UserPasswordLabel = new JLabel("Password:");
		UserPasswordLabel.setBounds(50, 205, 100, 25);
		
		UserIDField = new JTextField();
		UserIDField.setBounds(115, 170, 115, 25);
		
		PasswordField = new JPasswordField();
		PasswordField.setBounds(115, 205, 115, 25);
		PasswordField.setEchoChar('*');
		
		P1.add(ButtonLogIn);
		P1.add(ButtonRegister);
		P1.add(UserIDLabel);
		P1.add(UserPasswordLabel);
		P1.add(UserIDField);
		P1.add(PasswordField);
		P2.add(ImageLabel);
		P1.add(P2);
		P1.add(NewUserLabel);
		P1.add(WelcomeLabel);
		LogInFrame.add(P1);
		
		LogInFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent AE)
	{
		String command = AE.getActionCommand();
		
		if(command.equals(ButtonLogIn.getText()))
		{
			if(UserIDField.getText().isEmpty()==true||PasswordField.getText().isEmpty()==true){
				JOP = new JOptionPane();
				JOP.showMessageDialog(LogInFrame, "One of the fields is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			else if(UserIDField.getText().isEmpty()==false||PasswordField.getText().isEmpty()==false){
				System.out.println("Attempting Log In");
				EmployeeRepository ER = new EmployeeRepository();
				Employee Emp = ER.getEmployee(UserIDField.getText(), PasswordField.getText());
			
				if(Emp != null)
				{
					System.out.println("Successfully connected");
					JOP = new JOptionPane();
					JOP.showMessageDialog(LogInFrame, "Successfully logged in!\nWelcome back!");
					LogInFrame.setVisible(false);
					MainFrame MF = new MainFrame(UserIDField.getText());
				}
				else
				{
					System.out.println("Could not log in");
					JOP = new JOptionPane();
					JOP.showMessageDialog(LogInFrame, "Access Denied", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
			
		}
		else if(command.equals(ButtonRegister.getText()))
		{
			System.out.println("Registration frame launched");
			LogInFrame.setVisible(false);
			Registration R = new Registration();
		}
	}
}