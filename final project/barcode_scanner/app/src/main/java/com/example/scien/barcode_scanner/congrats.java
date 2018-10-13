package com.example.scien.barcode_scanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class                                                                                                                                                                        congrats extends AppCompatActivity {

    public static TextView confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats);

        Intent intent = getIntent();

        String value = Book_Seat.seat.getText().toString();
        String stand = Scanned_result.stand.getText().toString();
        int val = Integer.parseInt(value);

        TextView textView = (TextView) findViewById(R.id.confirm);
        String conf = "Booking done for "+val+" in "+stand+" ";
        textView.setText(conf);
    }
}
