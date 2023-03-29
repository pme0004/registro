package Conectadobbdd;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Registro extends JFrame {

	private JPanel contentPane;
	private JTextField campomail;
	private JPasswordField campocontraseña;
	private JPasswordField campocontraseña2;
	private JButton btnregistro;
	private JTextField camponombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registro() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registro.class.getResource("/media/MEDAC (1).jpg")));
		setTitle("Regístrate en nuestra plataforma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //mata el programa cuando se cierra la ventana
		setBounds(600, 300, 707, 425);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		campomail = new JTextField();
		campomail.setBounds(309, 102, 101, 20);
		contentPane.add(campomail);
		campomail.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("REGISTRO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(301, 11, 95, 27);
		contentPane.add(lblNewLabel);
		
		JLabel labelmail = new JLabel("E-mail");
		labelmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelmail.setBounds(242, 102, 52, 17);
		contentPane.add(labelmail);
		
		JLabel labelcontraseña = new JLabel("Contraseña");
		labelcontraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelcontraseña.setBounds(220, 130, 95, 14);
		contentPane.add(labelcontraseña);
		
		JLabel labelrepetir = new JLabel("Repetir contraseña");
		labelrepetir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelrepetir.setBounds(170, 160, 156, 14);
		contentPane.add(labelrepetir);
			
		JCheckBox checkcontraseña = new JCheckBox("Mostrar contraseña");
		checkcontraseña.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(checkcontraseña.isSelected()) {
					campocontraseña.setEchoChar((char)0); //cuando se selecciona la checkbox se muestra la contraseña
				}else {
					campocontraseña.setEchoChar('•'); //cuando se deselecciona sustituye los caracteres por asteriscos
				}
				if(checkcontraseña.isSelected()) {
					campocontraseña2.setEchoChar((char)0);
				}else {
					campocontraseña2.setEchoChar('•');
				}
			}
		});
		
		
		btnregistro = new JButton("REGISTRARSE");
		
		btnregistro.setBounds(301, 317, 122, 23);
		contentPane.add(btnregistro);
		
		campocontraseña = new JPasswordField();
		campocontraseña.setBounds(309, 129, 101, 20);
		contentPane.add(campocontraseña);
		
		campocontraseña2 = new JPasswordField();
		campocontraseña2.setBounds(309, 159, 101, 20);
		contentPane.add(campocontraseña2);
		
		JLabel imagen = new JLabel("");
		imagen.setIcon(new ImageIcon(Registro.class.getResource("/media/MEDAC (1).jpg")));
		imagen.setBounds(0, 0, 160, 205);
		contentPane.add(imagen);
		
		JCheckBox checkpolitica = new JCheckBox("Acepto la política de privacidad");
		
		checkpolitica.setBounds(267, 270, 206, 23);
		contentPane.add(checkpolitica);
		
		JLabel lblNewLabel_6 = new JLabel("La contraseña debe contener al menos un signo de exclamación o interrogación,");
		lblNewLabel_6.setBounds(174, 199, 498, 27);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("ocho caracteres y el mail una arroba y un punto");
		lblNewLabel_7.setBounds(174, 237, 367, 14);
		contentPane.add(lblNewLabel_7);
		
		checkcontraseña.setBounds(416, 128, 138, 23);
		contentPane.add(checkcontraseña);
		
		camponombre = new JTextField();
		camponombre.setBounds(310, 71, 100, 20);
		contentPane.add(camponombre);
		camponombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(237, 72, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		//BOTON REGISTRO
		btnregistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkpolitica.isSelected()) {
					if(campocontraseña.getText().equals(campocontraseña2.getText())) { 
						if(campomail.getText().contains("@") || campomail.getText().contains(".")) { 
							if(campocontraseña.getText().contains("!") || campocontraseña.getText().contains("?")) { 
								if(campocontraseña.getText().length()>=8) {
									Exito obj=new Exito();
									obj.setVisible(true);
									dispose();
								}else {
									System.out.println("Contraseña corta");
									Error obj=new Error();
									obj.setVisible(true);
									dispose();
								}
							}else {
								System.out.println("La contraseña no tiene caracteres especiales");
								Error obj=new Error();
								obj.setVisible(true);
								dispose();
							}
						}else {
							System.out.println("Lo que has metido no es un mail");
							Error obj=new Error();
							obj.setVisible(true);
							dispose();
						}	
					}else{
						System.out.println("no son iguales");
						Error obj=new Error();
						obj.setVisible(true);
						dispose();
					}
				}else {
					System.out.println("No has aceptado la politica");
					Error obj=new Error();
					obj.setVisible(true);
					dispose();
				}
			}
		});
	}
}
