import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class InterfazRegistrar extends JPanel {
	
	InterfazRegistrar() {
		setLayout(new GridLayout(8, 2, 10, 5));
		setBorder(new EmptyBorder(20, 10, 10, 10));
		
		JLabel labelUsuario = new JLabel("Usuario");
		final JTextField usuario = new JTextField();
		add(labelUsuario);
		add(usuario);
		
		JLabel labelPass = new JLabel("Contraseña");
		final JPasswordField pass = new JPasswordField();
		add(labelPass);
		add(pass);
		
		JLabel labelPass2 = new JLabel("Confirmar contraseña");
		final JPasswordField pass2 = new JPasswordField();
		add(labelPass2);
		add(pass2);
		
		JLabel labelNombre = new JLabel("Nombre");
		final JTextField nombre = new JTextField();
		add(labelNombre);
		add(nombre);
		
		JLabel labelApellidos = new JLabel("Apellidos");
		final JTextField apellidos = new JTextField();
		add(labelApellidos);
		add(apellidos);
		
		JLabel labelEmail = new JLabel("Email");
		final JTextField email = new JTextField();
		add(labelEmail);
		add(email);
		
		JLabel labelNacimiento = new JLabel("Fecha nacimiento (dd/mm/aaaa)");
		final JTextField nacimiento = new JTextField();
		add(labelNacimiento);
		add(nacimiento);
		
		JLabel blanco = new JLabel();
		add(blanco);
		
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
				
				boolean comprobarUsuario;
				
				if (stringUsuario.length() == 0) {
					mensajeError += "Usuario incorrecto \n";
					todoCorrecto = false;
					
				}
				
				boolean comprobarPass = stringPass1.equals(stringPass2);
				if (comprobarPass == false) {
						//Comprobar que la contrasenya no estiga buida
					comprobarPass = (stringPass1.length() > 0 && stringPass2.length() > 0);
					if (comprobarPass == false) {
						mensajeError += "Contraseña incorrecta \n";
						todoCorrecto = false;
					}
				}
				
				boolean comprobarEmail = comprobarEmailOk(stringEmail);
				if (comprobarEmail == false) {
					mensajeError += "El email es incorrecto \n";
					todoCorrecto = false;
				}
				System.out.println("hola");
				
				if (todoCorrecto == true) {
					BaseDatos.actualizar("INSERT INTO usuarios (usuario, contraseña, nombre, apellidos, email, fnacimiento) VALUES ('"+stringUsuario+"', '"+stringPass1+"', '"+stringNombre+"', '"+stringApellidos+"', '"+stringEmail+"', '"+stringFechaNac+"')");
				}
				
				else {
					JOptionPane.showMessageDialog(null, mensajeError);
				}
				
				
			};
		});

		add(botonAceptar);
		
		//JOptionPane.showMessageDialog(null, "");
	}
	
	public boolean comprobarEmailOk(String email) {
		int tamañoEmail = email.length();
		
		boolean comprobar = true;
		
		for(int i = 0; i < tamañoEmail; i++) {
			if (email.substring(i, i + 1).equals("@")) {
				if (email.substring((tamañoEmail - 3), tamañoEmail).equals(".es") || email.substring((tamañoEmail - 4), tamañoEmail).equals(".com")) {
					System.out.println("El email es correcto");
				}
			}
			
			else {
				System.out.println("El email es incorrecto");
				comprobar = false;
			}
		}
		return comprobar;

	}

}
