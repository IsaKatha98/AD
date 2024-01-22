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
            String sql = "create table Usuarios ("
                +"idUsuario int primary key,"
                +"nombre varchar(45),"
                +"apellidos varchar (45),"
                +"username varchar(12),"
                +"password varchar(128),"
                +"email varchar(50))"
                +"create table Posts ("
                +"idPost int primary key,"
                +"idusuario int,"
                +"created_at Date default current_timestamp,"
                +"updated_at Date default current_timestamp,"
                +"foreign key(idUsuario) references Usuarios(idUsuario))"
                +"create table Likes ("
                +"idLike int primary key,"
                +"idUsuario int,"
                +"idPost int,"
                +"foreign key (idUsuario) references Usuarios(idUsuario),"
                +"foreign key (idPost) references Posts(idPost))";

                
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


    }

    
}
