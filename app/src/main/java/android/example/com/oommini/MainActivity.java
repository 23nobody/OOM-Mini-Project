package android.example.com.oommini;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

   static TextClock clock;
   static Clock clock1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView dateView = (TextView)findViewById(R.id.date);
        clock = (TextClock) findViewById(R.id.text_clock);
        setDate(dateView);
//        bu12.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TextClock clock = (TextClock) findViewById(R.id.text_clock);
//               // clock.setTimeZone("America/Los_Angeles");
//                clock.setFormat12Hour(clock.getFormat12Hour());
//
//                Log.i("12 wali button","change karnni ki koshish");
//            }
//        });
//        bu24.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TextClock clock = (TextClock) findViewById(R.id.text_clock);
//                clock.setFormat24Hour(clock.getFormat24Hour());
//                //clock.setTimeZone("America/Los_Angeles");
//                Log.i("24 wali button","change karnni ki koshish");
//            }
//        });
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
    public void setClockAttributes(Clock c){

      // clock.setBackgroundColor(Color.parseColor(c.getBackgroundColor()));
    }
}
