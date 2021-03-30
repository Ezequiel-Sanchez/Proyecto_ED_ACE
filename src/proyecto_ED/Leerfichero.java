package proyecto_ED;

import java.io.*;

public class Leerfichero {
	Utiles util = new Utiles();

	public String lectura(String fichero) {
		BufferedWriter bw;
		BufferedReader br;
		String linea = "", aux = "", print = "";
		try {
			br = new BufferedReader(new FileReader(fichero));
			while (br.ready()) {

				linea += aux + br.readLine();
				aux="";
				if (linea.length() > 150) {
					for (int i = 0; i < linea.length(); i++) {
						if (i < 150) {
							print += linea.charAt(i);
						} else {
							aux += linea.charAt(i);
						}
					}
					aux+=";";
				} else {
					print += linea;
				}
				
				print += ";";
				linea="";
			}
			br.close();
		} catch (IOException ex) {
			util.setError(
					"¡¡ATENCION!! El sistema no puede encontrar el archivo especificado (verifica la ruta y escribe el nombre del fichero sin la extensión)");
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
		return print;
	}
}
