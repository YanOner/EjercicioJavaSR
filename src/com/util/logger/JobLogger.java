package com.util.logger;

import java.text.DateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class JobLogger {

	private final Logger logger;

	public JobLogger(Class<?> clazz) {
		this.logger = Logger.getLogger(clazz.getName());
	}

	public void logMessage(String messageText, boolean message, boolean warning, boolean error, boolean logToConsole,
			boolean logToFile, boolean logToDatabase) throws Exception {

		messageText = messageText.trim();
	
		if (messageText == null || messageText.length() == 0) {
			return;
		}
		if (!message && !warning && !error) {
			throw new Exception(JobLoggerConfig.LOG_ERROR_MESSAGE);
		}
		
		int type = JobLoggerConfig.LOG_TYPE_MESSAGE;
		if(warning){
			type = JobLoggerConfig.LOG_TYPE_WARNING;
		}
		if(error){
			type = JobLoggerConfig.LOG_TYPE_ERROR;
		}
		
		StringBuilder messageJob = new StringBuilder();
		
		String dateFormat = DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + " ";

		if (message) {
			messageJob.append(JobLoggerConfig.LOG_TEXT_MESSAGE)
					.append(dateFormat).append(messageText)
					.append("\n");
		}
		if (warning) {
			messageJob.append(JobLoggerConfig.LOG_TEXT_WARNING)
					.append(dateFormat).append(messageText)
					.append("\n");
		}
		if (error) {
			messageJob.append(JobLoggerConfig.LOG_TEXT_ERROR)
					.append(dateFormat).append(messageText);
		}

		if (logToConsole) {
			logger.addHandler(JobLoggerUtil.getHandlerConsole());
			logger.info(messageJob.toString());
			logger.removeHandler(JobLoggerUtil.getHandlerConsole());
		}

		if (logToFile) {
			logger.addHandler(JobLoggerUtil.getHandlerFile());
			logger.info(messageJob.toString());
			logger.removeHandler(JobLoggerUtil.getHandlerFile());
		}

		if (logToDatabase) {
			JobLoggerUtil.insertLogValues(messageJob.toString(), type);
		}
		
	}

}
