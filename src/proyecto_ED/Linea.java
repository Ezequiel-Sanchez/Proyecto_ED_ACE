package proyecto_ED;

public class Linea {
	private int lineaNum;
	private String lineaTxt;

	public Linea() {
		lineaNum = 0;
		lineaTxt = "";
	}

	public Linea(int num, String txt) {
		lineaNum = num;
		lineaTxt = txt;
	}

	public int getLineaNum() {
		return lineaNum;
	}

	public void setLineaNum(int lineaNum) {
		this.lineaNum = lineaNum;
	}

	public String getLineaTxt() {
		return lineaTxt;
	}

	public void setLineaTxt(String lineaTxt) {
		this.lineaTxt = lineaTxt;
	}
}