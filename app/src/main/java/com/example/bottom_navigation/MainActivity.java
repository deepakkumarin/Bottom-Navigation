package com.example.bottom_navigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bottom_navigation.fragments.CameraFragment;
import com.example.bottom_navigation.fragments.MoreFragment;
import com.example.bottom_navigation.fragments.PicturesFragment;
import com.example.bottom_navigation.fragments.ProductFragment;
import com.example.bottom_navigation.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomnavigation);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container,new HomeFragment());
        transaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId()){
                    case R.id.home:
                        transaction.replace(R.id.container,new HomeFragment());
                        break;
                    case R.id.pictures:
                        transaction.replace(R.id.container,new PicturesFragment());
                        break;
                    case R.id.camera:
                        transaction.replace(R.id.container,new CameraFragment());
                        break;
                    case R.id.products:
                        transaction.replace(R.id.container,new ProductFragment());
                        break;
                    case R.id.more:
                        transaction.replace(R.id.container,new MoreFragment());
                        break;
                }
                transaction.commit();

                return true;
            }
        });
    }
}