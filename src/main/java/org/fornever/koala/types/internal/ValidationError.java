package org.fornever.koala.types.internal;

import java.util.HashMap;
import java.util.function.Supplier;

public class ValidationError extends HashMap<String, String> {

	public Supplier<Boolean> haveError = () -> {
		return !this.isEmpty();
	};

}
