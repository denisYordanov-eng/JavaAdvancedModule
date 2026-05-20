package logger.appenders;

import logger.enums.ReportLevel;
import logger.layouts.Layout;

public class ConsoleAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;
    private  int messageCount;

    public ConsoleAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
        this.messageCount = 0;
    }

    public int getMessageCount() {
        return messageCount;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    @Override
    public ReportLevel getReportLevel() {
        return this.reportLevel;
    }

    @Override
    public Layout getLayout() {
        return this.layout;
    }

    @Override
    public void append(String dateTime, ReportLevel reportLevel, String message) {
        if(reportLevel.ordinal() >= this.reportLevel.ordinal()) {
            String formattedMessage = layout.format(dateTime, reportLevel, message);

            System.out.println(formattedMessage);

            this.messageCount++;
        }
    }
}
