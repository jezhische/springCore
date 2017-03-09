import clients.Client;
import events.Event;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utilities.EventLogger;

import java.io.IOException;

/**
 * Created by WORK_x64 on 02.03.2017.
 */
public class App {
    public static void main(String[] args) throws IOException {

        /* данный класс контекста использовать можно, но он не содержит метода close(), а он нам будет нужен: **/
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        /* поэтому вызываем его класс-наследник (NB - это тоже интерфейс): **/
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        app.logEvent("Some event for 1");
        app.logEvent("Some event for 2");
        ctx.close();
/* FIXME: разобраться с этим - выкидывает ошибку: **/
//        ConfigurableApplicationContext child = new ClassPathXmlApplicationContext(ctx);
//        App app2 = (App) child.getBean("app");
//        app2.logEvent("Some event for 1");
//        app2.logEvent("Some event for 2");
//        child.close();

    }

    private Client client;
    private EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger) {
        this.client = client;
        this.eventLogger =eventLogger;
    }

    private void logEvent(String msg) {
        String message = msg.replaceAll(client.getId(), client.getFullName());
        System.out.println(message);
        eventLogger.logEvent(new Event());
    }
}
