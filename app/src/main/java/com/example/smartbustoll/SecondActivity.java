package com.example.smartbustoll;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    private Button fee_details;
    private Button scanner;
    private Button fee_plan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        fee_details = (Button)findViewById(R.id.button);
        scanner = (Button)findViewById(R.id.button2);
        fee_plan = (Button)findViewById(R.id.button3);

        fee_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, fee_details.class);
                startActivity(intent);

            }
        });
        scanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, scanner.class);
                startActivity(intent);

            }
        });
        fee_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondActivity.this, fee_plan.class);
                startActivity(intent);

            }
        });



    }
}