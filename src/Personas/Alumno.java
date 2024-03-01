package Personas;

public class Alumno extends Persona {
	private String modulo;
	private int numMaterias;
	private boolean repetidor;
	
	private static int nalumno = 0;
	
	public Alumno(String n, int e, String m, int nm) {
		super(n,e);
		this.modulo=m;
		this.numMaterias=nm;
		this.repetidor=false;
		this.nalumno++;
	}
	
	public String getModulo() {
		return this.modulo;
	}
	
	public void setModulo(String newModulo) {
		this.modulo = newModulo;
	}
	
	public void repite(int newMateria) {
		this.repetidor = true;
		this.numMaterias = newMateria;
	}
	
	
	public static int getNalumno() {
		return nalumno;
	}

	public static void setNalumno(int nalumno) {
		Alumno.nalumno = nalumno;
	}

	public boolean getRepetidor() {
		return this.repetidor;
	}
	
	public void setRepetidor(boolean newRepetidor) {
		this.repetidor = newRepetidor;
	}
	
	public String toString() {
		return super.toString();
	}
}
