import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class TablaListar extends JPanel {
	
	JTable tablaListar;

	TablaListar() {
		/*JPanel panelTabla = new JPanel(new GridLayout(1, 1));
		panelTabla.setBounds(0, 0, 500, 450);
		
		//setLayout(new GridLayout(1, 1));
		
		DefaultTableModel definicionTabla = new DefaultTableModel();
		tablaListar = new JTable(definicionTabla);
		
			//Columnas de la tabla
		definicionTabla.addColumn("Nombre");
		definicionTabla.addColumn("Tamaño");
		
		tablaListar.setFillsViewportHeight(true);
		tablaListar.getTableHeader();
		
		tablaListar.repaint();
		tablaListar.revalidate();
		
		panelTabla.add(tablaListar);
		add(panelTabla);*/
		
		setLayout(new GridLayout(1, 1));
		setBounds(500, 150, 500, 250);
		
		DefaultTableModel definicionTabla = new DefaultTableModel();
		tablaListar = new JTable(definicionTabla);

		tablaListar.setSize(500, 250);
		
			//Columnes de la tabla
		definicionTabla.addColumn("Nombre");
		definicionTabla.addColumn("Tamaño");
		
		tablaListar.setFillsViewportHeight(true);
		tablaListar.getTableHeader();
		
		tablaListar.repaint();
		tablaListar.revalidate();
		
		add(tablaListar);
		
	}

}
