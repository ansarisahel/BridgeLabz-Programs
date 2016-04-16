package shoppingpad.com.glidedemo;

import android.app.VoiceInteractor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.DrawableRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1,imageView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        SimpleTarget target = new SimpleTarget() {
            @Override
            public void onResourceReady(Object resource, GlideAnimation glideAnimation) {
                imageView1.setImageBitmap((Bitmap)resource);
                imageView2.setImageBitmap((Bitmap) resource);
            }
        };
        
        Glide.with(this).load("http://freebigpictures.com/wp-content/uploads/2009/09/country-view.jpg").asBitmap().into(target);
    }
}
