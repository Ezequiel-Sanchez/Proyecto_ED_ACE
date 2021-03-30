package proyecto_ED;

import java.io.*;

public class Escritura {

	public static void Escritura(String entrada, String ruta) {
		try {
			
			BufferedWriter bw= new BufferedWriter(new FileWriter(ruta,true));
			
			bw.write(entrada);
			bw.close();
			
		} catch (FileNotFoundException ex) {
			System.out.println("Fichero no encontrado");
		} catch (IOException ex) {
			System.out.println("IOException");
		}catch(Exception ex) {
			System.out.println("Error");
		}
	}
}
