package proyecto_ED;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leerfichero {


	public static void main(String[] args) throws Exception {
	

	
		
		File dir =new File("D:\\00Usuarios\\Admin\\Desktop\\ficheros");
	
	
		for(File fichero : dir.listFiles()) {	
		if(! fichero.isDirectory()) {
			String linea="";	
			System.out.println("Leyendo..."+fichero);
			BufferedReader br =new BufferedReader(new FileReader(fichero));
			
			linea = br.readLine();
			while(linea!=null) {
				System.out.println("\t" + linea);
				linea = br.readLine();
				break;
				}
			}
		}
		
	}
		public static void LeerFichero(File fichero) throws IOException {
			
			BufferedReader br = new BufferedReader(new FileReader(fichero));
			String linea = br.readLine();
			
			while(linea !=null) {
				System.out.println(linea);
				linea = br.readLine();
			}
			
		}
	}
 

	


