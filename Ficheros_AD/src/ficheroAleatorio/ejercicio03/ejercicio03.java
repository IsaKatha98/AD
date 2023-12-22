package ficheroAleatorio.ejercicio03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * Añade un número a cada letra (a1, b2, c3, d4, e5) y realiza la misma 
 * operación anterior. Debe quedar e5 d4 c3 b2 a1.
 */
public class ejercicio03 {

    public static void main(String[] args) {
        
        //Accedemos al fichero.
        try {

            RandomAccessFile ficheroLectura= new RandomAccessFile ("src/ficheroAleatorio/ejercicio03/lectura.txt", "r");

            RandomAccessFile ficheroEscritura= new RandomAccessFile("escritura", "rw");
            
            String caracteres;
           for (int i=(int)ficheroLectura.length()-1; i>=0; i-=4){

            ficheroLectura.seek(i);
            caracteres=ficheroLectura.readLine();
            ficheroEscritura.writeChars(caracteres+"\n");
          }

            //cerramos el fichero.
            ficheroLectura.close();
            ficheroEscritura.close();

        
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     }
    
}
