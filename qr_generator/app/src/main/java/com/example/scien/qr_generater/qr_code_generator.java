package com.example.scien.qr_generater;

import android.content.Intent;
import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class qr_code_generator {
    private String details;
    public Bitmap bitmap;
    qr_code_generator(String text){
        details = text;
    }
    public Bitmap generate_qr(){
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(details, BarcodeFormat.QR_CODE,250,250);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.createBitmap(bitMatrix);

        }catch (WriterException e){
            e.printStackTrace();
        }
        return bitmap;
    }
}
