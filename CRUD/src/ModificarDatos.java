import java.sql.*;

public class ModificarDatos {

    public static void modificaUsuario (String res, String datoOG, String datoN) throws SQLException {
        switch (res){
            case "nombre": {

                Connection conn = null;
                Statement stmt = null;

                try {
                    //Paso 1.Previamente habremos realizado la conexión
                    conn = Conection.establishConection();
                    //Paso 2. Creamos un nuevo objeto con la conexión
                    stmt = conn.createStatement();
                    
                    String sql = "update Usuarios set nombre='"+datoN+"' where nombre='"+datoOG+"';";
                    
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
               
            }

            case "apellidos":{

                Connection conn = null;
                Statement stmt = null;

                try {
                    //Paso 1.Previamente habremos realizado la conexión
                    conn = Conection.establishConection();
                    //Paso 2. Creamos un nuevo objeto con la conexión
                    stmt = conn.createStatement();
                    
                    String sql = "update Usuarios set apellidos='"+datoN+"' where apellidos='"+datoOG+"';";
                    
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
               

               
            }

            case "nombre de usuario":{

                Connection conn = null;
                Statement stmt = null;

                try {
                    //Paso 1.Previamente habremos realizado la conexión
                    conn = Conection.establishConection();
                    //Paso 2. Creamos un nuevo objeto con la conexión
                    stmt = conn.createStatement();
                    
                    String sql = "update Usuarios set userName='"+datoN+"' where userName='"+datoOG+"';";
                    
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
               
               

            }

            case "contraseña":{

                Connection conn = null;
                Statement stmt = null;

                try {
                    //Paso 1.Previamente habremos realizado la conexión
                    conn = Conection.establishConection();
                    //Paso 2. Creamos un nuevo objeto con la conexión
                    stmt = conn.createStatement();
                    
                    String sql = "update Usuarios set password="+datoN+" where password="+datoOG;
                    
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
               
                
            }

            case "correo": {

                Connection conn = null;
                Statement stmt = null;

                try {
                    //Paso 1.Previamente habremos realizado la conexión
                    conn = Conection.establishConection();
                    //Paso 2. Creamos un nuevo objeto con la conexión
                    stmt = conn.createStatement();
                    
                    String sql = "update Usuarios set email='"+datoN+"' where email='"+datoOG+"';";
                    
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
               
               
            }
        }   
        
    }

    public static void modificaPost(int idPost, String username ) throws SQLException{

        Connection conn = null;
        Statement stmt = null;

                try {
                    //Paso 1.Previamente habremos realizado la conexión
                    conn = Conection.establishConection();
                    //Paso 2. Creamos un nuevo objeto con la conexión
                    stmt = conn.createStatement();
                    
                    String sql = "update Posts set username='"+username+"' where idPost="+idPost+";";
                    String sql2="update Posts set updated_at=NOW() where idPost="+idPost+";";
                    
                    stmt.executeUpdate(sql);
                    stmt.executeUpdate(sql2);

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
