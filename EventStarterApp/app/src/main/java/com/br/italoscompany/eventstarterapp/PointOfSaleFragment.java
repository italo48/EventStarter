package com.br.italoscompany.eventstarterapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PointOfSaleFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<String> pontosDeVendas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_point_of_sale, container, false);

        inicializarLista();
        recyclerView = view.findViewById(R.id.recyclerViewPointSale);
        Adapter adapter = new Adapter(pontosDeVendas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        return view;
    }

    public void inicializarLista(){
        pontosDeVendas = new ArrayList<>();
        pontosDeVendas.add("ponto1");
        pontosDeVendas.add("ponto2");
        pontosDeVendas.add("ponto3");
        pontosDeVendas.add("ponto4");
        pontosDeVendas.add("ponto5");
    }
}
