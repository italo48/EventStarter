package com.br.italoscompany.eventstarterapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.br.italoscompany.eventstarterapp.R;

import java.util.List;

public class PointSaleAdapter extends RecyclerView.Adapter<PointSaleAdapter.MyViewHolder> {

    List<String> pontosDeVendas;
    public PointSaleAdapter(List<String> pontosDeVendas){
        this.pontosDeVendas = pontosDeVendas;
    }

    @NonNull
    @Override
    public PointSaleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_point_of_sale, parent,false);
        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull PointSaleAdapter.MyViewHolder holder, int position) {
        holder.nomeLocal.setText(pontosDeVendas.get(position));
    }

    @Override
    public int getItemCount() {
        return pontosDeVendas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nomeLocal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            nomeLocal = itemView.findViewById(R.id.tituloLocal);
        }
    }
}
