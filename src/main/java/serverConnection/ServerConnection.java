package serverConnection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.UUID;

import gui.MainFrame;
import network.SendableLogin;
import network.SendableRegistration;

public class ServerConnection {

	MainFrame			mf				= null;
	Socket				server;
	ObjectInputStream	ois				= null;
	ObjectOutputStream	oos				= null;
	Thread				listenForInput	= null;
	ListenForInput		lfi				= null;
	
	public ServerConnection(MainFrame mf) {
		this.mf = mf;
		initConnection();
	}

	private void initConnection() {
		
		try {
			server = new Socket("localhost", 6000);
			lfi = new ListenForInput(server, mf);
			listenForInput = new Thread(lfi);
			listenForInput.start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block e.printStackTrace();
		}
		
	}
	
	public void sendSendable(UUID sender, UUID recipient, String message) {
		
	}

	public void sendLogin(SendableLogin sl) {
		try {
			oos = new ObjectOutputStream(server.getOutputStream());
			oos.writeObject(sl);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

	public void sendRegistration(SendableRegistration sr) {
		try {
			oos = new ObjectOutputStream(server.getOutputStream());
			oos.writeObject(sr);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null)
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}

}
