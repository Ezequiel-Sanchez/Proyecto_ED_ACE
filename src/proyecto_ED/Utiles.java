package proyecto_ED;

public class Utiles {
	static String opciones[] = new String[5];
	static String status[] = new String[4];
	Main main = new Main();

	public void cls() {
		System.out.print("\n\n\n\n\n\n\n\n\n\n" + "\n\n\n\n\n\n\n\n\n\n" + "\n\n\n\n\n\n\n\n\n\n"
				+ "\n\n\n\n\n\n\n\n\n\n" + "\n\n\n\n\n\n\n\n\n\n");
	}

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

	public void errorCls() {
		status[3] = "";
	}

	public void setError(String e) {
		status[3] = e;
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
		Main.getContenido();
		System.out.println(
				"+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		getStatus();
		System.out.println(
				"+---------------------------------------------------------------------------------------------------------------------------------------------------------------+");
		errorCls();
	}

}