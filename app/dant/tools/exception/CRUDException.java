package dant.tools.exception;

public class CRUDException extends Exception {

	/** Serial version. */
	private static final long serialVersionUID = 6655848587850282923L;

	/** Origin of exception. */
	private Exception origin;

	/**
	 * <b>Constructor</b>.
	 * 
	 * @return none
	 * @exception none
	 */
	public CRUDException() {
	}

	/**
	 * <b>Constructor</b>.
	 * 
	 * @param <b>number</b> @see ErrorDefinition
	 * @return none
	 * @exception none
	 */
	public CRUDException(String msg) {
		super(msg);
	}

	public CRUDException(Exception origin) {
		super(origin.getMessage());
		this.origin = origin;
	}

	public CRUDException(String msg, Exception origin) {
		super(msg);
		this.origin = origin;
	}

	public Exception getOrigin() {
		return origin;
	}

}
