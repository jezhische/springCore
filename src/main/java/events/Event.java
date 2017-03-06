package events;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Ежище on 04.03.2017.
 */
public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }

    public Event(/*Date date, DateFormat df*/) {
        id = new Random().nextInt(100);
//        this.date = date;
        date = new Date();
//        this.df = df;
    }

    @Override
    public String toString() {
        return String.format("id = %d, date = %s, msg = %s", id, date /*df.format(date)*/, msg);
    }
}
