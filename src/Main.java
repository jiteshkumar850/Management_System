    import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Main 
{
	JFrame frame=new JFrame("Employee Management System");
	JButton[] button=new JButton[5];
	Font font=new Font("arial",Font.PLAIN,21);
	public Main() 
	{
		frame.setSize(400,600);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		addButton();
		frame.setVisible(true);
	}
	private void addButton()
	{
		String[] buttonname={"Insert","Update","Search","Delete","ShowAll"}; 
		
		for(int i=0;i<5;i++) 
		{
			ClickListener listener=new ClickListener();
			button[i]=new JButton();
			button[i].setFont(font);
			button[i].addActionListener(listener);
			frame.add(button[i]);

		}
		button[0].setText(buttonname[0]+" Record");
		button[0].setBounds(80, 50, 200, 50);
		button[1].setText(buttonname[1]+" Record");
		button[1].setBounds(80, 140, 200, 50);
		button[2].setText(buttonname[2]+" Record");
		button[2].setBounds(80, 230, 200, 50);
		button[3].setText(buttonname[3]+" Record");
		button[3].setBounds(80, 320, 200, 50);
		button[4].setText(buttonname[4]+" Record");
		button[4].setBounds(80, 410, 200, 50);
		
 	}
	class ClickListener implements ActionListener
	{
		int count1=0;
		public void actionPerformed(ActionEvent event) 
		{
			count1+=1;
			if(event.getSource()==button[0]) 
			{
				if(count1==1) 
				{
					new InsertRecord();
					
				}
			}
			else if(event.getSource()==button[1]) 
			{
				if(count1==1) 
				{
					new UpdateRecord();
				}
			}
			else if(event.getSource()==button[2]) 
			{
				if(count1==1) 
				{
					new SearchRecord();
				}
			}
			else if(event.getSource()==button[3]) 
			{
				if(count1==1) 
				{
					new DeleteRecord();
				}
				
			}
			else if(event.getSource()==button[4]) 
			{
				if(count1==1) 
				{
					new ShowAllRecord();
				}
			}
		}	
	}
	class Window implements WindowListener
	{

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void windowOpened(WindowEvent arg0) 
		{
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	public static void main(String[] args) 
	{
		new Main();
	}
}
