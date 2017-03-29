package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class MainFrame {
	
	public static JFrame	mainFrame;
	static JPanel			centerpanel	= null;
	public static JFrame	loginFrame;
	JButton					bt_login, bt_register;
	JTextField				tf_username;
	JPasswordField			pf_password;
	JLabel					lb_username, lb_password;
	BufferedImage			image;
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
		
		panelLogin();
		mainFrame.setVisible(true);
		
	}

	private void panelLogin() {
		if (centerpanel != null)
			c.remove(centerpanel);

		c.add(centerpanel = new PanelLogin(), BorderLayout.CENTER);
		c.revalidate();

	}

	public static void panelClient() {
		c.remove(centerpanel);
		c.add(centerpanel = new PanelClient(), BorderLayout.CENTER);
		c.revalidate();
	}

	public static Dimension getDimension() {
		return mainFrame.getSize();
	}
}
