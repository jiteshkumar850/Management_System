import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class InsertRecord 
{
	JFrame frame=new JFrame("Insert Records");
	JLabel[] label=new JLabel[4];
	Font font=new Font("times new roman",Font.BOLD,25);
	Font font1=new Font("arial",Font.BOLD,15);
	JTextField[] textbox=new JTextField[4];
	JButton button1=new JButton("Submit");
	public InsertRecord() 
	{
		frame.setSize(400,350);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		addLabel();
		frame.setVisible(true);
	}
	private void addLabel() 
	{
		String[] name={"Id","Name","Department","Salary"};
		for(int i=0;i<4;i++) 
		{
			label[i]=new JLabel();
			label[i].setFont(font);
			frame.add(label[i]);
		}
		label[0].setText("Enter "+name[0]);
		label[0].setBounds(30,30,200,30);
		label[1].setText("Enter "+name[1]);
		label[1].setBounds(30,70,200,30);
		label[2].setText("Enter "+name[2]);
		label[2].setBounds(30,110,200,30);
		label[3].setText("Enter "+name[3]);
		label[3].setBounds(30,150,200,30);
		addTextBox();
	}
	private void addTextBox() 
	{
		for(int i=0;i<4;i++) 
		{
			textbox[i]=new JTextField();
			textbox[i].setFont(font1);
			textbox[i].setForeground(Color.blue);
			frame.add(textbox[i]);
		}
		textbox[0].setBounds(230,30,140,30);
		textbox[1].setBounds(230,70,140,30);
		textbox[2].setBounds(230,110,140,30);
		textbox[3].setBounds(230,150,140,30);
		addButtons();
	}
	private void addButtons() 
	{
		button1.addActionListener(new ClickListener());
		button1.setBounds(130,240,100,30);
		frame.add(button1);
		
	}
	
	class ClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event) 
		{	
			
			String a=textbox[0].getText();
			String b=textbox[1].getText();
			String c=textbox[2].getText();
			String d=textbox[3].getText();
			if(a.isEmpty()||b.equals("")||c.equals("")||d.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Fill out all fields");
			}
			else
			{
				int z=Integer.parseInt(a);
				int y=Integer.parseInt(d);
				try
				{	
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","jitesh");
					Statement s=cn.createStatement(); 
					ResultSet rs=s.executeQuery("select * from employeeinfo where id="+z+"");	
					if(rs.next()) 
					{
						JOptionPane.showMessageDialog(frame,"already exists");
					}
					else 
					{
						JOptionPane.showMessageDialog(frame,"Insert Sucessfully");
						for(int i=0;i<4;i++) 
						{
						textbox[i].setText(null);
						}
					}
					PreparedStatement ps=cn.prepareStatement("insert into employeeinfo(id,name,department,salary) values(?,?,?,?)"); 
					ps.setInt(1,z);
					ps.setString(2,b);
					ps.setString(3,c);
					ps.setInt(4,y);
					ps.executeUpdate();
				}
				catch(Exception ex) 
				{
					System.out.println(ex);
				}
			}			
			
		}
}
	
}
