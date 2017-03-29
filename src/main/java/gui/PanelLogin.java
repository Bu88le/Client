package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

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
	
	public PanelLogin() {
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
		panelCenter.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), new LineBorder(Color.white)));
		panelCenter.setLayout(new BorderLayout());
		{
			JPanel panelCenterCenter = new JPanel();
			panelCenterCenter.setLayout(new BoxLayout(panelCenterCenter, BoxLayout.Y_AXIS));
			{
				panelCenterCenter.add(Box.createVerticalGlue());
				lblUsername = new JLabel("<html><b><font size = 4><font color = #000000>Username</html>", SwingConstants.CENTER);
				JPanel panel = new JPanel();
				panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
				{
					panel.add(Box.createHorizontalGlue());
					panel.add(lblUsername);
					
					JPanel pl = new JPanel();
					pl.setLayout(new BorderLayout());
					{
						tfUsername = new JTextField();
						tfUsername.setBorder(new LineBorder(Color.DARK_GRAY));
						tfUsername.setPreferredSize(new Dimension(120, 25));
						pl.add(tfUsername, BorderLayout.CENTER);
					}
					panel.add(Box.createRigidArea(new Dimension(10, 0)));
					panel.add(pl);
					panel.add(Box.createHorizontalGlue());

				}
				
				panelCenterCenter.add(panel);
				panelCenterCenter.add(Box.createRigidArea(new Dimension(0, 10)));
				
				lblPassword = new JLabel("<html><b><font size =4><font color = #000000>Password</html>", SwingConstants.CENTER);
				JPanel panel2 = new JPanel();
				panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
				{
					panel2.add(Box.createHorizontalGlue());
					panel2.add(lblPassword);

					JPanel p = new JPanel();
					p.setLayout(new BorderLayout());
					{
						jpPassword = new JPasswordField();
						jpPassword.setBorder(new LineBorder(Color.DARK_GRAY));
						jpPassword.setPreferredSize(new Dimension(120, 1));
						p.add(jpPassword, BorderLayout.CENTER);
					}
					
					panel2.add(Box.createRigidArea(new Dimension(10, 0)));
					panel2.add(p);
					panel2.add(Box.createHorizontalGlue());
				}

				panelCenterCenter.add(panel2);
				panelCenterCenter.add(Box.createVerticalGlue());
			}
			panelCenter.add(panelCenterCenter, BorderLayout.CENTER);
			
			JPanel panelCenterSouth = new JPanel();
			panelCenterSouth.setLayout(new BoxLayout(panelCenterSouth, BoxLayout.X_AXIS));
			btLogin = new JButton("Login");
			btLogin.setBackground(Color.DARK_GRAY);
			btLogin.setForeground(Color.WHITE);
			btLogin.setBorderPainted(false);
			btLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
			btLogin.setPreferredSize(new Dimension(120, 30));
			btLogin.addActionListener(arg0 -> {
				// TODO Auto-generated method stub
				
			});
			panelCenterSouth.add(Box.createHorizontalGlue());
			panelCenterSouth.add(btLogin);
			panelCenterSouth.add(Box.createHorizontalGlue());
			panelCenter.add(panelCenterSouth, BorderLayout.SOUTH);
		}
		add(panelCenter, BorderLayout.CENTER);
		
		panelSouth = new JPanel();
		panelSouth.setBorder(new CompoundBorder(new EmptyBorder(5, 0, 5, 0), new LineBorder(Color.white)));
		panelSouth.setLayout(new BorderLayout());
		{
			lblRegistrationLink = new JLabel("", SwingConstants.CENTER);
			lblRegistrationLink.setText("<html><u><font color = #0000FF> Noch kein Konto? Hier gehts zur Anmeldung</html>");
			lblRegistrationLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblRegistrationLink.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
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
	
}
