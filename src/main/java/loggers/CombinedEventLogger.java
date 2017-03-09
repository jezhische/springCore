package loggers;

import events.Event;
import utilities.EventLogger;

import java.util.List;

/**
 * Created by WORK_x64 on 09.03.2017.
 */
public class CombinedEventLogger implements EventLogger {
    List<EventLogger> loggers;

    CombinedEventLogger(List<EventLogger> loggers) {
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {

    }
}
