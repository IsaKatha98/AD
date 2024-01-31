import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {

    /**
	 * Método que establece la conexión con la base de datos de MySQL
	 * @return una conexión
	 */
    public static Connection establishConection (){
        
		Connection conn=null;
        String url="jdbc:mysql://dns11036.phdns11.es:3306/ad2324_isabel_loerzer"; 
		String user="isabel.loerzer";
		String password="12345";

        try {

			conn=  DriverManager.getConnection(url, user, password);
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("Conexión establecida.");
			
			
		} catch (ClassNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		
		} 

		return conn; 
    
    }

	/**
	 * Método que establece la conexión de una base de datos en SQLServer
	 */
	public static void establishConectionSQLServer() {
		String jdbc="com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String url="jdbc:sqlserver://107-24\\SQLEXPRESS:49767;databaseName=Becas;user=sa;password=mitesoro; trustServerCertificate=true; loginTimeout=30;";
		String user="sa";
		String pass="mitesoro"; 
	

		//107-24\SQLEXPRESS:49767

	
        try {
			Class.forName(jdbc);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try  {
			
            Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexión establecida con SQLSERVER.");

        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }

	}
}
