package android.example.com.oommini;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Time {
private int hour;
private int minute;
    private int second;
    private int dayOfMonth;
    private int month;
    private int year;
    private String day;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    public void fetchTime(){
        Date str = Calendar.getInstance().getTime();
        SimpleDateFormat formatter1 = new SimpleDateFormat("EEE");
        SimpleDateFormat formatter2 = new SimpleDateFormat("d");
        SimpleDateFormat formatter3 = new SimpleDateFormat("HH");
        SimpleDateFormat formatter4 = new SimpleDateFormat("mm");
        SimpleDateFormat formatter5 = new SimpleDateFormat("ss");
        SimpleDateFormat formatter6 = new SimpleDateFormat("yyyy");
        SimpleDateFormat formatter7= new SimpleDateFormat("MMM");//formating according to my need
        setDay(formatter1.format(str));
        setDayOfMonth(Integer.parseInt(formatter2.format(str)));
        setHour(Integer.parseInt(formatter3.format(str)));
        setMinute(Integer.parseInt(formatter4.format(str)));
        setSecond(Integer.parseInt(formatter5.format(str)));
        setYear(Integer.parseInt(formatter6.format(str)));
        setMonth(Integer.parseInt(formatter7.format(str)));
    }


    public Time() {
        fetchTime();
    }


}
