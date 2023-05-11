package com.example.shifa.ui;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;


public class Adapter extends RecyclerView.Adapter<Adapter.MyClassAdapter> {


    private ButtonClickedListener buttonClickedListener ;


    public Adapter (){

    }
    @NonNull
    @Override
    public Adapter.MyClassAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //LayoutInflater layoutInflater = LayoutInflater.from(context);
        //View view = layoutInflater.inflate(R.layout.template,parent,false);

        return null/*new MyClassAdapter(view)*/;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.MyClassAdapter holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    /* setting on button clicked listener */
    public void setButtonClickedListener(ButtonClickedListener listener){
        this.buttonClickedListener = listener;
    }
    public interface ButtonClickedListener{
        void onButtonClicked(int position);
    }
    public class MyClassAdapter extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView rest_name,rating;
        ImageView image;

        Button menu ;
        public MyClassAdapter(@NonNull View itemView) {
            super(itemView);

            menu.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
