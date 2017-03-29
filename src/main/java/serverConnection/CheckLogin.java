package serverConnection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;

import javax.swing.JOptionPane;

import gui.MainFrame;
import logic.ClientMain;
import logic.UserObject;

public class CheckLogin {
	
	Socket					serverConnection;
	ObjectInputStream		ois;
	String					feed, returnString;
	UserObject				userObject;
	String					error		= null;

	public final static int	LOGIN		= 0;
	public final static int	REGISTER	= 1;

	public CheckLogin(String username, String password, int mode) {
		feed = "@@login" + username + "@" + password;
		if (!username.equals("") && !password.equals("")) {
			if (mode == LOGIN) {
				feed = "@@login" + username + "@" + password;
				userObject = new UserObject(username, password);
				send();
			} else if (mode == REGISTER) {
				feed = "@@register" + username + "@" + password;
				send();
			}
		} else
			error = "login";
	}

	private void send() {
		ObjectOutputStream oos = null;
		try {
			serverConnection = new Socket("networkingtest.ddns.net", 6000);
			oos = new ObjectOutputStream(serverConnection.getOutputStream());
			oos.writeObject(userObject);
			oos.flush();
			recieve();
		} catch (ConnectException e) {
			JOptionPane.showMessageDialog(null, "Cannot connect to server!\nPlease try again later!", "Connection Refused", JOptionPane.ERROR_MESSAGE); //Change to a label on the frame
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			if (serverConnection != null)
				try {
					serverConnection.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}

	private void recieve() {
		try {
			ois = new ObjectInputStream(serverConnection.getInputStream());
			try {
				ClientMain.userObject = (UserObject) ois.readObject();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			setLabel();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ois != null)
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	private void setLabel() {
		if (ClientMain.userObject.getErrorMessage() != null) {
			
		} else if (error != null) {

		} else {
			MainFrame.loginFrame.dispose();
			MainFrame.panelClient();
		}

	}
	
}
