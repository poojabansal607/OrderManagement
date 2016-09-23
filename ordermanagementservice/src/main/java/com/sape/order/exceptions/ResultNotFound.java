package com.sape.order.exceptions;

/**
 * ResultNotFound is raised when searched results are not found.
 * 
 * @author Nilaksh Bajpai
 */
public class ResultNotFound extends Exception {
	private static final long serialVersionUID = 1L;

	public ResultNotFound() {
		super("ResultNotFound");
	}
}
