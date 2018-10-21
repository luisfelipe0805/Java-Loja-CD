package viewInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Label;
import javax.swing.ImageIcon;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField loginText;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginText = new JTextField();
		loginText.setBounds(155, 201, 226, 20);
		contentPane.add(loginText);
		loginText.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(154, 254, 226, 20);
		contentPane.add(passwordField);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(157, 181, 46, 14);
		contentPane.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(156, 238, 46, 14);
		contentPane.add(lblSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(338, 305, 89, 23);
		contentPane.add(btnEntrar);
		
		JLabel iconLbl = new JLabel("New label");
		iconLbl.setBounds(196, 24, 140, 144);
		
		ImageIcon imagem=new ImageIcon(TelaLogin.class.getResource("/viewInterface/imagens/logo-icon-2.png"));
		
		Image imag=imagem.getImage().getScaledInstance(iconLbl.getWidth(), iconLbl.getHeight(), Image.SCALE_SMOOTH);
		iconLbl.setIcon(new ImageIcon(imag));
		
		
		
		contentPane.add(iconLbl);
	}
}
