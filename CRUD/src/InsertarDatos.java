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
            
            if (stmt.executeUpdate(sql)==1) {

                userCreado=true;
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
                 if (stmt.executeUpdate(sql)==1) {

                    System.out.println("El usuario se ha modificado correctamente.");
                    postCreado=true;
                
                }
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
       
        try {
            //Paso 1.Previamente habremos realizado la conexión
            conn = Conection.establishConection();
            //Paso 2. Creamos un nuevo objeto con la conexión
            stmt = conn.createStatement();
            //Buscamos el id del usuario según ese username.
             PreparedStatement s= conn.prepareStatement("select idUsuario from Usuarios where username=?;");
             s.setString(1, userName);
             ResultSet rs=s.executeQuery();
             //asignamos el valor del resultSet.
             int idUsuario=0;
             if (rs.next()) {

                idUsuario=rs.getInt("idUsuario");
             }
             //comprobamos que el usuario existe.
             if (idUsuario==0) {
               
                System.out.println("Ese usuario no existe.");
                
             } else {
                //comprobamos que si ese usuario ya le ha dado mg al post.
                //intentamos hacer un select.
                PreparedStatement s2= conn.prepareStatement("select * from Likes where idPost=? and idUsuario=?");
                s2.setInt(1, idPost);                
                s2.setInt(2, idUsuario);

                //Si nos da null, significa que no hay ningún registro de este tipo, por lo que se le puede dar mg.
                if (s2.executeQuery()==null) {

                    //Por lo tanto, hacemos el insert en la tabla Likes.
                    String sql = "insert into Likes (idUsuario, idPost) values"
                        + "("+idUsuario+","+idPost+");"; 
         
                        //Paso 4. Ejecutar la sentencia
                        stmt.executeUpdate(sql);
        
                        mg=true;              
                         

                } else {

                    System.out.println("Ya se le ha dado me gusta a este post.");
                }
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
