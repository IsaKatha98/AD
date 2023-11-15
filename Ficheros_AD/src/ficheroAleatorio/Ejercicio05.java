package ficheroAleatorio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio05 {
	
	  public static void main(String[] args) {
		  
		  //Guardamos el fichero.
		  File fichero=new File("C:\\Users\\ikloerzer\\Documents\\GitHub\\AD\\Ficheros_AD\\src\\ficheroAleatorio\\A");
		  File ficheroEscritura= new File ("C:\\Users\\ikloerzer\\Documents\\GitHub\\AD\\Ficheros_AD\\src\\ficheroAleatorio\\Apor5")
		  
		  //Declaramos el fichero de acceso aleatorio.
		  try {
			  
			 //Será "rw" porque se abre en modo lectura y escritura
			RandomAccessFile ficheroAleatorio= new RandomAccessFile (fichero, "r");
			RandomAccessFile ficheroAleatorioEscritura= new RandomAccessFile (ficheroEscritura, "rw");
		
			//Hacemos un array de tipo char. 
			//Aquí se da el caso de que el tamaño es 0 pero sino sabemos cuál es, hay que
			//crearlo vacío.
			char letras[]=new char[0];
			int index=0;
			
			for (int i=0;i<letras.length;i++) {
				
				//Leemos y guardamos en el array.
				letras[i]=ficheroAleatorio.readChar();
			}
			
			//Hago un for que recorra el array y lo escriba en un fichero 
			//5 veces.
			for (int i=0; i<=5;i++) {
				
				//Recorremos el array.
				for (string letra: letras) {
					ficheroAleatorioEscritura.writeChars(null);;
				}
				
			}
		  
		  
		  
		  } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

}
