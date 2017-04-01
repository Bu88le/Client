package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import network.SendableLogin;
import serverConnection.ServerConnection;

public class PanelLogin extends JPanel {
	
	/**
	 *
	 */
	private static final long	serialVersionUID	= -6214531407691449222L;
	
	Image						image;
	JLabel						lblImg, lblRegistrationLink;
	JPanel						panelCenter, panelSouth, panelCenterCenterLeft, panelCenterCenterRight;
	JLabel						lblUsername, lblPassword;
	JTextField					tfUsername;
	JPasswordField				jpPassword;
	JButton						btLogin;
	GridBagConstraints			c					= new GridBagConstraints();
	Boolean						pwField				= false, tField = false;
	static Boolean				registrationExists	= false;
	ServerConnection			connection;
	String						pw, username;
	JFrame						caller;

	public PanelLogin(ServerConnection connection, JFrame caller) {
		this.caller = caller;
		this.connection = connection;
		setLayout(new BorderLayout());
		initGUI();
	}

	private void initGUI() {
		try {
			image = ImageIO.read(getClass().getClassLoader().getResource("images/speech-md.png"));
			image = image.getScaledInstance(200, 120, Image.SCALE_SMOOTH);
			lblImg = new JLabel(new ImageIcon(image));
			lblImg.setPreferredSize(new Dimension(202, 130));
			add(lblImg, BorderLayout.NORTH);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		panelCenter = new JPanel();
		panelCenter.setBorder(new EmptyBorder(10, 10, 10, 10));
		panelCenter.setLayout(new BorderLayout());
		{
			JPanel panelCenterCenter = new JPanel();
			panelCenterCenter.setLayout(new BorderLayout());
			{
				//panelCenterCenter.add(Box.createVerticalGlue(), BorderLayout.CENTER);
				lblUsername = new JLabel("<html><b><font size = 4><font color = #000000>Username</html>", SwingConstants.CENTER);
				lblPassword = new JLabel("<html><b><font size =4><font color = #000000>Password</html>", SwingConstants.CENTER);

				tfUsername = new JTextField();
				tfUsername.setPreferredSize(new Dimension(200, 25));
				tfUsername.addKeyListener(new KeyAdapter() {

					@Override
					public void keyReleased(KeyEvent arg0) {
						if (verifyUsername(tfUsername.getText())) {
							tfUsername.setBorder(new LineBorder(Color.black, 1));
							username = tfUsername.getText();
						} else
							tfUsername.setBorder(new LineBorder(Color.RED, 2));

						if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
							if ((tfUsername.getText() != null) && (verifyUsername(tfUsername.getText()) == true)) {
								username = tfUsername.getText();
								btLogin.doClick();
							} else
								tfUsername.setBorder(new LineBorder(Color.RED));
					}
				});

				jpPassword = new JPasswordField();
				jpPassword.setPreferredSize(new Dimension(200, 25));
				jpPassword.addKeyListener(new KeyAdapter() {

					@Override
					public void keyReleased(KeyEvent arg0) {
						pw = "";
						for (int i = 0; i < jpPassword.getPassword().length; i++)
							pw += jpPassword.getPassword()[i];

						if (verifyPassword(pw))
							jpPassword.setBorder(new LineBorder(Color.black, 1));
						else
							jpPassword.setBorder(new LineBorder(Color.RED, 2));

						if (arg0.getKeyCode() == KeyEvent.VK_ENTER)
							if ((pw != null) && (verifyPassword(pw) == true))
								btLogin.doClick();
							else {
								pw = null;
								jpPassword.setBorder(new LineBorder(Color.RED, 2));
							}
					}
				});

				JPanel panel = new JPanel();
				panel.setLayout(new GridBagLayout());
				{
					c.insets = new Insets(5, 8, 10, 8);
					c.fill = GridBagConstraints.NONE;
					c.gridx = 0;
					c.gridy = 0;
					panel.add(lblUsername, c);

					c.gridx = 1;
					panel.add(tfUsername, c);

					c.gridx = 0;
					c.gridy = 1;
					panel.add(lblPassword, c);

					c.gridx = 1;
					panel.add(jpPassword, c);
				}
				panelCenterCenter.add(panel, BorderLayout.CENTER);

			}
			panelCenter.add(panelCenterCenter, BorderLayout.CENTER);

			JPanel panelCenterSouth = new JPanel();
			panelCenterSouth.setLayout(new BoxLayout(panelCenterSouth, BoxLayout.X_AXIS));
			{
				btLogin = new JButton("Login");
				btLogin.setBackground(Color.DARK_GRAY);
				btLogin.setForeground(Color.WHITE);
				btLogin.setBorderPainted(false);
				btLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
				btLogin.setPreferredSize(new Dimension(120, 30));
				btLogin.addActionListener(arg0 -> {
					if ((pwField == true) && (tField == true)) {
						SendableLogin sl = new SendableLogin(username, pw);
						pw = null;
						connection.sendLogin(sl);
					}

				});
			}
			panelCenterSouth.add(Box.createHorizontalGlue());
			panelCenterSouth.add(btLogin);
			panelCenterSouth.add(Box.createHorizontalGlue());
			panelCenter.add(panelCenterSouth, BorderLayout.SOUTH);
		}
		add(panelCenter, BorderLayout.CENTER);

		panelSouth = new JPanel();
		panelSouth.setBorder(new EmptyBorder(10, 0, 5, 0));
		panelSouth.setLayout(new BorderLayout());
		{
			lblRegistrationLink = new JLabel("", SwingConstants.CENTER);
			lblRegistrationLink.setText("<html><u><font color = #0000FF> Noch kein Konto? Hier gehts zur Anmeldung</html>");
			lblRegistrationLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblRegistrationLink.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent arg0) {
					if (registrationExists == false) {
						registrationExists = true;
						new RegistrationWindow(caller, connection);
					} else {

					}

				}

			});
			panelSouth.add(lblRegistrationLink, BorderLayout.CENTER);
		}
		add(panelSouth, BorderLayout.SOUTH);

	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(null, 1, 5, null);

	}
	
	private Boolean verifyUsername(String username) {
		return username.matches("[A-Za-z1-9_.]*");
	}

	private Boolean verifyPassword(String password) {
		return password.matches("[A-Za-z1-9!\\?@\\(\\)\\{\\}\\[\\]\\\\/|<>=~$€%&#\\*-\\+.:,;'\"_]*");
	}

	public static void setBooleanWindow(Boolean b) {
		registrationExists = b;
	}

}
