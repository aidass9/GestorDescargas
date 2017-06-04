import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;


public class BajarFTP extends Thread {
	
	public void run() {
		String ftpServer = "10.2.1.148";
		String ftpUsuario = "ftpClient";
		String ftpPass = "1234";
		
		FTPClient clienteFTP = new FTPClient();
		
		try {
			clienteFTP.connect(ftpServer);
			boolean login = clienteFTP.login(ftpUsuario, ftpPass);
			System.out.println("Conexión FTP correcta");
			
			clienteFTP.enterLocalPassiveMode();
		}
		
		catch (Exception e) {
			System.out.println("Fallo al descargar el archivo");
			JOptionPane.showMessageDialog(null, "¡Fallo al descargar el archivo!");
		}
	}

}
