import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;


public class BajarFTP extends Thread {

	//private String nombreArchivoFTP, nombreArchivoBajado;
	
	//public BajarFTP(String nombreOrigen, String nombreDestino) {
		//this.nombreArchivoFTP = nombreOrigen;
		//this.nombreArchivoBajado = nombreDestino;
	//}
	
	private String nombreArchivoFTP;
	static ArrayList<FTPFile> archivos;
	
	public BajarFTP(String nombreArchivoFTP) {
		this.nombreArchivoFTP = nombreArchivoFTP;
	}
	
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
			
			boolean condicion = false;
			archivos = new ArrayList<FTPFile>(Arrays.asList(clienteFTP.listFiles()));
				//---------------------------
			/*for(int i = 0; i <= ListarFTP.archivos.size(); i++) {
				if(ListarFTP.archivos.equals(nombreArchivoFTP)) {
					condicion = true;
					break;
				}
			}*/
			
			for(FTPFile archivo : archivos) {
				if(archivo.getName().equals(nombreArchivoFTP)) {
					condicion = true;
					break;
				}
			}
				//---------------------------
			
			clienteFTP.enterLocalPassiveMode();
			
			FileOutputStream fos = new FileOutputStream("Descargas/" + nombreArchivoFTP);
			clienteFTP.retrieveFile(nombreArchivoFTP, fos);
			
			JOptionPane.showMessageDialog(null, "¡Archivo descargado!");
			
			clienteFTP.logout();
			clienteFTP.disconnect();
		}
		
		catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("Fallo al descargar el archivo");
			JOptionPane.showMessageDialog(null, "¡Fallo al descargar el archivo!");
		}
		
	}

}
