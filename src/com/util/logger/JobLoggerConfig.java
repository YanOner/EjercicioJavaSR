package com.util.logger;

public class JobLoggerConfig {

	public final static String LOG_FILE_FOLDER = "C:/tmpTest/";
	public final static String LOG_FILE_NAME = "logFile.txt";

	public final static String LOG_DB_USER_NAME = "root";
	public final static String LOG_DB_PASSWORD = "r@@t";
	public final static String LOG_DB_DBMS = "mysql";
	public final static String LOG_DB_SERVER_NAME = "localhost";
	public final static String LOG_DB_PORT_NUMBER = "3306";

	public final static String LOG_DB_JDBC = "jdbc";
	public final static String LOG_DB_SEPARATOR = ":";
	public final static String LOG_DB_SLASH = "/";

	public final static int LOG_TYPE_MESSAGE = 1;
	public final static int LOG_TYPE_WARNING = 2;
	public final static int LOG_TYPE_ERROR = 3;

	public final static String LOG_TEXT_MESSAGE = "message ";
	public final static String LOG_TEXT_WARNING = "warning ";
	public final static String LOG_TEXT_ERROR = "error ";

	public final static String LOG_ERROR_MESSAGE = "Error or Warning or Message must be specified.";

}
