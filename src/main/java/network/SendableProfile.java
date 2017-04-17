package network;

import logic.Profile;

public class SendableProfile extends Sendable {

	private static final long	serialVersionUID	= 1L;
	private final Profile		profile;

	public SendableProfile(Profile profile) {
		super(SendableType.PROFILE);
		this.profile = profile;
	}

	public Profile getProfile() {
		return profile;
	}

}
