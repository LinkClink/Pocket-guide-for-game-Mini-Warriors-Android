package com.example.linkclink.pocketguidemini_wariors_game__beta_ver_01;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Description page for clothing and ammunition
public class BasedInfoActivity_5 extends AppCompatActivity
{
    private DataBaseSqlHelper dbHelper;
    private SQLiteDatabase database;

    Bundle arguments;
    String request_code;

    private String table_name;
    private String button_id;
    private String type;

    private ImageView imageView_icon;

    private TextView textView_name;
    private TextView textView_type;

    // Strings data sql
    String[] list_names = {"Hit-points: ","Attack: ","Defence: ","Luck: ","Dodge: ","Stars: ","Price: "};
    String[] list_names_1 = {"Price: " , "Legion shop price: " , "Use by upgrade heroes skills level: "};

    ListView list1;

    int i;
    int charAt =0;

    int a = 2;

    // Link to icon
    private int drawable_icon_link;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_based_info_5);

        // For DB connect
        dbHelper = new DataBaseSqlHelper(this);

        try
        { dbHelper.updateDataBase(); }
        catch (IOException mIOException)
        { throw new Error("UnableToUpdateDatabase"); }
        try
        { database = dbHelper.getWritableDatabase(); }
        catch (SQLException mSQLException)
        { throw mSQLException; }

        // Add informations to layout
        sql_data_to_info();
    }

    public  void sql_data_to_info()
    {
        arguments = getIntent().getExtras();

        table_name = arguments.get("table_name").toString();
        button_id = arguments.get("button_id").toString();
        type = arguments.get("type_1").toString();
        request_code = arguments.get("request_code").toString();

        imageView_icon = (ImageView) findViewById(R.id.imageview_weap_cloth);

        textView_name = (TextView) findViewById(R.id.textview_weap_cloth_name_1);
        textView_type = (TextView) findViewById(R.id.textview_weap_cloth_type_1);

        Cursor cursor_data = database.rawQuery(" SELECT * FROM " + table_name +" WHERE id= " + button_id , null);
        cursor_data.moveToFirst();

        // Icon
        drawable_icon_link = getResources().getIdentifier(cursor_data.getString(charAt=Integer.parseInt(Character.toString(request_code.charAt(0)))), "drawable", getPackageName());
        imageView_icon.setImageResource(drawable_icon_link);

        // Name
        textView_name.setText("Name: "+cursor_data.getString(charAt=Integer.parseInt(Character.toString(request_code.charAt(1)))));

        // Type
        textView_type.setText("Type: "+type);
        List<String> arr_1 = new ArrayList<String>();
        list1 = (ListView) findViewById(R.id.listview_weaponcloth);
        charAt = Integer.parseInt(Character.toString(request_code.charAt(2)));

       for( i =0 ; i<=charAt ; i++ )
       {
           switch (request_code)
           {
               case "512":
               {
                   arr_1.add(list_names_1[i] + cursor_data.getString(a));
                   break;
               }
               case "916":
               {
                   arr_1.add(list_names[i] + cursor_data.getString(a));
                   break;
               }
           }
           a++;
       }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr_1);
        list1.setAdapter(arrayAdapter);
        cursor_data.close();
    }
}
