package com.example.smartbustoll;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class scanner extends AppCompatActivity {
    TextView txt;
    Button but_scan;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        txt =findViewById(R.id.textView2);
        but_scan =findViewById(R.id.button7);
        but_scan.setOnClickListener(view ->
        {
            scanCode();

        });




    }

    public void scanCode() {
        ScanOptions options= new ScanOptions();
        options.setPrompt("turn on the flash");
        options.setBeepEnabled(false);
        options.setOrientationLocked(true);
        options.setCaptureActivity(captureact.class);
        barlaucher.launch(options);


    }
    ActivityResultLauncher<ScanOptions> barlaucher = registerForActivityResult(new ScanContract(), result -> {
        if(result.getContents().contains("paid"))
        {

            txt.setText("Paid");
            txt.setBackgroundColor(Color.parseColor("#00FF00"));




        }
        else{
            txt.setText("Not Paid");
            txt.setBackgroundColor(Color.parseColor("#FF0000"));

        }
    });
}