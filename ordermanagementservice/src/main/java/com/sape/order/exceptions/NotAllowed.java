package com.sape.order.exceptions;

/**
 * NotAllowed is raised when a user tries do an operation which she doesn't have
 * access to do.
 * 
 * @author Nilaksh Bajpai
 */
public class NotAllowed extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotAllowed() {
		super("NotAllowed");
	}
}
