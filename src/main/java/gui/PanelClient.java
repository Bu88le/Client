package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PanelClient extends JPanel {

	private static final long	serialVersionUID	= -4308067181923954687L;
	
	static JPanel				panelLeft, panelCenter;

	public PanelClient() {
		setLayout(new BorderLayout());
		initGUI();
	}
	
	private void initGUI() {

		panelLeft = new JPanel();
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
		panelLeft.setBorder(new LineBorder(Color.RED));
		panelLeft.setPreferredSize(new Dimension((MainFrame.mainFrame.getWidth() / 3), MainFrame.mainFrame.getHeight()));
		this.add(panelLeft, BorderLayout.LINE_START);
		
		panelCenter = new JPanel();
		panelCenter.setBorder(new LineBorder(Color.red));
		panelCenter.setPreferredSize(new Dimension((MainFrame.mainFrame.getWidth() / 3) * 2, MainFrame.mainFrame.getHeight()));
		{
			JLabel lbl = new JLabel("Test");
			panelCenter.add(lbl);
		}
		this.add(panelCenter, BorderLayout.CENTER);
	}
	
	public static void refresh() {
		panelLeft.setPreferredSize(new Dimension(MainFrame.mainFrame.getWidth() / 3, MainFrame.mainFrame.getHeight()));
		panelCenter.setPreferredSize(new Dimension((MainFrame.mainFrame.getWidth() / 3) * 2, MainFrame.mainFrame.getHeight()));
	}
}