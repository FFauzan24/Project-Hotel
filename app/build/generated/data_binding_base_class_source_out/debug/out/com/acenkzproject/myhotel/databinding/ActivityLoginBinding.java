// Generated by view binder compiler. Do not edit!
package com.acenkzproject.myhotel.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.acenkzproject.myhotel.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnSignin;

  @NonNull
  public final ImageView image1;

  @NonNull
  public final TextInputEditText inputEmail;

  @NonNull
  public final TextInputLayout inputlayout1;

  @NonNull
  public final TextInputLayout inputlayout2;

  @NonNull
  public final TextInputEditText inputpassword;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final TextView register;

  @NonNull
  public final RelativeLayout relativeview;

  @NonNull
  public final TextView text;

  @NonNull
  public final TextView text1;

  private ActivityLoginBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnSignin,
      @NonNull ImageView image1, @NonNull TextInputEditText inputEmail,
      @NonNull TextInputLayout inputlayout1, @NonNull TextInputLayout inputlayout2,
      @NonNull TextInputEditText inputpassword, @NonNull LinearLayout linearLayout,
      @NonNull TextView register, @NonNull RelativeLayout relativeview, @NonNull TextView text,
      @NonNull TextView text1) {
    this.rootView = rootView;
    this.btnSignin = btnSignin;
    this.image1 = image1;
    this.inputEmail = inputEmail;
    this.inputlayout1 = inputlayout1;
    this.inputlayout2 = inputlayout2;
    this.inputpassword = inputpassword;
    this.linearLayout = linearLayout;
    this.register = register;
    this.relativeview = relativeview;
    this.text = text;
    this.text1 = text1;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_signin;
      Button btnSignin = ViewBindings.findChildViewById(rootView, id);
      if (btnSignin == null) {
        break missingId;
      }

      id = R.id.image1;
      ImageView image1 = ViewBindings.findChildViewById(rootView, id);
      if (image1 == null) {
        break missingId;
      }

      id = R.id.inputEmail;
      TextInputEditText inputEmail = ViewBindings.findChildViewById(rootView, id);
      if (inputEmail == null) {
        break missingId;
      }

      id = R.id.inputlayout1;
      TextInputLayout inputlayout1 = ViewBindings.findChildViewById(rootView, id);
      if (inputlayout1 == null) {
        break missingId;
      }

      id = R.id.inputlayout2;
      TextInputLayout inputlayout2 = ViewBindings.findChildViewById(rootView, id);
      if (inputlayout2 == null) {
        break missingId;
      }

      id = R.id.inputpassword;
      TextInputEditText inputpassword = ViewBindings.findChildViewById(rootView, id);
      if (inputpassword == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.register;
      TextView register = ViewBindings.findChildViewById(rootView, id);
      if (register == null) {
        break missingId;
      }

      id = R.id.relativeview;
      RelativeLayout relativeview = ViewBindings.findChildViewById(rootView, id);
      if (relativeview == null) {
        break missingId;
      }

      id = R.id.text;
      TextView text = ViewBindings.findChildViewById(rootView, id);
      if (text == null) {
        break missingId;
      }

      id = R.id.text1;
      TextView text1 = ViewBindings.findChildViewById(rootView, id);
      if (text1 == null) {
        break missingId;
      }

      return new ActivityLoginBinding((ConstraintLayout) rootView, btnSignin, image1, inputEmail,
          inputlayout1, inputlayout2, inputpassword, linearLayout, register, relativeview, text,
          text1);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
