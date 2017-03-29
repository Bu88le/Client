package network;

public class SendableRegistration extends Sendable {
	
	private static final long	serialVersionUID	= 1L;
	private final String		username;
	private final String		password;
	
	public SendableRegistration(String username, String password) {
		super(SendableType.REGISTRATION);
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
