package network;

public class SendableLogin extends Sendable {

	private static final long serialVersionUID = 1L;
	private final String		username;
	private final String		password;
	
	public SendableLogin(String username, String password) {
		super(SendableType.LOGIN);
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
}
