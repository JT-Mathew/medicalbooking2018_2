package c.hayeon.seproject.model;
import java.util.Date;
import java.util.UUID;

public class Appointment {



    String date;
    String time;
    String doc;

    public Appointment(String date, String time, String doc) {
        this.date = date;
        this.time = time;
        this.doc = doc;
    }

    public Appointment() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc;
    }
}