// Generated by view binder compiler. Do not edit!
package com.course.finalproject.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.course.finalproject.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button csButton;

  @NonNull
  public final RecyclerView itemList;

  @NonNull
  public final TextView tvTitle;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull Button csButton,
      @NonNull RecyclerView itemList, @NonNull TextView tvTitle) {
    this.rootView = rootView;
    this.csButton = csButton;
    this.itemList = itemList;
    this.tvTitle = tvTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cs_button;
      Button csButton = ViewBindings.findChildViewById(rootView, id);
      if (csButton == null) {
        break missingId;
      }

      id = R.id.item_list;
      RecyclerView itemList = ViewBindings.findChildViewById(rootView, id);
      if (itemList == null) {
        break missingId;
      }

      id = R.id.tv_Title;
      TextView tvTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvTitle == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, csButton, itemList, tvTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}