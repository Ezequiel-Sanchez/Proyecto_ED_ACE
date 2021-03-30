package proyecto_ED;

import java.util.Scanner;

public class Teclado {
	private char n[] = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
	private Scanner ent;
	private boolean error;
	private int num;
	private long l;
	private float f;
	private double d;
	private String cadena;

	public Teclado() {
		ent = new Scanner(System.in);
		error = false;
	}

	public long getLong(String mensaje) { // LONG ------------------------------------------------------LONG
		do {
			reset(mensaje);
			try {
				l = ent.nextLong();
			} catch (Exception e) {
				error();
			}
		} while (error);
		return l;
	}// --------------------------------------------------------------------------------------------------------------------------------------------

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

	public int getEnteroRango(int min, int max, String cosas) { // ENTERO RANGO --------------- ENTERO RANGO
		do {
			num = 0;
			error = false;
			getEntero("Por favor ingresa el numero de " + cosas + " (Minimo " + min + ", Maximo " + max + ")");
			if (num < min) {
				System.out.println("El valor ingresado es inferior al minimo permitido (Minimo " + min
						+ ", y tu has ingresado " + num + ")\n");
				error = true;
			}
			if (num > max) {
				System.out.println("El valor ingresado es superior al maximo permitido (Maximo " + max
						+ ", y tu has ingresado " + num + ")\n");
				error = true;
			}
		} while (error);
		return num;
	} // --------------------------------------------------------------------------------------------------------------------------------------------

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

	public double getDouble(String mensaje) { // DOUBLE --------------------------------------------- DOUBLE
		d = ent.nextDouble();
		do {
			reset(mensaje);
			try {
				d = ent.nextDouble();
			} catch (Exception e) {
				error();
			}
		} while (error);
		return d;
	}// --------------------------------------------------------------------------------------------------------------------------------------------

	public float getFloat(String mensaje) { // FLOAT ------------------------------------------------- FLOAT
		do {
			reset(mensaje);
			try {
				f = ent.nextFloat();
			} catch (Exception e) {
				error();
			}
		} while (error);
		return f;
	}// --------------------------------------------------------------------------------------------------------------------------------------------

	public String getString(String mensaje) { // STRING --------------------------------------------- STRING
		reset(mensaje);
		cadena = ent.nextLine();
		return cadena;
	}// --------------------------------------------------------------------------------------------------------------------------------------------

	public char getChar(String mensaje) { // CHAR -------------------------------------------------------------------
											// CHAR
		do {
			error = false;
			System.out.println(mensaje);
			cadena = ent.nextLine();
			if (cadena.isEmpty()) {
				error();
			} else if (cadena.length() > 1) {
				error();
			}
		} while (error);
		return cadena.charAt(0);
	}// --------------------------------------------------------------------------------------------------------------------------------------------

	public char getLetraSola(String mensaje) { // LETRA SOLA ----------------------------------------- LETRA SOLA
		do {
			error = false;
			System.out.println(mensaje);
			cadena = ent.nextLine();
			if (cadena.isEmpty()) {
				error();
			} else if (cadena.length() > 1) {
				error();
			} else if (cadena.charAt(0) > 90 && cadena.charAt(0) < 97) {
				error();
			} else if (cadena.charAt(0) > 122 || cadena.charAt(0) < 65) {
				error();
			}
		} while (error);
		return cadena.charAt(0);
	}// --------------------------------------------------------------------------------------------------------------------------------------------

	public String getPalabra(String mensaje) { // STRING --------------------------------------------- STRING
		do {
			error = false;
			System.out.println(mensaje);
			cadena = ent.nextLine();
			for (int i = 0; i < cadena.length(); i++) {
				if (cadena.charAt(i) > 90 && cadena.charAt(i) < 97) {
					error();
					break;
				} else if (cadena.charAt(i) > 122 || cadena.charAt(i) < 65) {
					error();
					break;
				}
			}
		} while (error);
		return cadena;
	}// --------------------------------------------------------------------------------------------------------------------------------------------

	public String getTexto(String mensaje) { // STRING --------------------------------------------- STRING
		do {
			error = false;
			System.out.println(mensaje);
			cadena = ent.nextLine();
			for (int i = 0; i < cadena.length(); i++) {
				if (cadena.charAt(i) == ' ' || cadena.charAt(i) == ',' || cadena.charAt(i) == '.') {
				} else if (cadena.charAt(i) > 90 && cadena.charAt(i) < 97) {
					error();
					break;
				} else if (cadena.charAt(i) > 122 || cadena.charAt(i) < 65) {
					error();
					break;
				}
			}
		} while (error);
		return cadena;
	}// --------------------------------------------------------------------------------------------------------------------------------------------

	public int getNum(String numeros) { // para componer el numero
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