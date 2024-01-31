import java.sql.*;

public class ModificarDatos {

    /**
     * Método que modifica un usuario.
     * Solo se puede modificar un tipo de dato.
     * @param res
     * @param datoOG
     * @param datoN
     * @throws SQLException
     */
    public static void modificaUsuario (String res, String datoOG, String datoN) throws SQLException {
        switch (res){
            case "nombre": {

                Connection conn = null;
                Statement stmt = null;

                try {
                   
                    conn = Conection.establishConection();
                    stmt = conn.createStatement();
                    
                    String sql = "update Usuarios set nombre='"+datoN+"' where nombre='"+datoOG+"';";
                    
                    //comprobamos que se ejecuta correctamente.
                    if (stmt.executeUpdate(sql)==1) {

                        System.out.println("El usuario se ha modificado correctamente.");
                    
                    } else {

                        System.out.println("No se ha encontrado un usuario con ese nombre.");
                    }

                }catch(SQLException se){
                    //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
                    se.printStackTrace();
                }catch(Exception e){
                    //Gestionamos los posibles errores
                    e.printStackTrace();
                }finally{
                    //Cerrar el objeto en uso y la conexión
                    stmt.close();
                    conn.close();
                }                
               break;
            }

            case "apellidos":{

                Connection conn = null;
                Statement stmt = null;

                try {
                    conn = Conection.establishConection();
                    stmt = conn.createStatement();
                    
                    String sql = "update Usuarios set apellidos='"+datoN+"' where apellidos='"+datoOG+"';";
                    
                    if (stmt.executeUpdate(sql)==1) {

                        System.out.println("El usuario se ha modificado correctamente.");
                    
                    } else {

                        System.out.println("No se ha encontrado un usuario con ese nombre.");
                    }

                }catch(SQLException se){
                    //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
                    se.printStackTrace();
                }catch(Exception e){
                    //Gestionamos los posibles errores
                    e.printStackTrace();
                }finally{
                    //Cerrar el objeto en uso y la conexión
                    stmt.close();
                    conn.close();
                }                
                break;              
            }

            case "nombre de usuario":{

                Connection conn = null;
                Statement stmt = null;

                try {
                    conn = Conection.establishConection();
                    stmt = conn.createStatement();
                    
                    String sql = "update Usuarios set userName='"+datoN+"' where userName='"+datoOG+"';";
                    
                    if (stmt.executeUpdate(sql)==1) {

                        System.out.println("El usuario se ha modificado correctamente.");
                    
                    } else {

                        System.out.println("No se ha encontrado un usuario con ese nombre.");
                    }

                }catch(SQLException se){
                    //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
                    se.printStackTrace();
                }catch(Exception e){
                    //Gestionamos los posibles errores
                    e.printStackTrace();
                }finally{
                    //Cerrar el objeto en uso y la conexión
                    stmt.close();
                    conn.close();
                }                
                break;
            }

            case "contraseña":{

                Connection conn = null;
                Statement stmt = null;

                try {
                    conn = Conection.establishConection();
                    stmt = conn.createStatement();
                    
                    String sql = "update Usuarios set password="+datoN+" where password="+datoOG;
                    
                    if (stmt.executeUpdate(sql)==1) {

                        System.out.println("El usuario se ha modificado correctamente.");
                    
                    } else {

                        System.out.println("No se ha encontrado un usuario con ese nombre.");
                    }

                }catch(SQLException se){
                    //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
                    se.printStackTrace();
                }catch(Exception e){
                    //Gestionamos los posibles errores
                    e.printStackTrace();
                }finally{
                    //Cerrar el objeto en uso y la conexión
                    stmt.close();
                    conn.close();
                }                
                break;
            }

            case "correo": {

                Connection conn = null;
                Statement stmt = null;

                try {
                    conn = Conection.establishConection();
                    stmt = conn.createStatement();
                    
                    String sql = "update Usuarios set email='"+datoN+"' where email='"+datoOG+"';";
                    
                    if (stmt.executeUpdate(sql)==1) {

                        System.out.println("El usuario se ha modificado correctamente.");
                    
                    } else {

                        System.out.println("No se ha encontrado un usuario con ese nombre.");
                    }

                }catch(SQLException se){
                    //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
                    se.printStackTrace();
                }catch(Exception e){
                    //Gestionamos los posibles errores
                    e.printStackTrace();
                }finally{
                    //Cerrar el objeto en uso y la conexión
                    stmt.close();
                    conn.close();
                }                
                break;
            }
        }   
        
    }

    /**
     * Método que modifica el usuario que ha generado un post.
     * @param idPost
     * @param username
     * @throws SQLException
     */
    public static void modificaPost(int idPost, String username ) throws SQLException{

        Connection conn = null;
        Statement stmt = null;

                try {
                    conn = Conection.establishConection();
                    stmt = conn.createStatement();
                    
                    String sql = "update Posts set username='"+username+"' where idPost="+idPost+";";
                    String sql2="update Posts set updated_at=NOW() where idPost="+idPost+";";
                    
                    if (stmt.executeUpdate(sql)==1) {
                        stmt.executeUpdate(sql2);

                        System.out.println("El post se ha modificado correctamente.");
                    
                    } else {

                        System.out.println("No se ha encontrado ningún post con ese nombre.");
                    }
                    
                }catch(SQLException se){
                    //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
                    se.printStackTrace();
                }catch(Exception e){
                    //Gestionamos los posibles errores
                    e.printStackTrace();
                }finally{
                    //Cerrar el objeto en uso y la conexión
                    stmt.close();
                    conn.close();
                }                
    }
    
}
