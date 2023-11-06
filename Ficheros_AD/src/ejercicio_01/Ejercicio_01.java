package ejercicio_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Ejercicio_01 {

	public static void main(String[] args) {
	
		try {

			// Declaración de variables

			   String directorioOG = "C:\\Users/ikloerzer";
			   String directorio;

			      			       
			  //Nos creamos un búfer que lea el fichero carpetas.
			    
			    BufferedReader  br= new BufferedReader (new FileReader("C:\\Users\\ikloerzer\\Documents\\GitHub\\AD\\Ficheros_AD\\src\\ejercicio_01\\carpetas.txt"));
			    String linea;
			    
			    //lee la primera línea
			    linea=br.readLine();
			    
			    new File(directorioOG,linea).mkdir();
			    
			    
			    while (linea!=null) {
			    	
			    	//Guardamos la linea separada en una variable array.
			    	String [] datos= linea.split("/");
			    	
			    	//Guardamos el valor de la última posición.
			    	String dato=datos[datos.length-1];
			    	
		
			    	if (datos.length==2) {
			    		
			    		directorio = directorioOG+"/"+datos[0];
			    		new File (directorio, dato).mkdir();
			    		
			    		//Machacamos la ubicación
			    		directorio=directorioOG;
			    	
			    	} else if (datos.length==3) {
			    		
			    		directorio = directorioOG+"/"+datos[0]+"/"+datos[1];
			    		new File (directorio, dato).mkdir();
			    		
			    	}
			    	
			    	//Pasamos a la siguiente línea.
			    	linea= br.readLine();
			    }

			
			}catch (Exception e){

			      System.err.println("Error: " + e.getMessage());

			}

	}

}
