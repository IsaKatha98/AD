


import java.sql.SQLException;
import java.util.Scanner;

public class App {
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
            
            //TODO: el usuario debe poder crear tablas.
            case 1:{

                try{

                    //llamamos a la función de crear tablas.
                    CrearTablas.crear();

                } catch (SQLException e) {
                    e.getMessage();
                }
                break;
            }
			
			
			case 2: {
				sc.nextLine();
				System.out.println("Indique tipo de dato quiere insertar o si quiere dar like:");
                var data= sc.nextLine();

                switch (data) {

                    case "usuario": {
                        System.out.println("Introduzca el nombre: ");
                        String nombre= sc.nextLine();
                        System.out.println("Introduzca los apellidos: ");
                        String apellidos= sc.nextLine();
                        System.out.println("Nombre de usuario:");
                        String userName= sc.nextLine();
                        System.out.println("La contraseña: ");
                        String password= sc.nextLine();
                        System.out.println("Email: ");
                        String email= sc.nextLine(); //TODO: tenemos que comprobar que es un correo???

                    try{
                        //Llamamos a la función.
                        boolean userCreado= InsertarDatos.insertaUsuarios(nombre, apellidos, userName, password, email);

                        if (userCreado) {
                            System.out.println("Se ha creado el usuario: "+ userName);
                        
                        } else {
                            System.out.println("No se ha podido crear el usuario.");
                        }
                    } catch (Exception ex) {
                        System.err.println("Ha ocurrido un error.");
                    }

                    break;
                    }

                    case "post": {

                        System.out.println("Introduzca el nombre del usuario: ");
                        String userName= sc.nextLine();

                        try{
                        //Llamamos a la función.
                        boolean postCreado=InsertarDatos.insertaPost(userName);

                        if (postCreado) {
                            System.out.println("Se ha creado el post.");
                        
                        } else {
                            System.out.println("No se ha podido crear post.");
                        }
                    } catch (Exception ex) {
                        System.err.println("Ha ocurrido un error.");
                    }
                    break;

                    }

                    case "dar like": {

                        System.out.println("Introduzca el nombre del usuario: ");
                        String nombre= sc.nextLine();
                        System.out.println("Introduzca el id del post: ");
                        int idPost= sc.nextInt();
                       
                        try{
                        //Llamamos a la función.
                        boolean mg=InsertarDatos.darLike(nombre, idPost);

                        if (mg) {
                            System.out.println("Se ha dado mg.");
                        
                        } else {
                            System.out.println("No se ha dado mg.");
                        }

                    } catch (Exception ex) {
                        System.err.println("Ha ocurrido un error.");
                    }
                    }  
                    break; 
                }

                break;
			}

			case 3: {
				
				sc.nextLine();
				System.out.println("Introduzca si quiere modificar un usuario o un post:");
				String respuesta= sc.nextLine();
				
                if (respuesta.equalsIgnoreCase("usuario")) {
					
				    System.out.println("¿Quiere modificar el nombre, los apellidos, el nombre de usuario, la contraseña o el correo? ");
				    String res= sc.nextLine();
                    sc.nextLine();
				    System.out.println("Introduzca el dato original:");
				    String datoOG= sc.nextLine();
                    //TDOO.aquí hay que comprobar que el dato existe.
                    sc.nextLine();
				    System.out.println("Introduzca el dato nuevo:");
				    String datoN= sc.nextLine();

                    try {

                        //Llamamos a la función 
                        ModificarDatos.modificaUsuario(res, datoOG, datoN);
                        
                    } catch (Exception e) {
                        
                        System.err.println("Ha ocurrido un error.");
                    }
				} else if (respuesta.equalsIgnoreCase("post")) {

                    sc.nextLine();
				    System.out.println("Introduzca el post que quiere modificar");
				    int idPost= sc.nextInt();

                    sc.nextLine();
				    System.out.println("Introduzca el nuevo user:");
				    String userName= sc.nextLine();

                    try {

                        //Llamamos a la función 
                        ModificarDatos.modificaPost(idPost, userName);
                        
                    } catch (Exception e) {
                        
                        System.err.println("Ha ocurrido un error.");
                    }
                }	
                
                break;
				
			}

            case 4: {
                sc.nextLine();
                System.out.println("Introduzca la tabla a listar:");
				String respuesta= sc.nextLine();

                switch (respuesta) {
                    case "usuarios": {
                        
                        try {
                             //Llamar a la función de listar usuarios.
                            ListarDatos.listaUsuarios();
                            
                        } catch (Exception e) {
                            System.err.println("Ha ocurrido un error.");
                        }
                        
                    }
                    case "posts": {

                        try {
                            

                           //Llamar a la función de listar posts.
                            ListarDatos.listaPosts();
                           
                       } catch (Exception e) {
                           System.err.println("Ha ocurrido un error.");
                       }
                        
                    }

                    case "likes": {

                        try {
                             //Llamar a la función de listar likes.
                            ListarDatos.listaLikes();
                           
                       } catch (Exception e) {
                           System.err.println("Ha ocurrido un error.");
                       }
                      
                    }                      
                }

                break;

            }

            case 5: {
                sc.nextLine();
                System.out.println("Introduzca el dato a borrar:");
				String respuesta= sc.nextLine();

                switch (respuesta) {
                    case "usuario": {
                        sc.nextLine();
                        System.out.println("Indique el user a borrar:");
                        String userName= sc.nextLine();

                        try {
                            BorrarDatos.borraUsuario(userName);
                            
                        } catch (Exception e) {
                            System.err.println("Ha ocurrido un error.");
                        }

                        
                       
                    }
                    case "post": {
                        sc.nextLine();
                        System.out.println("Indique el id del post a borrar:");
                        int idPost= sc.nextInt();

                        try {
                            BorrarDatos.borraPost(idPost);
                            
                        } catch (Exception e) {
                            System.err.println("Ha ocurrido un error.");
                        }

                    }

                    case "like": {
                      
                        sc.nextLine();
                        System.out.println("Indique el id del post:");
                        int idPost= sc.nextInt();
                        sc.nextLine();
                        System.out.println("Indique el user:");
                        String userName= sc.nextLine();

                        try {
                            BorrarDatos.borraLike(idPost, userName);
                            
                        } catch (Exception e) {
                            System.err.println("Ha ocurrido un error.");
                        }                      
                    }                      
                }

                break;
            }

            case 6: {
               
                // salir
				System.out.println("Ha salido del programa.");
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

    }
