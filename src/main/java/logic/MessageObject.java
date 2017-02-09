package logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageObject {

	private static String	message;
	private static Long		User_ID, Reciever_ID;
	private static String	client_sent, server_recieved, server_sent, reciever_recieved, reciever_read;
	private static int		state;

	public static final int	STATE_REGISTER	= 0;
	public static final int	STATE_LOGIN		= 1;
	public static final int	STATE_MESSAGE	= 2;

	public MessageObject() {
		client_sent = new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

	public static void setMessage(String string) {
		message = string;
	}

	public static void setUserID(Long ID) {
		User_ID = ID;
	}

	public static void setRecieverID(Long ID) {
		Reciever_ID = ID;
	}

	public static void setServerRecieved(String date) {
		server_recieved = date;
	}

	public static void setServerSent(String date) {
		server_sent = date;
	}

	public static void setRecieverRecieved(String date) {
		reciever_recieved = date;
	}

	public static void setRecieverRead(String date) {
		reciever_read = date;
	}

	public static void setState(int number) {
		state = number;
	}

	public static String getMessage() {
		return message;
	}
	
	public static Long getUserID() {
		return User_ID;
	}
	
	public static Long getRecieverID() {
		return Reciever_ID;
	}
	
	public static String getClientSent() {
		return client_sent;
	}
	
	public static String getServerRecieved() {
		return server_recieved;
	}
	
	public static String getServerSent() {
		return server_sent;
	}
	
	public static String getRecieverRecieved() {
		return reciever_recieved;
	}
	
	public static String getRecieverRead() {
		return reciever_read;
	}

	public static int getState() {
		return state;
	}
}
