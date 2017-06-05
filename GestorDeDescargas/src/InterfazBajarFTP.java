import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class InterfazBajarFTP extends JPanel {
	JLabel labelMensaje;
	JLabel labelFicheroFTP;
	JButton botonBajar;
	JTextField nombreArchivo;
	JLabel labelBlanco;
	JLabel labelBlanco2;
	static String stringArchivo;
	
	InterfazBajarFTP() {
		setLayout(new GridLayout(3, 1, 10, 5));
		setBorder(new EmptyBorder(25, 25, 20, 25));
		
		labelMensaje = new JLabel("Descargar archivo del servidor FTP", JLabel.CENTER);
		add(labelMensaje);
		
		labelBlanco = new JLabel();
		add(labelBlanco);
		
		labelFicheroFTP = new JLabel("Fichero FTP", JLabel.CENTER);
		add(labelFicheroFTP);
		
		nombreArchivo = new JTextField();
		add(nombreArchivo);
		
		labelBlanco2 = new JLabel();
		add(labelBlanco2);
		
		botonBajar = new JButton("Descargar");
		add(botonBajar);
		botonBajar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stringArchivo = nombreArchivo.getText();
				
				BajarFTP hiloBajarFTP = new BajarFTP(stringArchivo);
				hiloBajarFTP.start();
			}
		});
		add(botonBajar);
	}
}

/*String ftpServer = "ftp.rediris.es";
String ftpUsuario = "";
String ftpPass = "";
*/