// TRABAJO PRÁCTICO FINAL
package manipular_archivos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class tpFinal {
	static Scanner entrada = new Scanner(System.in);
	static String respuestaAgregar;

	static String[] nombres = new String[3];
	static String[] apellidos = new String[3];
	static int[] numeros = new int[3];

	static String[] nombresNuevo = new String[4];
	static String[] apellidosNuevo = new String[4];
	static int[] numerosNuevo = new int[4];

	public static void main(String ars[]) {

		ingresarDatos();
		agregarJugador();
		crearArchivo();

	}

	public static void ingresarDatos() {
		for (int i = 0; i < 3; i++) {
			System.out.println("Ingresa el nombre del jugador numero: " + (i + 1));
			nombres[i] = entrada.next();

			System.out.println("Ingresa el apellido");
			apellidos[i] = entrada.next();

			System.out.println("Numero de camiseta?");
			numeros[i] = entrada.nextInt();

			System.out.println("");
		}
	}

	public static void agregarJugador() {
		boolean respuestaAgregarIncorrecta = true;
		while (respuestaAgregarIncorrecta) {
			System.out.println("Desea agregar otro jugador?");
			respuestaAgregar = entrada.next().toLowerCase();

			if (respuestaAgregar.equals("si")) {
				for (int i = 0; i < 3; i++) {

					nombresNuevo[i] = nombres[i];

					apellidosNuevo[i] = apellidos[i];

					numerosNuevo[i] = numeros[i];

				}

				System.out.println("Ingresa el nuevo nombre: ");
				nombresNuevo[3] = entrada.next();
				System.out.println("Ingresa su apellido: ");
				apellidosNuevo[3] = entrada.next();
				System.out.println("Ingresa su numero de camiseta: ");
				numerosNuevo[3] = entrada.nextInt();

				analizarDatosCuatroJugadores();

				respuestaAgregarIncorrecta = false;
			} else if (respuestaAgregar.equals("no")) {

				analizarDatosTresJugadores();

				respuestaAgregarIncorrecta = false;

			} else {
				System.out.println("Respuesta incorrecta. Volver a ingresar:");

			}
		}
	}

	public static void analizarDatosTresJugadores() {
		System.out.println("Verifica si los datos son correctos.");
		for (int j = 0; j < numeros.length; j++) {
			System.out.println("Nombre: " + nombres[j]);
			System.out.println("Apellido: " + apellidos[j]);
			System.out.println("Numero: " + numeros[j]);
			System.out.println("");
		}

		System.out.println("Son correctos?");

		boolean respuestaActualizarIncorrecta = true;
		while (respuestaActualizarIncorrecta) {
			String respuestaActualizar;
			respuestaActualizar = entrada.next().toLowerCase();

			if (respuestaActualizar.equals("si")) {
				respuestaActualizarIncorrecta = false;
				break;
			} else if (respuestaActualizar.equals("no")) {
				System.out.println("Para corregir, ingresa el numero de jugador");
				int numeroCorregir = entrada.nextInt();

				for (int i = 0; i < numeros.length; i++) {

					if (numeroCorregir == numeros[i]) {
						System.out.println("Nombre: ");
						nombres[i] = entrada.next();

						System.out.println("Apellido: ");
						apellidos[i] = entrada.next();

						System.out.println("Numero: ");
						numeros[i] = entrada.nextInt();
					}
				}
				System.out.println("Comprobamos nuevamente.");

				for (int j = 0; j < numeros.length; j++) {
					System.out.println("Nombre: " + nombres[j]);
					System.out.println("Apellido: " + apellidos[j]);
					System.out.println("Numero: " + numeros[j]);
					System.out.println("");
				}

				System.out.println("Si los datos son incorrectos, volve a comenzar el programa.");

				respuestaActualizarIncorrecta = false;
			} else {
				System.out.println("Respuesta incorrecta. Volve a ingresarla.");
			}

		}
	}

	public static void analizarDatosCuatroJugadores() {
		System.out.println("Verifica si los datos son correctos.");
		for (int j = 0; j < numerosNuevo.length; j++) {
			System.out.println("Nombre: " + nombresNuevo[j]);
			System.out.println("Apellido: " + apellidosNuevo[j]);
			System.out.println("Numero: " + numerosNuevo[j]);
			System.out.println("");
		}

		System.out.println("Son correctos?");

		boolean respuestaActualizarIncorrecta = true;
		while (respuestaActualizarIncorrecta) {
			String respuestaActualizar;
			respuestaActualizar = entrada.next().toLowerCase();

			if (respuestaActualizar.equals("si")) {
				respuestaActualizarIncorrecta = false;
				break;
			} else if (respuestaActualizar.equals("no")) {
				System.out.println("Para corregir, ingresa el numero de jugador");
				int numeroCorregir = entrada.nextInt();

				for (int i = 0; i < numerosNuevo.length; i++) {

					if (numeroCorregir == numerosNuevo[i]) {
						System.out.println("Nombre: ");
						nombresNuevo[i] = entrada.next();

						System.out.println("Apellido: ");
						apellidosNuevo[i] = entrada.next();

						System.out.println("Numero: ");
						numerosNuevo[i] = entrada.nextInt();
					}
				}
				System.out.println("Comprobamos nuevamente.");

				for (int j = 0; j < numerosNuevo.length; j++) {
					System.out.println("Nombre: " + nombresNuevo[j]);
					System.out.println("Apellido: " + apellidosNuevo[j]);
					System.out.println("Numero: " + numerosNuevo[j]);
					System.out.println("");
				}

				System.out.println("Si los datos son incorrectos, volve a comenzar el programa.");
				respuestaActualizarIncorrecta = false;
			} else {
				System.out.println("Respuesta incorrecta. Volve a ingresarla.");
			}

		}
	}

	public static void crearArchivo() {
		try {
			String ruta = "C:\\Users\\seeba\\Documents\\ListaJugadores\\archivo_jugadores.txt";

			File file = new File(ruta);

			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);

			if (respuestaAgregar.equals("si")) {
				for (int i = 0; i < nombresNuevo.length; i++) {
					// Escribir en el archivo una linea que contiene el nombre y el apellido

					bw.write("Nombre: " + nombresNuevo[i] + ", Apellido: " + apellidosNuevo[i] + ", Numero:"
							+ numerosNuevo[i]);

					// Agregar una nueva linea despues de cada entrada
					bw.newLine();
				}
			}

			else if (respuestaAgregar.equals("no")) {
				for (int i = 0; i < nombres.length; i++) {
					// Escribir en el archivo una linea que contiene el nombre y el apellido

					bw.write("Nombre: " + nombres[i] + ", Apellido: " + apellidos[i] + ", Numero:" + numeros[i]);

					// Agregar una nueva linea despues de cada entrada
					bw.newLine();
				}
			}

			System.out.println("El archivo fue generado con éxito");

			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
