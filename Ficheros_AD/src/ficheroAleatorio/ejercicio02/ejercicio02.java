package ficheroAleatorio.ejercicio02;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Aumenta el documento de lectura hasta la letra "e" 
 * en líneas diferentes (a, b, c, d, e) y crea un 
 * método que las escriba en otro de forma inversa. 
 * Sin usar ARRAYS ni BUFFER.
 */
public class ejercicio02 {
    
    public static void main(String[] args) {
        
        //Accedemos al fichero.
        try {

            File lectura=  new File ("Ficheros_AD/src/ficheroAleatorio/ejercicio02/lectura.txt");
            RandomAccessFile ficheroLectura= new RandomAccessFile (lectura, "r");

            String linea="";
            String aux="";

            //Colocamos el puntero en el principio del fichero.
            ficheroLectura.seek(0);

              //Abrimos un fichero de escritura
            File escritura= new File("Ficheros_AD/src/ficheroAleatorio/ejercicio02/escritura.txt");
            RandomAccessFile ficheroEscritura= new RandomAccessFile(escritura, "rw");
            
            //nos situamos al final del fichero.
            ficheroEscritura.seek(ficheroEscritura.length());

            //leemos la primera linea.
            linea=ficheroLectura.readLine();

            //Recorremos el fichero.
            while (linea!=null){

                aux+=linea;
                //Pasamos a la siguiente línea
                 linea=ficheroLectura.readLine();    
            }

            //cerramos el fichero.
            ficheroLectura.close();

            //Llamamos al método escribefichero.
            escribeFichero(aux, ficheroEscritura);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

   

    }

    /**
     * Función que escribe de forma inversa en un fichero.
     * @param linea
     */

     private static void escribeFichero(String aux, RandomAccessFile ficheroEscritura){

        //Escribimos en el fichero.
        try {

            char reverse;
            String invertido="";
            //Recorremos el aux del reves.
            for (int i=aux.length()-1; i>=0; i--){


                     reverse= aux.charAt(i);

                    //Casteamos a string.
                    invertido=""+reverse;

                

                 System.out.println(invertido);
              
               //Escribimos el reverse en el fichero.
               ficheroEscritura.writeChars(invertido+"\n");

            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


     }
 
}
