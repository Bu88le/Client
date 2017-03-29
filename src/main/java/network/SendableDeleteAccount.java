package network;

/**
 * This is basically a marker.
 * Account deletion can only be performed when a user is logged in
 */
public class SendableDeleteAccount extends Sendable {
	
	private static final long	serialVersionUID	= 1L;

	public SendableDeleteAccount() { 
		super(SendableType.DELETE_ACCOUNT);
	}

}
