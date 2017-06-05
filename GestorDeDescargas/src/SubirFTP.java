import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class SubirFTP extends Thread {
	
	File archivoLocal;
	String archivoServidor;
	
	static ArrayList<FTPFile> archivos;
	
	SubirFTP(String archivoLocal) {
		this.archivoLocal = new File(archivoLocal);
		this.archivoServidor = archivoLocal;
		
	}
		
	public void run() {
		
		/*String ftpServer = "ftp.drivehq.com";
		String ftpUsuario = "boriues";
		String ftpPass = "ftpdrivehq123";*/
		
		String ftpServer = "localhost";
		String ftpUsuario = "ftpClient";
		String ftpPass = "1234";
		
		/*String ftpServer = "10.2.1.148";
		String ftpUsuario = "ftpClient";
		String ftpPass = "1234";*/
		
		int subidos;
			
		FTPClient clienteFTP = new FTPClient();
			
		try {
			clienteFTP.connect(ftpServer);
			boolean login = clienteFTP.login(ftpUsuario, ftpPass);
			System.out.println("Conexión FTP correcta");
				
			clienteFTP.enterLocalPassiveMode();
			
			InputStream streamLocal = new FileInputStream(archivoLocal);
			
			boolean done = clienteFTP.storeFile(archivoServidor, streamLocal);
			streamLocal.close();
			archivos = new ArrayList<FTPFile>(Arrays.asList(clienteFTP.listFiles()));
			JOptionPane.showMessageDialog(null, "¡Archivo subido!");
			
			//clienteFTP.changeWorkingDirectory("");
			
			clienteFTP.logout();
			clienteFTP.disconnect();
			
			BaseDatos.actualizar("UPDATE usuarios SET subidas = subidas + 1 WHERE usuario = '" + Usuario.nombre + "' ");
				
		}
			
		catch (Exception e) {
			System.out.println("Fallo al subir el archivo");
			JOptionPane.showMessageDialog(null, "¡Fallo al subir el archivo!");
		}
	}
	
}
