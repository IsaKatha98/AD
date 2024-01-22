public class ModificarDatos {

    public static int buscaId (String nombreTabla, String data) {

        int idUsuario;
        switch (data){

            //TODO:ahora hay que escribir los statements correspondientes.
            case "nombre": {
                
               
            }

            case "apellidos":{

               
            }

            case "nombre de usuario":{
               

            }

            case "contraseña":{
                
            }

            case "correo": {
               
            }
        }
        //TODO: aquí se busca el id del usuario a través de SQL.
        return idUsuario;
        
    }

    public static void modificaUsuario (String respuesta) {

        String nombreTabla="Usuarios";
        int idUsuario= buscaId(nombreTabla, respuesta);

        switch (respuesta){

            //TODO:ahora hay que escribir los alter correspondientes ya que tenemos el id del usuario.
            case "nombre": {
                
               
            }

            case "apellidos":{

               
            }

            case "nombre de usuario":{
               

            }

            case "contraseña":{
                
            }

            case "correo": {
               
            }
        }

    }

    public static void modificaPost(int idPost, String username ){

        //Hay que comprobar si ese post existe.


        //hay que comprobar que ese username existe.

        //Si ambos existen, entonces se hace un alter.
    }
    
}
