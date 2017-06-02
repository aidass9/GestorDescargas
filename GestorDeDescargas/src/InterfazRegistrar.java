import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class InterfazRegistrar extends JPanel {
	JLabel labelUsuario;
	JLabel labelPass;
	JLabel labelPass2;
	JLabel labelNombre;
	JLabel labelApellidos;
	JLabel labelEmail;
	JLabel labelNacimiento;

	InterfazRegistrar() {
		setLayout(new GridLayout(8, 2, 10, 5));
		setBorder(new EmptyBorder(20, 10, 10, 10));
		
		labelUsuario = new JLabel("Usuario");
		final JTextField usuario = new JTextField(); usuario.setText("aida");
		add(labelUsuario);
		add(usuario);
		
		labelPass = new JLabel("Contraseña");
		final JPasswordField pass = new JPasswordField(); pass.setText("4321");
		add(labelPass);
		add(pass);
		
		labelPass2 = new JLabel("Confirmar contraseña");
		final JPasswordField pass2 = new JPasswordField(); pass2.setText("4321");
		add(labelPass2);
		add(pass2);
		
		labelNombre = new JLabel("Nombre");
		final JTextField nombre = new JTextField(); nombre.setText("Aida");
		add(labelNombre);
		add(nombre);
		
		labelApellidos = new JLabel("Apellidos");
		final JTextField apellidos = new JTextField(); apellidos.setText("Soriano");
		add(labelApellidos);
		add(apellidos);
		
		labelEmail = new JLabel("Email");
		final JTextField email = new JTextField(); email.setText("aida@gmail.com");
		add(labelEmail);
		add(email);
		
		labelNacimiento = new JLabel("Fecha nacimiento (dd/mm/aaaa)");
		final JTextField nacimiento = new JTextField(); nacimiento.setText("20/05/2000");
		add(labelNacimiento);
		add(nacimiento);
		
		JButton botonInicio = new JButton("Volver");
		botonInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InterfazGrafica.interfazGrafica();
			}
		});
		add(botonInicio);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean todoCorrecto = true;
				String mensajeError = "";
				
				String stringUsuario = usuario.getText();
				String stringPass1 = String.valueOf(pass.getPassword());
				String stringPass2 = String.valueOf(pass2.getPassword());
				String stringNombre = nombre.getText();
				String stringApellidos = apellidos.getText();
				String stringEmail = email.getText();
				String stringFechaNac = nacimiento.getText();
				
					//Comprobar usuario
				
				boolean comprobarUsuario;
				
				if (stringUsuario.length() == 0) {
					mensajeError += "- Usuario incorrecto \n";
					todoCorrecto = false;
					
				}
				
					//Comprobar contraseña
				
				boolean comprobarPass = (stringPass1.length() > 0 && stringPass2.length() > 0);
				
				if (comprobarPass == true) {
						//Comprobar que la contrasenya no estiga buida
					comprobarPass = stringPass1.equals(stringPass2);

					if (comprobarPass == false) {
						mensajeError += "- Contraseña incorrecta \n";
						todoCorrecto = false;
					}
				}
				else {
					mensajeError += "- Contraseña no introducida \n";
					todoCorrecto = false;
					
				}
				
					//Comprobar nombre
				
				boolean comprobarNombre = (stringNombre.length() > 0);
				
				if (comprobarNombre == false) {
					mensajeError += "- Nombre no introducido \n";
					todoCorrecto = false;
				}
				
					//Comprobar apellidos
				
				boolean comprobarApellidos = (stringApellidos.length() > 0);
				
				if (comprobarApellidos == false) {
					mensajeError += "- Apellidos no introducidos \n";
					todoCorrecto = false;
				}
				
					//Comprobar email
				
				boolean comprobarEmail = comprobarEmailOk(stringEmail);
				if (comprobarEmail == false) {
					mensajeError += "- El email es incorrecto \n";
					todoCorrecto = false;
				}
				
					//Comprobar apellidos
				
				boolean comprobarNacimiento = (stringFechaNac.length() > 0);
				
				if (comprobarNacimiento == false) {
					mensajeError += "- Fecha no introducida \n";
					todoCorrecto = false;
				}
				
				
					//Conseguir IP
				
				/*String ip = "";
				Socket socket = new Socket();
				ip = socket.connect(new InetSocketAddress("google.com", 80));
				//String ip = InetSocketAddress("google.com", 80);
				System.out.println(socket.getLocalAddress());*/
				
				String ip ="";
				
				try {
					ip = InetAddress.getLocalHost().getHostAddress();
				}
				
				catch (Exception o) {
					System.out.println(o.toString());
				}
				
					//Introducir registro
				
				if (todoCorrecto == true) {
					boolean resultadoRegistrar;
					resultadoRegistrar = BaseDatos.actualizar("INSERT INTO usuarios (usuario, contraseña, nombre, apellidos, email, fnacimiento, bajadas, subidas, ip) VALUES ('"+stringUsuario+"', '"+stringPass1+"', '"+stringNombre+"', '"+stringApellidos+"', '"+stringEmail+"', '"+stringFechaNac+"', 0 , 0,  '"+ip+"')");
					
					if (resultadoRegistrar == true) {
						JOptionPane.showMessageDialog(null, "¡Registro correcto!");
						InterfazGrafica.mostrarVentanaSesion();
					}
					
					else {
							//Salta cuando hay un error en la base de datos
						JOptionPane.showMessageDialog(null, "¡Registro fallado!");
					}
					
				}
				
				else {
					JOptionPane.showMessageDialog(null, mensajeError);
				}

			};
		});

		add(botonAceptar);
	}
	
	public boolean comprobarEmailOk(String email) {
		int tamañoEmail = email.length();
		
		boolean comprobar = false;
		
		for(int i = 0; i < tamañoEmail; i++) {
			if (email.substring(i, i + 1).equals("@")) {
				if (email.substring((tamañoEmail - 3), tamañoEmail).equals(".es") || email.substring((tamañoEmail - 4), tamañoEmail).equals(".com")) {
					System.out.println("El email es correcto");
					comprobar = true;
				}
			}
		}
		if (comprobar == false){
			System.out.println("El email es incorrecto");
		}
		return comprobar;
	}

}
