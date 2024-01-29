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
            + "( '"+nombre+"', '"+apellidos+"', '"+userName+"', '"+password+"', '"+email+"');"; 
            
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
            PreparedStatement s= conn.prepareStatement("select idUsuario from Usuarios where username=?;");
            s.setString(1, userName);
            ResultSet rs=s.executeQuery();

            if (rs.next()) {
                System.out.println(rs.getInt("idUsuario"));
            
                String sql = "insert into Posts (idUsuario, created_at, updated_at) values"
                + "("+rs.getInt("idUsuario")+", now(), now());"; 

                 //Paso 4. Ejecutar la sentencia
            stmt.executeUpdate(sql);
                postCreado=true;
                
            }
           
           
           
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
        //TODO: hay que controlar que el mismo usuario no de like dos veces al mismo post.

        try {
            //Paso 1.Previamente habremos realizado la conexión
            conn = Conection.establishConection();
            //Paso 2. Creamos un nuevo objeto con la conexión
            stmt = conn.createStatement();
            //Buscamos el id del usuario según ese username.
             PreparedStatement s= conn.prepareStatement("select idUsuario from Usuarios where username=?;");
             s.setString(1, userName);
             ResultSet rs=s.executeQuery();
 
             if (rs.next()) {
             
                String sql = "insert into Likes (idUsuario, idPost) values"
                + "("+rs.getInt("idUsuario")+","+idPost+");"; 
 
                //Paso 4. Ejecutar la sentencia
                stmt.executeUpdate(sql);

                mg=true;              
             }        
            
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
