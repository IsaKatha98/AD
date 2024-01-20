import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        String conn= Conection.establishConection();

        System.out.println(conn);

        //Aquí empieza el crud
        // Creamos un escáner y los búferes necesarios.
		Scanner sc = new Scanner(System.in);
		
		//Creamos las variables necesarias.
		int opcion;
        String nombreTabla;

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

			case 1: {
				
				//Pedimos los datos.
				sc.nextLine();

                //Llamamos a la función que establece la conexión.
                Conection.establishConection();
            }
            
            //TODO: el usuario debe poder crear tablas.
            case 2:{

                    //llamamos a la función de crear tablas.
            }
			
			
			case 3: {
				
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

                        //Llamamos a la función.
                        boolean userCreado= InsertarDatos.insertaUsuarios(nombre, apellidos, userName, password, email);

                        if (userCreado) {
                            System.out.println("Se ha creado el usuario: "+ userName);
                        
                        } else {
                            System.out.println("No se ha podido crear el usuario.");
                        }

                    }

                    case "post": {

                        //TODO: pedimos el nombre y buscamos en la lista el idUsuario asociado o cómo????
                        System.out.println("Introduzca el nombre del usuario: ");
                        String nombre= sc.nextLine();

                        //Llamamos a la función.
                        boolean postCreado=InsertarDatos.insertaPost(nombre);

                        if (postCreado) {
                            System.out.println("Se ha creado el post.");
                        
                        } else {
                            System.out.println("No se ha podido crear post.");
                        }

                    }

                    case "dar like": {

                        System.out.println("Introduzca el nombre del usuario: ");
                        String nombre= sc.nextLine();
                        System.out.println("Introduzca el id del post: ");
                        int idPost= sc.nextInt();
                       

                        //Llamamos a la función.
                        boolean mg=InsertarDatos.darLike(nombre, idPost);

                        if (mg) {
                            System.out.println("Se ha dado mg.");
                        
                        } else {
                            System.out.println("No se ha dado mg.");
                        }
                    }

                
    
                }
			}

			case 4-> {
				
				sc.nextLine();
				System.out.println("¿Quiere guardar la agenda?");
				respuesta= sc.nextLine();
				
				if (respuesta.equalsIgnoreCase("si")) {
					
					//Llamamos a la función de guardar.
					Utils.guardar();
					
				}
				
				// salir
				System.out.println("Ha salido del programa.");
				
			}

			default -> {

				System.err.println("Opción introducida incorrecta");
			}
			}
			
			System.out.println();

		} while (opcion != 4);

	}
    }
}
