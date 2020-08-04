import java.text.DateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Event {
    static int cursor = 1;
    private final int id = cursor++;
    private String msg;

    private Date date;
    private final DateFormat df;

    Event(Date date, DateFormat df){
        this.date = date; this.df = df;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\nid=" + id +
                ",\n msg='" + msg + '\'' +
                ",\n date=" + df.format(date) +
                "\n}\n";
    }

    public int getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateFormat getDateFormat() {
        return df;
    }
}
