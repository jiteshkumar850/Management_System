import java.sql.*;
public class Sql 
{
	private Sql()
	{

		try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","jitesh");
				Statement st=cn.createStatement();
				st.execute("create table employeeinfo(id int primary key,name varchar(25),department varchar(25),salary int)");
			}
			catch(Exception ex) 
			{
				System.out.println(ex);
			}
	}
	public static void main(String[] args) {
		new Sql();
	}
}
