package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import logic.Profile;

public class PanelChats extends JPanel {
	
	/**
	 *
	 */
	private static final long	serialVersionUID	= 1L;
	Connection					con					= null;
	PreparedStatement			ps					= null;
	Statement					statement			= null;
	ArrayList<Profile>			list				= new ArrayList<>();
	JPanel						floorPanel, pChat;
	int							width, height;
	Image						image;
	JLabel						lblImage, lblUsername;

	public PanelChats(int width, int height) {
		this.width = width;
		this.height = height;
		searchForChats();
		initGUI();
	}

	private void searchForChats() {
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:file:c:/database/", "root", "");
			con.setAutoCommit(false);
			//UUID id = UUID.randomUUID();
			//ps = con.prepareStatement("INSERT INTO CLIENT (ID,UUID,Profile,Message) VALUES(?,?,?,?)");
			//ps.setObject(1, id.toString());
			//ps.setObject(2, id);
			//Profile pf = new Profile();
			//Image img = Toolkit.getDefaultToolkit().createImage(getClass().getClassLoader().getResource("images/laden.gif"));
			//ImageIcon ii = new ImageIcon(getClass().getClassLoader().getResource("images/laden.gif"));
			//pf.setImageicon(ii);
			//pf.setNickname("Leo");
			//ps.setObject(3, pf);
			//ps.setObject(4, null);
			//ps.executeUpdate();
			//con.commit();
			statement = con.createStatement();
			ResultSet rs = statement.executeQuery("SELECT PROFILE from CLIENT");
			while (rs.next()) {
				Profile p = (Profile) rs.getObject(1);
				list.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void initGUI() {
		floorPanel = new JPanel();
		floorPanel.setLayout(new BoxLayout(floorPanel, BoxLayout.PAGE_AXIS));
		for (Profile p : list) {
			pChat = new JPanel();
			pChat.setLayout(new BoxLayout(pChat, BoxLayout.X_AXIS));
			pChat.setMinimumSize(new Dimension(150, 50));
			pChat.setPreferredSize(new Dimension((width / 3) - 20, 50));
			
			pChat.setBorder(new LineBorder(Color.DARK_GRAY));
			
			pChat.add(Box.createRigidArea(new Dimension((int) (0.01 * (width / 3)), 0)));
			
			try {
				image = ImageIO.read(new ByteArrayInputStream(p.getImage()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			image = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			ImageIcon ii = new ImageIcon(image);
			lblImage = new JLabel(ii);
			lblImage.setCursor(new Cursor(Cursor.HAND_CURSOR));
			lblImage.setMinimumSize(new Dimension((int) (0.16 * (width / 3)), (int) (0.64 * 0.11 * height)));
			//if (((0.92 * 0.16 * (width / 3)) > 68) || ((0.92 * 0.64 * 0.11 * height) > 68))
			//	image = image.getScaledInstance((int) (0.92 * 80), (int) (0.62 * 115), Image.SCALE_SMOOTH);
			//else
			//	image = image.getScaledInstance((int) (0.95 * 0.16 * (width / 3)), (int) (0.95 * 0.64 * 0.11 * height), Image.SCALE_SMOOTH);
			//image = image.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
			lblImage.setMaximumSize(new Dimension(65, 65));
			pChat.add(lblImage);
			
			pChat.add(Box.createRigidArea(new Dimension(10, 0)));
			
			lblUsername = new JLabel(p.getNickname(), SwingConstants.LEFT);
			if ((int) (0.24 * 0.11 * height) > 24)
				lblUsername.setFont(new Font("Calibri", Font.BOLD, 22));
			else if ((int) (0.24 * 0.11 * height) < 12)
				lblUsername.setFont(new Font("Calibri", Font.BOLD, 13));
			else
				lblUsername.setFont(new Font("Calibri", Font.BOLD, (int) (0.24 * 0.11 * height)));
			pChat.add(lblUsername);
			pChat.add(Box.createHorizontalGlue());
			
			floorPanel.add(pChat);
			
		}
		add(floorPanel);
		
	}
}
