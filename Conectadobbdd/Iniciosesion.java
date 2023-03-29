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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Iniciosesion extends JFrame {
	private JTextField campomail;
	private JPasswordField campocontraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Iniciosesion frame = new Iniciosesion();
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
	public Iniciosesion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Iniciosesion.class.getResource("/media/MEDAC (1).jpg")));
		setTitle("Inicia sesión en nuestra plataforma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(600, 300, 577, 352);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INICIO DE SESIÓN");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(209, 24, 174, 43);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("E-Mail");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(178, 97, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Contraseña");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(165, 135, 72, 14);
		getContentPane().add(lblNewLabel_2);
		
		campomail = new JTextField();
		campomail.setBounds(247, 95, 86, 20);
		getContentPane().add(campomail);
		campomail.setColumns(10);
		
		campocontraseña = new JPasswordField();
		campocontraseña.setBounds(247, 133, 86, 20);
		getContentPane().add(campocontraseña);
		
		JCheckBox checkcontraseña = new JCheckBox("Mostrar contraseña");
		checkcontraseña.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(checkcontraseña.isSelected()) {
					campocontraseña.setEchoChar((char)0);
				}else {
					campocontraseña.setEchoChar('•');
				}
			}
		});
	
		checkcontraseña.setBounds(349, 132, 151, 23);
		getContentPane().add(checkcontraseña);
		
		JButton btnNewButton = new JButton("Iniciar sesión");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(campomail.getText().contains("@") || campomail.getText().contains(".")) {
					if(campocontraseña.getText().length()>=8) {
						if(campocontraseña.getText().contains("!") || campocontraseña.getText().contains("?")) {
							Exito obj=new Exito();
							obj.setVisible(true);
							dispose();
						}else {
							System.out.println("mala contraseña");
							Error obj=new Error();
							obj.setVisible(true);
							dispose();
						}
					}else {
						System.out.println("mala longitud");
						Error obj=new Error();
						obj.setVisible(true);
						dispose();
					}
					
				}else {
					System.out.println("caracteres incorrectos en el mail");
					Error obj=new Error();
					obj.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		btnNewButton.setBounds(222, 200, 124, 28);
		getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Iniciosesion.class.getResource("/media/MEDAC (1).jpg")));
		lblNewLabel_3.setBounds(0, 0, 155, 193);
		getContentPane().add(lblNewLabel_3);
	}
} 
	