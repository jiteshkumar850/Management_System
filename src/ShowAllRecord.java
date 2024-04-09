import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.sql.*;
import java.awt.*;
public class ShowAllRecord 
{
	JFrame frame=new JFrame("Show All record");
	JLabel[] label=new JLabel[4];
	JTable table=new JTable();
	public ShowAllRecord() 
	{
		frame.setSize(520,700);
		frame.setLocation(400,0);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setLayout(null);
		addLabel();
	}
	private void addLabel() 
	{
		for(int i=0;i<4;i++) 
		{
			label[i]=new JLabel();
			label[i].setFont(new Font("arial",Font.BOLD,14));
			frame.add(label[i]);
		}
		label[0].setText("Employee id");
		label[0].setBounds(20,10,120,30);
		label[1].setText("Employee name");
		label[1].setBounds(120,10,120,30);
		label[2].setText("Employee Dept..");
		label[2].setBounds(250,10,120,30);
		label[3].setText("Employee Salary");
		label[3].setBounds(370,10,120,30);
		addTable();
	}
	private void addTable() 
	{
		
		table.setBounds(30,50,450,600);
		table.setAutoscrolls(true);
		frame.add(table);
		
		addBase();
	}
	 private void addBase()
	 {
		 String[] column= {"id","name","dep","sala"};
	 
		DefaultTableModel model=new DefaultTableModel();
		model.setColumnIdentifiers(column);
		table.setModel(model);
		
		 
		 try 
		 {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","jitesh");
			 Statement st=cn.createStatement();
			 ResultSet rs=st.executeQuery("Select * from Employeeinfo");

			 while(rs.next()) 
			 {
				 
				 String a=rs.getString(1);
				 String b=rs.getString(2);
				 String c=rs.getString(3);
				 String d=rs.getString(4);
				 model.addRow(new Object[] {a,b,c,d});
					
				 
			 }
		 }
		 catch(Exception ex)
		 {
			 System.out.println(ex);
		 }
	 }
	
}
