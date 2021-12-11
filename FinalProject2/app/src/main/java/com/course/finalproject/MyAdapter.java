package com.course.finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView mainPicture;
        TextView brand;
        TextView name;
        TextView price;

        MyViewHolder(@NonNull View view) {
            super(view);
            mainPicture = view.findViewById(R.id.main_image);
            brand = view.findViewById(R.id.main_brand);
            name = view.findViewById(R.id.main_pname);
            price = view.findViewById(R.id.main_price);
        }
    }

    private ArrayList<Items> myItemList;
    MyAdapter(ArrayList<Items> iteminfo) {
        this.myItemList = iteminfo;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        myViewHolder.mainPicture.setImageResource(myItemList.get(position).getMain_img_id());
        myViewHolder.brand.setText(myItemList.get(position).getBrand());
        myViewHolder.name.setText(myItemList.get(position).getName());
        myViewHolder.price.setText(myItemList.get(position).getPrice()+"원");

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //각 아이템을 눌렀을때 이벤트 추가 구현 필요, 상세 페이지로 넘어가게끔! 해당 포지션에 해당하는 아이템객체를 인텐트로 넘겨주자. myItemList.get(myViewHolder.getAdapterPosition()) --> Item 객체 아이템
                Context context = v.getContext();
                //Toast.makeText(context, "Item is clicked: "+myItemList.get(myViewHolder.getAdapterPosition()).getName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, DetailPage.class);
                intent.putExtra("Info", myItemList.get(myViewHolder.getAdapterPosition()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return myItemList.size();
    }

}
