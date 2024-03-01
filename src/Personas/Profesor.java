package Personas;

public class Profesor extends Persona {
	private String asignatura;
	private boolean esmajo;
	private int numMaterias;
	private static int nProfesor = 0;
	
	public Profesor(String n, int e, String asignatura) {
		super(n,e);
		this.asignatura = asignatura;
		this.esmajo = false;
		nProfesor++;
	}

	
	
	public static int getNprofesor() {
		return nProfesor;
	}

	public static void setNProfesor(int nProfesor) {
		Profesor.nProfesor = nProfesor;
	}



	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public boolean isEsmajo() {
		return esmajo;
	}

	public void setEsmajo(boolean esmajo) {
		this.esmajo = esmajo;
	}

	public int getNumMaterias() {
		return numMaterias;
	}

	public void setNumMaterias(int numMaterias) {
		this.numMaterias = numMaterias;
	}
}
