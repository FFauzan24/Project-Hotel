package com.acenkzproject.myhotel;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.acenkzproject.myhotel.Data.Profile;
import com.acenkzproject.myhotel.databinding.ActivityHomeBinding;

import java.util.Objects;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityHomeBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setHomeButtonEnabled(true);

        binding.btnCari.setOnClickListener(this);
        binding.btnProfile.setOnClickListener(this);
        binding.btnAbout.setOnClickListener(this);
        binding.btnExit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.btnCari.getId()){
            Intent listIntent = new Intent(HomeActivity.this, ListHotelActivity.class);
            startActivity(listIntent);
        }
        if (view.getId() == binding.btnProfile.getId()){
            profile();
        }
        if (view.getId() == binding.btnAbout.getId()){
            Intent about = new Intent(HomeActivity.this, AboutActivity.class);
            startActivity(about);
        }
        if (view.getId() == binding.btnExit.getId()){
            Intent exit = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(exit);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == R.id.profile){
            profile();
        }
        return super.onOptionsItemSelected(item);
    }

    private void profile(){
        Profile data = getIntent().getParcelableExtra(EXTRA_PROFILE);
        Profile profile = new Profile();

        profile.setNama(data.getNama());
        profile.setHp(data.getHp());
        profile.setEmail(data.getEmail());

        Intent Intetprofile = new Intent(this, ProfileActivity.class);
        Intetprofile.putExtra(ProfileActivity.EXTRA_PROFILE, data);
        startActivity(Intetprofile);

    }
    public static final String EXTRA_PROFILE = "extra profile";
}