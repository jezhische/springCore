package events;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * Created by Ежище on 04.03.2017.
 */
public class Event {
    private int id;
    private String msg;
    private Date date;

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

/* Constructor **/
    public Event() {
        id = new Random().nextInt(100);
        date = new Date();
    }

    public static boolean isDay() {
        DateFormat df = new SimpleDateFormat("H");
        int currentTime = Integer.valueOf(df.format(new Date()));
        return (currentTime >= 8 && currentTime < 17);
    }

    @Override
    public String toString() {
        return String.format("id = %d, date = %s, msg = %s", id, date /*df.format(date)*/, msg);
    }
}
