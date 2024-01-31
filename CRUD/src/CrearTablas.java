import java.sql.*;
public class CrearTablas {

    /**
     * Método que crea las tablas de la base de datos.
     * @throws Exception
     */
    public static void crear() throws Exception {

        Connection conn = null;
        Statement stmt = null;

        try {
            conn=Conection.establishConection();
            stmt = conn.createStatement();
            
            String sqlUsuarios = "create table Usuarios ("
                +"idUsuario int auto_increment primary key,"
                +"nombre varchar(45),"
                +"apellidos varchar (45),"
                +"username varchar(12),"
                +"password varchar(128),"
                +"email varchar(50));";

            String sqlPosts="create table Posts ("
                +"idPost int auto_increment primary key,"
                +"idUsuario int,"
                +"created_at Date default current_timestamp,"
                +"updated_at Date default current_timestamp,"
                +"foreign key(idUsuario) references Usuarios(idUsuario) on delete cascade);";
                
            String sqlLikes="create table Likes ("
                +"idLike int auto_increment primary key,"
                +"idUsuario int,"
                +"idPost int,"
                +"foreign key (idUsuario) references Usuarios(idUsuario) on delete cascade,"
                +"foreign key (idPost) references Posts(idPost) on delete cascade);";

            stmt.executeUpdate(sqlUsuarios);
            stmt.executeUpdate(sqlPosts);
            stmt.executeUpdate(sqlLikes);

            System.out.println("Se han creado las tablas con éxito.");
           
        }catch(SQLException se){
            System.err.println("Las tablas ya han sido creadas anteriormente.");
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
