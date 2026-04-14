/**
 * @author Adrián Celestrín
 */
package modelo;

public class Cliente {
	/**
	 * Atributos de Clase
	 */
	private String dni;
	private String nomnbre;
	private String apellidos;
	private int edad;
	
	/**
	 * 
	 * @param dni
	 * @param nomnbre
	 * @param apellidos
	 * @param edad
	 */
	public Cliente(String dni, String nomnbre, String apellidos, int edad) {
		this.dni = dni;
		this.nomnbre = nomnbre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	/**
	 * @return the dni
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * @return the nomnbre
	 */
	public String getNomnbre() {
		return nomnbre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

}
