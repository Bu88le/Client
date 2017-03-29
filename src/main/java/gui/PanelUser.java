package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelUser extends JPanel {

	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;

	int							widthRigid			= 0;
	String						username;
	URI							uri					= null;
	Image						image, imageSettings, imageAdd;
	JLabel						lblImage, lblUsername, lblSettings, lblAdd;

	public PanelUser(String username) {
		this.username = username;
		initGUI();
	}

	public PanelUser(String username, int width) {
		this.username = username;
		widthRigid = width;
		initGUI();
	}

	private void initGUI() {

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setPreferredSize(new Dimension(200, 50));
		setBorder(new LineBorder(Color.BLACK));

		add(Box.createRigidArea(new Dimension(2, 0)));

		try {
			image = ImageIO.read(getClass().getClassLoader().getResource("images/black.png"));
			image = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			lblImage = new JLabel(new ImageIcon(image));
			lblImage.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblImage.setPreferredSize(new Dimension(32, 32));
			add(lblImage);
		} catch (IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}

		add(Box.createRigidArea(new Dimension(5, 0)));

		lblUsername = new JLabel(username, SwingConstants.CENTER);
		add(lblUsername);

		add(Box.createHorizontalGlue());

		try {
			uri = getClass().getClassLoader().getResource("images/add.png").toURI();
			imageAdd = ImageIO.read(new File(uri));
			imageAdd = imageAdd.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
			lblAdd = new JLabel(new ImageIcon(imageAdd));
			lblAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblAdd.setToolTipText("Add a new friend");
			lblAdd.setPreferredSize(new Dimension(25, 25));
			add(lblAdd);
		} catch (IOException | URISyntaxException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}

		add(Box.createRigidArea(new Dimension(4, 0)));

		try {
			uri = getClass().getClassLoader().getResource("images/dots.png").toURI();
			imageSettings = ImageIO.read(new File(uri));
			imageSettings = imageSettings.getScaledInstance(23, 9, Image.SCALE_SMOOTH);
			lblSettings = new JLabel(new ImageIcon(imageSettings));
			lblSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblSettings.setToolTipText("Menu");
			lblSettings.setPreferredSize(new Dimension(25, 11));
			add(lblSettings);
		} catch (IOException | URISyntaxException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(null, 1, 1, null);

	}

	public void setWidthRigid(int width) {
		widthRigid = width;
	}

}
