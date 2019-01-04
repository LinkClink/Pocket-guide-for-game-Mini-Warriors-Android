package com.example.linkclink.pocketguidemini_wariors_game__beta_ver_01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

// Menu armour laczenie do roznych tabeli
public class ChestsMenuActivuty_3 extends AppCompatActivity

{
    int[] item_type = {2,3};

    Intent intent;

    int i = 0;

    Button[] buttons = new Button[2];

    String[] table_names;
    String[] type_names;
    String type_1;

    int resID;
    String hh ="Chest";

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chests_menu_3);

        buttons_realisations();
    }

    public void buttons_realisations()
    {
        table_names = getResources().getStringArray(R.array.Chests_Table_name);
        type_names = getResources().getStringArray(R.array.Chests_type_name);
        type_1 = getResources().getString(R.string.Chests_type_1);

        for (i = 0; i < 2; i++)
        {
            resID = getResources().getIdentifier("menuchests_button_" + i, "id", getPackageName());
            buttons[i] = (Button) findViewById(resID);
            buttons[i].setId(i);
            buttons[i].setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    intent = new Intent(ChestsMenuActivuty_3.this, ItemsListActivity_4.class);
                    intent.putExtra("table_name", table_names[v.getId()]);
                    intent.putExtra("type_1", type_1 + "," + type_names[v.getId()]);

                    if (type_names[v.getId()].equals("Chest")) intent.putExtra("item_type", item_type[0]);
                    else intent.putExtra("item_type", item_type[1]);

                    startActivityForResult(intent, 1);
                    overridePendingTransition(R.anim.animation_activity_standart_1, R.anim.animation_activity_standart_1);
                }
            });
        }
    }
}
