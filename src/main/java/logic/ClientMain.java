package logic;

import javax.swing.SwingUtilities;

import gui.MainFrame;

public class ClientMain {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new MainFrame());
	}

}
