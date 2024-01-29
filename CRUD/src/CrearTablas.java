import java.sql.*;


public class CrearTablas {

    public static void crear() throws Exception {

        Connection conn = null;
        Statement stmt = null;

        try {
            //Paso 1.Previamente habremos realizado la conexión
            conn = Conection.establishConection();
            //Paso 2. Creamos un nuevo objeto con la conexión
            stmt = conn.createStatement();
            //Paso 3. Definimos la sentencia de crear una nueva base de datos
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

                
            //Paso 4. Ejecutar la sentencia
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
            //Paso 5. Cerrar el objeto en uso y la conexión
            stmt.close();
            conn.close();
        }


    }

    
}
