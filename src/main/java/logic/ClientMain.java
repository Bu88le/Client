package logic;

import javax.swing.SwingUtilities;

import gui.MainFrame;
import serverConnection.ServerConnection;

public class ClientMain {
	
	public static UserObject userObject;
	
	public static void main(String[] args) {
		ServerConnection connection = new ServerConnection();
		SwingUtilities.invokeLater(() -> new MainFrame(connection));
	}
	
}
