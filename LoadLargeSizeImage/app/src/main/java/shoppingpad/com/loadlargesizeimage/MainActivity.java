package shoppingpad.com.loadlargesizeimage;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

public class MainActivity extends AppCompatActivity {

    SubsamplingScaleImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        imageView = (SubsamplingScaleImageView) findViewById(R.id.imageView1);
        imageView.setImage(ImageSource.uri(Environment.getExternalStorageDirectory()+"/Zip Files Extracted1/ContentId1/Content/media/images/m_11044522989043.png"));


    }
}
