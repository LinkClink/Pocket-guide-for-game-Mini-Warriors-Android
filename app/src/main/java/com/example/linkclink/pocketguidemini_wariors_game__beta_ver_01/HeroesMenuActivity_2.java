package com.example.linkclink.pocketguidemini_wariors_game__beta_ver_01;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class HeroesMenuActivity_2 extends AppCompatActivity

{
    // !Only in version 0.1
    Button[] hero_buts = new Button[4];
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_heroes_menu_2);

        // !Only in version 0.1
        buttons_add();
    }

  // !Only in version 0.1
  public void buttons_add()
  {
      for(i=0;i<=3;i++)
      {
          String find = "menuheroes_button_"+i;
          int resID = getResources().getIdentifier(find, "id", getPackageName());

          hero_buts[i] = (Button)findViewById(resID);
          hero_buts[i].setOnClickListener(new View.OnClickListener()
          {
              @Override
              public void onClick(View v)
              {
                  CodeErrNotWork.showToast(getApplicationContext());
              }
          });
      }
  }
}