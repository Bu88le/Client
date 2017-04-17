package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.net.URI;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import net.java.dev.designgridlayout.DesignGridLayout;

public class PanelClient extends JPanel {

	private static final long	serialVersionUID	= -4308067181923954687L;
	
	static JPanel				panelCenter, panelLeft, panelCenterTop, panelCenterCenter, panelCenterDown, panelLeftCenter, panelLeftTop;
	String						username;
	JLabel						usernameLeftTop;
	GridBagConstraints			c					= new GridBagConstraints();
	DesignGridLayout			layout;
	Image						profilePicture		= null;
	URI							uri					= null;
	Image						image;
	static int					height				= (int) MainFrame.getDimension().getHeight(), width = (int) MainFrame.getDimension().getWidth();
	PanelUser					pUser;
	PanelChats					pChats;
	JScrollPane					jsp;

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

			jsp = new JScrollPane(pChats = new PanelChats((int) MainFrame.getDimension().getWidth(), (int) MainFrame.getDimension().getHeight()));
			panelLeft.add(jsp, BorderLayout.CENTER);
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
		pUser.resizePanel(MainFrame.mainFrame.getWidth(), MainFrame.mainFrame.getHeight());

	}
	
	public void setUsername(String s) {
		username = s;
	}

	public void resize() {
		height = (int) MainFrame.getDimension().getHeight();
		width = (int) MainFrame.getDimension().getWidth();
		revalidate();
	}

	//	public void panelResize(int width, int height) {
	//		if (pUser != null) {
	//			System.out.println(height);
	//			//panelLeft.remove(pUser);
	//			//panelLeft.add(pUser = new PanelUser("Josef", width, height), BorderLayout.NORTH);
	//			//panelLeft.repaint();
	//			panelLeft.remove(pUser);
	//			pUser.resizePanel(width, height);
	//			pUser.revalidate();
	//			panelLeft.add(pUser, BorderLayout.NORTH);
	//			revalidate();
	//			repaint();
	//		}
	//	}

	private void setSendables() {

	}
}