import java.sql.*;
public class ListarDatos {

    public static void listaUsuarios() throws SQLException {
  
        Connection conn = null;
        Statement stmt = null;

        try {
            //Paso 1.Previamente habremos realizado la conexión
            conn = Conection.establishConection();
            //Paso 2. Creamos un nuevo objeto con la conexión
            stmt = conn.createStatement();
            
            //Paso 1 establecer conexión + pasar la consulta
            PreparedStatement s= conn.prepareStatement("select * from Usuarios");

            ResultSet resultado = s.executeQuery();

            while(resultado.next()){
                System.out.println("IdUsuario: " + resultado.getInt("idUsuario"));
                System.out.println("Nombre: " + resultado.getString("nombre"));
                System.out.println("Apellidos: " + resultado.getString("apellidos"));
                System.out.println("Nombre de usuario: " + resultado.getString("username"));
                System.out.println("Contraseña: " + resultado.getString("password"));
                System.out.println("Correo: " + resultado.getString("email"));
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
    }

    public static void listaPosts () throws SQLException {

        Connection conn = null;
        Statement stmt = null;

        try {
            //Paso 1.Previamente habremos realizado la conexión
            conn = Conection.establishConection();
            //Paso 2. Creamos un nuevo objeto con la conexión
            stmt = conn.createStatement();
            
            //Paso 1 establecer conexión + pasar la consulta
            PreparedStatement s= conn.prepareStatement("select * from Posts");

            ResultSet resultado = s.executeQuery();

            while(resultado.next()){
                System.out.println("IdPost: " + resultado.getInt("idPost"));
                System.out.println("IdUsuario: " + resultado.getInt("idUsuario"));
                System.out.println("Creado el: " + resultado.getDate("created_at"));
                System.out.println("Actualizado el: " + resultado.getDate("updated_at"));
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


    }

    public static void listaLikes() throws SQLException {

        Connection conn = null;
        Statement stmt = null;

        try {
            //Paso 1.Previamente habremos realizado la conexión
            conn = Conection.establishConection();
            //Paso 2. Creamos un nuevo objeto con la conexión
            stmt = conn.createStatement();
            
            //Paso 1 establecer conexión + pasar la consulta
            PreparedStatement s= conn.prepareStatement("select * from Posts");

            ResultSet resultado = s.executeQuery();

            while(resultado.next()){
                System.out.println("IdLike: " + resultado.getInt("idLike"));
                System.out.println("IdUsuario: " + resultado.getInt("idUsuario"));
                System.out.println("IdPost: " + resultado.getInt("idPost"));
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


    }
    
}
