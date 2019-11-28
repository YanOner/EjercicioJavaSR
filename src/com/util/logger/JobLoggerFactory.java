package com.util.logger;

public final class JobLoggerFactory {

	private JobLoggerFactory() {
	}

	public static JobLogger getLogger(Class<?> clazz) {
		return new JobLogger(clazz);
	}

}
