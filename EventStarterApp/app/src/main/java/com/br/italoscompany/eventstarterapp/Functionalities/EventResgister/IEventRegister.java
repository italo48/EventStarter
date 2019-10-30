package com.br.italoscompany.eventstarterapp.Functionalities.EventResgister;

import com.br.italoscompany.eventstarterapp.Model.entities.PointOfSala;
import com.google.android.gms.maps.model.LatLng;

import java.util.Date;
import java.util.List;

public interface IEventRegister {
    interface IView {
        //void showToast(String msg);
    }

    interface IPresenter {
        void registerEvent(String nome, Date data, LatLng local, List<PointOfSala> pontosDeVendas);
    }
}
