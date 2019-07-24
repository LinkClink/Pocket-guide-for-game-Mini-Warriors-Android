package com.example.linkclink.pocketguidemini_wariors_game__beta_ver_01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class SkillsItemsMemuActivity_3 extends AppCompatActivity
{

    private Button menu_button_1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_skills_items_memu_3);
    }

    public void onClick(View view)
    {
        menu_button_1 = findViewById(R.id.menuscrolls_button_0);

        if(view == menu_button_1) ;




    }



}
