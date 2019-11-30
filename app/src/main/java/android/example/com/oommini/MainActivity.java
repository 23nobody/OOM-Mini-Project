package android.example.com.oommini;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity {

   static TextClock clock;
   static LinearLayout frame;
   static Clock clock1 ;
   static TextView dateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       dateView = (TextView)findViewById(R.id.date);
        clock = (TextClock) findViewById(R.id.text_clock);
        Log.i("MainActivity","timezone "+clock.getFontFeatureSettings());
        frame = (LinearLayout) findViewById(R.id.linear_layout);

        clock1 = new Clock(clock.getTimeZone(),clock.getCurrentTextColor(),Color.parseColor("#000000"),Color.parseColor("#009688"),"Proxima Nova");
        setDate(dateView);
        Button  alarmButton = (Button) findViewById(R.id.alarms_button);
        alarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Alarms.class);
                startActivity(intent);
            }
        });
        Button customizeBu = (Button) findViewById(R.id.button5);
        customizeBu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Settings.class);
                startActivity(intent);
            }
        });
    }
    public void setDate (TextView view){

        Date str = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMM d, yyyy");//formating according to my need
        String date = formatter.format(str);
        view.setText(date);

    }
    public static void setClockAttributes(Clock c){
        clock1.setBackgroundColor(c.getBackgroundColor());
        clock1.setBorderColor(c.getBorderColor());
        clock1.setTimeZone(c.getTimeZone());
        clock1.setFont(c.getFont());
        clock1.setFontColor(c.getFontColor());
        clock.setBackgroundColor(c.getBackgroundColor());
        frame.setBackgroundColor(c.getBorderColor());

        clock.setTimeZone(c.getTimeZone());
        Log.i("MainActivity","timezone "+clock.getTimeZone());
        clock.setTypeface(Typeface.create(c.getFont(),Typeface.BOLD_ITALIC));
        dateView.setTextColor(c.getFontColor());
        dateView.setTypeface(Typeface.create(c.getFont(),Typeface.NORMAL));
        dateView.setBackgroundColor(c.getBackgroundColor());
        clock.setTextColor(c.getFontColor());
      // clock.setBackgroundColor(Color.parseColor(c.getBackgroundColor()));
    }
}
