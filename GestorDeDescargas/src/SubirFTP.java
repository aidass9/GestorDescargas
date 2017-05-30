import org.apache.commons.net.ftp.FTPClient;


public class SubirFTP extends Thread {
		
	public void run() {
		String ftpServer = "10.2.1.148";
		String ftpUsuario = "ftpClient";
		String ftpPass = "1234";
		
		int subidos, bajados;
			
		FTPClient clienteFTP = new FTPClient();
			
		try {
			clienteFTP.connect(ftpServer);
			boolean login = clienteFTP.login(ftpUsuario, ftpPass);
			System.out.println("Conexión FTP correcta");
				
			clienteFTP.enterLocalPassiveMode();
				
			clienteFTP.changeWorkingDirectory("");
			
			
		}
			
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
}
