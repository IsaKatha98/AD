package paquete.crudHibernate;

import java.util.List;

public class Functions {
	
	 private static AccesoBD instancia;
	 
	 public static boolean confirmaID( int id) throws Exception {
		   
		 instancia = new AccesoBD();
		 
         try {
			instancia.abrir();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         boolean idExiste= instancia.compruebaId(id);
         
         instancia.cerrar();
         
		return idExiste;
	 }
	 
	 public static  void mostrarDatos (int id) {

	        try {
	        	
	        	//Instanciamos la conexión.
	        	instancia= new AccesoBD();
	        	
	        	//Abrimos la conexión
	        	instancia.abrir();
	        	
	        	//Llamamos a la función
	        	instancia.mostrarDatos(id);
	        	
	        }catch(Exception e){
	            //Gestionamos los posibles errores
	            e.printStackTrace();
	        }finally{
	            //Cerrar la conexión
	            instancia.cerrar();
	        }

	         
	    }
	    
	    public static  void insertaUsuario (String nombre, String apellidos, String userName, String password, String email) throws Exception {

	        try {
	        	
	        	//creamos el usuario a insertar.
	        	//Ponemos 0 como id por defecto.
	        	Usuarios2 usuarioNuevo= new Usuarios2(0, nombre, apellidos, userName, password, email);
	        	
	        	//Instanciamos la conexión.
	        	instancia= new AccesoBD();
	        	
	        	//Abrimos la conexión
	        	instancia.abrir();
	        	
	        	//Llamamos a la función
	        	instancia.guardar(usuarioNuevo);
	        	
	        	System.out.println("Se ha guardado un el usuario: "+nombre);
	        	
	        }catch(Exception e){
	            //Gestionamos los posibles errores
	            e.printStackTrace();
	        }finally{
	            //Cerrar la conexión
	            instancia.cerrar();
	        }
	         
	    }

	    public static void modificaUsuario (int id, String res, String datoN ) {
	    	
	    	 try {
		        
		        	//Instanciamos la conexión.
		        	instancia= new AccesoBD();
		        	
		        	//Abrimos la conexión
		        	instancia.abrir();
		        	
		        	//TODO: en teoría hay que crear una función por cada elemento a eliminar.
		        	
		        	//Llamamos a la función
		        	instancia.modificar(id, res, datoN);
		        			        	
		        }catch(Exception e){
		            //Gestionamos los posibles errores
		            e.printStackTrace();
		        }finally{
		            //Cerrar la conexión
		            instancia.cerrar();
		        }
	    	
	    }
	    
	    public static void borraUsuario(int id) {
	    	
	    	 try {
		        	
		        	//Instanciamos la conexión.
		        	instancia= new AccesoBD();
		        	
		        	//Abrimos la conexión
		        	instancia.abrir();
		        	
		        	//Llamamos a la función
		        	instancia.eliminar(id);
		        	
		        }catch(Exception e){
		            //Gestionamos los posibles errores
		            e.printStackTrace();
		        }finally{
		            //Cerrar la conexión
		            instancia.cerrar();
		        }
	    }
	    
	   
	    public static void listarUsuarios() {
	    	
	    	List<Usuarios2> lista= null;
	    	
	    	 try {
		        	
		        	//Instanciamos la conexión.
		        	instancia= new AccesoBD();
		        	
		        	//Abrimos la conexión
		        	instancia.abrir();
		        	
		        	//Llamamos a la función
		        	lista= instancia.listarUsuarios();
		        	
		        	//hacemos un for each, recorriendo cada usuario.
		        	for (Usuarios2 usuario : lista) {
		        		
		        		System.out.println("------------- ");	
		        		System.out.println("ID:"+usuario.getIdUsuario());
		        		System.out.println("Nombre: "+usuario.getNombre());
		        		System.out.println("Apellidos: "+usuario.getApellidos());
		        		System.out.println("Nombre de usuario: "+usuario.getUsername());
		        		System.out.println("Correo: "+usuario.getEmail());
		        		System.out.println("Contraseña: "+usuario.getPassword());		        	
		        		System.out.println();
		        	
		        		
		        	}
		        	
		        }catch(Exception e){
		            //Gestionamos los posibles errores
		            e.printStackTrace();
		        }finally{
		            //Cerrar la conexión
		            instancia.cerrar();
		        }
	    }
}


