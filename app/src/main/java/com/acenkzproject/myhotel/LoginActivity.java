package com.acenkzproject.myhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.acenkzproject.myhotel.Data.Hotel;
import com.acenkzproject.myhotel.Data.Profile;
import com.acenkzproject.myhotel.databinding.ActivityLoginBinding;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).hide();

        binding.btnSignin.setOnClickListener(this);
        binding.register.setOnClickListener(this);

        animation();
    }

    @Override
    public void onClick(View view) {

        if(view.getId() == binding.register.getId()){
            Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(register);
        }

        if (view.getId() == binding.btnSignin.getId()){

            Profile data = getIntent().getParcelableExtra(EXTRA_DATA);


            String email = binding.inputEmail.getText().toString().trim();
            String password = binding.inputpassword.getText().toString().trim();
            Profile profile = new Profile();
            Intent homeIntent = new Intent(LoginActivity.this, HomeActivity.class);

            if (Objects.equals(data, null)){
                if (email.equals("Farhan") && password.equals("12345")){
                    profile.setNama("Farhan");
                    profile.setEmail("20200810002@uniku.ac.id");
                    profile.setHp("081214477989");
                    homeIntent.putExtra(HomeActivity.EXTRA_PROFILE, profile);
                    startActivity(homeIntent);
                }
                else {
                    Toast.makeText(this, "Email Atau Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                String checkEmail = data.getEmail();
                String checkPassword = data.getPassword();
                String checkhp = data.getHp();
                String checkNama = data.getNama();
                if(email.equals(checkEmail) && password.equals(checkPassword)) {
                    profile.setNama(checkNama);
                    profile.setEmail(checkEmail);
                    profile.setHp(checkhp);
                    homeIntent.putExtra(HomeActivity.EXTRA_PROFILE, profile);
                    startActivity(homeIntent);
                }
                else {
                    Toast.makeText(this, "Email Atau Password Salah", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private void animation() {

        ObjectAnimator Linear = ObjectAnimator.ofFloat(binding.linearLayout, View.ALPHA, 1f).setDuration(1500);
        ObjectAnimator relative = ObjectAnimator.ofFloat(binding.relativeview, View.ALPHA, 1f).setDuration(1500);

        ObjectAnimator image1 = ObjectAnimator.ofFloat(binding.image1, View.TRANSLATION_Y, -500f, 0f)
                .setDuration(1000);

        ObjectAnimator text = ObjectAnimator.ofFloat(binding.text, View.TRANSLATION_X, -2000f, 0f).setDuration(1000);

        ObjectAnimator login = ObjectAnimator.ofFloat(binding.inputlayout1, View.TRANSLATION_X, -2000f, 0f).setDuration(1000);
        ObjectAnimator password = ObjectAnimator.ofFloat(binding.inputlayout2, View.TRANSLATION_X, -2000f, 0f).setDuration(1000);
        ObjectAnimator button = ObjectAnimator.ofFloat(binding.btnSignin, View.TRANSLATION_X, -2000f, 0f).setDuration(1000);


        AnimatorSet as = new AnimatorSet();
        AnimatorSet as2 = new AnimatorSet();
        AnimatorSet as3 = new AnimatorSet();

        as2.playTogether(Linear, relative);
        as.playTogether(image1, text, login, password, button);
        as3.playTogether(as2, as);
        as3.start();
    }
    public static final String EXTRA_DATA = "extra data";
}