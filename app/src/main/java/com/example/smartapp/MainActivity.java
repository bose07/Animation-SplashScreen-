package com.example.smartapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import static com.example.smartapp.R.*;
import static java.lang.Thread.*;

public class MainActivity extends AppCompatActivity {
Button sub;
ImageView ballon ;
Animation frombottom,fromtop ;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);

        sub= findViewById(id.sub);
        ballon= findViewById(id.ballon);

        frombottom = AnimationUtils.loadAnimation(this, anim.frombottom);
        fromtop = AnimationUtils.loadAnimation(this, anim.fromtop);
                sub.setAnimation(frombottom);
                ballon.setAnimation(fromtop);

                Thread myThread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        long millis = 4000;
                        try {
                            sleep(millis);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }


                        Intent intent=new Intent(MainActivity.this,HomeActivity.class);
                        startActivity(intent);
                    }
                });
                  myThread.start();
    }



}
