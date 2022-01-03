package sample;

import java.io.Serializable;




public class Time implements Serializable {

    public int hour;
    public int minute;
    public int second;


    public Time(int hour, int minute , int second )
    {
        if((hour>24||hour<0)&&(minute>60||minute<0)&&(second>60||second<0) )
            throw new IllegalArgumentException("WRONG FORMAT OF TIME");
        this.hour=hour;
        this.minute=minute;
        this.second=second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setSecond(int second) {
        this.second = second;
    }
    @Override
    public String toString()
    {
        return String.format(hour+":"+minute+":"+second);
    }
}
