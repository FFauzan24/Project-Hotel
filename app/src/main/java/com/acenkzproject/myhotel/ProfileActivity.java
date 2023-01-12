package com.acenkzproject.myhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.acenkzproject.myhotel.Data.Profile;
import com.acenkzproject.myhotel.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity {

    ActivityProfileBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Profile data = getIntent().getParcelableExtra(EXTRA_PROFILE);

        binding.namaUser.setText(data.getNama());
        binding.Email.setText(data.getEmail());
        binding.noHP.setText(data.getHp());

        binding.btnLogout.setOnClickListener(view -> {
            Intent Logout = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(Logout);
        });

    }
    public static final String EXTRA_PROFILE = "extra profile";
}