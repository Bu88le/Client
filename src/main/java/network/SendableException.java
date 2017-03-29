package network;

public class SendableException extends Sendable {
	
	private static final long serialVersionUID = 1L;

	private final Exception		exception;

	public SendableException(Exception exception) {
		super(SendableType.EXCEPTION);
		this.exception = exception;
	}

	public Exception getException() {
		return exception;
	}
	
}
