package com.example.se2_nicola_dirr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private TextView textView1;
    private EditText textNumber1;
    private Button button2;
    private TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button) findViewById(R.id.button1);
        textView1 = (TextView) findViewById(R.id.textView1);
        textNumber1 = (EditText) findViewById(R.id.textNumber1);
        button2 = (Button) findViewById(R.id.button2);
        textView2 = (TextView) findViewById(R.id.textView2);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String st = textNumber1.getText().toString();
                StringBuilder studentNumber = new StringBuilder(st);
                int p = 97;

                for (int i = 1; i < st.length(); i++) {
                    if (i % 2 != 0) {
                        studentNumber.setCharAt(i, (char) p);
                        p++;

                    }
                }
                textView1.setText(studentNumber);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                run();

            }
        });

    }

    public void run() {
        ExampleThread thread = new ExampleThread();
        thread.start();

    }

    class ExampleThread extends Thread {
        @Override
        public void run() {
            try {
                String textServer = textNumber1.getText().toString();
                Socket clientTCP = new Socket("se2-isys.aau.at", 53212);
                DataOutputStream outToServer = new DataOutputStream(clientTCP.getOutputStream());
                BufferedReader fromServer = new BufferedReader(new InputStreamReader(clientTCP.getInputStream()));
                outToServer.writeBytes(textServer + '\n');
                textView2.setText(fromServer.readLine());
                clientTCP.close();
            } catch (Exception  NetworkError) {
                System.out.println("Error");
            }
        }
    }
}