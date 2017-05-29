import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class TablaListar extends JPanel {
	
	JTable tablaListar;

	TablaListar() {
		
		

		setLayout(new GridLayout(1, 1));
		
		DefaultTableModel definicionTabla = new DefaultTableModel();
		tablaListar = new JTable(definicionTabla);

		//tablaListar.setSize(500, 250);
		
			//Columnes de la tabla
		definicionTabla.addColumn("Nombre");
		definicionTabla.addColumn("Tamaño");
		
		/*Object[] objeto = new Object[2];
		objeto[0] = "aida";
		objeto[1] = 1;
		definicionTabla.addRow(objeto);*/
		
		tablaListar.setFillsViewportHeight(true);
		
		add(tablaListar);

		tablaListar.repaint();
		tablaListar.revalidate();
		
	}

}
