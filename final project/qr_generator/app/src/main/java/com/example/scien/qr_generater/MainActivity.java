package com.example.scien.qr_generater;

import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    private ImageView imageView;
    private String check ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.qrcode);

        final String[] text_array = {"ashoknagar", "10AM", "12/13/18"};

        Handler handler = new Handler();

        for (int i=1;i<text_array.length;i++) {
        qr_code_generator code = new qr_code_generator(text_array[0]);
            Bitmap bitmap = code.generate_qr();
            imageView.setImageBitmap(bitmap);
            check = text_array[i];
             handler.postDelayed(new Runnable() {
                 @Override
                 public void run() {
                     qr_code_generator code = new qr_code_generator(check);
                     Bitmap bitmap = code.generate_qr();
                     imageView.setImageBitmap(bitmap);
                 }
             }, 30000);
        }
    }
}
