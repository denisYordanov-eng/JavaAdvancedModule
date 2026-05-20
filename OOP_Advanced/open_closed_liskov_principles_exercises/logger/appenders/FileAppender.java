package logger.appenders;

import logger.enums.ReportLevel;
import logger.files.File;
import logger.files.LogFile;
import logger.layouts.Layout;

public class FileAppender implements Appender {
    private Layout layout;
    private ReportLevel  reportLevel;
    private  int messageCount;
    private File file;

    public FileAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = ReportLevel.INFO;
        this.messageCount = 0;
        this.file = new LogFile();
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

    @Override
    public void append(String dateTime, ReportLevel reportLevel, String message) {
        if(reportLevel.ordinal() >= this.reportLevel.ordinal()) {
            String formattedMessage = this.layout.format(dateTime, reportLevel, message);
            this.file.write(formattedMessage);
            this.messageCount++;
        }
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
    public int getMessageCount() {
        return this.messageCount;
    }
}
