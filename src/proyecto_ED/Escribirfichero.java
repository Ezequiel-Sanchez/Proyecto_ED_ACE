package proyecto_ED;

import java.io.*;

public class Escribirfichero {
	Utiles util = new Utiles();

	public void escritura(String entrada, String ruta) {
		BufferedWriter bw;
		String directorio = "";
		
		try {
			
			for (int i = 0; i < ruta.lastIndexOf('\\'); i++) {
				directorio += ruta.charAt(i);
			}
			File dir = new File(directorio);
			dir.mkdirs();
			bw = new BufferedWriter(new FileWriter(ruta, true));
			bw.write(entrada);
			bw.close();

		} catch (IOException ex) {
			util.setError("¡¡ATENCION!! error I/O (verifica que no estas usando caracteres especiales y/o que no estas tratando de crear el archivo directamente en la raiz");
		
		} catch (Exception ex) {
			util.setError("¡¡ATENCION!! error desconocido (buscar el log file en c:\\errorlog\\java\\log.txt)");
			File dir = new File("c:\\errorlog\\java");
			dir.mkdirs();
			
			try {
				bw = new BufferedWriter(new FileWriter("c:\\errorlog\\java\\log.txt", true));
				bw.write("la fecha y hora \n" + ex.toString() + "\n");
				bw.close();
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}