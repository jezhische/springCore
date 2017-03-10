package loggers;

import events.Event;
import utilities.EventLogger;

/**
 * Created by WORK_x64 on 09.03.2017.
 */
public class CombinedEventLogger implements EventLogger {
    private EventLogger consoleEventLogger, fileEventLogger;

    public void setConsoleEventLogger(EventLogger consoleEventLogger) {
        this.consoleEventLogger = consoleEventLogger;
    }

    public void setFileEventLogger(EventLogger fileEventLogger) {
        this.fileEventLogger = fileEventLogger;
    }

    @Override
    public void logEvent(Event event) {
        consoleEventLogger.logEvent(event);
        fileEventLogger.logEvent(event);
    }
}
