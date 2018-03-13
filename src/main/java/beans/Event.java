package beans;

import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {
    private final static AtomicInteger AUTO_ID =new AtomicInteger(0);

    private Integer id;
    private String message;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df){
        this.date=date;
        this.df=df;
        this.id=AUTO_ID.getAndIncrement();
    }

    public void setMessage(String message){
        this.message=message;
    }

    public String getMessage(){
        return this.message;
    }

    public String toString(){
        return id+ " "+message+" "+df.format(date)+"\n";
    }
}
