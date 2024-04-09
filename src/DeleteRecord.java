import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JTextField;
import javax.swing.JButton;

public class DeleteRecord 
{
	JFrame frame=new JFrame("Delete record");
	JLabel label=new JLabel("Enter Id:");
	Font font=new Font("times new roman",Font.BOLD,25);
	Font font1=new Font("arial",Font.BOLD,15);
	JTextField textbox=new JTextField();
	JButton button=new JButton("Delete");
	
	public DeleteRecord() 
	{
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		addLabel();
		frame.setVisible(true);
	}
	private void addLabel() 
	{
		label.setBounds(50,50,100,50);
		label.setFont(font);
		frame.add(label);
		addBox();
	}
	private void addBox() 
	{
		textbox.setBounds(160,60,180,30);
		textbox.setFont(font1);
		frame.add(textbox);
		addButton();
	}
	private void addButton() 
	{
		button.setBounds(150,120,100,30);
		button.setFont(new Font("times new roman",Font.BOLD,15));
		button.addActionListener(new DeleteListener());
		frame.add(button);
	}
	class DeleteListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) 
		{
			try
			{
				String s=textbox.getText();		
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","jitesh");
				Statement st=cn.createStatement();
				int d=st.executeUpdate("delete  from Employeeinfo where id="+s+"");
				if(d==0) 
				{
					JOptionPane.showMessageDialog(frame,"Id not exist");
					
				}else {
				JOptionPane.showMessageDialog(frame,"Delete sucessfully");
				textbox.setText(null);}
			}
			catch(Exception ex)
			{
				System.out.println(ex);
				JOptionPane.showMessageDialog(frame,"nanananan sucessfully");

			}
		}
	}
}
