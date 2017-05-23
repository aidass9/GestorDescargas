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
	JLabel labelUsuario;
	JLabel labelPass;
	
	final JTextField usuario;
	final JPasswordField pass;
	
	InterfazLogin() {
		
		setLayout(new GridLayout(3, 2, 20, 10));
		setBorder(new EmptyBorder(20, 10, 50, 10));
		
		labelUsuario = new JLabel("Usuario");
		usuario = new JTextField(); usuario.setText("asoriano");
		add(labelUsuario);
		add(usuario);
		
		labelPass = new JLabel("Contraseña");
		pass = new JPasswordField(); pass.setText("1234");
		add(labelPass);
		add(pass);
		
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
				String stringUsuario = usuario.getText();
					//getPassword() -> devuelve un array de caracteres (char[])
					//Para pasar el el contenido del array a String -> String.valueOf()
				String stringPass = String.valueOf(pass.getPassword());
				String passObtenido ="";
				
				String sql = "SELECT contraseña FROM usuarios WHERE usuario='" + stringUsuario + "';";
				System.out.println(sql);

				
				try {
					ResultSet resultadoConsulta = BaseDatos.consultar(sql);

					while (resultadoConsulta.next()) {
						System.out.println(resultadoConsulta);
						passObtenido = resultadoConsulta.getString("contraseña");
					}	
				}
				
				catch (Exception a) {
					System.out.println(a.toString());
				}

				
				if (stringPass.equals(passObtenido)) {
					System.out.println("Las contraseñas coinciden");
					InterfazGrafica.ventanaBienvenida();
					iniciarSesion();
					
				}
				else {
					System.out.println("El usuario o la contraseña no coinciden");
				}


			}
		});
		
		add(botonAceptar);
		
	}
	
	public void iniciarSesion() {
		String sql = "SELECT * FROM usuarios WHERE usuario='" + usuario.getText() + "';";
		
		String usuario= "", contraseña= "", nombre= "", apellidos= "", email= "", fnacimiento = "";
		int bajadas = 0, subidas = 0;
		
		try {
			ResultSet resultadoConsulta = BaseDatos.consultar(sql);

			while (resultadoConsulta.next()) {
				usuario = resultadoConsulta.getString("usuario");
				contraseña = resultadoConsulta.getString("contraseña");
				nombre = resultadoConsulta.getString("nombre");
				apellidos = resultadoConsulta.getString("apellidos");
				email = resultadoConsulta.getString("email");
				fnacimiento = resultadoConsulta.getString("fnacimiento");
				bajadas = resultadoConsulta.getInt("bajadas");
				subidas = resultadoConsulta.getInt("subidas"); //els que van en "" son el mateix nom que la base de datos
			}	
		}
		
		catch (Exception a) {
			System.out.println(a.toString());
		}
		
		//InterfazGrafica.sesionUsuario = new Usuario();
	}

}
