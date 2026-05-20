package logger.appenders;

import logger.enums.ReportLevel;
import logger.layouts.Layout;

public interface Appender {
    void append(String dateTime, ReportLevel reportLevel, String message);

    void setReportLevel(ReportLevel reportLevel);

    ReportLevel getReportLevel();

    Layout getLayout();

    int getMessageCount();
}
