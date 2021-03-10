package com.example.se2_nicola_dirr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private TextView textView4;
    private EditText textNumber1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        textView4 = (TextView) findViewById(R.id.textView4);
        textNumber1 = (EditText) findViewById(R.id.textNumber1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // OnClick Methode legt fest was passiert, wenn man auf den Button Klickt -> Bei uns wird Matrikelnr an den Server geschickt und das ergebnis zurück via TCP
                textView4.setText("Ihre Matrikelnummer: ");

            }
        });

    }
}