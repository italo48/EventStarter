package com.br.italoscompany.eventstarterapp.Functionalities.EventResgister;

import com.br.italoscompany.eventstarterapp.Model.IModel;
import com.br.italoscompany.eventstarterapp.Model.entities.PointOfSala;
import com.google.android.gms.maps.model.LatLng;

import java.util.Date;
import java.util.List;

import static com.br.italoscompany.eventstarterapp.Model.data.AppDBMemory.dbEvent;

public class EventRegisterPresenter implements IEventRegister.IPresenter {
    private IEventRegister.IView iViewEventRegister;
    private IModel.IEventModel eventModel;

    public EventRegisterPresenter(IEventRegister.IView v){
        this.iViewEventRegister = v;
        this.eventModel = dbEvent;
    }


    @Override
    public void registerEvent(String nome, Date data, LatLng local, List<PointOfSala> pontosDeVendas) {
        if (nome.isEmpty() || data == null || local == null) {
            //iViewEventRegister.showToast("Erro ao criar evento");
        }
    }
}
