package ficheroAleatorio.ejercicio01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


/*
	 * 1)Crea un documento de texto con una única letra "a" que será leído de forma
	 * aleatoria (seek) y escrito 5 veces en otro documento también de forma
	 * aleatoria (seek).
	 */

public class Ejercicio01 {
	
	  public static void main(String[] args) {
		  
		  /*Guardamos el fichero.
		  File fichero=new File("C:\\Users\\ikloerzer\\Documents\\GitHub\\AD\\Ficheros_AD\\src\\ficheroAleatorio\\A");
		  File ficheroEscritura= new File ("C:\\Users\\ikloerzer\\Documents\\GitHub\\AD\\Ficheros_AD\\src\\ficheroAleatorio\\Apor5")
		  */

		  

		  try {
			File lectura= new File ("Ficheros_AD/src/ficheroAleatorio/ejercicio01/A");
			File escritura= new File("Ficheros_AD/src/ficheroAleatorio/ejercicio01/Apor5");
			  
			//Declaramos el fichero de acceso aleatorio.
			//Será "rw" porque se abre en modo lectura y escritura
			RandomAccessFile ficheroLectura= new RandomAccessFile (lectura, "r");
			RandomAccessFile ficheroEscritura= new RandomAccessFile (escritura, "rw");
		
			//Colocamos el puntero al principio del fichero, con seek.
			//la posición 0 indica que es al principio del fichero.
			ficheroLectura.seek(0);

			//Leemos el fichero y lo guardamos en la variable linea.
			String linea=ficheroLectura.readLine();
			System.out.println(linea);

			//Cerramos el fichero.
			ficheroLectura.close();

			//Colocamos el punteroa al principio del otro fichero.
			ficheroEscritura.seek(0);

			//Hago un for que escribe en el fichero.
			for (int i=0; i<=5;i++) {
				
				ficheroEscritura.writeChars(linea+"\n");
				
			}

			//cerramos el fichero.
			ficheroEscritura.close();
		  
		  } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }

}
