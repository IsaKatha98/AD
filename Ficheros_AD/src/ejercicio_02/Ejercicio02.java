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
			   String nomCarpeta;
			  
			  
			  //Nos creamos un búfer que lea el fichero carpetas.
			    
			    BufferedReader  br= new BufferedReader (new FileReader("../ejercicio_02/carpetas.txt"));
			    String linea;
			    
			    
			    //lee la primera línea
			    linea=br.readLine();
			    
			  //Guardamos la linea separada en una variable array.
		    	String [] datos= linea.split("/");
		    	
		    	//Guardamos el valor de la última posición.
		    	String dato=datos[datos.length-1];
		    	
		    	nomCarpeta=dato;
		    	
		    	directorio = directorioOG+"/"+datos[0];
	    		
		    	//Llamamos a la función del html.
			    creaHTML(directorio, nomCarpeta);
			    
			  //Pasamos a la siguiente línea.
		    	linea= br.readLine();
			     
			    while (linea!=null) {

			    	//Guardamos la linea separada en una variable array.
			    	datos= linea.split("/");
			    			    	
			    	//Guardamos el valor de la última posición.
			    	dato=datos[datos.length-1];
			    	
			    	directorio = directorioOG+"/"+linea;
		    		
			    	if (datos.length==2) {
			    		nomCarpeta=dato;
			    		
				    	//Llamamos a la función del html.
					    creaHTML(directorio, nomCarpeta);
					    
			    		//Machacamos la ubicación
			    		directorio=directorioOG;
			    	
			    	} else if (datos.length==3) {
			    		
			    		nomCarpeta=dato;
			    		
			
			    		
			    		//Llamamos a la función del html.
					    creaHTML(directorio, nomCarpeta);
					    
			    		//Machacamos la ubicación
			    		directorio=directorioOG;
			    		
			    	}
			    	
			    	//Pasamos a la siguiente línea.
			    	linea= br.readLine();
			    }

			
			}catch (Exception e){

			      System.err.println("Error: " + e.getMessage());

			}

	}
	
	/**
	 * Método que crea los html.
	 * 
	 * @param directorio la ruta en la que sea crea el html.
	 * @param nomCarpeta el nombre que va a tener de titulo el html
	 */
	
	public static void creaHTML (String directorio, String nomCarpeta) {
		
		//Variables
		String html=".html";
		File fichero= new File(directorio,nomCarpeta+html);
		String autor="Isabel Katharina Loerzer";
		
		try {
			
			//Creamos el archivo html.
			if(fichero.createNewFile()) {
			
			//BufferedWriter: escribe en el fichero que nos hemos creado.
			BufferedWriter bw= new BufferedWriter (new FileWriter(fichero));
			
				//Escribimos lo que sea
				
				bw.write("<html>");
				bw.newLine();
				
				bw.write("<head>");
				bw.newLine();
				
				bw.write("<title>"+nomCarpeta+"</title>");
				bw.newLine();
				
				bw.write("</head>");
				bw.newLine();
				
				bw.write("<body>");
				bw.newLine();
				
				bw.write("<h1>Ruta: "+directorio+"; Nombre: "+nomCarpeta+"</h1>");
				bw.newLine();
				
				bw.write( "<h3>Autor: "+autor+"</h3>");
				bw.newLine();
				
				bw.write("</body>");
				bw.newLine();
				
				bw.write("</html>");
				bw.newLine();
				
				//Guardamos
				bw.flush();
				
			}
			
			
				
		} catch (IOException e) {
			System.err.println("Error: " + e.getMessage());
		}
			
	}

}
