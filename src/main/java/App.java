import beans.Client;
import events.Event;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utilities.EventLogger;

import java.io.IOException;

/**
 * Created by WORK_x64 on 02.03.2017.
 */
public class App {
    public static void main(String[] args) throws IOException {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        app.logEvent("Some event for 1");
        app.logEvent("Some event for 2");

    }

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger =eventLogger;
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        eventLogger.logEvent(new Event());
    }
}
