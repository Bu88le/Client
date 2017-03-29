package network;

import java.util.UUID;

public class SendableLogin extends Sendable {

	private static final long serialVersionUID = 1L;
	private final UUID			uuid;
	private final String		password;
	
	public SendableLogin(UUID uuid, String password) {
		super(SendableType.LOGIN);
		this.uuid = uuid;
		this.password = password;
	}
	
	public UUID getUUID() {
		return uuid;
	}
	
	public String getPassword() {
		return password;
	}
}
