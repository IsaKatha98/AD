package boletin01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {

	public static void main(String[] args) {
		
		String url="jdbc:mysql://dns11036.phdns11.es:3306/ad2324_isabel_loerzer"; 
		String user="isabel.loerzer";
		String password="12345";
		Connection conn=null;
		try {
			conn=  DriverManager.getConnection(url, user, password);
			Class.forName("com.mysql.cj.jdbc.Driver");
			if (conn!=null&&!conn.isClosed()) {
				System.out.println("conexión establecida.");
			}
			
			
			//Aquí llamamos a la función de crear tablas.
			
		} catch (ClassNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		
		} finally {
			//aquí hay que cerrar la conexión.
			if (conn!=null) {
				try {conn.close();}
				catch (SQLException e) {
					System.out.println(e.getMessage().toString());
				}
			}
		}

	}

}
