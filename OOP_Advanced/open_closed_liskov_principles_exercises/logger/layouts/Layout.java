package logger.layouts;

import logger.enums.ReportLevel;

public interface Layout {
    String format(String dateTime, ReportLevel reportLevel, String message);
}
