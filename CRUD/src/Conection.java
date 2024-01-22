import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    
    public static Connection establishConection (){

        Connection conn=null;
        String url="jdbc:mysql://dns11036.phdns11.es:3306/ad2324_isabel_loerzer"; 
		String user="isabel.loerzer";
		String password="12345";

        try {

			conn=  DriverManager.getConnection(url, user, password);
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
		} catch (ClassNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		
		} 

		return conn;
    
    }
}
