package com.example.linkclink.pocketguidemini_wariors_game__beta_ver_01;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import java.io.IOException;

// A list for items (all)
public class ItemsListActivity_4 extends AppCompatActivity

{
    private DataBaseSqlHelper dbHelper;
    private SQLiteDatabase  database;

    // For SQL
    private String icon_link;
    private String name_item;

    Bundle arguments;
    String intent_arg_table;

    int drawable_icon_link;
    int i=1;

    String type;
    String ac_request_code;
    int item_type_activity;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_items_list_4);

        // For DB connect
        dbHelper = new DataBaseSqlHelper(this);

        try
        {
            dbHelper.updateDataBase();

        }
        catch (IOException mIOException)
        {
            throw new Error("UnableToUpdateDatabase");
        }
        try
        {
            database = dbHelper.getWritableDatabase();
        }
        catch (SQLException mSQLException)
        {
            throw mSQLException;
        }

        // Database items to list
        add_to_list();
    }

    public void add_to_list()
    {
        arguments = getIntent().getExtras();
        intent_arg_table = arguments.get("table_name").toString();
        item_type_activity = arguments.getInt("item_type");
        ac_request_code = arguments.get("request_code").toString();
        type = arguments.get("type_1").toString();

        // Font for buttons
        Typeface typeface = ResourcesCompat.getFont(getApplicationContext(), R.font.the_girl_next_door);
        Drawable drawable_backround = getResources().getDrawable(R.drawable.main_buttons_selector);
        LinearLayout list_linearlay = (LinearLayout)findViewById(R.id.line_sc) ;

        /// Layout settings
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(0, 40, 0, 0);

        ///  Select SQL
        Cursor cursor_name = database.rawQuery(" SELECT * FROM " + intent_arg_table , null);
        Cursor cursor_icon = database.rawQuery(" SELECT link_image FROM " + intent_arg_table ,null);

        cursor_name.moveToFirst();
        cursor_icon.moveToFirst();

        while (!cursor_name.isAfterLast())
        {
            //// Buttons Settings
            Button button = new Button(this);

            // size
            button.setWidth(270);
            button.setHeight(60);
            button.setTextSize(17);

            button.setTypeface(typeface);
            button.setGravity(Gravity.CENTER);
            button.setBackground(drawable_backround);
            ///////////////////////

            button.setId(i);
            button.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    switch (item_type_activity)
                    {
                        // Weapons , Clothing , Scrolls
                        case 1:
                        {
                            Intent intent = new Intent(ItemsListActivity_4.this, BasedInfoActivity_5.class);
                            intent.putExtra("table_name",intent_arg_table);
                            intent.putExtra("button_id",v.getId());
                            intent.putExtra("type_1",type);
                            intent.putExtra("request_code",ac_request_code);
                            startActivityForResult(intent, 1);
                            overridePendingTransition(R.anim.animation_activity_standart_1, R.anim.animation_activity_standart_1);
                            break;
                        }

                        // Chests
                        case 2:
                        {
                            Intent intent = new Intent(ItemsListActivity_4.this, ChestsInfoActivity_5.class);
                            intent.putExtra("table_name",intent_arg_table);
                            intent.putExtra("button_id",v.getId());
                            intent.putExtra("type_1",type);
                            startActivityForResult(intent, 1);
                            overridePendingTransition(R.anim.animation_activity_standart_1, R.anim.animation_activity_standart_1);
                            break;
                        }

                        // Keys
                        case 3:
                        {
                            Intent intent = new Intent(ItemsListActivity_4.this, KeysInfoActivity_5.class);
                            intent.putExtra("table_name",intent_arg_table);
                            intent.putExtra("button_id",v.getId());
                            intent.putExtra("type_1",type);
                            startActivityForResult(intent, 1);
                            overridePendingTransition(R.anim.animation_activity_standart_1, R.anim.animation_activity_standart_1);
                            break;
                        }
                        default:
                        {
                            break;
                        }

                    }
                }
            });

            //icon
            icon_link = cursor_icon.getString(0);
            drawable_icon_link = getResources().getIdentifier(icon_link , "drawable", getPackageName());
            button.setCompoundDrawablesWithIntrinsicBounds(drawable_icon_link,0,0,0);
            button.setPadding(18,0,0,0);
            cursor_icon.moveToNext();

            // name
            name_item = cursor_name.getString(1);
            button.setText(name_item);
            cursor_name.moveToNext();

            //add to list
            list_linearlay.addView(button,layoutParams);
            i++;
        }

        cursor_name.close();
        cursor_icon.close();
    }
}