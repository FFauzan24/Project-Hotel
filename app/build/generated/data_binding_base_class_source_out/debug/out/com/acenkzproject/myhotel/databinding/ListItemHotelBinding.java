// Generated by view binder compiler. Do not edit!
package com.acenkzproject.myhotel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.acenkzproject.myhotel.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ListItemHotelBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView imageHotel;

  @NonNull
  public final ImageView imglocation;

  @NonNull
  public final ImageView imgstar;

  @NonNull
  public final TextView location;

  @NonNull
  public final TextView namaHotel;

  @NonNull
  public final TextView rangeHarga;

  @NonNull
  public final TextView rating;

  private ListItemHotelBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView imageHotel,
      @NonNull ImageView imglocation, @NonNull ImageView imgstar, @NonNull TextView location,
      @NonNull TextView namaHotel, @NonNull TextView rangeHarga, @NonNull TextView rating) {
    this.rootView = rootView;
    this.imageHotel = imageHotel;
    this.imglocation = imglocation;
    this.imgstar = imgstar;
    this.location = location;
    this.namaHotel = namaHotel;
    this.rangeHarga = rangeHarga;
    this.rating = rating;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ListItemHotelBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ListItemHotelBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.list_item_hotel, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ListItemHotelBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.imageHotel;
      ImageView imageHotel = ViewBindings.findChildViewById(rootView, id);
      if (imageHotel == null) {
        break missingId;
      }

      id = R.id.imglocation;
      ImageView imglocation = ViewBindings.findChildViewById(rootView, id);
      if (imglocation == null) {
        break missingId;
      }

      id = R.id.imgstar;
      ImageView imgstar = ViewBindings.findChildViewById(rootView, id);
      if (imgstar == null) {
        break missingId;
      }

      id = R.id.location;
      TextView location = ViewBindings.findChildViewById(rootView, id);
      if (location == null) {
        break missingId;
      }

      id = R.id.namaHotel;
      TextView namaHotel = ViewBindings.findChildViewById(rootView, id);
      if (namaHotel == null) {
        break missingId;
      }

      id = R.id.rangeHarga;
      TextView rangeHarga = ViewBindings.findChildViewById(rootView, id);
      if (rangeHarga == null) {
        break missingId;
      }

      id = R.id.rating;
      TextView rating = ViewBindings.findChildViewById(rootView, id);
      if (rating == null) {
        break missingId;
      }

      return new ListItemHotelBinding((ConstraintLayout) rootView, imageHotel, imglocation, imgstar,
          location, namaHotel, rangeHarga, rating);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
