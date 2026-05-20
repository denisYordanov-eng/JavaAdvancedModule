package logger.layouts;

import logger.enums.ReportLevel;

public class XmlLayout  implements Layout {
    @Override
    public String format(String dateTime, ReportLevel reportLevel, String message) {
        StringBuilder sb = new StringBuilder();
//
        sb.append("<log>").append(System.lineSeparator())
                .append("\t<date>").append(dateTime).append("</date>").append(System.lineSeparator())
                .append("\t<level>").append(reportLevel.name()).append("</level>").append(System.lineSeparator())
                .append("\t<message>").append(message).append("</message>").append(System.lineSeparator());
        sb.append("</log>");

        return sb.toString();
    }
}
