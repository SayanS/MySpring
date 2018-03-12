import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    Client client;
    EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger){
        this.eventLogger=eventLogger;
        this.client=client;
    }

    public void logEvent(String msg){
        String message=msg.replaceAll(client.getId(),client.getFullName());
        eventLogger.logEvent(message);
    }

    public static void main(String[] args){
        App app;
        ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
        app=ctx.getBean(App.class);
        app.logEvent("Some event for user 1");
    }
}
