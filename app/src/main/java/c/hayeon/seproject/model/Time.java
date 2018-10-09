package c.hayeon.seproject.model;

public class Time {
    String hour;
    String min;

    public Time(String hour, String min) {
        this.hour = hour;
        this.min = min;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }
}
