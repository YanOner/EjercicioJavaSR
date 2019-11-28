package com.util.logger;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;

public final class JobLoggerUtil {

	public static FileHandler getHandlerFile() {
		FileHandler fh = null;
		try {
			File logFile = new File(JobLoggerConfig.LOG_FILE_FOLDER);
			if (!logFile.exists()) {
				logFile.mkdirs();
			}

			String pathName = JobLoggerConfig.LOG_FILE_FOLDER + JobLoggerConfig.LOG_FILE_NAME;
			fh = new FileHandler(pathName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fh;
	}

	public static ConsoleHandler getHandlerConsole() {
		return new ConsoleHandler();
	}

	public static void insertLogValues(String message, int type) {
		Connection connection = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", JobLoggerConfig.LOG_DB_USER_NAME);
		connectionProps.put("password", JobLoggerConfig.LOG_DB_PASSWORD);

		StringBuilder url = new StringBuilder();
		url.append(JobLoggerConfig.LOG_DB_JDBC).append(JobLoggerConfig.LOG_DB_SEPARATOR)
				.append(JobLoggerConfig.LOG_DB_DBMS).append(JobLoggerConfig.LOG_DB_SEPARATOR)
				.append(JobLoggerConfig.LOG_DB_SLASH).append(JobLoggerConfig.LOG_DB_SLASH)
				.append(JobLoggerConfig.LOG_DB_SERVER_NAME).append(JobLoggerConfig.LOG_DB_SEPARATOR)
				.append(JobLoggerConfig.LOG_DB_PORT_NUMBER).append(JobLoggerConfig.LOG_DB_SLASH);

		try {
			connection = DriverManager.getConnection(url.toString(), connectionProps);
			PreparedStatement stmt = connection.prepareStatement("insert into log_values(message, type) values (?,?)");
			stmt.setString(1, message);
			stmt.setInt(2, type);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
