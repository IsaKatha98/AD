public class InsertarDatos {

    public static int buscaId (String nombreTabla) {

        int ultimoId;


        return ultimoId;
        
    }

    public static boolean insertaUsuarios (String nombre, String apellidos, String userName, String password, String email) {

        boolean userCreado= false;

       

        //Llamamos a la función del id.
        String nombreTabla="Usuarios";
        int idUsuario=buscaId(nombreTabla);

         //aquí pues toda la pesca del SQL.


         return userCreado;

        

        
    }

    public static boolean insertaPost (String nombre) {

        boolean postCreado=false;

        //TODO: hay que buscar el id asociado a ese nombre.
        int idUsuario;

        //Si se valida pues se genera el post 
        String nombreTabla="Posts";
        int idPost= buscaId(nombreTabla);

        Date created_at;
        Date updated_at; 
        //Estos dos se hacen con un timestamp entiendo.

        
        return postCreado;
    }

    public static boolean darLike (String nombre, int idPost ) {

        boolean mg= false;

          //TODO: hay que buscar el id asociado a ese nombre.
          int idUsuario;

          //TODO: hay que comprobar que idPsot existe en la tabla posts.
          boolean postExiste= false;

          //Si el post existe pues se genera un insert en la tabla likes.
          if (postExiste) {

            //Buscamos el id del like.
            String nombreTabla="Likes";
            int idLike= buscaId(nombreTabla);

          }

          return mg;


    }

    
}
