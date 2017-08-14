package com.bitbotech.ronen.circlemenu;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bitbotech.ronen.circlemenu.Fragment.AFragment;
import com.hitomi.cmlibrary.CircleMenu;
import com.hitomi.cmlibrary.OnMenuSelectedListener;
import com.hitomi.cmlibrary.OnMenuStatusChangeListener;

public class MainActivity extends AppCompatActivity {

   CircleMenu circleMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        Button btnLoad = (Button) findViewById(R.id.btn_load);
//        View.OnClickListener listener = new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fragmentManager = getFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                AFragment hello = new AFragment();
//
//                fragmentTransaction.add(R.id.fragment_container, hello, "HELLO");
//                fragmentTransaction.commit();
//            }
//        };
//        btnLoad.setOnClickListener(listener);



        circleMenu =   (CircleMenu) findViewById(R.id.circle_menu);

        circleMenu.setMainMenu(Color.parseColor("#CDCDCD"), R.drawable.menu, R.drawable.stop)
                .addSubMenu(Color.parseColor("#FFFFFF"), R.drawable.like)
                .addSubMenu(Color.parseColor("#30A400"), R.drawable.hurt)
                .addSubMenu(Color.parseColor("#FF4B32"), R.drawable.home)
                .addSubMenu(Color.parseColor("#8A39FF"), R.drawable.plus)
                .addSubMenu(Color.parseColor("#FF6A00"), R.drawable.musicplayer);


        circleMenu.setOnMenuSelectedListener(new OnMenuSelectedListener() {
                    @Override
                    public void onMenuSelected(int index) {

                        switch (index) {
                            case 0:
                                Toast.makeText(MainActivity.this, "Like Button Clicked", Toast.LENGTH_SHORT).show();
                                addTofragmentSection(index , "Like Button");
                                break;
                            case 1:
                                Toast.makeText(MainActivity.this, "Heart button Clicked", Toast.LENGTH_SHORT).show();
                                addTofragmentSection(index , "Heart Button");
                                break;
                            case 2:
                                Toast.makeText(MainActivity.this, "Home button Clciked", Toast.LENGTH_SHORT).show();
                                addTofragmentSection(index , "Home Button");
                                break;
                            case 3:
                                Toast.makeText(MainActivity.this, "Plus button Clcked", Toast.LENGTH_SHORT).show();
                                addTofragmentSection(index , "Plus Button");
                                break;
                            case 4:
                                Toast.makeText(MainActivity.this, "Music Play button Clicked", Toast.LENGTH_SHORT).show();
                                addTofragmentSection(index , "Music Button");
                                break;
                        }

                    }

            private void addTofragmentSection(int index, String s) {

                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                AFragment hello = new AFragment();
                hello.index = index;
                hello.name = s;
                fragmentTransaction.add(R.id.fragment_container, hello, "HELLO");
                fragmentTransaction.commit();
            }

        });

        circleMenu.setOnMenuStatusChangeListener(new OnMenuStatusChangeListener() {

            @Override
            public void onMenuOpened() {
                Toast.makeText(MainActivity.this, "Menu Opend", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMenuClosed() {
                Toast.makeText(MainActivity.this, "Menu Closed", Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public void onBackPressed() {
        if (circleMenu.isOpened()){
            Toast.makeText(MainActivity.this, "circleMenu.closeMenu();", Toast.LENGTH_SHORT).show();
            circleMenu.closeMenu();
        }else
        {
            finish();
        }


    }
}
