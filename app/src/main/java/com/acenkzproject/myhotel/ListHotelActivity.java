package com.acenkzproject.myhotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.acenkzproject.myhotel.Data.Hotel;
import com.acenkzproject.myhotel.Data.ListHotelAdapter;
import com.acenkzproject.myhotel.databinding.ActivityListHotelBinding;

import java.util.ArrayList;

public class ListHotelActivity extends AppCompatActivity {

    ActivityListHotelBinding binding;
    protected ArrayList<Hotel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityListHotelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rvHotel.setHasFixedSize(true);
        list.addAll(getListHotel());
        showRecyclerList();

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("List Hotel");

    }

    public ArrayList<Hotel> getListHotel(){
        String[] datanamaHotel = getResources().getStringArray(R.array.nama_hotel);
        String[] datalokasiHotel = getResources().getStringArray(R.array.lokasi_hotel);
        String[] dataRating = getResources().getStringArray(R.array.rating_hotel);
        String[] dataDetailHotel = getResources().getStringArray(R.array.detail);
        String[] dataHarga = getResources().getStringArray(R.array.range_harga);
        String[] dataReviewer = getResources().getStringArray(R.array.reviewer);
        int[] dataHarga2 = getResources().getIntArray(R.array.harga);
        TypedArray dataImgHotel = getResources().obtainTypedArray(R.array.gambar_hotel);

        ArrayList<Hotel> listHotel = new ArrayList<>();
        for (int i = 0; i < datanamaHotel.length; i++){
            Hotel hotel = new Hotel();
            hotel.setNamaHotel(datanamaHotel[i]);
            hotel.setLokasiHotel(datalokasiHotel[i]);
            hotel.setRatingHotel(dataRating[i]);
            hotel.setDetailHotel(dataDetailHotel[i]);
            hotel.setRangeHarga(dataHarga[i]);
            hotel.setReviewer(dataReviewer[i]);
            hotel.setHarga(dataHarga2[i]);
            hotel.setImgHotel(dataImgHotel.getResourceId(i, -1));

            listHotel.add(hotel);
        }
        return listHotel;
    }

    private void showRecyclerList(){
        binding.rvHotel.setLayoutManager(new LinearLayoutManager(this));
        ListHotelAdapter listHotelAdapter = new ListHotelAdapter(list);
        binding.rvHotel.setAdapter(listHotelAdapter);

        listHotelAdapter.setOnItemClickCallback(new ListHotelAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Hotel data) {
                Intent intentDetail = new Intent(ListHotelActivity.this, DetailHotelActivity.class);
                intentDetail.putExtra(DetailHotelActivity.EXTRA_DATA, data);
                startActivity(intentDetail);
            }
        });
    }

}