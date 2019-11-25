package android.example.com.oommini;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Alarms extends AppCompatActivity {
    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private TimePicker alarmTimePicker;
    private TextView alarmTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
        alarmTimePicker = (TimePicker) findViewById(R.id.timePick);
        alarmTextView = (TextView) findViewById(R.id.alarmText);
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggle_alarm);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
    }
    public void onToggleClicked(View view) {
        if (((ToggleButton) view).isChecked()) {
            Log.d("MyActivity", "Alarm On");
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getHour());
            calendar.set(Calendar.MINUTE, alarmTimePicker.getMinute());

            Intent myIntent = new Intent(Alarms.this, AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(Alarms.this, 0, myIntent, 0);
            alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);

        } else {
            alarmManager.cancel(pendingIntent);
            setAlarmText("");
            Log.d("MyActivity", "Alarm Off");
        }
    }
    public void setAlarmText(String alarmText) {
        alarmTextView.setText(alarmText);
    }
}
