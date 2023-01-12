package com.acenkzproject.myhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.acenkzproject.myhotel.Data.Profile;
import com.acenkzproject.myhotel.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String nama = binding.inputNama.getText().toString().trim();
        String email = binding.inputEmail.getText().toString().trim();
        String hp = binding.inputhp.getText().toString().trim();
        String password1 = binding.inputPassword.getText().toString().trim();
        String password2 = binding.inputRetypePassword.getText().toString().trim();

        Profile profile = new Profile();
        profile.setNama(nama);
        profile.setEmail(email);
        profile.setHp(hp);
        profile.setPassword(password1);

        if (view.getId() == binding.btnRegister.getId()){
            if (TextUtils.isEmpty(nama)){
                binding.inputNama.setError("Data Harus Diisi");
            }
            else if (TextUtils.isEmpty(email)){
                binding.inputEmail.setError("Data Harus Diisi");
            }
            else if (TextUtils.isEmpty(password1)){
                binding.inputPassword.setError("Data Harus Diisi");
            }
            else if (TextUtils.isEmpty(password2)){
                binding.inputRetypePassword.setError("Data Harus Diisi");
            }
            else if (!password1.equals(password2)){
                binding.inputRetypePassword.setError("Password Tidak Sama");
            }
            else{
                Intent intentLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                intentLogin.putExtra(LoginActivity.EXTRA_DATA, profile);
                startActivity(intentLogin);
            }

        }
    }
}