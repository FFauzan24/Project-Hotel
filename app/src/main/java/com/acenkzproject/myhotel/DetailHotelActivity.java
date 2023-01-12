package com.acenkzproject.myhotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.acenkzproject.myhotel.Data.Hotel;
import com.acenkzproject.myhotel.databinding.ActivityDetailHotelBinding;

import java.util.Objects;

public class DetailHotelActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityDetailHotelBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailHotelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Hotel");

        Hotel hotel = getIntent().getParcelableExtra(EXTRA_DATA);

        binding.imgHotel.setImageResource(hotel.getImgHotel());
        binding.namaHotel.setText(hotel.getNamaHotel());
        binding.lokasi.setText(hotel.getLokasiHotel());
        binding.rating.setText(hotel.getRatingHotel());
        binding.reviewer.setText(hotel.getReviewer());
        binding.dekripsi.setText(hotel.getDetailHotel());

        binding.btnBooking.setOnClickListener(this);

    }

    public static final String EXTRA_DATA = "extra data";

    @Override
    public void onClick(View view) {
        Hotel hotel = getIntent().getParcelableExtra(EXTRA_DATA);

        int harga = hotel.getHarga();

        Hotel data = new Hotel();
        data.setImgHotel(hotel.getImgHotel());
        data.setNamaHotel(binding.namaHotel.getText().toString());
        data.setLokasiHotel(binding.lokasi.getText().toString());
        data.setHarga(harga);

        if (view.getId() == binding.btnBooking.getId()){
            Intent IntentBooking = new Intent(DetailHotelActivity.this, BookingActivity.class);
            IntentBooking.putExtra(BookingActivity.EXTRA_BOOKING, data);
            startActivity(IntentBooking);
        }
    }
}