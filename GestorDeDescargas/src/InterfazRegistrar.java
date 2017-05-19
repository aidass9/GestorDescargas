import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
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
				//guardar en variables tots els camps
			};
		});

		add(botonAceptar);
		
		
	}

}
