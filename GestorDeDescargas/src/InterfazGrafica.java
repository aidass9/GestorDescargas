import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;


public class InterfazGrafica {
	static InterfazLogin login;
	static InterfazRegistrar registrar;
	static JFrame ventana;
	static JMenuBar menu;
	static JMenu ftp;
	
		//Acceder a la clase Usuario - objeto de la clase Usuario
	public static Usuario sesionUsuario;
	
	public static void interfazGrafica() {
		
		login = new InterfazLogin();
		registrar = new InterfazRegistrar();
		
		ventana = new JFrame("Gestor de descargas");
		ventana.setBounds(500, 150, 500, 250);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		menu = new JMenuBar();
		
		menuSesion();
		menuFTP();
		
		ventanaBienvenida();
		
		ventana.setJMenuBar(menu);
		ventana.setVisible(true);
	}
	
	public static void menuSesion() {
		JMenu inicio = new JMenu("Inicio");
		JMenuItem sesion = new JMenuItem("Iniciar sesión");
		JMenuItem registro = new JMenuItem("Registrarse");
		
		inicio.add(sesion);
		inicio.add(registro);
		
		sesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVentanaSesion();


			}
		});
		
		registro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {

				ventana.getContentPane().removeAll();
				ventana.add(registrar);
				ventana.revalidate();
				ventana.repaint();

			}
		});
		
		menu.add(inicio);
	}
	
	public static void menuFTP() {
		ftp = new JMenu("FTP");
		JMenuItem listar = new JMenuItem("Listar FTP");
		listar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sesionUsuario == null) {
					System.out.println("Inicia sesión");
				}
				
			}
		});
		JMenuItem subir = new JMenuItem("Subir archivo");
		JMenuItem bajar = new JMenuItem("Bajar archivo");
		
		ftp.add(listar);
		ftp.add(subir);
		ftp.add(bajar);
		
		menu.add(ftp);
		
		ftp.setVisible(false);
	}
	
	public static void mostrarVentanaSesion() {
		ventana.getContentPane().removeAll();
		ventana.add(login);
		ventana.revalidate();
		ventana.repaint();
	}
	
	public static void ventanaBienvenida() {
		ventana.getContentPane().removeAll();
		
		JPanel ventanaBienvenida = new JPanel();
		
		ventanaBienvenida.setLayout(new GridLayout(1, 1, 20, 10));
		
		JLabel mensaje = new JLabel("Bienvenid@ al gestor de descargas", JLabel.CENTER);
		
		ventanaBienvenida.add(mensaje);
		
		ventana.add(ventanaBienvenida);
	}
	
	public static void ventanaBienvenidaSesion() {
		ventana.getContentPane().removeAll();
		
		JPanel ventanaBienvenidaSesion = new JPanel();
		
		ventanaBienvenidaSesion.setLayout(new GridLayout(1, 1, 20, 10));
		
		JLabel mensaje = new JLabel("Hola " + sesionUsuario.nombre , JLabel.CENTER);
		
		ftp.setVisible(true);
		
		ventanaBienvenidaSesion.add(mensaje);

		ventana.add(ventanaBienvenidaSesion);
		ventana.repaint();
		ventana.revalidate();
	}
	
}
