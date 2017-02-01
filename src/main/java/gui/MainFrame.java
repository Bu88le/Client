package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;

import serverConnection.CheckLogin;

public class MainFrame {

	public static JFrame	mainFrame;
	static JPanel			centerpanel	= null;
	public static JFrame	loginFrame;
	JButton					bt_login, bt_register;
	JTextField				tf_username;
	JPasswordField			pf_password;
	JLabel					lb_username, lb_password;
	public static JLabel	message;
	static Container		c;
	
	public MainFrame() {
		initGUI();
	}
	
	@SuppressWarnings("unused")
	private void initGUI() {
		mainFrame = new JFrame("Client");
		mainFrame.setSize(new Dimension(600, 450));
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		c = mainFrame.getContentPane();
		c.setLayout(new BorderLayout());
		mainFrame.setMinimumSize(new Dimension(600, 450));
		mainFrame.setVisible(true);
		
		loginFrame = new JFrame("Login");
		loginFrame.setLayout(null);
		loginFrame.setSize(new Dimension(350, 200));
		loginFrame.setLocationRelativeTo(mainFrame);
		loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		lb_username = new JLabel("<html><b>Benutzername</html>", SwingConstants.CENTER);
		lb_username.setBounds(5, 10, 85, 20);
		loginFrame.getContentPane().add(lb_username);
		
		tf_username = new JTextField();
		tf_username.setSize(new Dimension(200, 20));
		tf_username.setLocation(110, 10);
		//tf_username.setBounds(100, 10, 250, 20);
		tf_username.setBorder(new LineBorder(Color.black));
		loginFrame.getContentPane().add(tf_username);
		
		lb_password = new JLabel("<html><b>Passwort</html>", SwingConstants.CENTER);
		lb_password.setBounds(5, 40, 85, 20);
		loginFrame.getContentPane().add(lb_password);
		
		pf_password = new JPasswordField();
		pf_password.setBounds(110, 40, 200, 20);
		pf_password.setBorder(new LineBorder(Color.BLACK));
		loginFrame.getContentPane().add(pf_password);
		
		bt_login = new JButton("Login");
		bt_login.setBounds(10, 120, 120, 25);
		bt_login.addActionListener(e -> {
			message.setText("");
			String password = "";
			char[] input = pf_password.getPassword();
			for (char element : input)
				password += element;
			new CheckLogin(tf_username.getText(), password, CheckLogin.LOGIN);
			
		});
		loginFrame.getContentPane().add(bt_login);
		
		bt_register = new JButton("Registrieren");
		bt_register.setBounds(205, 120, 120, 25);
		bt_register.addActionListener(e -> {
			message.setText("");
			String password = "";
			char[] input = pf_password.getPassword();
			for (char element : input)
				password += element;
			new CheckLogin(tf_username.getText(), password, CheckLogin.REGISTER);
		});
		loginFrame.getContentPane().add(bt_register);
		
		message = new JLabel("", SwingConstants.CENTER);
		message.setBounds(5, 75, 310, 30);
		loginFrame.add(message);
		
		loginFrame.setVisible(true);
	}
	
	public static void panelClient() {
		if (centerpanel != null)
			c.remove(centerpanel);
		c.add(centerpanel = new PanelClient(), BorderLayout.CENTER);
		c.revalidate();
	}
}
