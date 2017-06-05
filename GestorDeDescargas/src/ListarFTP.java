import java.util.ArrayList;
import java.util.Arrays;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;


public class ListarFTP extends Thread {
	
	static ArrayList<FTPFile> archivos;

	public void run() {
		
		String ftpServer = "localhost";
		String ftpUsuario = "ftpClient";
		String ftpPass = "1234";
		
		/*String ftpServer = "10.2.1.148";
		String ftpUsuario = "ftpClient";
		String ftpPass = "1234";*/
		
		FTPClient clienteFTP = new FTPClient();
		
		try {
			clienteFTP.connect(ftpServer);
			boolean login = clienteFTP.login(ftpUsuario, ftpPass);
			System.out.println("Conexión FTP correcta");
				
			clienteFTP.enterLocalPassiveMode();
			
			clienteFTP.changeWorkingDirectory("");
			archivos = new ArrayList(new ArrayList<FTPFile>(Arrays.asList(clienteFTP.listFiles())));
			clienteFTP.logout();
			clienteFTP.disconnect();
		}
		
		catch (Exception e) {
			System.out.println(e.toString());
		}
				
	}
	
	/*public static void listar() {
		new ArrayList<FTPFile>(Arrays.asList(clienteFTP())));
	}*/
	
}