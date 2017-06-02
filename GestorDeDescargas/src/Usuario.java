
public class Usuario {
	
	String usuario, contraseña;
	static String nombre;
	String apellidos;
	String email;
	String nacimiento;
	int subidos, bajados;
		
		//varibles que recibe de InterfazGrafica -> stringNombreVariable
		//Constructor Usuario
	Usuario(String usuario, String contraseña, String nombre, String apellidos, String email, String nacimiento, int subidos, int bajados) {
			
		//Variable que recibe - variable creada
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
		this.nacimiento = nacimiento;
		this.subidos = subidos;
		this.bajados = bajados;
		
		
	}

}
