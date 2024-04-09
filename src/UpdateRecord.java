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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class UpdateRecord 
{
	JFrame frame=new JFrame("Update record");
	JLabel label=new JLabel("Enter Id:");
	Font font=new Font("times new roman",Font.BOLD,25);
	Font font1=new Font("arial",Font.BOLD,15);
	JTextField textbox=new JTextField();
	JButton button=new JButton("update");
	JPanel panel=new JPanel();
	JLabel[] labels=new JLabel[3];
	JTextField[] text=new JTextField[3];	
	JButton button1=new JButton("Submit");
	FirstListener listener=new FirstListener();
	public UpdateRecord() 
	{
		frame.setSize(400,400);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		addLabel();
		panel.setVisible(false);
		button1.setVisible(false);
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
		frame.getContentPane().add(textbox);
		addButton();
	}
	private void addButton() 
	{
		button.setBounds(130, 100, 90, 30);
		button.setFont(new Font("times new roman",Font.BOLD,15));
		button.addActionListener(listener);
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
			text[i]=new JTextField();
			text[i].setFont(font1);
			text[i].setBorder(BorderFactory.createEmptyBorder());
			text[i].setBackground(frame.getBackground());
			panel.add(text[i]);
			text[i].setBackground(Color.yellow);
		}
		text[0].setBounds(200,10,70,30);
		text[1].setBounds(200,50,70,30);
		text[2].setBounds(200,90,70,30);
		button1.setBounds(130,320,100,30);
		button1.addActionListener(listener);
		frame.add(button1);

	}

	class FirstListener  implements ActionListener
	{
		Connection cn;
		PreparedStatement ps;
		String id="";
		public void actionPerformed(ActionEvent event) 
		{
			if(event.getSource()==button)
			{
				try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","jitesh");
						ps=cn.prepareStatement("select * from employeeinfo where id=?");
						id=textbox.getText();
						ps.setString(1,id);
						ResultSet rst=ps.executeQuery();						
						if(rst.next())
						{
							text[0].setText(rst.getString(2));
							text[1].setText(rst.getString(3));
							text[2].setText(rst.getString(4));
							panel.setVisible(true);
							button1.setVisible(true);
							
						}else 
						{
							JOptionPane.showMessageDialog(null,"id not exist");

						}
						
				}
				catch(Exception e) {}
			}
			else if(event.getSource()==button1)
			{
		
				try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","jitesh");
						ps=cn.prepareStatement("update employeeinfo set name=?, department=?, salary=? where id=?;");
						ps.setString(1,text[0].getText());
						ps.setString(2,text[1].getText());
						ps.setString(3,text[2].getText());
						ps.setString(4,id);
						ps.executeUpdate();
						
						JOptionPane.showMessageDialog(null,"Data updated");
						panel.setVisible(false);
						button1.setVisible(false);
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
		}
	}
}
