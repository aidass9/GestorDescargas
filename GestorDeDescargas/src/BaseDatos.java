import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class BaseDatos {
	
	static Statement sentencia;
	
	public static ResultSet consultar (String consultaSQL) {
		ResultSet resultadoConsulta = null;
		try {
			Connection conn;
			conn = DriverManager.getConnection("jdbc:mysql://server:3306/midb", "root", "");
			sentencia = conn.createStatement();
			System.out.println("¡Conexión correcta!");
			
			resultadoConsulta = sentencia.executeQuery(consultaSQL);

		}
		
		catch (Exception e) {
			System.out.println("Conn ERROR! " + e.toString());
		}
		return resultadoConsulta;
		
		

	
	}
}

