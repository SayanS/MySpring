import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client client;
    EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger){
        this.eventLogger=eventLogger;
        this.client=client;
    }

    public void logEvent(Event event, String msg){
        String message=msg.replaceAll(client.getId(),client.getFullName());
        event.setMessage(message);
        eventLogger.logEvent(event);
    }

    public static void main(String[] args){
        App app;
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
        app=ctx.getBean(App.class);

        Event event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 1");

        event = ctx.getBean(Event.class);
        app.logEvent(event, "Some event for 2");

    }
}
