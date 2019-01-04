package com.example.linkclink.pocketguidemini_wariors_game__beta_ver_01;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

// Informacja o programie
public class CreditsInfoActivity_2 extends AppCompatActivity
{
    TextView textView_1;

    Animation animation_1;

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits_info_2);

        animation_textviews();
    }

    public void animation_textviews()
    {
        handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            public void run()
            {
                textView_1 = (TextView) findViewById(R.id.credits_text_1);
                animation_1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.animation_textviews_credits_info_2);
                textView_1.startAnimation(animation_1);
            }
        }, 5000);
    }
}
