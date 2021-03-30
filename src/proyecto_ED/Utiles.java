package proyecto_ED;

import java.io.*;

public class Utiles {
	static String opciones[] = new String[5];
	static String status[] = new String[4];
//	Documento doc = new Documento(); //test
	Main eme = new Main();
	
	
	public void cls() {
		System.out.print("\n\n\n\n\n\n\n\n\n\n" + "\n\n\n\n\n\n\n\n\n\n" + "\n\n\n\n\n\n\n\n\n\n"
				+ "\n\n\n\n\n\n\n\n\n\n" + "\n\n\n\n\n\n\n\n\n\n");
	}

//	public void getContenido() { //test
//		String printlinea="";
//				System.out.println(doc.getSize());
//		for (int i =0; i <doc.getSize();i++) {
//			System.out.println("|"+i+"\t"+doc.getLinea(i));
//			printlinea="|"+(i+1)+"\t"+doc.getLinea(i);
//			for (int j =0;j<(160-doc.getSize());j++) {
//				printlinea+=" ";
//			}
//			printlinea+="|";
//			System.out.println(printlinea);
//		}
//	}

	public void setOpciones(String op1, String op2, String op3, String op4, String op5) {
		opciones[0] = op1;
		opciones[1] = op2;
		opciones[2] = op3;
		opciones[3] = op4;
		opciones[4] = op5;
	}

	public static void getOpciones() {
		for (int i = 0; i < opciones.length; i++) {
			if (opciones[i].isEmpty()) {
			} else {
				opciones[i] = "| -" + (i + 1) + ". " + opciones[i];
				int largo = opciones[i].length();
				for (int j = 0; j < (160 - largo); j++) {
					opciones[i] += " ";
				}
				opciones[i] += "|";
				System.out.println(opciones[i]);
			}
		}
	}

	public void errorCls(){
		status[3] = "";
	}

	public void setStatus(String st1, String st2, String st3) {
		status[0] = st1;
		status[1] = st2;
		status[2] = st3;
	}

	public static void getStatus() {
		String printstat = "";
		for (int i = 0; i < status.length; i++) {
			if (status[i].isEmpty()) {
			} else {
				printstat = "|" + status[i];
				for (int j = 0; j < (159 - status[i].length()); j++) {
					printstat += " ";
				}
				printstat += "|";
				System.out.println(printstat);
			}
		}
	}

	public void getTitle(String title) {
		String titulo = "|";
		for (int i = 0; i < (160 - title.length()); i++) {
			if (titulo.length() == (160 - title.length()) / 2) {
				titulo += title;
			} else {
				titulo += " ";
			}
		}
		titulo += "|";
		System.out.println(titulo);
	}

	public void menu(String title) {
		cls();
		System.out.println(
				"+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		getTitle(title);
		System.out.println(
				"+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		getOpciones();
		System.out.println(
				"+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
//		+"\n  "+doc.getSize()+"\n"+doc.toString()); //test
		Main.getContenido();
		System.out.println(
				"+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		getStatus();
		System.out.println(
				"+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");

	}

	public String fileRead(String ruta) { // ------------------------------- devuelve una cadena String con todo el
											// contenido del fichero
		String texto = "", linea = "";
		try {
			FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr);
			int counter = 0;
			linea = br.readLine();
			while (linea != null) {
				counter += linea.split(" ").length;
				texto += linea + "\n";
				linea = br.readLine();

			}
			System.out.println("Fichero leido correctamente.. se han leido " + counter + " palabras. y contiene "
					+ texto.length() + " caracteres.");
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("404 file not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("I/O ERROR");
			e.printStackTrace();
		}
		return texto;
	}

	public void fileWriter(String entrada, String ruta) {
//		File dir = null;
//		FileWriter fw = null;
		BufferedWriter bw = null;
//		String linea="";
		try {
			String directorio = "";
			for(int i=0;i<ruta.lastIndexOf('\\');i++) {
				directorio += ruta.charAt(i);
			}
			File dir = new File(directorio);
			dir.mkdirs();
			bw = new BufferedWriter(new FileWriter(ruta, true));			//no se si me esta liando esto pero creo que no hace falta pq cargo todo el documento al array y luego al guardarlo se duplicaria
			bw.write(entrada);
			bw.close();

		} 	
		catch (IOException e) {
			status[3] = "　ATENCION!! Acceso denegado (verifica que no estas usando caracteres especiales y/o que no estas tratando de crear el archivo directamente en la raiz";
			
		} 
		catch (Exception e) {
			status[3] = "　ATENCION!! error desconocido (buscar el log file en c:\\errorlog\\java\\log.txt)";
			File dir = new File("c:\\errorlog\\java");
			dir.mkdirs();
				try {
					bw = new BufferedWriter(new FileWriter("c:\\errorlog\\java\\log.txt", true));
					bw.write("la fecha y hora \n"+e.toString()+"\n");
					bw.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			
		}
//		catch (Exception e) {
//			e.printStackTrace();
//			status[3] = "　ATENCION!! Ha ocurrido un error > .fileWriter > intentalo denuevo";
//			// podria meter aqui un mkdir y reintentar el guardado del archivo?
//		}

	}
	
	public String leerFichero(String fichero){
		
		BufferedReader br;
		String linea ="";
		try {
			br = new BufferedReader(new FileReader(fichero));
		while(br.ready()) {
			linea += br.readLine();
			linea +=";";
		}
		br.close();
	} 	catch (FileNotFoundException e) {
		e.printStackTrace();
		status[3] = "　ATENCION!! El sistema no puede encontrar la ruta especificada";
	} catch (IOException e) {
		e.printStackTrace();
		status[3] = "　ATENCION!! Ha ocurrido un error > .leerFichero > intentalo denuevo";
	}
		return linea;
	}

}
