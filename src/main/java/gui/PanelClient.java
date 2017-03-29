package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.net.URI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import net.java.dev.designgridlayout.DesignGridLayout;
import serverConnection.ChatConnection;

public class PanelClient extends JPanel {
	
	private static final long	serialVersionUID	= -4308067181923954687L;

	static JPanel				panelCenter, panelLeft, panelCenterTop, panelCenterCenter, panelCenterDown, panelLeftCenter, panelLeftTop;
	String						username;
	JLabel						usernameLeftTop;
	ChatConnection				cc;
	GridBagConstraints			c					= new GridBagConstraints();
	DesignGridLayout			layout;
	Image						profilePicture		= null;
	URI							uri					= null;
	Image						image;
	static int					height				= (int) MainFrame.getDimension().getHeight(), width = (int) MainFrame.getDimension().getWidth();
	PanelUser					pUser;
	
	public PanelClient() {
		setLayout(new BorderLayout());
		//Thread thread = new Thread(cc = new ChatConnection());
		//thread.start();
		initGUI();
	}

	private void initGUI() {
		
		panelLeft = new JPanel();
		panelLeft.setBorder(new LineBorder(Color.BLACK));
		panelLeft.setLayout(new BorderLayout());
		{
			pUser = new PanelUser("Josef");
			panelLeft.add(pUser, BorderLayout.NORTH);
		}
		add(panelLeft, BorderLayout.WEST);
		
		revalidate();
		repaint();
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new BorderLayout());
		{
			
		}
		add(panelCenter, BorderLayout.CENTER);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 1, 1, null);
		
	}

	public void setUsername(String s) {
		username = s;
	}
	
	public void resize() {
		height = (int) MainFrame.getDimension().getHeight();
		width = (int) MainFrame.getDimension().getWidth();
		revalidate();
	}
}