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

import serverConnection.ServerConnection;

public class MainFrame {

	public static JFrame	mainFrame;
	static JPanel			centerpanel	= null;
	JButton					bt_login, bt_register;
	JTextField				tf_username;
	JPasswordField			pf_password;
	JLabel					lb_username, lb_password;
	BufferedImage			image;
	public static JLabel	message;
	static Container		c;
	PanelClient				pc;
	
	ServerConnection		connection;
	
	public MainFrame(ServerConnection connection) {
		this.connection = connection;
		initGUI();
	}
	
	private void initGUI() {
		mainFrame = new JFrame("Client");
		mainFrame.setSize(new Dimension(600, 450));
		mainFrame.setMinimumSize(new Dimension(600, 450));
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		c = mainFrame.getContentPane();
		c.setLayout(new BorderLayout());
		
		//panelLogin();
		panelClient();
		mainFrame.setVisible(true);

	}
	
	private void panelLogin() {
		if (centerpanel != null)
			c.remove(centerpanel);
		
		c.add(centerpanel = new PanelLogin(connection, mainFrame), BorderLayout.CENTER);
		c.revalidate();
		
	}
	
	public void panelClient() {
		//c.remove(centerpanel);
		pc = new PanelClient();
		c.add(centerpanel = pc, BorderLayout.CENTER);
		c.revalidate();
		//		listener();
	}
	
	public static Dimension getDimension() {
		return mainFrame.getSize();
	}

	public static JFrame getFrame() {
		return mainFrame;
	}
	
	//	private void listener() {
	//		mainFrame.addComponentListener(new ComponentAdapter() {
	//			
	//			@Override
	//			public void componentResized(ComponentEvent e) {
	//				pc.panelResize(mainFrame.getWidth(), mainFrame.getHeight());
	//				c.revalidate();
	//				c.repaint();
	//			}
	//			
	//		});
	//	}

}
