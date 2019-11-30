package android.example.com.oommini;

public class Clock  {
//    private Time time;
    private String timeZone;
    private int fontcolor;
    private int backgroundColor;
    private int borderColor;
    private String font;

//    public Time getTime() {
//        return time;
//    }
//
//    public void setTime(Time time) {
//        this.time = time;
//    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public int getFontColor() {
        return fontcolor;
    }

    public void setFontColor(int color) {
        this.fontcolor = color;
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public int getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(int borderColor) {
        this.borderColor = borderColor;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public Clock(String timeZone, int color, int backgroundColor, int borderColor, String font) {
//        this.time = time;
        this.timeZone = timeZone;
        this.fontcolor = color;
        this.backgroundColor = backgroundColor;
        this.borderColor = borderColor;
        this.font = font;
    }



}
