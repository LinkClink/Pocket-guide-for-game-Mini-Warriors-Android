package com.example.linkclink.pocketguidemini_wariors_game__beta_ver_01;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

// Glowne menu programu
public class MainActivity_1 extends AppCompatActivity
{
    // Buttons Main menu declaration
    private Button main_button_1;
    private Button main_button_2;
    private Button main_button_3;
    private Button main_button_4;
    private Button main_button_5;
    private Button main_button_6;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        setTheme(R.style.AppTheme);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);
    }
    //Realizacja kliknieczia
    public void onClick(View view)
    {
        main_button_1 = (Button) findViewById(R.id.main_button_1);
        main_button_2 = (Button) findViewById(R.id.main_button_2);
        main_button_3 = (Button) findViewById(R.id.main_button_3);
        main_button_4 = (Button) findViewById(R.id.main_button_4);
        main_button_5 = (Button) findViewById(R.id.main_button_5);
        main_button_6 = (Button) findViewById(R.id.main_button_6);

        if(view  == main_button_1) menu_heroes();
        if(view == main_button_2) menu_items();
        if(view == main_button_3) skills_menu();
        if(view == main_button_4) academy_menu();
        if(view == main_button_5) info_credits();
        if(view == main_button_6) quit();

    }

    public void menu_heroes()
    {
        Intent intent = new Intent(MainActivity_1.this, HeroesMenuActivity_2.class);
        startActivityForResult(intent,1);
        overridePendingTransition(R.anim.animation_activity_standart_1,R.anim.animation_activity_standart_1);
    }

    public void menu_items()
    {
        Intent intent = new Intent(MainActivity_1.this, ItemsMenuActivity_2.class);
        startActivityForResult(intent,1);
        overridePendingTransition(R.anim.animation_activity_standart_1,R.anim.animation_activity_standart_1);
    }

    public void skills_menu()
    {
        CodeErrNotWork.showToast(getApplicationContext());
    }

    public void academy_menu()
    {
        CodeErrNotWork.showToast(getApplicationContext());
    }

    public void info_credits()
    {
        Intent intent = new Intent(MainActivity_1.this, CreditsInfoActivity_2.class);
        startActivityForResult(intent,1);
        overridePendingTransition(R.anim.animation_activity_standart_1,R.anim.animation_activity_standart_1);
    }

    public void quit()
    {
        finish();
        System.exit(0);
    }
}