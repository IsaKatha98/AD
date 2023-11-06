package ejercicio_02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class Ejercicio02 {

	public static void main(String[] args) {
		
		try {

			// Declaración de variables

			   String directorioOG = "C:\\Users/ikloerzer";
			   String directorio;
			  
			  
			  //Nos creamos un búfer que lea el fichero carpetas.
			    
			    BufferedReader  br= new BufferedReader (new FileReader("C:\\Users\\ikloerzer\\Documents\\GitHub\\AD\\Ficheros_AD\\src\\ejercicio_02\\carpetas.txt"));
			    String linea;
			    
			    //lee la primera línea
			    linea=br.readLine();
			    
			     
			    while (linea!=null) {

			    	//Guardamos la linea separada en una variable array.
			    	String [] datos= linea.split("/");
			    	
			    	//Guardamos el valor de la última posición.
			    	String dato=datos[datos.length-1];
			    	
			    	if (datos.length==2) {
			    		
			    		directorio = directorioOG+"/"+datos[0];
			    		
			        	
			    		
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
	
	public static void creaHTML (String directorio) {
		
		//Variables
		File fichero= new File(directorio);
		String autor="Isabel Katharina Loerzer";
		String title="index";
		
		try {
			
			//Creamos el archivo html.
			fichero.createNewFile();
			
			//BufferedWriter: escribe en el fichero que nos hemos creado.
			BufferedWriter bw= new BufferedWriter (new FileWriter(fichero));
			
			//Escribimos lo que sea
			
			bw.write("<html>");
			bw.newLine();
			
			bw.write("<head>");
			bw.newLine();
			
			bw.write("<title>"+title+"</title>");
			bw.newLine();
			
			bw.write("</head>");
			bw.newLine();
			
			bw.write("<body>");
			bw.newLine();
			
			bw.write("<h1>Ruta: "+directorio+"; Nombre: "+title+"</h1>");
			bw.newLine();
			
			bw.write( "<h3>Autor: "+autor+"/h3>");
			bw.newLine();
			
			bw.write("</body>");
			bw.newLine();
			
			bw.write("</html>");
			bw.newLine();
			
			//Guardamos
			bw.flush();
				
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
		
		
		
		
		
		
	}

}
