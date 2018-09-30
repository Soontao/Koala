package org.fornever.koala.type;

import java.util.HashMap;
import java.util.Map;

public class ValidationErrors {

	private Map<String, String> errors = new HashMap<>();

	public Boolean ok() {
		return this.errors.isEmpty();
	}

	public ValidationErrors addError(String field, String reason) {
		this.errors.put(field, reason);
		return this;
	}

}
