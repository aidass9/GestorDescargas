import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class InterfazLogin extends JPanel {
	
	InterfazLogin() {
		
		setLayout(new GridLayout(3, 2, 20, 10));
		setBorder(new EmptyBorder(20, 10, 50, 10));
		
		JLabel labelUsuario = new JLabel("Usuario");
		final JTextField usuario = new JTextField();
		add(labelUsuario);
		add(usuario);
		
		JLabel labelPass = new JLabel("Contraseña");
		final JPasswordField pass = new JPasswordField();
		add(labelPass);
		add(pass);
		
		JButton botonAceptar = new JButton("Aceptar");
		botonAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String stringUsuario = usuario.getText();
					//getPassword() -> devuelve un array de caracteres (char[])
					//Para pasar el el contenido del array a String -> String.valueOg()
				String stringPass = String.valueOf(pass.getPassword());
				
				String sql = "SELECT contraseña FROM usuarios WHERE usuario='" + stringUsuario + "';";
				
				
				ResultSet resultadoConsulta =  BaseDatos.consultar(sql);
				
				/*while(resultadoConsulta.next()) {
					
				}*/
			}
		});
		
		add(botonAceptar);

	}
	

}
