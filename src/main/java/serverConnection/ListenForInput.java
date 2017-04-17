package serverConnection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

import gui.MainFrame;
import network.Sendable;
import network.SendableDeleteAccount;
import network.SendableException;
import network.SendableLogin;
import network.SendableMessage;
import network.SendableProfile;
import network.SendableRegistration;

public class ListenForInput implements Runnable {
	
	MainFrame				mf		= null;

	Socket					server	= null;
	Sendable				basic	= null;
	ObjectInputStream		ois		= null;
	
	SendableProfile			sp		= null;
	SendableLogin			sl		= null;
	SendableRegistration	sr		= null;
	SendableDeleteAccount	sda		= null;
	SendableMessage			sm		= null;
	SendableException		se		= null;

	public ListenForInput(Socket server, MainFrame mf) {
		this.server = server;
		this.mf = mf;
	}
	
	@Override
	public void run() {
		while (true)
			try {
				ois = new ObjectInputStream(server.getInputStream());
				basic = (Sendable) ois.readObject();
				switch (basic.getType()) {
					case REGISTRATION:
					case LOGIN:
					case DELETE_ACCOUNT:
					case MESSAGE:
					case MESSAGE_RESPONSE:
					case EXCEPTION:
					case COMMAND:
					case OTHER:
					case PROFILE:
						sp = (SendableProfile) basic;

					default:
						break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
