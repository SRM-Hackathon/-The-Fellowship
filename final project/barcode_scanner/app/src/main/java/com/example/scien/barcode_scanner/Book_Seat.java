package com.example.scien.barcode_scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Book_Seat extends AppCompatActivity {

    public static TextView seat;
    public ImageView minus;
    public ImageView plus;
    public int seats = 1;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book__seat);

        Intent intent = getIntent();
        final String text = intent.getStringExtra("string");

        seat = (TextView) findViewById(R.id.seats);
        minus = (ImageView) findViewById(R.id.minus);
        plus = (ImageView) findViewById(R.id.plus);
        button = (Button) findViewById(R.id.submit);

        seat.setText(String.valueOf(seats));
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(seats>0)
                {
                    seats--;
                }
                seat.setText(String.valueOf(seats));
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                seats++;
                seat.setText(String.valueOf(seats));
            }
        });

        //int value = Integer.parseInt(seat.getText().toString());

        final Intent intent1 = new Intent(Book_Seat.this, congrats.class);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent1);
            }
        });
    }
}
