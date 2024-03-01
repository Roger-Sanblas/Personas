package Personas;

public class Persona {
	private String nombre;
	private int edad;
	private static int npersonas = 0;

	public Persona(String n, int e) {
		this.nombre = n;
		this.edad = e;
		npersonas++;
	}

	public int getEdad() {
		return this.edad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nuevo) {
		this.nombre = nuevo;
	}

	public void cumpleaños() {
		this.edad++;
		System.out.println("Fiesta de " + this.nombre);
	}

	public String toString() {
		return this.nombre + " tiene " + this.edad + " a�os ";
	}

	public static int getNpersonas() {
		return npersonas;
	}
}
