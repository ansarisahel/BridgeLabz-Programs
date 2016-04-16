package com.example.bridgelabz.bitmap1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.ImageView;import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends ActionBarActivity {

    private int width=800, height=800;
    private float x=463,y=743,vx=1,vy=1,r=30;
    private Canvas c;
    private Paint paint;
    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

                Bitmap b = Bitmap.createBitmap(width,
                        height,Bitmap.Config.ARGB_8888);
                c = new Canvas(b);
                c.drawColor(Color.WHITE);

                paint = new Paint();
                paint.setAntiAlias(true);
                paint.setStyle(Paint.Style.FILL);

                imageview=(ImageView) findViewById(R.id.imageView1);
                imageview.setImageBitmap(b);
                Timer timer=new Timer();

                timer.schedule(
                        new TimerTask()
                        {
                            @Override
                            public void run()
                            {
                                runOnUiThread
                                        (
                                        new Runnable()
                                        {
                                            @Override
                                            public void run()
                                            {
                                                update();
                                            }
                                        });
                            }
                        },0,10 );
            }

                    void update()
                    {
                        paint.setColor(Color.WHITE);
                        c.drawCircle(x, y, r, paint);
                        float randomValX = (float)Math.random();
                        float randomValY = (float)Math.random();
                        if ( vx > 0 ) vx = randomValX;
                        else if (vx < 0) vx = -randomValX;
                        if ( vy > 0 ) vy = randomValY;
                        else if (vy < 0) vy = -randomValY;
                        x=x+vx;
                        y=y+vy;
                        if(x+r>=width || x-r<=0){ vx=-vx;}
                        // if(x-r<=0)vx=-vx;
                        if(y+r>=height || y-r<=0) {vy=-vy;}
                        // if(y-r<=0)vy=-vy;
                        paint.setColor(Color.RED);
                        c.drawCircle(x, y, r, paint);
                        imageview.invalidate();
                    }
        }
