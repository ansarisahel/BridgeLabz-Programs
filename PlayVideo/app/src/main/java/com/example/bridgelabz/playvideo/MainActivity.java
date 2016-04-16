package com.example.bridgelabz.playvideo;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends ActionBarActivity implements SurfaceHolder.Callback {

    Button button;
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
        videoView = (VideoView) findViewById(R.id.videoView1);
        String path = Environment.getExternalStorageDirectory()+"/Movies/myVideo".toString();
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VideoView videoView = (VideoView) findViewById(R.id.videoView1);
                String path = Environment.getExternalStorageDirectory().getAbsolutePath()+"/Movies/myVideo.3gp".toString();
                Toast.makeText(getBaseContext(),path,Toast.LENGTH_SHORT).show();
                Uri uri = Uri.parse(path);
                videoView.setVideoURI(uri);
                videoView.requestFocus();
                videoView.start();
            }
        });
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }
}
