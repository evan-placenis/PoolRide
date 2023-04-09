package com.example.javapoolrides.DriverRideActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;

import com.example.javapoolrides.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode);
        setTitle("QR Code");
    }

    public void generate(View v){
        Bitmap qrCodeBitmap = generateQRCode("Hello, world!");
        ImageView imageView = findViewById(R.id.QR);
        imageView.setImageBitmap(qrCodeBitmap);
    }

    public static Bitmap generateQRCode(String text) {
        int width = 350; // width of the QR code bitmap
        int height = 350; // height of the QR code bitmap

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        try {
            BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);
            Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    bitmap.setPixel(x, y, bitMatrix.get(x, y) ? Color.BLACK : Color.WHITE);
                }
            }
            return bitmap;
        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }
    }
}