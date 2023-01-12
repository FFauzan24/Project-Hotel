package com.acenkzproject.myhotel.Data;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.acenkzproject.myhotel.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ListHotelAdapter extends RecyclerView.Adapter<ListHotelAdapter.ListViewHolder> {
    private ArrayList<Hotel> listHotel;

    public ListHotelAdapter(ArrayList<Hotel> list){
        this.listHotel = list;
    }

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public ListHotelAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_hotel, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListHotelAdapter.ListViewHolder holder, int position) {
        Hotel hotel = listHotel.get(position);
        Glide.with(holder.itemView.getContext())
                .load(hotel.getImgHotel())
                .into(holder.imgHotel);
        holder.namaHotel.setText(hotel.getNamaHotel());
        holder.Rating.setText(hotel.getRatingHotel());
        holder.lokasi.setText(hotel.getLokasiHotel());
        holder.range.setText(hotel.getRangeHarga());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(listHotel.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHotel.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgHotel;
        TextView namaHotel, Rating, lokasi, range;

        ListViewHolder(View itemView){
            super(itemView);
            imgHotel = itemView.findViewById(R.id.imageHotel);
            namaHotel = itemView.findViewById(R.id.namaHotel);
            Rating = itemView.findViewById(R.id.rating);
            lokasi = itemView.findViewById(R.id.location);
            range = itemView.findViewById(R.id.rangeHarga);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(Hotel data);
    }
}

