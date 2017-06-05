import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;


public class BajarFTP extends Thread {
	
	//String nomArchivoDescargar = InterfazBajarFTP.stringArchivo;
	
	private String nombreArchivoFTP, nombreArchivoBajado;
	
	public BajarFTP(String nombreOrigen, String nombreDestino) {
		this.nombreArchivoFTP = nombreOrigen;
		this.nombreArchivoBajado = nombreDestino;
	}
	
	//private FTPFile archivoFTP;
	//private String nombreArchivo;
	
	/*BajarFTP(FTPFile archivoFTP, String nombreArchivo) {
		this.archivoFTP = archivoFTP;
		if (nombreArchivo.equals("")) {
			this.nombreArchivo = archivoFTP.getName();
		}
		else {
			this.nombreArchivo = nombreArchivo;
		}
	}*/
	
	public void run() {
		String ftpServer = "10.2.1.148";
		String ftpUsuario = "ftpClient";
		String ftpPass = "1234";
		
		FTPClient clienteFTP = new FTPClient();
		
		try {
			clienteFTP.connect(ftpServer);
			boolean login = clienteFTP.login(ftpUsuario, ftpPass);
			System.out.println("Conexión FTP correcta");
			
			boolean condicion = false;
			
				//---------------------------
			for(int i = 0; i <= ListarFTP.archivos.size(); i++) {
				if(ListarFTP.archivos.equals(nombreArchivoFTP)) {
					condicion = true;
					break;
				}
			}
			
			for(FTPFile archivo : ListarFTP.archivos) {
				if(archivo.getName().equals(nombreArchivoFTP)) {
					condicion = true;
					break;
				}
			}
				//---------------------------
			
			clienteFTP.enterLocalPassiveMode();
			
			FileOutputStream fos = new FileOutputStream(nombreArchivoBajado);
			clienteFTP.retrieveFile(nombreArchivoFTP, fos);
			
			clienteFTP.logout();
			clienteFTP.disconnect();
		}
		
		catch (Exception e) {
			System.out.println("Fallo al descargar el archivo");
			JOptionPane.showMessageDialog(null, "¡Fallo al descargar el archivo!");
		}
		
	}

}
