package com.acenkzproject.myhotel.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class DataBooking implements Parcelable {
    private String nama;
    private String hp;
    private String CheckIn;
    private String CheckOut;
    private String tipe;
    private String jumlah;

    public DataBooking(Parcel in) {
        nama = in.readString();
        hp = in.readString();
        CheckIn = in.readString();
        CheckOut = in.readString();
        tipe = in.readString();
        jumlah = in.readString();
    }

    public static final Creator<DataBooking> CREATOR = new Creator<DataBooking>() {
        @Override
        public DataBooking createFromParcel(Parcel in) {
            return new DataBooking(in);
        }

        @Override
        public DataBooking[] newArray(int size) {
            return new DataBooking[size];
        }
    };

    public DataBooking() {

    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getCheckIn() {
        return CheckIn;
    }

    public void setCheckIn(String checkIn) {
        CheckIn = checkIn;
    }

    public String getCheckOut() {
        return CheckOut;
    }

    public void setCheckOut(String checkOut) {
        CheckOut = checkOut;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(hp);
        parcel.writeString(CheckIn);
        parcel.writeString(CheckOut);
        parcel.writeString(tipe);
        parcel.writeString(jumlah);
    }
}
