package ficheroSecuencial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio03 {

	public static void main(String[] args) {
		
	//Declaración de variables.
		
	//Creamos una variable para guardar la letra.
	char letra=' ';
	//Ficheros
	File archivo= new File ("palabras.txt");
	File nuevoArchivo= new File ("juego.txt");
	
	//Variable que guarda la palabra creada.
	String palabraCreada="";
	//Un contador de letras.
	int cont=0;
	//La línea que se lee.
	String linea="";
	

	try {
		
		//Nos creamos un bufer de lectura.
		BufferedReader  br= new BufferedReader (new FileReader("C:\\Users\\IsaK\\Documents\\GitHub\\AD\\Ficheros_AD\\src\\ficheroSecuencial\\palabras.txt"));
		
		//Creamos un búfer de escritura.
		BufferedWriter  bw= new BufferedWriter (new FileWriter("C:\\Users\\IsaK\\Documents\\GitHub\\AD\\Ficheros_AD\\src\\ficheroSecuencial\\juego.txt"));
	
		//Leemos la línea.
		linea=br.readLine();
		
		//Separamos la línea, con un bucle for.
		for (int i=0; i<linea.length(); i++) {
			
			//Guardamos letra por letra.
			letra=linea.charAt(i);
			
			//La metemos en el string, pasando el char a string
			palabraCreada=palabraCreada+(String.valueOf(letra));
			
			//Aumentamos 1 al contador.
			cont++;
			
			//En caso de que el contador llegue a 5.
			if (cont==5) {
				
				//Hacemos una salto de línea
				palabraCreada+="\n";
				
				//Seteamos el contador a 0.
				cont=0;
			
			}
		}
		
		System.out.println(palabraCreada);
	
		//Escribimos en el fichero la palabra.
		bw.write(palabraCreada);
		
		//Hacemos flush.
		bw.flush();
		
		
		//Cerramos todo.
		br.close();
		bw.close();
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
	
	
	}

}
