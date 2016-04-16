package com.example.bridgelabz.app2;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    TextView txtMessage;
    EditText et;
    Button btnLoad;
    String packageName = "com.example.bridgelabz.app1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("App 2");
        txtMessage = (TextView) findViewById(R.id.txtMessage);
        et = (EditText) findViewById(R.id.et1);
        btnLoad = (Button) findViewById(R.id.btnLoad);
    }


    public void onBtnLoadClick(View view) {
        PackageManager packageManager = getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(packageName,PackageManager.GET_META_DATA);
            String fullPath = applicationInfo.dataDir +"/files/abc.txt";
            Toast.makeText(MainActivity.this,fullPath, Toast.LENGTH_SHORT).show();
            readFile(fullPath);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void readFile(String fullPath) {
        try {
            StringBuffer message = new StringBuffer();
            int read = -1;
            FileInputStream reader = new FileInputStream(new File(fullPath));
            while ((read = reader.read()) != -1)
            {
                message.append((char)read);
            }
            txtMessage.setTextColor(Color.GREEN);
            txtMessage.setText(message.toString());
        }
        catch (FileNotFoundException fex)
        {
            txtMessage.setTextColor(Color.RED);
            txtMessage.setText(fex.toString());
        } catch (IOException IOE) {
            txtMessage.setTextColor(Color.RED);
            txtMessage.setText(IOE.toString());
        }
    }
}
