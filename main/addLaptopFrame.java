import entities.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.*;

public class addLaptopFrame implements ActionListener{
	private JFrame addFrame;
	private JButton ButtonConfirm,ButtonCancel;
	private JPanel ExtraPanel;
	private JLabel L1, L2, L3, L4, L5, L6, L7;
	private JTextField T1, T2, T3, T4, T5, T6, T7;
	private ProductRepository PR = new ProductRepository();
	private JOptionPane JOP;
	
	public addLaptopFrame(){
		addFrame = new JFrame();
		addFrame.setTitle("Add Laptop");
		addFrame.setBounds(400, 50, 500, 550);
		addFrame.setVisible(true);
		
		ExtraPanel = new JPanel();
		ExtraPanel.setBounds(5, 5, 390, 540);
		ExtraPanel.setLayout(null);
		
		L1 = new JLabel("Product ID: ");
		L1.setBounds(100, 70, 140, 20);
		L2 = new JLabel("Model Name: ");
		L2.setBounds(100, 100, 140, 20);
		L3 = new JLabel("Processor Model: ");
		L3.setBounds(100, 130, 140, 20);
		L4 = new JLabel("Ram Size: ");
		L4.setBounds(100, 160, 140, 20);
		L5 = new JLabel("Storage Size: ");
		L5.setBounds(100, 190, 140, 20);
		L6 = new JLabel("Battery: ");
		L6.setBounds(100, 220, 140, 20);
		L7 = new JLabel("Price: ");
		L7.setBounds(100, 250, 140, 20);
		
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
		T6 = new JTextField();
		T6.setBounds(220, 220, 140, 20);
		T7 = new JTextField();
		T7.setBounds(220, 250, 140, 20);
		
		ButtonConfirm = new JButton("Add Laptop");
		ButtonConfirm.setBounds(100, 400, 120, 30);
		ButtonConfirm.addActionListener(this);
		ButtonCancel = new JButton("Go Back");
		ButtonCancel.setBounds(250, 400, 120, 30);
		ButtonCancel.addActionListener(this);
		
		ExtraPanel.add(ButtonConfirm);
		ExtraPanel.add(ButtonCancel);
		ExtraPanel.add(L1);ExtraPanel.add(L2);ExtraPanel.add(L3);ExtraPanel.add(L4);ExtraPanel.add(L5);ExtraPanel.add(L6);ExtraPanel.add(L7);
		ExtraPanel.add(T1);ExtraPanel.add(T2);ExtraPanel.add(T3);ExtraPanel.add(T4);ExtraPanel.add(T5);ExtraPanel.add(T6);ExtraPanel.add(T7);
		addFrame.add(ExtraPanel);
		addFrame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent AE){
		String command = AE.getActionCommand();
		if(command.equals(ButtonConfirm.getText())){
			System.out.println("Attempting to add new laptop");
			if(T1.getText().isEmpty()==true||T2.getText().isEmpty()==true||T3.getText().isEmpty()==true||T4.getText().isEmpty()==true||T5.getText().isEmpty()==true||T6.getText().isEmpty()==true||T7.getText().isEmpty()==true){
				JOP = new JOptionPane();
				JOP.showMessageDialog(addFrame, "One of the fields is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
			}
			else{
				Laptops L = new Laptops(T1.getText(), T2.getText(), T3.getText(), T4.getText(), T5.getText(), T6.getText(), Integer.parseInt(T7.getText()));
			    PR.insertLaptops(L);
				JOP = new JOptionPane();
				JOP.showMessageDialog(addFrame, "Successfully added "+T2.getText()+" to Laptop Database!");
			}
		}
		else if(command.equals(ButtonCancel.getText())){
			addFrame.dispose();
			System.out.println("Closed adding laptop frame");
		}
	}
}