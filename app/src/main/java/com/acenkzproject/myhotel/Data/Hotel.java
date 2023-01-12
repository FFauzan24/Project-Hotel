package com.acenkzproject.myhotel.Data;

import android.os.Parcel;
import android.os.Parcelable;

public class Hotel implements Parcelable {
    private String namaHotel;
    private String lokasiHotel;
    private String detailHotel;
    private String ratingHotel;
    private String reviewer;
    private int harga;
    private int imgHotel;
    private String rangeHarga;

    public Hotel() {

    }

    protected Hotel(Parcel in) {
        namaHotel = in.readString();
        lokasiHotel = in.readString();
        detailHotel = in.readString();
        ratingHotel = in.readString();
        reviewer = in.readString();
        harga = in.readInt();
        imgHotel = in.readInt();
        rangeHarga = in.readString();
    }

    public static final Creator<Hotel> CREATOR = new Creator<Hotel>() {
        @Override
        public Hotel createFromParcel(Parcel in) {
            return new Hotel(in);
        }

        @Override
        public Hotel[] newArray(int size) {
            return new Hotel[size];
        }
    };

    public String getNamaHotel() {
        return namaHotel;
    }

    public void setNamaHotel(String namaHotel) {
        this.namaHotel = namaHotel;
    }

    public String getLokasiHotel() {
        return lokasiHotel;
    }

    public void setLokasiHotel(String lokasiHotel) {
        this.lokasiHotel = lokasiHotel;
    }

    public String getDetailHotel() {
        return detailHotel;
    }

    public void setDetailHotel(String detailHotel) {
        this.detailHotel = detailHotel;
    }

    public String getRatingHotel() {
        return ratingHotel;
    }

    public void setRatingHotel(String ratingHotel) {
        this.ratingHotel = ratingHotel;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public int getImgHotel() {
        return imgHotel;
    }

    public void setImgHotel(int imgHotel) {
        this.imgHotel = imgHotel;
    }

    public String getRangeHarga() {
        return rangeHarga;
    }

    public void setRangeHarga(String rangeHarga) {
        this.rangeHarga = rangeHarga;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(namaHotel);
        parcel.writeString(lokasiHotel);
        parcel.writeString(detailHotel);
        parcel.writeString(ratingHotel);
        parcel.writeString(reviewer);
        parcel.writeInt(harga);
        parcel.writeInt(imgHotel);
        parcel.writeString(rangeHarga);
    }
}
