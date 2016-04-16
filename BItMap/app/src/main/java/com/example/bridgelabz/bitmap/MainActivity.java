package com.example.bridgelabz.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

import java.io.File;

public class MainActivity extends ActionBarActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bitmap b = Bitmap.createBitmap(500,500,Bitmap.Config.ARGB_8888);
        b.eraseColor(Color.RED);
        iv = (ImageView) findViewById(R.id.imageView1);

        Drawable drawable = getResources().getDrawable(R.drawable.d);
        Bitmap b1 = ((BitmapDrawable) drawable).getBitmap();
        Canvas c1 = new Canvas(b1);

        Canvas c = new Canvas(b);
        iv.setImageBitmap(b1);

        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(6F);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);

        int x = 10, y = 10;

        for(int i = 1; i <= 10; i++)
        {
            c.drawCircle(x,y,25F,paint);
            x = x+50;
            y = y+50;
        }
       // c.drawLine(0F,0F,500F,500F,paint);

        /*paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.YELLOW);
        c.drawCircle(400F, 200F, 50F, paint);

        paint.setColor(Color.BLUE);
        c.drawRect(20F,300F,180F,400F,paint);

        paint.setColor(Color.BLACK);
        paint.setTextSize(50F);
        c.rotate(15F);
        c.drawText("Hello Graphics",0,14,90,80,paint);*/

    }
}
