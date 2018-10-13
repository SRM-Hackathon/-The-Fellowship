package com.example.scien.barcode_scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Scanned_result extends AppCompatActivity {

    public static TextView stand;
    public static TextView time;
    public static TextView date;
    public static TextView seat;
    public Button book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanned_result);

        Intent intent = getIntent();
        String text = intent.getStringExtra("result");

        stand = (TextView) findViewById(R.id.stand);
        time = (TextView) findViewById(R.id.time);
        date = (TextView) findViewById(R.id.date);
        seat = (TextView) findViewById(R.id.seat);
        book = (Button) findViewById(R.id.book);

        final String[] text_array = text.split(" ");
        try {
            stand.setText(text_array[0]);
            time.setText(text_array[1]);
            date.setText(text_array[2]);
            seat.setText(text_array[3]);
        }catch (Exception e){
            e.printStackTrace();
        }

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Scanned_result.this, Book_Seat.class);
                intent1.putExtra("string", text_array[0]);
                startActivity(intent1);
            }
        });
    }
}
