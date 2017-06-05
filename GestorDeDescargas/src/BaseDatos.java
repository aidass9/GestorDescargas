import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class BaseDatos {
	
	static Statement sentencia;
	
	static String server = "jdbc:mysql://localhost:3306/midb";
	static String usuario = "root";
	static String pass = "1234";
	
	public static ResultSet consultar (String consultaSQL) {
		ResultSet resultadoConsulta = null;
		try {
			Connection conn;
			conn = DriverManager.getConnection(server, usuario, pass);
			//conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/midb", "root", "1234");
			//conn = DriverManager.getConnection("jdbc:mysql://server:3306/midb", "root", "");
			sentencia = conn.createStatement();
			System.out.println("¡Conexión correcta!");

			resultadoConsulta = sentencia.executeQuery(consultaSQL);

		}
		
		catch (Exception e) {
			System.out.println("Conn ERROR! " + e.toString());
		}
		return resultadoConsulta;
	
	}
	
	public static boolean actualizar (String consultaSQL) {
		try {
			Connection conn;
			
			conn = DriverManager.getConnection(server, usuario, pass);
			//conn = DriverManager.getConnection("jdbc:mysql://server:3306/midb", "root", "");
			sentencia = conn.createStatement();
			System.out.println("¡Conexión correcta!");

			sentencia.executeUpdate(consultaSQL);
			return true;
		}
		
		catch (Exception e) {
			System.out.println("Conn ERROR! " + e.toString());
			return false;
		}
		
	}
}

