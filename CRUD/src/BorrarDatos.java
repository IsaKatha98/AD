import java.sql.*;

public class BorrarDatos {
    public static void borraUsuario(String userName) throws SQLException {

        Connection conn = null;
        Statement stmt = null;

        try {
            
            conn = Conection.establishConection();
            stmt = conn.createStatement();
                    
            String sql = "delete from Usuarios  where username="+userName;              
                    
            stmt.executeUpdate(sql);

        }catch(SQLException se){
            //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
            se.printStackTrace();
        }catch(Exception e){
            //Gestionamos los posibles errores
            e.printStackTrace();
        }finally{
                    
            stmt.close();
            conn.close();
        }                
               
    }

    public static void borraPost (int idPost) throws SQLException {

    Connection conn = null;
    Statement stmt = null;

    try {
        
        conn = Conection.establishConection();
        stmt = conn.createStatement();
                
        String sql = "delete from Posts  where idPost="+idPost;              
                
        stmt.executeUpdate(sql);

    }catch(SQLException se){
        //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
        se.printStackTrace();
    }catch(Exception e){
        //Gestionamos los posibles errores
        e.printStackTrace();
    }finally{
                
        stmt.close();
        conn.close();
    }                

    }
    
    public static void borraLike(int idPost, String userName) throws SQLException {

        Connection conn = null;
        Statement stmt = null;
    
        try {
            
            conn = Conection.establishConection();
            stmt = conn.createStatement();

            String sql = "delete from Likes where idPost="+idPost+"and idUsuario= (select idUsuario from Usuarios where username"+userName+")";              
                    
            stmt.executeUpdate(sql);
    
        }catch(SQLException se){
            //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
            se.printStackTrace();
        }catch(Exception e){
            //Gestionamos los posibles errores
            e.printStackTrace();
        }finally{
                    
            stmt.close();
            conn.close();
        }                
    

        
    
    }
}
