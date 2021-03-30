package proyecto_ED;

public class Main {
	static String printlinea = "", siguientelinea = "";
	static Documento doc = new Documento();

	public static void main(String arg[]) {

		Teclado ent = new Teclado();
		Utiles util = new Utiles();
		int opcion = 0;
		String comando = "", ruta = "Nuevo Documento";
		boolean run = true, escribiendo = false, buscando = false;
		util.errorCls();
		util.setStatus("Bienvenido", "", "Selecciona una opcion del menu superior.");
		do {
			util.setOpciones("Crear / Modificar fichero", "Buscar fichero", "Salir", "", "");
			util.menu("Menu principal");
			util.errorCls();
			opcion = ent.getOpcion(1, 3);
			switch (opcion) {
			case 1:
				escribiendo = true;
				do {
					util.setStatus("Documento: " + ruta,
							"El comando !x no guarda los cambios, procura usar el comando !gg antes de salir si no quieres perder los cambios.",
							"Escribe un comando del menu o simplemente introduce el texto que quieras añadir al fichero.");
					util.setOpciones("!gg (guardar documento)", "!bl (borrar linea)", "!rl (reemplazar linea)",
							"!bt (borrartodo)", "!x (salir)");
					util.menu("Crear fichero");
					util.errorCls();
					comando = ent.getString("Escribe..");
					switch (comando) {
					case "!gg":
						util.setStatus("Ejemplo de ruta: " + "C:\\Users\\Username\\Desktop\\nombredocumento",
								"No es necesario incluir la extensión (se asigna automaticamente .txt)",
								"En caso de no existir la ruta se creara (No se pueden guardar archivos directamente en C:\\ (primero debes crear una carpeta por ejemplo: \"c:\\carpeta\\fichero\")");
						util.setOpciones("", "", "", "", "");
						util.menu("Guardando fichero...");
						util.errorCls();
						ruta = ent.getString("Indica el nombre y la ruta en la que quieres guardar el documento")
								+ ".txt";
						doc.saveFile(ruta);
						break;
					case "!bl":
						util.setStatus("Ingresa el numero de linea que deseas eliminiar", "o escribe !c para cancelar",
								"");
						util.setOpciones("!cancelar", "", "", "", "");
						util.menu("Borrar linea");
						util.errorCls();
						comando = ent.getString("Escribe..");
						switch (comando) {
						case "!c":
							break;
						default:
							try {
								doc.delLinea(ent.getNum(comando));
							} catch (Exception e) {
								util.setError("¡¡ATENCION!! La linea que desea eliminar no existe");
							}
						}
						break;
					case "!rl":
						util.setStatus("Ingresa el numero de linea que deseas reemplazar", "o escribe !c para cancelar",
								"");
						util.setOpciones("!cancelar", "", "", "", "");
						util.menu("Borrar linea");
						util.errorCls();
						comando = ent.getString("Escribe..");
						switch (comando) {
						case "!c":
							break;
						default:
							try {
								doc.repLinea(ent.getNum(comando),
										ent.getString("Escribe algo para reemplazar la linea"));
							} catch (Exception e) {
								util.setError("¡¡ATENCION!! La linea que desea eliminar no existe");
							}
						}
						break;
					case "!bt":
						doc.delDoc();
						break;
					case "!x":
						doc.delDoc();
						escribiendo = false;
						break;
					default:
						doc.nuevaLinea(comando);
					}
				} while (escribiendo);
				break;
			case 2:
				buscando = true;
				do {
					util.setStatus("Ejemplo de ruta:",
							"C:\\Users\\Username\\Desktop\\nombredocumento  << reemplaza \"Username\" con tu nombre de usuario de windows",
							"No es necesario incluir la extensión en el nombre del fichero");
					util.setOpciones("!x (salir de la busqueda)",
							"!ba (borrar archivo sera implementado en proximas actualizaciones)",
							"!ca (copiar archivo sera implementado en proximas actualizaciones)", "", "");
					util.menu("Buscar fichero");
					util.errorCls();
					comando = ent.getString(
							"Indica la ruta y el nombre del documento o escribe !x para abandonar la busqueda");
					switch (comando) {
					case "!x":
						buscando = false;
						break;
					case "!ba":
						// ba.borrar(ruta); //crear clase BorrarArchivo
						break;
					case "!ca":
						// String nuevaRuta = ent.getString("Indica la ruta donde deseas copiar el
						// documento");
						// ca.copiar(ruta,nuevaRuta); //crear clase CopiarArchivo
						break;
					default:
						ruta = comando + ".txt";
						doc.delDoc();
						doc.readFile(ruta);
					}
				} while (buscando);
				break;
			case 3:
				util.setStatus("Ha cerrado la aplicación", "", "");
				util.setOpciones("", "", "", "", "");
				util.errorCls();
				util.menu("Ha cerrado la aplicación");
				run = false;
			}
		} while (run);

	}// fin del main

	public static void getContenido() {
		for (int i = 0; i < doc.getSize(); i++) {
			if (i < 9) {
				printlinea = "|  " + (i + 1) + "   " + doc.getLinea(i);
			} else if (i < 99) {
				printlinea = "| " + (i + 1) + "   " + doc.getLinea(i);
			} else {
				printlinea = "|" + (i + 1) + "   " + doc.getLinea(i);
			}
			String pl = printlinea;
			for (int j = 0; j < (160 - pl.length()); j++) {
				printlinea += " ";
			}
			printlinea += "|";
			System.out.println(printlinea);
		}
		siguientelinea = "| >>   " + doc.getAux();
		String nl = siguientelinea;
		for (int j = 0; j < (160 - nl.length()); j++) {
			siguientelinea += " ";
		}
		siguientelinea += "|";
		System.out.println(siguientelinea);
	}

}
