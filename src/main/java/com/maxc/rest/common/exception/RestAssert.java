package com.maxc.rest.common.exception;

import org.springframework.util.Assert;

public class RestAssert extends Assert {

	public static void notNull(Object param,String object, String message) {
		if (param == null)  {
			throw new ParametersException(object, message);
		}
	}

	public static void notNull(Object param, String object) {
		if (param == null) {
			throw new ParametersException(object, "is required.");
		}
	}

	public static <T> void notNull(Class<T> clazz,Object object) {
		if (object == null) {
			throw new ParametersException(clazz.getSimpleName(),
					" is required");
		}
	}

}
