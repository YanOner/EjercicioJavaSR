package com.util.logger;

public class TestApplication {

	private static final JobLogger logger = JobLoggerFactory.getLogger(TestApplication.class);

	public static void main(String[] args) throws Exception {
		// MESSAGE | CONSOLE
		logger.logMessage("TEST | MESSAGE | CONSOLE", true, false, false, true, false, false);
		// WARNING | CONSOLE
		logger.logMessage("TEST | WARNING | CONSOLE", false, true, false, true, false, false);
		// ERROR | CONSOLE
		logger.logMessage("TEST | ERROR | CONSOLE", false, false, true, true, false, false);

		// MESSAGE | FILE
		logger.logMessage("TEST | MESSAGE | FILE", true, false, false, false, true, false);
		// WARNING | FILE
		logger.logMessage("TEST | WARNING | FILE", false, true, false, false, true, false);
		// ERROR | FILE
		logger.logMessage("TEST | ERROR | FILE", false, false, true, false, true, false);

		// MESSAGE TEXT EMPTY
		logger.logMessage("", true, false, false, true, false, false);

		try {
			// NO LOG TYPE ALL FALSE
			logger.logMessage("NO LOG TYPE ALL FALSE", true, false, false, false, false, false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// MESSAGE | CONSOLE-FILE
		logger.logMessage("MESSAGE | CONSOLE-FILE", true, false, false, true, true, false);

		// MESSAGE | CONSOLE-FILE-DB
		logger.logMessage("TEST | MESSAGE | DB", true, false, false, true, true, true);

	}

}
