import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class InterfazGrafica {
	
	
	public static void interfazGrafica() {
		
		final InterfazLogin login = new InterfazLogin();
		
		final JFrame ventana = new JFrame("Gestor de descargas");
		ventana.setBounds(500, 150, 500, 250);
		
		JMenuBar menu = new JMenuBar();
		
		JMenu inicio = new JMenu("Inicio");
		JMenuItem sesion = new JMenuItem("Iniciar sesión");
		JMenuItem registro = new JMenuItem("Registrarse");
		
		inicio.add(sesion);
		inicio.add(registro);
		
		sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ventana.add(login);
				ventana.repaint();
				ventana.revalidate();
				
				//IniciarSesion.conectarBD();
			}
		});
		
		menu.add(inicio);
		
		ventana.setJMenuBar(menu);
		ventana.setVisible(true);
	}
	

}
