package loggers;

import abstractClasses.AbstractLogger;
import enums.LogType;


public class CombatLogger extends AbstractLogger {

    @Override
    public void handle(LogType logType, String message) {
        if(logType == LogType.ATTACK || logType == LogType.MAGIC){
            System.out.println(logType.name() + ": " + message);
        }else {
            if(super.getSuccessor() != null) {
                super.getSuccessor().handle(logType, message);
            }
        }
    }
}
