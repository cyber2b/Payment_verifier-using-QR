package com.example.smartbustoll;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

public class fee_details extends AppCompatActivity {

    Button but_scan;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_details);

        but_scan =findViewById(R.id.button);
        txt = findViewById(R.id.textView);
        but_scan.setOnClickListener(view ->
        {
            scanCode();

        });
    }

    private void scanCode() {
        ScanOptions options= new ScanOptions();
        options.setPrompt("turn on the flash");
        options.setBeepEnabled(true);
        options.setOrientationLocked(true);
        options.setCaptureActivity(captureact.class);
        barlaucher.launch(options);


    }
    ActivityResultLauncher<ScanOptions> barlaucher = registerForActivityResult(new ScanContract(),result -> {
        if(result.getContents() != null)
        {
            txt.setText(result.getContents());

        }
    });


}