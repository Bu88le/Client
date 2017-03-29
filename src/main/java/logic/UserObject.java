package logic;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.InetAddress;

public class UserObject implements Serializable {

	private final String	username, password;
	private Long			id;
	private InetAddress		address;
	private FileStorage		fs, fs2;
	private String			errorMessage;

	public UserObject(String name, String password) {
		username = name;
		this.password = password;
		try {
			fs2 = new FileStorage(new File("src/main/resources/UserID"));
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void storeUser() {
		try {

			id = (long) (Math.random() * (Math.pow(2, 63) - 1));
			fs2.store(username, id);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setInetAdress(InetAddress address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public Long getID(String name) {
		return (Long) fs2.get(name);
	}

	public Object getSocket() {
		return fs.get(username);
	}

	public InetAddress getAdress() {
		return address;
	}
	
	public String getPassword() {
		return password;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
