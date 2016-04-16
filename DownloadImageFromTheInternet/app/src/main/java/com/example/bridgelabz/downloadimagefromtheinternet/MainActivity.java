package com.example.bridgelabz.downloadimagefromtheinternet;

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
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.Buffer;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    EditText editText;
    TextView progressTextView;
    Button downloadBtn;
    ListView listView;
    ProgressBar progressBar;
    String[] images;
    LinearLayout loadingSection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        images = getResources().getStringArray(R.array.nature_Images);
        editText = (EditText) findViewById(R.id.editText1);
        progressTextView = (TextView) findViewById(R.id.textView1);
        downloadBtn = (Button) findViewById(R.id.downloadImageBtn);
        listView = (ListView) findViewById(R.id.listView1);
        listView.setOnItemClickListener(this);
        loadingSection = (LinearLayout) findViewById(R.id.loadingSection);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

    }

    public boolean downloadImageUsingThread(String url)
    {
        URL downloadUrl;
        boolean successful = false;
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            downloadUrl = new URL(url);
            connection = (HttpURLConnection)downloadUrl.openConnection();
            inputStream = connection.getInputStream();

            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath()+"/"+ Uri.parse(url).getLastPathSegment());
            fileOutputStream = new FileOutputStream(file);

            byte[] buffer = new byte[1024];
            int read = -1;
            while ((read = inputStream.read(buffer)) != -1)
            {
                fileOutputStream.write(buffer,0,read);
                successful = true;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    loadingSection.setVisibility(View.GONE);
                }
            });
            if(connection != null)
                connection.disconnect();
            if(inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (fileOutputStream!= null)
            {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return successful;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        editText.setText(images[i]);
    }

    public void onDownloadBtnClick(View view) {
        if (editText.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "please enter some number", Toast.LENGTH_SHORT).show();
        }
        else {
            String getUrl = editText.getText().toString();
            Toast.makeText(MainActivity.this, "Btn Click", Toast.LENGTH_SHORT).show();
            Thread thread = new Thread(new downloadImageUsingThread(getUrl));
            thread.start();
        }
    }


    private class downloadImageUsingThread implements Runnable
    {
        String url;
        downloadImageUsingThread(String url)
        {
            this.url = url;
        }
        @Override
        public void run() {
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    loadingSection.setVisibility(View.VISIBLE);
                }
            });
            downloadImageUsingThread(url);
        }
    }
}
