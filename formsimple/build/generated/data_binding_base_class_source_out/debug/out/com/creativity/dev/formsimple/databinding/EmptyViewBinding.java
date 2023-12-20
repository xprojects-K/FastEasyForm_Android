// Generated by view binder compiler. Do not edit!
package com.creativity.dev.formsimple.databinding;

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
import com.creativity.dev.formsimple.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class EmptyViewBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout contentEmpty;

  @NonNull
  public final ImageView imgEmpty;

  @NonNull
  public final TextView tvEmpty;

  private EmptyViewBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout contentEmpty, @NonNull ImageView imgEmpty,
      @NonNull TextView tvEmpty) {
    this.rootView = rootView;
    this.contentEmpty = contentEmpty;
    this.imgEmpty = imgEmpty;
    this.tvEmpty = tvEmpty;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static EmptyViewBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static EmptyViewBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.empty_view, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static EmptyViewBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout contentEmpty = (ConstraintLayout) rootView;

      id = R.id.img_empty;
      ImageView imgEmpty = ViewBindings.findChildViewById(rootView, id);
      if (imgEmpty == null) {
        break missingId;
      }

      id = R.id.tv_empty;
      TextView tvEmpty = ViewBindings.findChildViewById(rootView, id);
      if (tvEmpty == null) {
        break missingId;
      }

      return new EmptyViewBinding((ConstraintLayout) rootView, contentEmpty, imgEmpty, tvEmpty);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}