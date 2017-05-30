import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class IntefazSubirFTP extends JPanel {
	JLabel labelMensaje;
	JLabel labelFicheroFTP;
	JButton botonSubir;
	JTextField nombreArchivo;
	JLabel labelBlanco;
	JLabel labelBlanco2;

	IntefazSubirFTP() {
		setLayout(new GridLayout(3, 1, 10, 5));
		setBorder(new EmptyBorder(25, 25, 20, 25));
		
		labelMensaje = new JLabel("Subir archivo al servidor FTP", JLabel.CENTER);
		add(labelMensaje);
		
		labelBlanco = new JLabel();
		add(labelBlanco);
		
		labelFicheroFTP = new JLabel("Fichero FTP", JLabel.CENTER);
		add(labelFicheroFTP);
		
		nombreArchivo = new JTextField();
		add(nombreArchivo);
		
		labelBlanco2 = new JLabel();
		add(labelBlanco2);
		
		botonSubir = new JButton("Subir");
		botonSubir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String stringArchivo = nombreArchivo.getText();
				
				SubirFTP hiloSubirFTP = new SubirFTP();
				hiloSubirFTP.start();
			}
		});
		add(botonSubir);
	}
	
}
