package ficheroAleatorio.ejercicio01;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EjercicioJavi {

    public static void main(String[] args) {
		try {



			RandomAccessFile filea = new RandomAccessFile("A", "rw");
			RandomAccessFile fileaaaa = new RandomAccessFile("Apor5", "rw");
			
			filea.seek(0);
			String linea = filea.readLine();
			filea.close();
			for (int i = 0; i < 5; i++) {
				fileaaaa.writeChars(linea);
				System.out.println("Letra a escrita");
			}
			fileaaaa.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
}
