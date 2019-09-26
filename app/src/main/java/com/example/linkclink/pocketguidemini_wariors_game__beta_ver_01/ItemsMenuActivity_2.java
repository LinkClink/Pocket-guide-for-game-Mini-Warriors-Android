package com.example.linkclink.pocketguidemini_wariors_game__beta_ver_01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

// Menu wyboru typy amunicji
public class ItemsMenuActivity_2 extends AppCompatActivity

{
    private Button menuitems_button_1;
    private Button menuitems_button_2;
    private Button menuitems_button_3;
    private Button menuitems_button_4;
    private Button menuitems_button_5;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_items_menu_2);
    }

    public void onClick(View view)

    {
        menuitems_button_1 = (Button) findViewById(R.id.menuitems_button_1);
        menuitems_button_2 = (Button) findViewById(R.id.menuitems_button_2);
        menuitems_button_3 = (Button) findViewById(R.id.menuitems_button_3);
        menuitems_button_4 = (Button) findViewById(R.id.menuitems_button_4);
        menuitems_button_5 = (Button) findViewById(R.id.menuitems_button_5);

        if(view == menuitems_button_1) menu_weapons();
        if(view == menuitems_button_2) menu_clothing();
        if(view == menuitems_button_3) menu_chests();
        if(view == menuitems_button_4) menu_skill_items();
        if(view == menuitems_button_5) menu_money();

    }

    public void menu_weapons()
    {
        Intent intent = new Intent(ItemsMenuActivity_2.this, WeaponsMenuActivity_3.class);
        startActivityForResult(intent,1);
        overridePendingTransition(R.anim.animation_activity_standart_1,R.anim.animation_activity_standart_1);
    }

    public void menu_clothing()
    {
        Intent intent = new Intent(ItemsMenuActivity_2.this, ClothingMenuActivity_3.class);
        startActivityForResult(intent,1);
        overridePendingTransition(R.anim.animation_activity_standart_1,R.anim.animation_activity_standart_1);
    }

    public void menu_chests()
    {
        Intent intent = new Intent(ItemsMenuActivity_2.this, ChestsMenuActivity_3.class);
        startActivityForResult(intent,1);
        overridePendingTransition(R.anim.animation_activity_standart_1,R.anim.animation_activity_standart_1);
    }

    public void menu_skill_items()
    {
       Intent intent = new Intent(ItemsMenuActivity_2.this , SkillsItemsMenuActivity_3.class);
       startActivityForResult(intent,1);
        overridePendingTransition(R.anim.animation_activity_standart_1,R.anim.animation_activity_standart_1);
    }

    public void menu_money()
    {
        Intent intent = new Intent(ItemsMenuActivity_2.this , MoneyInfoActivity_3.class);
        startActivityForResult(intent,1);
        overridePendingTransition(R.anim.animation_activity_standart_1,R.anim.animation_activity_standart_1);
    }

}