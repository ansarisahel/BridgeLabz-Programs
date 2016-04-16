package shoppingpad.com.svgimagedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.larvalabs.svgandroid.SVG;
import com.larvalabs.svgandroid.SVGParser;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (ImageView) findViewById(R.id.imageView1);
        SVG svg = SVGParser.getSVGFromResource(getResources(),R.raw.golden_floral_vector_frame);
        imageView.setImageDrawable(svg.createPictureDrawable());
        imageView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        //setContentView(imageView);


    }
}
