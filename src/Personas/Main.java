package Personas;

import java.util.Scanner;

public class Main {
	private static char menu(Scanner sc) {
		char opcion;
		System.out.println("A: Mostrar personas");
		System.out.println("B: Añadir profesor");
		System.out.println("C: Añadir Alumno");
		System.out.println("D: Quitar persona");
		System.out.println("E: Persona Cumple A�os");
		System.out.println("F: Hacer repetido");
		System.out.println("G: Hacer majo");
		System.out.println("H: Mostrar numero de personas");
		System.out.println("I: Mostrar numero historico de profesores");
		System.out.println("J: Mostrar numero historico de alumnos");
		System.out.println("K: Mostrar numero de alumnos repetidores");
		System.out.println("L: Mostrar numero de profesores majos");
		System.out.println("M: Promedio de edades de todos los alumnos");
		System.out.println("N: Promedio de edades de todos los profesores");
		System.out.println("ñ: Promedio de edades de todos las personas");
		System.out.println("Z: Salir");

		System.out.println("Dime una opcion: ");
		opcion = sc.next().toUpperCase().charAt(0);
		return opcion;
	}

	public static void MostrarPersonas(Persona[] personas) {
		for (int i = 0; i < personas.length; i++) {
			System.out.println("Persona[" + i + "]" + personas[i]);
		}
	}

	public static int contarNrepetidores(Persona[] personas) {
		int contador = 0;
		for (int i = 0; i < personas.length; i++) {
			if (personas[i] != null && personas[i] instanceof Alumno && ((Alumno) personas[i]).getRepetidor()) {
				contador++;
			}
		}
		return contador;
	}

	public static int contarAlumnosRep(Persona[] personas) {
		int contador = 0;
		for (int i = 0; i < personas.length; i++) {
			if (personas[i] != null && personas[i] instanceof Alumno && ((Alumno) personas[i]).getRepetidor()) {
				contador++;
			}
		}
		return contador;
	}

	public static int contarNprofesoresMajos(Persona[] personas) {
		int contador = 0;
		for (int i = 0; i < personas.length; i++) {
			if (personas[i] != null && personas[i] instanceof Profesor && ((Profesor) personas[i]).isEsmajo()) {
				contador++;
			}
		}
		return contador;
	}

	private static int contarNpersonas(Persona[] personas) {
		int contador = 0;
		for (int i = 0; i < personas.length; i++) {
			if (personas[i] != null) {
				contador++;
			}
		}
		return contador;
	}

	private static int ObtenerEdadesAlumnosDAW(Persona[] personas, int[] edades) {
		int j = 0;

		for (int i = 0; i < personas.length; i++) {
			if (personas[i] != null && personas[i] instanceof Alumno
					&& ((Alumno) personas[i]).getModulo().equals("DAW")) {
				edades[j] = personas[i].getEdad();
				j++;
			}
		}
		return j;
	}

	private static boolean AñadirAlumno(Persona[] personas, Scanner sc) {
		int pos, edad, numMaterias;
		boolean res;
		String nombre, modulo;

		pos = 0;

		while (pos < personas.length && personas[pos] != null) {
			pos++;
		}
		// pos >= personas.length o personas[pos] = null

		if (pos >= personas.length) {
			res = false;
		} else {
			System.out.println("Dime el nombre: ");
			nombre = sc.next();
			System.out.println("Dime la edad: ");
			edad = sc.nextInt();
			System.out.println("Dime el modulo: ");
			modulo = sc.next();
			System.out.println("Dime el numero de asignaturas: ");
			numMaterias = sc.nextInt();

			personas[pos] = new Alumno(nombre, edad, modulo, numMaterias);
			res = true;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int maxpersonas;
		Persona [] personas;
		char opcion;
		boolean aux;
		int [] edades;
		int nedades;
		
		do {
			System.out.println("Dime el numero maximo de personas");
			maxpersonas = sc.nextInt();
		} while (maxpersonas <= 0);

		personas = new Persona[maxpersonas];
		edades = new int[maxpersonas];

		do {
			opcion = menu(sc);
			switch (opcion) {
				case 'A':
					MostrarPersonas(personas);
					break;
				case 'C':
					aux = AñadirAlumno(personas, sc);
					String mensaje = (aux ? "Se logro agregar el alumno" : "No Se logro agregar el alumno");
					System.out.println(mensaje);
					break;
				case 'H':
					System.out.println("hay " + contarNpersonas(personas) + " personas");
					break;
				case 'I':
					System.out.println("Se han creado" + Profesor.getNprofesor() + " profesores");
					break;
				case 'J':
					System.out.println("Se han creado" + Alumno.getNalumno() + " alumnoss");
					break;
				case 'K':
					System.out.println("Numero de Repetidores " + contarNrepetidores(personas) + " alumnos");
				case 'L':
					System.out.println("Total de Profesores Majos " + contarNrepetidores(personas) + " profesores");
				case 'O':
					nedades = ObtenerEdadesAlumnosDAW(personas, edades);
				case 'Z':
					break;
				default:
					System.out.println("Opcion Incorrecta.");
			}
		} while (opcion != 'Z');

		MostrarPersonas(personas);
	}
}