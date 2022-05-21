package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.View;

import com.example.finalproject.databinding.ActivityHomepageBinding;
import com.example.finalproject.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationView;

public class Homepage extends AppCompatActivity {

   ActivityHomepageBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomepageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new CounterFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch(item.getItemId()){
                case R.id.counter:
                    replaceFragment(new CounterFragment());
                    break;
                case R.id.area:
                    replaceFragment(new AreaFragment());
                    break;
                case R.id.volume:
                    replaceFragment(new VolumeFragment());
                    break;
            }



            return true;
        });
        
    }

    private void replaceFragment(Fragment fragment) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
    }
