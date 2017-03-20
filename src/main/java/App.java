import clients.Client;
import config.AppConfig;
import events.Event;
import events.EventType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import utilities.EventLogger;

import java.io.IOException;
import java.util.Map;

import static events.EventType.ERROR;
import static events.EventType.INFO;

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
        app.logEvent(INFO, "Some event for 1");
        app.logEvent(ERROR, "Some event for 2");
        app.logEvent(INFO, "1 goes to school");
        app.logEvent(null, "hey, 1, go home!");
        app.logEvent(null, "hey, 1, are you home yet?");
        app.logEvent(ERROR, "what's up?...");
        app.logEvent(ERROR, "oblivion...");
        // здесь пользуемся логгером, полученным в конструкторе, а туда мы получаем, в зависимости от времени суток,
        // либо ConsoleEventLogger, либо FileEventLogger (см. конструктор App в spring.xml)
        app.eventLogger.logEvent(new Event());
        System.out.println(app.client.getGreetings());
        ctx.close();
        /* FIXME: разобраться с этим - выкидывает ошибку, если определять тип вот так: (урок 9) **/
//        ApplicationContext ctxa = new AnnotationConfigApplicationContext();
        AnnotationConfigApplicationContext ctxa = new AnnotationConfigApplicationContext();
        ctxa.register(AppConfig.class);
//        ctxa.register(LoggersConfig.class);
        ctxa.refresh();
/* FIXME: разобраться с этим - выкидывает ошибку: (урок 8 или 7) **/
//        ConfigurableApplicationContext child = new ClassPathXmlApplicationContext(ctx);
//        App app2 = (App) child.getBean("app");
//        app2.logEvent("Some event for 1");
//        app2.logEvent("Some event for 2");
//        child.close();

    }

    @Autowired
    private Client client;
    private EventLogger eventLogger;
    @Autowired
    @Qualifier ("fileEventLogger")
    private EventLogger defaultLogger;
    private Map<EventType, EventLogger> loggers;


    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers) {
        this.client = client;
        this.eventLogger =eventLogger;
        this.loggers = loggers;
    }

//    public void setDefaultLogger(EventLogger defaultLogger) {
//        this.defaultLogger = defaultLogger;
//    }

    private void logEvent(EventType type, String msg) {
        EventLogger logger = loggers.get(type);
        if (logger == null) {
            logger = eventLogger;
        }
        String message = msg.replaceAll(client.getId(), client.getFullName());
        System.out.println(message);
        /*eventLogger*/logger.logEvent(new Event());
    }
}
