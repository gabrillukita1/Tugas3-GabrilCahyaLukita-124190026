package com.example.sembakopaktoyib;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SembakoAdapter extends RecyclerView.Adapter<SembakoAdapter.ViewHolder> {

    private  int RvOrienta;
    private Context context;
    private ArrayList<SembakoModel> sembakoModels;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick (int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public SembakoAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<SembakoModel> getSembakoModels() {
        return sembakoModels;
    }


    public void setSembakoModels(ArrayList<SembakoModel> sembakoModels) {
        this.sembakoModels = sembakoModels;
    }

    public int getRvOrienta() {
        return RvOrienta;
    }

    public void setRvOrienta(int rvOrienta) {
        RvOrienta = rvOrienta;
    }

    @NonNull
    @Override
    public SembakoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow;
        switch (getRvOrienta()){
            case 0 : itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recyclerview_vetical, viewGroup, false);
                break;
            case 1 : itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recyclerview_grid, viewGroup, false);
                break;
            case 2: itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recyclerview_grid, viewGroup, false);
                break;
            default : itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_recyclerview_grid, viewGroup, false);
        }
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull SembakoAdapter.ViewHolder viewHolder, int i) {
        Glide.with(context).load(getSembakoModels().get(i).getIcon()).into(viewHolder.ivIcon);
        viewHolder.tvNamaBarang.setText(getSembakoModels().get(i).getNamaBarang());
    }

    @Override
    public int getItemCount() {
        return getSembakoModels().size();
    }

    public class ViewHolder  extends RecyclerView.ViewHolder{
        private ImageView ivIcon;
        private TextView tvNamaBarang;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.iv_icon);
            tvNamaBarang = itemView.findViewById(R.id.tv_namabarang);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        mListener.onItemClick(position);
                    }
                }
            });
        }
    }
}