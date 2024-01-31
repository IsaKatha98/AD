import java.sql.*;
public class ListarDatos {

    /**
     * Método que lista la tabla Usuarios.
     * @throws SQLException
     */
    public static void listaUsuarios() throws SQLException {
  
        Connection conn = null;

        try {
            conn = Conection.establishConection();
            PreparedStatement s= conn.prepareStatement("select * from Usuarios");
            ResultSet resultado = s.executeQuery();

            while(resultado.next()){
                System.out.println("IdUsuario: " + resultado.getInt("idUsuario"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Apellidos: " + resultado.getString("apellidos"));
                System.out.println("Nombre de usuario: " + resultado.getString("username"));
                System.out.println("Contraseña: " + resultado.getString("password"));
                System.out.println("Correo: " + resultado.getString("email"));
                System.out.println();
                }

        }catch(SQLException se){
            //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
            if (se.getErrorCode()==0) {
                System.out.println("Esta tabla está vacía.");

            }
        }catch(Exception e){
            //Gestionamos los posibles errores
            e.printStackTrace();
        }finally{
            conn.close();
        }             
    }

    /**
     * Método que lista la tabla Posts.
     * @throws SQLException
     */
    public static void listaPosts () throws SQLException {

        Connection conn = null;

        try {
            conn = Conection.establishConection();
           
            PreparedStatement s= conn.prepareStatement("select * from Posts");

            ResultSet resultado = s.executeQuery();

            while(resultado.next()){
                System.out.println("IdPost: " + resultado.getInt("idPost"));
                System.out.println("IdUsuario: " + resultado.getInt("idUsuario"));
                System.out.println("Creado el: " + resultado.getDate("created_at"));
                System.out.println("Actualizado el: " + resultado.getDate("updated_at"));
                System.out.println();
                }

        }catch(SQLException se){
            //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
            if (se.getErrorCode()==0) {
                System.out.println("Esta tabla está vacía.");

            }
        }catch(Exception e){
            //Gestionamos los posibles errores
            e.printStackTrace();
        }finally{
            conn.close();
        }        
    }

    /**
     * Método que lista la tabla Likes.
     * @throws SQLException
     */
    public static void listaLikes() throws SQLException {

        Connection conn = null;
        
        try {
            conn = Conection.establishConection();
            
           PreparedStatement s=conn.prepareStatement("select * from Posts");

                ResultSet rs = s.executeQuery();
                while(rs.next()){

             

                        System.out.println("IdLike: " + rs.getInt("idLike"));
                        System.out.println("IdUsuario: " + rs.getInt("idUsuario"));
                        System.out.println("IdPost: " + rs.getInt("idPost"));
                        System.out.println();

                   
                   
                }       
        }catch(SQLException se){
            //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
            if (se.getErrorCode()==0) {
                System.out.println("Esta tabla está vacía.");

            }
        }catch(Exception e){
            //Gestionamos los posibles errores
            e.printStackTrace();
        }finally{
            conn.close();
        }        
    }
    
}
