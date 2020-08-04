import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private static App app;

    public App(Client client, EventLogger eventLogger){
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        app = (App) applicationContext.getBean("app");

        app.logEvent(applicationContext, "Some event for user 1");
        app.logEvent(applicationContext, "Some event for user 2");

        applicationContext.close();
    }

    private void logEvent(ApplicationContext applicationContext, String msg){
        Event event = (Event) applicationContext.getBean("event");
        event.setMsg(msg);
        eventLogger.logEvent(event);
    }
}
