package android.example.com.oommini;

import android.content.BroadcastReceiver;
import android.graphics.Color;
import android.graphics.fonts.Font;

import java.util.TimeZone;

public class Clock  {
//    private Time time;
    private TimeZone timeZone;
    private Color color;
    private Color backgroundColor;
    private Color borderColor;
    private Font font;

//    public Time getTime() {
//        return time;
//    }
//
//    public void setTime(Time time) {
//        this.time = time;
//    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Clock( TimeZone timeZone, Color color, Color backgroundColor, Color borderColor, Font font) {
//        this.time = time;
        this.timeZone = timeZone;
        this.color = color;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.font = font;
    }



}
