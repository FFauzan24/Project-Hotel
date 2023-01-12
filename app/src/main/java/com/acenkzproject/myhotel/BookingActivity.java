package com.acenkzproject.myhotel;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.acenkzproject.myhotel.Data.DataBooking;
import com.acenkzproject.myhotel.Data.Hotel;
import com.acenkzproject.myhotel.databinding.ActivityBookingBinding;

import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

public class BookingActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityBookingBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBookingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Hotel data = getIntent().getParcelableExtra(EXTRA_BOOKING);

        binding.imageBooking.setImageResource(data.getImgHotel());
        binding.nameHotel.setText(data.getNamaHotel());
        binding.lokasi.setText(data.getLokasiHotel());
        String total = String.valueOf(data.getHarga());
        binding.total.setText(formatUang(Integer.parseInt(total)));

        binding.btnBooking.setOnClickListener(this);

        binding.tipekamar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (binding.tipekamar.getText().toString().equals("Business")){
                    int harga = 2 * data.getHarga();
                    binding.total.setText(formatUang(Integer.parseInt(String.valueOf(harga))));
                }
                else if (binding.tipekamar.getText().toString().equals("VVIP")){
                    int harga = 3 * data.getHarga();
                    binding.total.setText(formatUang(Integer.parseInt(String.valueOf(harga))));
                }
                else {
                    binding.total.setText(formatUang(Integer.parseInt(total)));
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public static final String EXTRA_BOOKING = "Extra Booking";

    public void setCheckIn(View view) {
        EditText checkIn = binding.inputCheckIn;
        final Calendar c = Calendar.getInstance();
        int thn = c.get(Calendar.YEAR);
        int bln = c.get(Calendar.MONTH);
        int tgl = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(BookingActivity.this, (datePicker, thn1, bln1, tgl1) -> checkIn.setText(tgl1 +"-"+(bln1 +1)+"-"+ thn1), thn, bln, tgl);
        datePickerDialog.show();
    }

    public void setCheckOut(View view) {
        EditText checkOut = binding.inputCheckOut;
        final Calendar c = Calendar.getInstance();
        int thn = c.get(Calendar.YEAR);
        int bln = c.get(Calendar.MONTH);
        int tgl = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(BookingActivity.this, (datePicker, thn1, bln1, tgl1) -> checkOut.setText(tgl1 +"-"+(bln1 +1)+"-"+ thn1), thn, bln, tgl);
        datePickerDialog.show();
    }

    public void tipeKamar(View view) {
        EditText tipe = binding.tipekamar;
        String[] List = getResources().getStringArray(R.array.tipe);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pilih tipe kamar");
        builder.setItems(List, ((dialogInterface, i) -> {
            tipe.setText(List[i]);

            dialogInterface.dismiss();
        })).show();
    }

    @Override
    public void onClick(View view) {
        String Nama = binding.inputNama.getText().toString().trim();
        String hp = binding.inputHp.getText().toString().trim();
        String CheckIn = binding.inputCheckIn.getText().toString().trim();
        String CheckOut = binding.inputCheckOut.getText().toString().trim();
        String tipe = binding.tipekamar.getText().toString().trim();
        String jumlah = binding.total.getText().toString().trim();

        DataBooking dataBooking = new DataBooking();
        dataBooking.setNama(Nama);
        dataBooking.setHp(hp);
        dataBooking.setCheckIn(CheckIn);
        dataBooking.setCheckOut(CheckOut);
        dataBooking.setTipe(tipe);
        dataBooking.setJumlah(jumlah);

        if (view.getId() == binding.btnBooking.getId()){

            if(TextUtils.isEmpty(Nama)){
                binding.inputNama.setError("Data Harus Diisi");
            }
            else if(TextUtils.isEmpty(hp)){
                binding.inputHp.setError("Data Harus Diisi");
            }
            else if(TextUtils.isEmpty(CheckIn)){
                binding.inputCheckIn.setError("Data Harus Diisi");
            }
            else if(TextUtils.isEmpty(CheckOut)){
                binding.inputCheckOut.setError("Data Harus Diisi");
            }
            else if(TextUtils.isEmpty(tipe)){
                binding.tipekamar.setError("Data Harus Diisi");
            }
            else if(TextUtils.isEmpty(jumlah)){
                binding.jumlahOrang.setError("Data Harus Diisi");
            }
            else {
                Intent intentBooking = new Intent(BookingActivity.this, SuccessActivity.class);
                intentBooking.putExtra(SuccessActivity.EXTRA_BOOKING, dataBooking);
                startActivity(intentBooking);
            }
        }
    }

    private String formatUang(int number){
        Locale localeID = new Locale("in","ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return formatRupiah.format(number);
    }


}