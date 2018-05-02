package com.example.android.utabazzar;
//do not use
//import android.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.android.utabazzar.ui.UserProfileFragment;
import com.example.android.utabazzar.ui.activity.UserProfileActivity;

public class club_tab extends AppCompatActivity {
    public ActionBar toolbar;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club_tab2);

        toolbar = getSupportActionBar();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        toolbar.setTitle("Store");
        loadFragment(new StoreFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_shop:
                    toolbar.setTitle("Store");
                    loadFragment(new StoreFragment());
                    return true;
                case R.id.navigation_cart:
//                    fragment = new SellFragment();
//                    loadFragment(fragment);
                    Intent intent = new Intent(getApplicationContext(),club_chat.class);

                    startActivity(intent);
                    finish();
                    return true;
                case R.id.navigation_profile:
                    //toolbar.setTitle("Profile");
                    //toolbar.setTitle("Messages");
                    //loadFragment(new StoreFragment());
                    //Intent intent1=new Intent(getApplicationContext(),UserProfileActivity.class);
                    //startActivity(intent1);
                    //finish();
                    //loadFragment(new UserProfileFragment());
                    //return true;
                case R.id.navigation_message:

                    return true;
                case R.id.club_management:
                    Intent intent1=new Intent(getApplicationContext(),ClubManagement.class);
                    startActivity(intent1);
                    finish();
                    return true;
            }

            return false;
        }
    };
    //
//    @Override
//    public void onBackPressed() {
//        if (fragment == storeFragment) {
//            finish();
//        } else {
//            loadFragment(storeFragment);
//            fragment = storeFragment;
//        }
//
//    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
