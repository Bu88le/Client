package serverConnection;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatConnection implements Runnable {
	
	static Socket serverConnection;
	
	public ChatConnection() {
		try {
			serverConnection = new Socket("networkingtest.ddns.net", 7000);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		while (true) {

		}

	}

	public static Socket getConnection() {
		return serverConnection;
	}
	
}
