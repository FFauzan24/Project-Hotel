package com.acenkzproject.myhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.acenkzproject.myhotel.Data.DataBooking;
import com.acenkzproject.myhotel.databinding.ActivitySuccessBinding;

public class SuccessActivity extends AppCompatActivity implements View.OnClickListener {

    ActivitySuccessBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySuccessBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnback.setOnClickListener(this);

        DataBooking dataBooking = getIntent().getParcelableExtra(EXTRA_BOOKING);
        progressbar(true);
        new Handler().postDelayed(() -> {
            binding.inputNama.setText(dataBooking.getNama());
            binding.inputHp.setText(dataBooking.getHp());
            binding.inputCheckIn.setText(dataBooking.getCheckIn());
            binding.inputCheckOut.setText(dataBooking.getCheckOut());
            binding.inputBiaya.setText(dataBooking.getJumlah());
            binding.barcode.setVisibility(View.VISIBLE);
            progressbar(false);
        }, 1000);
    }

    public static final String EXTRA_BOOKING = "extra booking";

    @Override
    public void onClick(View view) {
        if (view.getId() == binding.btnback.getId()){
            Intent intentBack = new Intent(SuccessActivity.this, HomeActivity.class);
            startActivity(intentBack);
        }
    }

    public void progressbar(Boolean loading){
        if (loading){
            binding.progressBar.setVisibility(View.VISIBLE);
        }
        else {
            binding.progressBar.setVisibility(View.GONE);
        }
    }

    public void dataUser(){

    }
}