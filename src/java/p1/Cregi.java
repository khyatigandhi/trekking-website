package p1;

import java.sql.Connection;
import java.sql.DriverManager;

public class Cregi
{
    public static Connection getConnected()
    {
        Connection cn=null;
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
             cn = DriverManager.getConnection("Jdbc:Odbc:Driver={SQL Server Native Client 10.0};Server=.\\SQL2008;Database=trek","sa","123456");
			
		
		
			System.out.println(cn);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return cn;
        
    }
    public static void main(String[] args) {
        getConnected();
    }
    
}
