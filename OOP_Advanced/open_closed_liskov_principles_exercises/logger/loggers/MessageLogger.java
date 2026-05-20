package logger.loggers;

import logger.appenders.Appender;
import logger.enums.ReportLevel;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logInfo(String dateTime, String message) {
        this.logAll(dateTime, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String dateTime, String message) {
        this.logAll(dateTime, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String dateTime, String message) {
        this.logAll(dateTime, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String dateTime, String message) {
        this.logAll(dateTime, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String dateTime, String message) {
        this.logAll(dateTime, ReportLevel.FATAL, message);
    }

    private void logAll(String dateTime, ReportLevel reportLevel, String message) {
        for (Appender appender : this.appenders) {
            appender.append(dateTime, reportLevel, message);
        }
    }
}
