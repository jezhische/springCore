package loggers;

import events.Event;
import utilities.EventLogger;

/**
 * Created by WORK_x64 on 02.03.2017.
 */
public class ConsoleEventLogger implements EventLogger {
    public void logEvent(Event event) {
        System.out.println(event.toString());
    }
}
