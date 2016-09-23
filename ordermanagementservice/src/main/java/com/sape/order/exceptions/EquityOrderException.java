package com.sape.order.exceptions;

import com.sape.order.model.EquityOrder;

/**
 * EquityOrderException is raised when a business rule is violated while working
 * on the {@link EquityOrder}.
 * 
 * @author Nilaksh Bajpai
 */
public class EquityOrderException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EquityOrderException() {
		super("EquityOrderException");
	}

	public EquityOrderException(String message) {
		super(message);
	}
}
