package shoppingpad.com.svgdemo1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageView = (ImageView) findViewById(R.id.imageView1);
        String path = Environment.getExternalStorageDirectory().getPath() + "/Zip/computer.svg";
        File file = new File(path);
        //if(file.exists()) {
          //  Toast.makeText(MainActivity.this, "File exist", Toast.LENGTH_SHORT).show();
            //try {
              //  FileInputStream fis = new FileInputStream(file);
                SVG svg = SVGParser.getSVGFromResource(getResources(),R.raw.page_2);
                imageView.setImageDrawable(svg.createPictureDrawable());
                imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            //} catch (FileNotFoundException e) {
             //   e.printStackTrace();
            //}
        //}
       // else
        //    Toast.makeText(MainActivity.this, "File Doesn't exist", Toast.LENGTH_SHORT).show();

    }
}
