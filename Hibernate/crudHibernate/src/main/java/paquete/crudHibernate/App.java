package paquete.crudHibernate;

import java.util.Scanner;

public class App {
	
	 private static AccesoBD instancia;

	    public static void main(String[] args) throws Exception {
	        
	      //Aquí empieza el crud
	        // Creamos un escáner y los búferes necesarios.
			Scanner sc = new Scanner(System.in);
			
			//Creamos las variables necesarias.
			int opcion;

			System.out.println("Bienvenido/a al gestor de su base de datos.");
			
			// Hacemos un bucle que se repita hasta que nos salgamos del programa.
			do {

				// Presentamos el menú.
				Menu.menu();

				// Preguntamos la opción que quiere el usuario.
				System.out.println("Introduzca la opción que desea: ");
				opcion = sc.nextInt();

				// Hacemos un switch.
				switch (opcion) {
	            //Opción de crear tablas.
	            case 1:{
	            	
	            	 sc.nextLine();
	            	 System.out.println("Indique el id del usuario:");
	                 int id= sc.nextInt();

	                try{

	                	mostrarDatos(id);

	                } catch (Exception e) {
	                    e.getMessage();
	                }
	                break;
	            }
				
				//opción de insertar datos
				case 2: {
					sc.nextLine();
					System.out.println("Va a insertar un nuevo usuario.");
					
					  System.out.println("Introduzca el nombre: ");
                      String nombre= sc.nextLine();
                      System.out.println("Introduzca los apellidos: ");
                      String apellidos= sc.nextLine();
                      System.out.println("Nombre de usuario:");
                      String userName= sc.nextLine();
                      System.out.println("La contraseña: ");
                      String password= sc.nextLine();
                      System.out.println("Email: ");
                      String email= sc.nextLine(); 

                  try{
                     
                	  insertaUsuario(nombre, apellidos, userName, password, email);
                	  
                  }catch (Exception e){
                	  
                	  System.out.println("Ha ocurrido un error.");
                	  
                  }
	                break;
				}
	            //opción de modificar datos
				case 3: {
					
					sc.nextLine();
					System.out.println("Va a modificar un usuario");
	            	 System.out.println("Indique el id del usuario:");
	                 int id= sc.nextInt();
	                 
	                 
					System.out.println("¿Quiere modificar el nombre, los apellidos, el nombre de usuario, la contraseña o el correo? ");
				    
				    
				    sc.nextLine();
				    
				    String res= sc.nextLine();
				    
				    System.out.println("Introduzca el dato nuevo:");
				    String datoN= sc.nextLine();
                   
				

                    try {
                    	
                       

                        //Llamamos a la función 
                        modificaUsuario(id, res,  datoN);
                        
                    } catch (Exception e) {
                        
                        System.err.println("Ha ocurrido un error:"+e);
			 
	                }	
	                
	                break;
					
				}
	            //opción de listar datos
	            case 4: {
	                sc.nextLine();
	                System.out.println("Lista de usuarios:");
	                
	                try {
                        //Llamar a la función de listar usuarios.
                       //ListarDatos.listaUsuarios();
                       
                   } catch (Exception e) {
                       System.err.println("Ha ocurrido un error.");
                   }
                   break;
	            }
	            //opción de borrar datos
	            case 5: {
	                sc.nextLine();
	                System.out.println("Va a borrar un usuario");
                    System.out.println("Indique el usuario a borrar:");
                    int id= sc.nextInt();

                    try {
                        borraUsuario(id);
                        
                    } catch (Exception e) {
                        System.err.println("Ha ocurrido un error.");
                    }                   

	                break;
	            }
	            //opción de salir del CRUD
	            case 6: {
	               
	                // salir
					System.out.println("Ha salido del programa y la base de datos se ha cerrado.");
					
	                break;
	            }
				default: {

					System.err.println("Opción introducida incorrecta");
	                break;
				}
				}
				
				System.out.println();

			} while (opcion != 6);

	        //Cerramos el escáner.
	        sc.close();
	        
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
}
