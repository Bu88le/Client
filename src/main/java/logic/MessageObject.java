package logic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageObject {
	
	private String			message;
	private Long			User_ID, Reciever_ID;
	private final String	client_sent;
	private String			server_recieved;
	private String			server_sent;
	private String			reciever_recieved;
	private String			reciever_read;
	private int				state;
	
	public final int		STATE_REGISTER	= 0;
	public final int		STATE_LOGIN		= 1;
	public final int		STATE_MESSAGE	= 2;
	
	public MessageObject() {
		client_sent = new SimpleDateFormat("HH:mm:ss").format(new Date());
	}
	
	public void setMessage(String string) {
		message = string;
	}
	
	public void setUserID(Long ID) {
		User_ID = ID;
	}
	
	public void setRecieverID(Long ID) {
		Reciever_ID = ID;
	}
	
	public void setServerRecieved(String date) {
		server_recieved = date;
	}
	
	public void setServerSent(String date) {
		server_sent = date;
	}
	
	public void setRecieverRecieved(String date) {
		reciever_recieved = date;
	}
	
	public void setRecieverRead(String date) {
		reciever_read = date;
	}
	
	public void setState(int number) {
		state = number;
	}
	
	public String getMessage() {
		return message;
	}

	public Long getUserID() {
		return User_ID;
	}

	public Long getRecieverID() {
		return Reciever_ID;
	}

	public String getClientSent() {
		return client_sent;
	}

	public String getServerRecieved() {
		return server_recieved;
	}

	public String getServerSent() {
		return server_sent;
	}

	public String getRecieverRecieved() {
		return reciever_recieved;
	}

	public String getRecieverRead() {
		return reciever_read;
	}
	
	public int getState() {
		return state;
	}
}
