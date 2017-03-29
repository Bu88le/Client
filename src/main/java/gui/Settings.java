package gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Settings {
	
	JFrame frame;
	
	public Settings() {
		initGUI();
	}
	
	private void initGUI() {
		frame = new JFrame("Settings");
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frame.setSize(400, 400);
		frame.setLocationRelativeTo(MainFrame.mainFrame);
		frame.setVisible(true);
	}
	
}
