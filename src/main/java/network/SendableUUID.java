package network;

import java.util.UUID;

public class SendableUUID extends Sendable {

	private static final long	serialVersionUID	= 1L;
	
	private final UUID			uuid;
	
	public SendableUUID(UUID uuid) {
		super(SendableType.EXCEPTION);
		this.uuid = uuid;
	}
	
	public UUID getUuid() {
		return uuid;
	}

}
