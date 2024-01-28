import java.sql.*;

public class InsertarDatos {

    public static boolean insertaUsuarios (String nombre, String apellidos, String userName, String password, String email) throws SQLException {

        boolean userCreado= false;

        Connection conn = null;
        Statement stmt = null;

        try {
            //Paso 1.Previamente habremos realizado la conexión
            conn = Conection.establishConection();
            //Paso 2. Creamos un nuevo objeto con la conexión
            stmt = conn.createStatement();
            //Paso 3. Definimos la sentencia de crear una nueva base de datos
            String sql = "insert into Usuarios (nombre, apellidos, username, password, email) values"
            + "("+nombre+","+apellidos+","+userName+","+password+","+email+")"; 
            
            userCreado=true;
            //Paso 4. Ejecutar la sentencia
            stmt.executeUpdate(sql);
        }catch(SQLException se){
            //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
            se.printStackTrace();
        }catch(Exception e){
            //Gestionamos los posibles errores
            e.printStackTrace();
        }finally{
            //Paso 5. Cerrar el objeto en uso y la conexión
            stmt.close();
            conn.close();
        }

         return userCreado;
    }

    public static boolean insertaPost (String userName) throws SQLException {

        boolean postCreado=false;

        Connection conn = null;
        Statement stmt = null;

        try {
            //Paso 1.Previamente habremos realizado la conexión
            conn = Conection.establishConection();
            //Paso 2. Creamos un nuevo objeto con la conexión
            stmt = conn.createStatement();
            //Buscamos el id del usuario según ese username.
            PreparedStatement s= conn.prepareStatement("select idUsuario from Usuarios where username="+userName);
            ResultSet resIdUsuario= s.executeQuery();

            String sql = "insert into Posts (idUsuario, created_at, updated_at) values"
            + "("+resIdUsuario.getInt("idUsuario")+", now(), now())"; 
            
            postCreado=true;
            //Paso 4. Ejecutar la sentencia
            stmt.executeUpdate(sql);
        }catch(SQLException se){
            //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
            se.printStackTrace();
        }catch(Exception e){
            //Gestionamos los posibles errores
            e.printStackTrace();
        }finally{
            //Paso 5. Cerrar el objeto en uso y la conexión
            stmt.close();
            conn.close();
        }
        
        return postCreado;
    }

    public static boolean darLike (String userName, int idPost ) throws SQLException {

        boolean mg= false;

        Connection conn = null;
        Statement stmt = null;

        try {
            //Paso 1.Previamente habremos realizado la conexión
            conn = Conection.establishConection();
            //Paso 2. Creamos un nuevo objeto con la conexión
            stmt = conn.createStatement();
            //Buscamos el id del usuario según ese username.
            PreparedStatement s= conn.prepareStatement("select idUsuario from Usuarios where username="+userName);
            ResultSet resIdUsuario= s.executeQuery();

            String sql = "insert into Likes (idUsuario, idPost) values"
            + "("+resIdUsuario.getInt("idUsuario")+", idPost)"; 
            
            mg=true;
            //Paso 4. Ejecutar la sentencia
            stmt.executeUpdate(sql);
        }catch(SQLException se){
            //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
            se.printStackTrace();
        }catch(Exception e){
            //Gestionamos los posibles errores
            e.printStackTrace();
        }finally{
            //Paso 5. Cerrar el objeto en uso y la conexión
            stmt.close();
            conn.close();
        }

         
          

          return mg;


    }

    
}
