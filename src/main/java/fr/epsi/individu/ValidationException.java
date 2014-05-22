package fr.epsi.individu;

import java.util.HashMap;
import java.util.Map;

public class ValidationException extends Exception {
	private static final long serialVersionUID = -567114778970132055L;

	private final Map<String, String> errorMessages;

	public ValidationException() {
		this.errorMessages = new HashMap<>();
	}

	public ValidationException(Map<String, String> errorMessages) {
		this.errorMessages = errorMessages;
	}

	public Map<String, String> getErrorMessages() {
		return errorMessages;
	}
}
