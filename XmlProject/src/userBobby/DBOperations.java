package userBobby;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBOperations 
{
	public static void InsertData(String id,String Name, String FatherName, String Mobile)
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:xe","system","viratkohli12345");
			PreparedStatement pst=con.prepareStatement("insert into users values(?,?,?,?)");
			pst.setInt(1,Integer.parseInt(id));
			pst.setString(2,Name);
			pst.setString(3,FatherName);
			pst.setString(4,Mobile);
			int I=pst.executeUpdate();
			if(I>0)
			{
				System.out.println(id+"Inserted successfully");
			}
		}
		catch(Exception ex)
		{
			System.out.println(id+"Fail to insert");
		}
	}
	public static ResultSet GetData()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:xe","system","viratkohli12345");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from users");
			return rs;
		}
		catch(Exception ex)
		{
			return null;
		}
	}
}


