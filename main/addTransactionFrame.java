import entities.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

public class addTransactionFrame implements ActionListener{
	private JFrame addFrame;
	private JButton ButtonConfirm,ButtonCancel;
	private JPanel ExtraPanel;
	private JLabel L1, L2, L3, L4, L5;
	private JTextField T1, T2, T3, T4, T5;
	private TransactionRepository TR = new TransactionRepository();
	private JOptionPane JOP;
	
	public addTransactionFrame(){
		addFrame = new JFrame();
		addFrame.setTitle("Add Transaction");
		addFrame.setBounds(400, 50, 500, 450);
		addFrame.setVisible(true);
		
		ExtraPanel = new JPanel();
		ExtraPanel.setBounds(5, 5, 390, 440);
		ExtraPanel.setLayout(null);
		
		L1 = new JLabel("Customer Name: ");
		L1.setBounds(100, 70, 140, 20);
		L2 = new JLabel("Phone: ");
		L2.setBounds(100, 100, 140, 20);
		L3 = new JLabel("Email: ");
		L3.setBounds(100, 130, 140, 20);
		L4 = new JLabel("Product ID: ");
		L4.setBounds(100, 160, 140, 20);
		L5 = new JLabel("Date (YYYY-MM-DD): ");
		L5.setBounds(100, 190, 140, 20);
		
		T1 = new JTextField();
		T1.setBounds(220, 70, 140, 20);
		T2 = new JTextField();
		T2.setBounds(220, 100, 140, 20);
		T3 = new JTextField();
		T3.setBounds(220, 130, 140, 20);
		T4 = new JTextField();
		T4.setBounds(220, 160, 140, 20);
		T5 = new JTextField();
		T5.setBounds(220, 190, 140, 20);
		
		ButtonConfirm = new JButton("Buy");
		ButtonConfirm.setBounds(100, 300, 120, 30);
		ButtonConfirm.addActionListener(this);
		ButtonCancel = new JButton("Go Back");
		ButtonCancel.setBounds(250, 300, 120, 30);
		ButtonCancel.addActionListener(this);
		
		ExtraPanel.add(ButtonConfirm);
		ExtraPanel.add(ButtonCancel);
		ExtraPanel.add(L1);ExtraPanel.add(L2);ExtraPanel.add(L3);ExtraPanel.add(L4);ExtraPanel.add(L5);
		ExtraPanel.add(T1);ExtraPanel.add(T2);ExtraPanel.add(T3);ExtraPanel.add(T4);ExtraPanel.add(T5);
		addFrame.add(ExtraPanel);
		addFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent AE){
		String command = AE.getActionCommand();
		String productid = T4.getText();
		if(command.equals(ButtonConfirm.getText())){
			//System.out.println("Attempting to add new phone");
			if(T1.getText().isEmpty()==true||T2.getText().isEmpty()==true||T3.getText().isEmpty()==true||T4.getText().isEmpty()==true||T5.getText().isEmpty()==true){
				JOP = new JOptionPane();
				JOP.showMessageDialog(addFrame, "One of the fields is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			else{
				if(productid.charAt(0) == 'P'){
					Transactions T = new Transactions(T1.getText(), T2.getText(), T3.getText(), T4.getText(), T5.getText());
					TR.insertTransactionsPhone(T);
					JOP = new JOptionPane();
					JOP.showMessageDialog(addFrame, "Successfully purchased new phone, added to Database!");
				}
				else if(productid.charAt(0) == 'L'){
					Transactions T = new Transactions(T1.getText(), T2.getText(), T3.getText(), T4.getText(), T5.getText());
					TR.insertTransactionsLaptop(T);
					JOP = new JOptionPane();
					JOP.showMessageDialog(addFrame, "Successfully purchased new laptop, added to Database!");
				}
				else if(productid.charAt(0) == 'T'){
					Transactions T = new Transactions(T1.getText(), T2.getText(), T3.getText(), T4.getText(), T5.getText());
					TR.insertTransactionsTelevision(T);
					JOP = new JOptionPane();
					JOP.showMessageDialog(addFrame, "Successfully purchased new television, added to Database!");
				}
			}
		}
		
		else if(command.equals(ButtonCancel.getText())){
			addFrame.dispose();
			System.out.println("Closed adding transaction frame");
		}
	}
}