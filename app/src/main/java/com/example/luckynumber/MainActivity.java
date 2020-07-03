package com.example.luckynumber;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ImageView imageViewDice;
    private Random rng = new Random();



    private DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.draw_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new MainFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_message);
        }
        //fragmentManager = getSupportFragmentManager();
        //fragmentTransaction = fragmentManager.beginTransaction();
        //fragmentTransaction.add(R.id.fragment_container, new MainFragment());
        //fragmentTransaction.commit();


        View constrainedLayout = findViewById(R.id.linear_layout);
        imageViewDice = findViewById(R.id.image_view_dice);
        constrainedLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                rollDice();
            }
        });
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.nav_message:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MainFragment()).commit();
                break;
            case R.id.nav_message2:
                Toast.makeText(this,"Share",Toast.LENGTH_SHORT).show();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }else
        {
            super.onBackPressed();
        }
        super.onBackPressed();
    }





    private void rollDice() {
        int randomNumber = rng.nextInt(6) + 1;

        switch(randomNumber){
            case 1:
                imageViewDice.setImageResource(R.drawable.one);
                break;
            case 2:
                imageViewDice.setImageResource(R.drawable.two);
                break;
            case 3:
                imageViewDice.setImageResource(R.drawable.three);
                break;
            case 4:
                imageViewDice.setImageResource(R.drawable.four);
                break;
            case 5:
                imageViewDice.setImageResource(R.drawable.five);
                break;
            case 6:
                imageViewDice.setImageResource(R.drawable.six);
                break;

        }
    }


}