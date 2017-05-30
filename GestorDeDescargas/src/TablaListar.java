import java.awt.Color;
import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.apache.commons.net.ftp.FTPFile;


public class TablaListar extends JPanel {
	
	JTable tablaListar;

	TablaListar() {
			//Objeto del Thread e iniciar el hilo
		ListarFTP hiloListar = new ListarFTP();
		hiloListar.start();
		
		setLayout(new GridLayout(1, 1));
		
		DefaultTableModel definicionTabla = new DefaultTableModel();
		tablaListar = new JTable(definicionTabla);
		tablaListar.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));

		//tablaListar.setSize(500, 250);
		
			//Columnes de la tabla
		definicionTabla.addColumn("Nombre");
		definicionTabla.addColumn("Tamaño");
		 
			//Mientras este activo el hilo haz:
		while (hiloListar.isAlive()) {
			
			try {
				Thread.sleep(200);
			}
			catch (InterruptedException e) {

			}
		}
		
		/*for(int i=0; i<= ListarFTP.archivos.size(); i++) {
			Object[] objeto = new Object[2];
			objeto[0] = ListarFTP.archivos.get(i).getName();
			objeto[1] = ListarFTP.archivos.get(i).getSize();
			definicionTabla.addRow(objeto);
			
		}*/
		
			//Bucle For each (igual que el anterior)
			//En cada vuelta almacena en archivo el contenido de ListarFTP.archivos
		for(FTPFile archivo : ListarFTP.archivos) {
			Object[] objeto = new Object[2];
			objeto[0] = archivo.getName();
			objeto[1] = calcularTamañoArchivos(archivo.getSize());
			definicionTabla.addRow(objeto);			
		}
		
		
		
		tablaListar.setFillsViewportHeight(true);
		
		JScrollPane scroll = new JScrollPane(tablaListar);
				
		add(scroll);
		

		tablaListar.repaint();
		tablaListar.revalidate();
		
	}
	
	public static String calcularTamañoArchivos(float peso) {
		
		DecimalFormat redondearTamaño = new DecimalFormat("#.##");
		String tamañoTxt = peso + " B";
		
		if(peso / 1024 / 1024 / 1024 > 1) {
			tamañoTxt = redondearTamaño.format(peso / 1024 /1024 / 1024) + " GB";
		}
		else if(peso / 1024 / 1024 > 1) {
			tamañoTxt = redondearTamaño.format(peso / 1024 / 1024) + " MB";
		}
		else if(peso / 1024 > 1) {
			tamañoTxt = redondearTamaño.format(peso / 1024) + " KB";
		}
		
		return tamañoTxt;
		
	}

}
