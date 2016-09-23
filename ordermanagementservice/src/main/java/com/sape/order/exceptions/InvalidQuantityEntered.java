package com.sape.order.exceptions;

import com.sape.order.model.EquityOrder;

/**
 * InvalidQuantityEntered is raised when an invalid quantity is entered. It is
 * raised while working on {@link EquityOrder}.
 * 
 * @author Nilaksh Bajpai
 */
public class InvalidQuantityEntered extends EquityOrderException {
	private static final long serialVersionUID = 1L;

	public InvalidQuantityEntered() {
		super("InvalidQuantityEntered");
	}
}
