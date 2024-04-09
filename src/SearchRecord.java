import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SearchRecord 
{
	JFrame frame=new JFrame("Search record");
	JLabel label=new JLabel("Enter Id:");
	Font font=new Font("times new roman",Font.BOLD,25);
	Font font1=new Font("arial",Font.BOLD,15);
	JTextField textbox=new JTextField();
	JButton button=new JButton("Search");
	JPanel panel=new JPanel();
	JLabel[] labels=new JLabel[3];
	JLabel[] lab=new JLabel[3];	
	
	public SearchRecord() 
	{
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		addLabel();
		panel.setVisible(false);
		frame.setVisible(true);

	}
	private void addLabel() 
	{
		label.setBounds(50,30,100,50);
		label.setFont(font);
		frame.add(label);
		addBox();
	}
	private void addBox() 
	{
		textbox.setBounds(160,40,180,30);
		textbox.setFont(font1);
		frame.add(textbox);
		addButton();
	}
	private void addButton() 
	{
		FirstListener listener1=new FirstListener();
		button.setBounds(130, 100, 90, 30);
		button.setFont(new Font("times new roman",Font.BOLD,15));
		button.addActionListener(listener1);
		frame.add(button);
		addPanel();
	}
	private void addPanel()
	{
		panel.setBounds(30, 140, 330, 170);
		panel.setBackground(Color.yellow);
		panel.setLayout(null);
		frame.add(panel);
		addPanelRaw();
	}
	private void addPanelRaw() 
	{
		for(int i=0;i<3;i++) 
		{
			labels[i]=new JLabel();
			labels[i].setFont(new Font("times new roman",Font.BOLD,20));
			panel.add(labels[i]);
		}
		String[] name={"Name","Dept...","Salary"};
		labels[0].setBounds(10,10,170,30);
		labels[0].setText("Employee "+name[0]);
		labels[1].setBounds(10,50,170,30);
		labels[1].setText("Employee "+name[1]);
		labels[2].setBounds(10,90,170,30);
		labels[2].setText("Employee "+name[2]);
		addText();
	}
	private void addText() 
	{
		for(int i=0;i<3;i++) 
		{
			lab[i]=new JLabel();
			lab[i].setFont(font1);
			panel.add(lab[i]);
			lab[i].setBackground(Color.yellow);
		}
		lab[0].setBounds(200,10,70,30);
		lab[1].setBounds(200,50,70,30);
		lab[2].setBounds(200,90,70,30);
		
	}

	class FirstListener  implements ActionListener
	{
		public void actionPerformed(ActionEvent event) 
		{
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","jitesh");
				String i=textbox.getText();
				PreparedStatement ps=cn.prepareStatement("select * from employeeinfo where id=?");
				ps.setString(1,i);
				ResultSet rs=ps.executeQuery();

				if(rs.next()==true)
				{
					
					textbox.setText(rs.getString(1));
					lab[0].setText(rs.getString(2));
					lab[1].setText(rs.getString(3));
					lab[2].setText(rs.getString(4));
					if(event.getSource()==button) 
					{
						panel.setVisible(true);
					}
				}
				else 
				{
					JOptionPane.showMessageDialog(frame, "Id not Exist");	
					panel.setVisible(false);
				}	
			}
			catch(Exception ex) 
			{
				System.out.println(ex);
			}
		}
	}
	
}
