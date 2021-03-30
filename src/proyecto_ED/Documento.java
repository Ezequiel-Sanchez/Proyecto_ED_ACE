package proyecto_ED;

import java.util.ArrayList;

public class Documento {
	private ArrayList<Linea> lineas;
	Utiles util = new Utiles();
	public Documento(){
		lineas = new ArrayList<Linea>();
	}

	public void nuevaLinea(String texto) {
		Linea lineaNueva= new Linea();
		if (lineas.size()>0) {
			lineaNueva.setLineaNum(lineas.get(lineas.size()-1).getLineaNum()+1);
		}else {
			lineaNueva.setLineaNum(1);
		}
		lineaNueva.setLineaTxt(texto);
		lineas.add(lineaNueva);
	}
	
	public String getLinea(int numero) {
		return lineas.get(numero).getLineaTxt();
	}
	
	public void delLinea(int numero) {
		lineas.remove(numero-1);
		for (int i=0; i<lineas.size();i++) {
			lineas.get(i).setLineaNum(i+1);
		}
	}
	
	public void repLinea(int numero,String txt) {
		lineas.get(numero-1).setLineaTxt(txt);;
		for (int i=0; i<lineas.size();i++) {
			lineas.get(i).setLineaNum(i+1);
		}
	}
	
	public void delDoc() {
		lineas.clear();
	}
	
	public int getSize() {
//		System.out.println("and "+lineas.size());
		return lineas.size();
	}

//	@Override
//	public String toString() {
//		return "Documento [lineas=" + lineas + "]";
//	}
	
	public ArrayList<Linea> getDoc(){
		ArrayList<Linea>documento=new ArrayList<Linea>();
		for (Linea doc:lineas) {
			documento.add(doc);
		}
		return documento;
	}

	public void saveFile(String ruta) {
		for (Linea doc:lineas) {
//			fw.escribirArchivo(doc.getLineaTxt(),ruta+".txt");
			util.fileWriter(doc.getLineaTxt()+"\n", ruta+".txt");
		}
		
	}
	
	public void readFile() {
//		for (Linea doc:lineas) {
//			fw.escribirArchivo(doc.getLineaTxt());
//		}
	}
}
