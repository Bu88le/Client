package serverConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.Socket;

import javax.swing.JOptionPane;

import gui.MainFrame;

public class CheckLogin {

	Socket					serverConnection;
	BufferedReader			reader;
	String					feed, returnString;
	
	public final static int	LOGIN		= 0;
	public final static int	REGISTER	= 1;
	
	public CheckLogin(String username, String password, int mode) {
		feed = "@@login" + username + "@" + password;
		if (!username.equals("") && !password.equals("")) {
			if (mode == LOGIN) {
				feed = "@@login" + username + "@" + password;
				send();
			} else if (mode == REGISTER) {
				feed = "@@register" + username + "@" + password;
				send();
			}
		} else if (username.equals("") && password.equals("")) {
			returnString = "enterLogin";
			setLabel();
		} else if (password.equals("")) {
			returnString = "noPassword";
			setLabel();
		} else if (username.equals("")) {
			returnString = "noUsername";
			setLabel();
		} else {
			returnString = "error";
			setLabel();
		}
	}
	
	private void send() {
		PrintWriter prw = null;
		try {
			serverConnection = new Socket("networkingtest.ddns.net", 6000);
			prw = new PrintWriter(serverConnection.getOutputStream(), true);
			prw.println(feed);
			recieve();
		} catch (@SuppressWarnings("unused") ConnectException e) {
			JOptionPane.showMessageDialog(null, "Cannot connect to server!\nPlease try again later!", "Connection Refused", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (prw != null)
				prw.close();
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
			reader = new BufferedReader(new InputStreamReader(serverConnection.getInputStream()));
			returnString = reader.readLine();
			setLabel();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void setLabel() {
		if (returnString.substring(0, 4).equals("true")) {
			MainFrame.loginFrame.dispose();
			MainFrame.panelClient();
			//Thread thread = new Thread(new ChatConnection());
			//thread.start();
		} else if (returnString.equals("false"))
			MainFrame.message.setText("Username and password don't match");
		else if (returnString.equals("userError"))
			MainFrame.message.setText("<html><b><font color=#FF0000>Error: </font></b>User isn't registered");
		else if (returnString.equals("userStored"))
			MainFrame.message.setText("<html><b><font color=#FF0000>Notice: </font></b>User registered succesfully");
		else if (returnString.equals("noUsername"))
			MainFrame.message.setText("<html><b><font color=#FF0000>Error: </font></b>Please enter a username");
		else if (returnString.equals("noPassword"))
			MainFrame.message.setText("<html><b><font color=#FF0000>Error: </font></b>Please enter a password");
		else if (returnString.equals("enterLogin"))
			MainFrame.message.setText("<html><b><font color=#FF0000>Error: </font></b>Please enter a username and a password");
		else if (returnString.equals("error"))
			MainFrame.message.setText("<html><b><font color=#FF0000>Error: </font></b>404");
		else
			MainFrame.message.setText("<html><b><font color=#FF0000>Error: </font></b>404");

	}

}
