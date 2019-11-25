package android.example.com.oommini;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

public class Settings extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);
        LinearLayout frame = (LinearLayout) findViewById(R.id.frame_color);
        LinearLayout background  = (LinearLayout) findViewById(R.id.background_color);
        LinearLayout tColor = (LinearLayout)findViewById(R.id.text_color);
        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            showColorPicker();
            }
        };
        frame.setOnClickListener(click);
        background.setOnClickListener(click);
        tColor.setOnClickListener(click);
    }
    private void showColorPicker(){
        ColorPickerDialogBuilder
                .with(this)
                .setTitle("Choose color")
                .initialColor(Color.parseColor("#00ff00"))
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {
                        Toast.makeText(getApplicationContext(),"onColorSelected: 0x" + Integer.toHexString(selectedColor),Toast.LENGTH_SHORT);
                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                     //   changeBackgroundColor(selectedColor);
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .build()
                .show();
    }
}

