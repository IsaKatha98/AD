package boletin01;

import java.sql.Connection;
import java.sql.Statement;



public class funciones {
	
	//recibe la conexión abierta por parámetro
	public static void createTable(Connection conn) throws Exception  {
		Statement stm=null;
		
		try {
			stm=  conn.createStatement();
			String sql = "create table Posts ("
					+ "idPosts int,"
					+ "idUsuarios int,"
					+ "created_at Date,"
					+ "updated_at Date "
					+ ") ";
		}
		
		
	}
}
