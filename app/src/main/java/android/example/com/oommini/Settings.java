package android.example.com.oommini;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

public class Settings extends AppCompatActivity {
    private Spinner fontSpinner;
    private Spinner tzSpinner;
    LinearLayout frame;
    LinearLayout background;
    LinearLayout tColor;
    View bgBox;
    View tcBox;
    View frBox;
    Clock clock;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);
        clock = MainActivity.clock1;;
         frame = (LinearLayout) findViewById(R.id.frame_color);
         background = (LinearLayout) findViewById(R.id.background_color);
         tColor = (LinearLayout) findViewById(R.id.text_color);
         bgBox = (View) findViewById(R.id.bg_box);
         tcBox = (View) findViewById(R.id.tc_box);
         frBox = (View) findViewById(R.id.frame_box);
        frame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showColorPicker1();
            }
        });
        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showColorPicker2();
            }
        });
        tColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showColorPicker3();
            }
        });

        fontSpinner = (Spinner) findViewById(R.id.font_spinner);
        tzSpinner = (Spinner) findViewById(R.id.tz_spinner);
        setupSpinner();
        Button save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.setClockAttributes(clock);
                finish();
            }
        });

    }

    private void showColorPicker1() {

        ColorPickerDialogBuilder
                .with(this)
                .setTitle("Choose color")
                .initialColor(Color.parseColor("#00ff00"))
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {
                        Toast.makeText(getApplicationContext(), "onColorSelected: 0x" + Integer.toHexString(selectedColor), Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        frBox.setBackgroundColor(selectedColor);
                        clock.setBorderColor(selectedColor);
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
    private void showColorPicker2() {

        ColorPickerDialogBuilder
                .with(this)
                .setTitle("Choose color")
                .initialColor(Color.parseColor("#00ff00"))
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {
                        Toast.makeText(getApplicationContext(), "onColorSelected: 0x" + Integer.toHexString(selectedColor), Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        bgBox.setBackgroundColor(selectedColor);
                        clock.setBackgroundColor(selectedColor);
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
    private void showColorPicker3() {

        ColorPickerDialogBuilder
                .with(this)
                .setTitle("Choose color")
                .initialColor(Color.parseColor("#00ff00"))
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {
                        Toast.makeText(getApplicationContext(), "onColorSelected: 0x" + Integer.toHexString(selectedColor), Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        tcBox.setBackgroundColor(selectedColor);
                        clock.setFontColor(selectedColor);
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

    private void setupSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter tzSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_timezone_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        tzSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        tzSpinner.setAdapter(tzSpinnerAdapter);

        // Set the integer mSelected to the constant values
        tzSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    clock.setTimeZone(selection);
                    Log.i("timezone selected",clock.getTimeZone());
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String selection = (String) parent.getItemAtPosition(0);
                if (!TextUtils.isEmpty(selection)) {
                clock.setTimeZone(null);
                }
            }
        });
        ArrayAdapter fontSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_font_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        fontSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        fontSpinner.setAdapter(fontSpinnerAdapter);

        // Set the integer mSelected to the constant values
       fontSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    clock.setFont(selection);
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String selection = (String) parent.getItemAtPosition(0);
                if (!TextUtils.isEmpty(selection)) {
                    clock.setFont(selection);
                }
            }
        });
    }
}

