package logger;


import logger.appenders.Appender;
import logger.appenders.ConsoleAppender;
import logger.appenders.FileAppender;
import logger.enums.ReportLevel;
import logger.layouts.Layout;
import logger.layouts.SimpleLayout;
import logger.layouts.XmlLayout;
import logger.loggers.Logger;
import logger.loggers.MessageLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Appender[] appenders = new Appender[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = br.readLine().split("\\s+");
            String appendType = tokens[0];
            String layoutType = tokens[1];

            Layout layout = null;

            if (layoutType.equalsIgnoreCase("SimpleLayout")) {
                layout = new SimpleLayout();
            } else if (layoutType.equalsIgnoreCase("XmlLayout")) {
                layout = new XmlLayout();
            }

            Appender appender = null;

            if (appendType.equalsIgnoreCase("ConsoleAppender")) {
                appender = new ConsoleAppender(layout);
            } else if (appendType.equalsIgnoreCase("FileAppender")) {
                appender = new FileAppender(layout);
            }

            if (tokens.length == 3) {
                ReportLevel reportLevel = ReportLevel.valueOf(tokens[2].toUpperCase());
                appender.setReportLevel(reportLevel);
            }

            appenders[i] = appender;

        }
        Logger logger = new MessageLogger(appenders);
        String input = br.readLine();
        while (!input.equalsIgnoreCase("END")) {
            String[] messageTokens = input.split("\\|");
            ReportLevel reportLevel = ReportLevel.valueOf(messageTokens[0].toUpperCase());
            String dateTime = messageTokens[1];
            String message = messageTokens[2];
            switch (reportLevel) {
                case INFO:
                    logger.logInfo(dateTime, message);
                    break;
                case ERROR:
                    logger.logError(dateTime, message);
                    break;
                case WARNING:
                    logger.logWarning(dateTime, message);
                    break;
                case FATAL:
                    logger.logFatal(dateTime, message);
                    break;
                case CRITICAL:
                    logger.logCritical(dateTime, message);
                    break;
            }
            input = br.readLine();
        }
        System.out.println("Logger info");
        for (Appender appender : appenders) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                    appender.getClass().getSimpleName()
                    , appender.getLayout().getClass().getSimpleName()
                    , appender.getReportLevel()
                    , appender.getMessageCount()));
            if (appender instanceof FileAppender) {
                FileAppender fileAppender = (FileAppender) appender;
                sb.append(String.format(", File size: %d",
                        fileAppender.getFile().getSize()));
            }
            System.out.println(sb.toString());
        }
    }
}
