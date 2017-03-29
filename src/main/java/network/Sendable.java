package network;

import java.io.Serializable;
import java.util.Date;

public class Sendable implements Serializable {

	private static final long	serialVersionUID	= 1L;
	private final SendableType	type;
	private Date				timestampSent;

	public Sendable(SendableType type) {
		this.type = type;
	}

	public SendableType getType() {
		return type;
	}
	
	public Date getTimestampSent() {
		return timestampSent;
	}

	public void setTimestampSent() {
		timestampSent = new Date();
	}
	
	public enum SendableType {
		REGISTRATION, LOGIN, DELETE_ACCOUNT, MESSAGE, MESSAGE_RESPONSE, EXCEPTION, COMMAND, OTHER //maybe friend request? confirmation (after sth like account deletion, login ...)?
	}
}
