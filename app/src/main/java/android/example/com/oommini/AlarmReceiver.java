package android.example.com.oommini;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        Alarms inst = Alarms.;
//        inst.setAlarmText("ALARM IS GOING OFF");
        Log.i("Alarm Receiver", "Receive toh ho raha hai");

        Uri alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if (alarmUri == null) {
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        }
        Ringtone ringtone = RingtoneManager.getRingtone(context, alarmUri);
        ringtone.play();

        //
//        ComponentName comp = new ComponentName(context.getPackageName(),
//                AlarmService.class.getName());
//        startService(context, (intent.setComponent(comp)));
//        setResultCode(Activity.RESULT_OK);
    }
    }

