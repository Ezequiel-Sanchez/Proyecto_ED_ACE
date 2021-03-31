package proyecto_ED;

import java.util.Scanner;

public class Teclado {
	private char n[] = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	private Scanner ent;
	private boolean error;
	private int num;
	private String cadena;

	public Teclado() {
		ent = new Scanner(System.in);
		error = false;
	}

	public int getEntero(String mensaje) { // ENTERO -------------------------------------------------ENTERO
		do {
			reset(mensaje);
			try {
				num = ent.nextInt();
			} catch (Exception e) {
				error();
			}
		} while (error);
		return num;
	}// --------------------------------------------------------------------------------------------------------------------------------------------

	public int getOpcion(int min, int max) { // GET OPCIONES ---------------------------------- GET OPCIONES
		num = getEntero("> Usa el teclado numerico para ingresar el numero correspondiente a la opcion deseada..");
		if (num < min) {
			num = 0;
		}
		if (num > max) {
			num = 0;
		}
		return num;
	}// --------------------------------------------------------------------------------------------------------------------------------------------

	public String getString(String mensaje) { // STRING --------------------------------------------- STRING
		reset(mensaje);
		cadena = ent.nextLine();
		return cadena;
	}// --------------------------------------------------------------------------------------------------------------------------------------------

	public int getNum(String numeros) { // COMPONER UN NUMERO
		boolean ok = false;
		num = 0;
		for (int contador = 0; contador < numeros.length(); contador++) {
			ok = false;
			for (int i = 0; i < n.length; i++) {
				if (numeros.charAt(contador) == n[i]) {
					num = i + (num * 10);
					ok = true;
				}
			}
			if (!ok) {
				contador = cadena.length();
				error = true;
				break;
			}
		}
		return num;
	}

	private void reset(String mensaje) {
		ent = new Scanner(System.in);
		error = false;
		System.out.println(mensaje);
	}

	private void error() {
		error = true;
		System.out.println("Entrada invalida..");
	}

}