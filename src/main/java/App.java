import beans.Client;
import beans.Event;
import loggers.EventLogger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {
    Client client;
    EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger){
        this.eventLogger=eventLogger;
        this.client=client;
    }

    public void logEvent(Event event, String msg) throws IOException {
        String message=msg.replaceAll(client.getId(),client.getFullName());
        event.setMessage(message);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args) throws IOException {
        App app;
        ConfigurableApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
        app=ctx.getBean(App.class);

        Event event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 1");

        event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 2");

        ctx.close();

    }
}
