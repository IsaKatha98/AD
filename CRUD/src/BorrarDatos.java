import java.sql.*;

public class BorrarDatos {
    public static void borraUsuario(String userName) throws SQLException {

        Connection conn = null;
    
        try {
            
            conn = Conection.establishConection();
                      
            PreparedStatement s =conn.prepareStatement("delete from Usuarios  where username=?;");
            s.setString(1, userName);  
           
            if (s.executeUpdate()==0){
                System.out.println("No se puede borrar este usuario.");
            } else{
                System.out.println("Se ha borrado el usuario: "+userName);
            }
 
        }catch(SQLException se){
            //Gestionamos los posibles errores que puedan surgir durante la ejecucion de la insercion
            se.printStackTrace();
        }catch(Exception e){
            //Gestionamos los posibles errores
            e.printStackTrace();
        }finally{
                    
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

            //buscamos el id del Usuario.
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

                //comprobamos si ese usuario le ha dado mg al post.
                //intentamos hacer un select.
                PreparedStatement s2= conn.prepareStatement("select * from Likes where idPost=? and idUsuario=?");
                s2.setInt(1, idPost);                
                s2.setInt(2, idUsuario);

                //Si nos da null, significa que no hay ningún registro de este tipo
                if (s2.executeQuery()==null) {

                    System.out.println("Este post no tiene ningún mg del usuario "+ userName);             
                         

                } else {

                    //borramos el mg.
                    PreparedStatement s3=conn.prepareStatement("delete from Likes where idPost=? and idUsuario=?");
                    s3.setInt(1, idPost);
                    s3.setInt(2, idUsuario);

                    //TODO.Esto así no funciona
                    if (!s3.executeQuery().equals(null)) {

                        System.out.println("Se borrado el mg.");

                    }                  
                }

             }

            
    
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
