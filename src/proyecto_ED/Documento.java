package proyecto_ED;

import java.util.ArrayList;

public class Documento {
	private ArrayList<Linea> lineas;
	Utiles util = new Utiles();
	Escritura fw=new Escritura();
	Leerfichero fr=new Leerfichero();
	String linea ="", aux="", print="";

	public Documento() {
		lineas = new ArrayList<Linea>();
	}

	public void nuevaLinea(String texto) {
		Linea lineaNueva = new Linea();
		if (lineas.size() > 0) {
			lineaNueva.setLineaNum(lineas.get(lineas.size() - 1).getLineaNum() + 1);
		} else {
			lineaNueva.setLineaNum(1);
		}
		linea = aux+texto;
		aux="";
		if (linea.length() > 150) {
			for (int i = 0; i < linea.length(); i++) {
				if (i < 150) {
					print += linea.charAt(i);
				} else {
					aux += linea.charAt(i);
				}
			}
			aux+=" ";
			lineaNueva.setLineaTxt(print);
			print="";
		}else {
		lineaNueva.setLineaTxt(linea);
		linea="";
		}
		lineas.add(lineaNueva);
	}

	public String getLinea(int numero) {
		return lineas.get(numero).getLineaTxt();
	}

	public void delLinea(int numero) {
		lineas.remove(numero - 1);
		for (int i = 0; i < lineas.size(); i++) {
			lineas.get(i).setLineaNum(i + 1);
		}
	}

	public void repLinea(int numero, String txt) {
		lineas.get(numero - 1).setLineaTxt(txt);
		;
		for (int i = 0; i < lineas.size(); i++) {
			lineas.get(i).setLineaNum(i + 1);
		}
	}

	public void delDoc() {
		lineas.clear();
	}

	public int getSize() {
		return lineas.size();
	}

	public ArrayList<Linea> getDoc() {
		ArrayList<Linea> documento = new ArrayList<Linea>();
		for (Linea doc : lineas) {
			documento.add(doc);
		}
		return documento;
	}

	public void saveFile(String ruta) {
		for (Linea doc : lineas) {
			fw.escritura(doc.getLineaTxt() + "\n", ruta);
		}

	}

	public void readFile(String ruta) {
		String array[]=null;
		String doc="";
		Linea ln;
//		for (Linea doc:lineas) {
//			fw.escribirArchivo(doc.getLineaTxt());
//		}
		doc=fr.lectura(ruta);
//		for (int i =0; i<doc.length();i++) {
//				if (i+25<doc.length()) {
//					i+=25;
//					doc.replaceFirst(doc.charAt(i)+doc.charAt(i+1), (doc.charAt(i)+";"));			
//				}
//		}
		array = doc.split(";");
		for (String linea:array) {
		ln = new Linea();
		if (lineas.size() > 0) {
			ln.setLineaNum(lineas.get(lineas.size() - 1).getLineaNum() + 1);
		} else {
			ln.setLineaNum(1);
		}
		ln.setLineaTxt(linea);
		lineas.add(ln);
		
		}
	}

	public String getAux() {
		return aux;
	}
}
