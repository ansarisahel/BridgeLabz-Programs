package shoppingpad.com.zipdemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
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
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.ByteArrayBuffer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.Buffer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        textView = (TextView) findViewById(R.id.textView1);

        String path = Environment.getExternalStorageDirectory().getPath()+"/Zip/myZipFiles.zip";
        String destinationPath = Environment.getExternalStorageDirectory().getPath()+"/myExtractedFile123456";
        String targetLocation = Environment.getExternalStorageDirectory().getPath()+"/myExtractedFile";
        //new MyThread().execute(destinationPath);
        new ZipUtil().unZip(destinationPath,targetLocation);
    }

        //new ZipUtil().unzip(path,destinationPath);
        class MyThread extends AsyncTask<String,String,String>
        {
            ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
            StringBuffer buffer = new StringBuffer();
            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                progressDialog.dismiss();
                textView.setText(buffer.toString());

            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog.setTitle("loading");
                progressDialog.setMessage("Downloading contents");
                progressDialog.show();
            }

            @Override
            protected String doInBackground(String... strings) {
                InputStream inputStream;
                HttpURLConnection connection;
                URL url = null;
                BufferedInputStream in;
                try {
                    Log.e("In background","In background");
                    url = new URL("http://54.86.64.100:3000/api/v4/content/zip");
                    connection = (HttpURLConnection) url.openConnection();
                    inputStream = connection.getInputStream();
                    in = new BufferedInputStream(inputStream);
                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    byte[] data = new byte[50];
                    int current = 0;
                    while ((current = in.read(data,0,data.length)) != -1) {
                        buffer.write(data,0,current);
                    }
                        /* Convert the Bytes read to a String. */
                    FileOutputStream fos = new FileOutputStream(strings[0]);
                    fos.write(buffer.toByteArray());
                    fos.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }

}
