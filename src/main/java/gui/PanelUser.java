package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
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

	int							width				= (int) MainFrame.getDimension().getWidth(), height = (int) MainFrame.getDimension().getHeight();
	String						username;
	URI							uri					= null;
	Image						image, imageSettings, imageAdd;
	JLabel						lblImage, lblUsername, lblSettings, lblAdd;

	public PanelUser(String username) {
		this.username = username;
		initGUI();
	}
	
	public PanelUser(String username, int width, int height) {
		this.width = width;
		this.height = height;
		this.username = username;
		initGUI();
	}

	private void initGUI() {
		removeAll();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setPreferredSize(new Dimension((width / 3), (int) (0.112 * height)));
		setBorder(new LineBorder(Color.BLACK));

		add(Box.createRigidArea(new Dimension((int) (0.01 * (width / 3)), 0)));

		try {
			image = ImageIO.read(getClass().getClassLoader().getResource("images/black.png"));

			lblImage = new JLabel();
			lblImage.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblImage.setMinimumSize(new Dimension((int) (0.16 * (width / 3)), (int) (0.64 * 0.11 * height)));
			if (((0.92 * 0.16 * (width / 3)) > 68) || ((0.92 * 0.64 * 0.11 * height) > 68))
				image = image.getScaledInstance((int) (0.92 * 80), (int) (0.62 * 115), Image.SCALE_SMOOTH);
			else
				image = image.getScaledInstance((int) (0.95 * 0.16 * (width / 3)), (int) (0.95 * 0.64 * 0.11 * height), Image.SCALE_SMOOTH);

			lblImage.setMaximumSize(new Dimension(65, 65));
			lblImage.setIcon(new ImageIcon(image));
			add(lblImage);
		} catch (IOException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}

		add(Box.createRigidArea(new Dimension(10, 0)));

		lblUsername = new JLabel(username, SwingConstants.LEFT);
		if ((int) (0.24 * 0.11 * height) > 24)
			lblUsername.setFont(new Font("Calibri", Font.BOLD, 22));
		else if ((int) (0.24 * 0.11 * height) < 12)
			lblUsername.setFont(new Font("Calibri", Font.BOLD, 13));
		else
			lblUsername.setFont(new Font("Calibri", Font.BOLD, (int) (0.24 * 0.11 * height)));

		add(lblUsername);

		add(Box.createHorizontalGlue());

		try {
			uri = getClass().getClassLoader().getResource("images/add.png").toURI();
			imageAdd = ImageIO.read(new File(uri));
			//imageAdd = imageAdd.getScaledInstance((int) (0.115 * (width / 3)), (int) (0.46 * 0.11 * height), Image.SCALE_SMOOTH);
			imageAdd = imageAdd.getScaledInstance(23, 23, Image.SCALE_SMOOTH);
			lblAdd = new JLabel(new ImageIcon(imageAdd));
			lblAdd.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblAdd.setToolTipText("Add a new friend");
			//lblAdd.setPreferredSize(new Dimension((int) (0.125 * (width / 3)), (int) (0.5 * 0.11 * height)));
			lblAdd.setMinimumSize(new Dimension(25, 25));
			add(lblAdd);
		} catch (IOException | URISyntaxException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}

		add(Box.createRigidArea(new Dimension(10, 0)));

		try {
			uri = getClass().getClassLoader().getResource("images/dots.png").toURI();
			imageSettings = ImageIO.read(new File(uri));
			//imageSettings = imageSettings.getScaledInstance((int) (0.115 * (width / 3)), (int) (0.18 * 0.11 * height), Image.SCALE_SMOOTH);
			imageSettings = imageSettings.getScaledInstance(25, 9, Image.SCALE_SMOOTH);
			lblSettings = new JLabel(new ImageIcon(imageSettings));
			lblSettings.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblSettings.setToolTipText("Menu");
			//lblSettings.setPreferredSize(new Dimension((int) (0.125 * (width / 3)), (int) (0.22 * 0.11 * height)));
			lblSettings.setMinimumSize(new Dimension(25, 11));
			add(lblSettings);
		} catch (IOException | URISyntaxException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
		}

		add(Box.createRigidArea(new Dimension(5, 0)));

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(null, 1, 1, null);

	}

	public void resizePanel(int width, int height) {
		this.width = width;
		this.height = height;
		initGUI();
		revalidate();
		repaint();
	}

}
