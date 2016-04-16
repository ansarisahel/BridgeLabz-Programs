package com.example.bridgelabz.transition;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity implements Animation.AnimationListener {

    Animation animFadeIn;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        animFadeIn.setAnimationListener(this);
        textView = (TextView) findViewById(R.id.textView1);
    }




    public void onClick(View view) {
        Intent intent = new Intent(MainActivity.this,TransistionActivity.class);
        Bundle bundleAnimation = ActivityOptions.makeCustomAnimation(getApplicationContext(),R.anim.animation1,R.anim.animation2).toBundle();
        startActivity(intent,bundleAnimation);


    }

    @Override
    public void onAnimationStart(Animation animation) {
        if(animation == animFadeIn)
        {
            Toast.makeText(getApplicationContext(),"Animation started",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(animation == animFadeIn)
        {
           // Toast.makeText(getApplicationContext(),"Animation stopped",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
