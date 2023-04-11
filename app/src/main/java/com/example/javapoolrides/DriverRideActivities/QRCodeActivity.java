package com.example.javapoolrides.DriverRideActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;

import com.example.javapoolrides.Databases.Order.Order;
import com.example.javapoolrides.Databases.Order.OrderDatabase;
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

        String driver = getIntent().getStringExtra("driver");
        Log.d("QR", driver);
        String seatsAvail = getIntent().getStringExtra("seatsAvail");
        String accessibility = getIntent().getStringExtra("accessibility");
        String petFriendly = getIntent().getStringExtra("petFriendly");

        //Hard coded for now. Change Later
        String location = "location";
        String q1 = "Yes";
        String q2 ="Yes";
        String q3 = "Yes";

        OrderDatabase dbO = Room.databaseBuilder(getApplicationContext(),
                OrderDatabase.class, "order-database").allowMainThreadQueries().build();

        Order order = new Order(driver, seatsAvail,location, petFriendly,accessibility,q1,q2,q3);
        dbO.orderDao().insertAll(order);

        Intent i = new Intent(this, RideHomeActivity.class);
        i.putExtra("from", "QR");
        i.putExtra("driver", driver);
        startActivity(i);
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